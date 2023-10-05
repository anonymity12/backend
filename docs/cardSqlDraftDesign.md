```yml
                    user
                   /    \
                serie1  series2
               /   |   \
            tpl1  tpl2  tpl3
             |     |     |   \
           inst1  ins2  ins3  ins4
```

```sql
CREATE TABLE IF NOT EXISTS `card_series` (
  `id` int(11) NOT NULL COMMENT '系列ID',
  `name` varchar(255) DEFAULT NULL COMMENT '系列名称',
  `desc` varchar(255) DEFAULT NULL COMMENT '系列描述',
  `owner` int(11) not null comment '这个系列的初始绑定用户'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
CREATE TABLE IF NOT EXISTS `card_template` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `series` int(11) DEFAULT 0 COMMENT '这个卡片属于什么系列',
  `image` varchar(255) DEFAULT NULL,
  `base_price` int(11) NOT NULL DEFAULT 100 COMMENT '卡片的基础价格'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS `card_instance` (
  `id` int(11) NOT NULL,
  `tmplate_id` varchar(255) NOT NULL,
  `hard_work_rate` int(11) DEFAULT 1 COMMENT '卡片上附加的努力率，用于计算实际最终价值的因子' 
    // = points = each time the user finish a task(or undone a task), the point++(--)
    // so we might have a function like:
    // taskService.doneTask():cardMapper.refineCard():update card_instance set hard_work_rate=hard_work_rate+1 （sql was validated ok)
  `owner` int(11) NOT NULL DEFAULT '1' COMMENT '这个卡片当前属于谁', 
    // 卡片后期可以换手，买卖，换主人(only card status in 0 can be trade; 1 means refining, cannot be trade)
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '卡片的状态0:入库，1:正在炼制' 
    // one user can have only one card in refining at each time, so we need a function like: checkOnlyOneCardInRefining(int userId){select count(*) card_instance(owner=userId and status=1) = 1 }
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
```

# random select a card for each month

at first this is my thoughts, which is: when a month start, I give the user one card(of course, a card belong to his/her style/series)
and we do need a random select algorithm to choose the card.

but later I realized that, in real game, we can have many card we want, as long as we buy it, then we refine it, then we 
sold it.

so here is my new thought: 
1) users can buy the card at shop at arbitrary time
2) after he/she buy the card, the card goes to his/her card cabinet
3) the card cabinet contains all cards that user own
4) the one card is being refining is paint with light edge, others are just normal card form
5) when user click one card, here is a dialog(button1: select: user can set this as primary refining card; button2: sold)
6) maybe we can make a card plaza/market(users buy and sold their card)

so based on the new thought 0819, I think that: we need a center shop.
shop has many series card, aka many template card.

so in the extra area, we will add a button, like `shop`, which will lead the users to the shop page.
here in the shop, users buy the card they like.
but here is the question: younger user will feel confuse that there are too many card, which one should I choose?
so at the beginning, I think that: we provide a few cards
a few cards means: we provide 4 cards, 4 butterfly picture(gif would be cool)
then after our app iteration, we may provide more cards, like tanjianci, like shanhaijing

so as summary, shop now provide four card(at the basic level), then in the future iteration, shop will provide more card
(at the advance level)

but this is not personal enough, since I can customize each user's app icon, I can customize his/her card series too
for example, user yy can have dancer card, user xx can have toy card, user sc can have stone card, user xh can have sichuanFood card,
user ll can have babe-face card.

so as another summary, shop should provide one series card for one user, so how do we choose the series? we bind the series
to the user.

so the above two plans can come to one plan, we bind basic series(butterfly) to every user, and then, we bind personal series
to specific user.

so we define a new table: user_card_series_tbl

```sql
CREATE TABLE IF NOT EXISTS `user_card_series_tbl` (
    `userId` int(11) NOT NULL comment 'relation left arrow to user',
    `seriesId` int(11) NOT NULL comment 'relation right arrow to card series',
    PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
```


# final pic explain

![2023-08-19-14-24-32](https://picgorepo.oss-cn-beijing.aliyuncs.com/2023-08-19-14-24-32.png)

# coding part

1005

do we need a cardShopController?
funcs:
    sellCard
    buyCard

NO,why? since only two func in the shopController, then we don't need the controller

what we need, is a mySql shop table
and a user_cabinet tbl

```sql
create table if not exists `shop` (
    
) engine=InnoDB default charset=utf8mb4;
```

```sql 
create table if not exists `user_cabinet` (
    id int(11) not null,
    user_id int,
    card_list json default null,
    primary key (id)
) engine=InnoDB default charset=uft8mb4;
```

guess we can use JSON in mysql5.7 and later, see: https://dev.mysql.com/doc/refman/8.0/en/json.html#json-values

## 查询我的卡片

getAllMyCards

查询一个用户拥有哪些卡片，实际上不是从用户表里面搜索，而是从卡片表里搜索
这是数据库的一个反人类之处，但是对于计算世界来说，非常合理
具体做法是: select id from card_instance where owner = #{userId}

## 决定我首要卡片

其实就是设定一个 card instance 的 status （从0 到1）
并且记得把之前的 primary card 的状态 从1到0；
实际上 先做2，再做1；
这里可以再借鉴一下gulimall的@Transactional注解
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
  `base_price` int(11) NOT NULL DEFAULT 100 COMMENT '卡片的基础价格',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '蝴蝶的状态0:得到，1:成年，-1:放生'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS `card_instance` (
  `id` int(11) NOT NULL,
  `tmplate_id` varchar(255) DEFAULT NULL,
  `init_rand_rate` int(11) DEFAULT 1 COMMENT '卡片初始随机底率，用于计算实际最终价值的因子1'
  `hard_work_rate` int(11) DEFAULT 1 COMMENT '卡片上附加的努力率，用于计算实际最终价值的因子2'
  `price` int(11) COMMENT '卡片的实际最终价值',
  `owner` int(11) NOT NULL DEFAULT '1' COMMENT '这个卡片当前属于谁', // 卡片后期可以换手，买卖，换主人
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '卡片的状态0:入库，1:正在炼制'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
```
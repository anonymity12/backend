userIds = getRecentlyActiveTenUsersIds()// select distinct owner from starrecord order by starDateTime limit 10;
userInfos = getUserInfoByIds(userIds)// 
userRecentStars = getUserRecentStars(userIds, 8);
for i in userInfos.length: starRoadVos.add(new starRoadVo(userInfos[i], userRecentStars[i]));
return starRoadVos;

select *
from user
where id in (select distinct owner from starrecord order by starDateTime limit 10)

SELECT *
FROM starrecord
WHERE owner in (select distinct owner from starrecord order by starDateTime limit 10)
ORDER BY starDateTime DESC
LIMIT 8;
-- mysql 5.7, 有两张表,user, 和 post, 我希望从其中找到 user.userface, user.name, 以及每个用户 的最近10条post, post 有个字段是 createTime,  最后排序, post 新的用户在最前面
-- 1. select * from starrecord s group by s.owner

/*
1. 
找到最近发布了帖子的10个用户的ID，你可以使用以下SQL查询：
select distinct owner from starrecord order by starDateTime limit 10;

2. 找到最近发布了帖子的10个用户的ID，然后依次查询他们最新的8个帖子
SELECT *
FROM posts
WHERE user_id in (select distinct owner from starrecord order by starDateTime limit 10)
ORDER BY post_date DESC
LIMIT 8;
*/
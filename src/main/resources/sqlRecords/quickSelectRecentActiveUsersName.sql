SELECT DISTINCT u.cname
FROM user u
INNER JOIN (
    SELECT owner
    FROM starrecord
    group by owner
    ORDER BY max(starDateTime) DESC
    LIMIT 20
) AS recent_users ON u.id = recent_users.owner;

-- gita's thinking: use having

SELECT DISTINCT u.cname
FROM user u
INNER JOIN (
    SELECT owner
    FROM starrecord
    group by owner
    ORDER BY max(starDateTime) DESC
    LIMIT 20
) AS recent_users ON u.id = recent_users.owner;
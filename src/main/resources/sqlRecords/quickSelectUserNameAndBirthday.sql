SELECT u.cname, recent_users.birth
FROM user u
INNER JOIN (
    SELECT user_id, birth
    FROM user_life_start_end_table
) AS recent_users ON u.id = recent_users.user_id;
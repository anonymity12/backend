SELECT d.id, d.log_content, d.log_cover, d.log_date, d.ownerId
FROM sixlog2 d
JOIN user u ON d.ownerId = u.user_id
WHERE u.group_id = [当前用户的group_id];
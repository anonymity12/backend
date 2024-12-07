in mysql, what if i want move one table data to another one, but the table structure is different, newer table has more filed, how do i do?
answer:
INSERT INTO new_table (id, firstname, lastname) 
SELECT id, fname, lname FROM old_table;

article_title, article_abstract, article_cover
INSERT INTO new_table (combined_field)
SELECT CONCAT(field1, ' ', field2) FROM old_table;

INSERT INTO sixlog2 (log_content, log_cover, log_date, ownerId)
SELECT CONCAT(article_title, ' ', article_abstract) AS log_content, article_cover, article_date, ownerId
FROM sixlog;

CREATE TABLE `sixlog2` (
 `id` int(11) NOT NULL AUTO_INCREMENT,
 `log_content` longtext DEFAULT NULL, -- this is real content actually
 `log_cover` varchar(255) DEFAULT 'https://picgorepo.oss-cn-beijing.aliyuncs.com//2022-02-04-17-37-11img_repo.png',
 `log_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP, -- for now 1120 2024, we dont support edit an old log, so we dont provide another: log_updated_time
 `ownerId` int(11) NOT NULL DEFAULT '1' COMMENT 'sixlog author',
 `log_tag` varchar(255) DEFAULT '杂念, random',
 PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8mb4
CREATE TABLE `sixlog2` (
 `id` int(11) NOT NULL AUTO_INCREMENT,
 `log_content` longtext DEFAULT NULL, -- this is real content actually
 `log_cover` varchar(255) DEFAULT 'https://picgorepo.oss-cn-beijing.aliyuncs.com//2022-02-04-17-37-11img_repo.png',
 `log_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP, -- for now 1120 2024, we dont support edit an old log, so we dont provide another: log_updated_time
 `ownerId` int(11) NOT NULL DEFAULT '1' COMMENT 'sixlog 属主',
 `log_tags` varchar(255) DEFAULT '杂念,random',
 PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8mb4


// in mysql dump table:
show create table sixlog2:
CREATE TABLE `sixlog2` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `log_content` longtext,
  `log_cover` varchar(255) DEFAULT 'https://picgorepo.oss-cn-beijing.aliyuncs.com//2022-02-04-17-37-11img_repo.png',
  `log_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `ownerId` int(11) NOT NULL DEFAULT '1' COMMENT 'sixlog author',
  `log_tags` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=559 DEFAULT CHARSET=utf8mb4
/*
1. insert a new log:
INSERT into sixlog (log_tag, log_content, log_cover, log_date, ownerId, )

*/
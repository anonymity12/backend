CREATE TABLE IF NOT EXISTS `sportrecord` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'sport record id',
  `owner` int(11) NOT NULL COMMENT 'sport owner',
  `sportDateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `sportContent` varchar(255) NOT NULL COMMENT 'sport descriptions, like what kind of sport you did',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
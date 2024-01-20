CREATE TABLE IF NOT EXISTS `sleeprecord` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'sleep record id',
  `owner` int(11) NOT NULL COMMENT 'sleep owner',
  `sleepDateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
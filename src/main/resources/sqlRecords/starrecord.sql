CREATE TABLE IF NOT EXISTS `starrecord` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'star record id',
  `owner` int(11) NOT NULL COMMENT 'star owner',
  `starDateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `starDescription` varchar(255) NOT NULL COMMENT 'star descriptions, like why you got this star',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
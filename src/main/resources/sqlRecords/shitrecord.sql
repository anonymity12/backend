CREATE TABLE IF NOT EXISTS `shitrecord` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'shit record id',
  `owner` int(11) NOT NULL COMMENT 'shit owner',
  `shitDateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
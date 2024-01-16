CREATE TABLE IF NOT EXISTS `trainstationinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'station_id',
  `name` varchar(255) NOT NULL COMMENT 'station名称',
  `desc` varchar(255) DEFAULT NULL COMMENT 'station描述',
  `status` int(11) NOT NULL DEFAULT 0 COMMENT '是否到达station',
  `img` varchar(255) DEFAULT NULL COMMENT '站点相册',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `xj`.`trainstationinfo` (`id`, `name`, `desc`, `status`, `img`)
VALUES (NULL, '偃师', '洛阳市下辖的一个市辖区。总面积668.58平方公里，总人口約55万人', 1, NULL);
INSERT INTO `xj`.`trainstationinfo` (`id`, `name`, `desc`, `status`, `img`)
VALUES (NULL, '洛阳', '古称神都、洛邑、洛京,总面积15230平方千米,人口为707.9万人,北魏太和十八年（494年），孝文帝迁都洛阳', 1, NULL);
INSERT INTO `xj`.`trainstationinfo` (`id`, `name`, `desc`, `status`, `img`)
VALUES (NULL, '渑池', '位于三门峡市内，位于河南省西北部，北濒黄河与山西省的垣曲、夏县、平陆隔河相望，是人类远祖起源地和举世闻名的仰韶文化发现地', 0, NULL);
INSERT INTO `xj`.`trainstationinfo` (`id`, `name`, `desc`, `status`, `img`)
VALUES (NULL, '三门峡', '古称陕州,相传大禹治水，使神斧将高山劈成“人门”、“神门”、“鬼门”三道峡谷，河道中由鬼石和神石将河道分成三流，如同有三座门', 0, NULL);
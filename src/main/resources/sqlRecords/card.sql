CREATE TABLE IF NOT EXISTS `card_series` (
  `id` int(11) NOT NULL COMMENT '系列ID',
  `name` varchar(255) NOT NULL COMMENT '系列名称',
  `desc` varchar(255) DEFAULT NULL COMMENT '系列描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS `card_template` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `series` int(11) DEFAULT 0 COMMENT '这个卡片属于什么系列',
  `image_url` varchar(255) DEFAULT NULL,
  `base_price` int(11) NOT NULL DEFAULT 100 COMMENT '卡片的基础价格',
  `desc` varchar(255) DEFAULT '一张价值连城的卡片，前提是经过了你的努力' COMMENT '卡片描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `card_instance` (
 `id` int(11) NOT NULL,
 `template_id` int(11) NOT NULL,
 `hard_work_rate` int(11) DEFAULT '1' COMMENT '卡片上附加的努力率，用于计算实际最终价值的因子',
 `owner` int(11) NOT NULL DEFAULT '0' COMMENT '这个卡片当前属于谁',
 `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '卡片的状态0:入库，1:正在炼制',
 PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4

ALTER TABLE `card_instance` CHANGE `id` `id` INT(11) NOT NULL AUTO_INCREMENT;
ALTER TABLE `card_template` CHANGE `id` `id` INT(11) NOT NULL AUTO_INCREMENT;
ALTER TABLE `card_series` CHANGE `id` `id` INT(11) NOT NULL AUTO_INCREMENT;


---insert part

INSERT INTO `xj`.`card_template` (`name`, `series`, `image_url`, `base_price`, `desc`) VALUES ('快乐熊', '1', 'https://picgorepo.oss-cn-beijing.aliyuncs.com/Happy_cf0.png', '250', '越努力越快乐的小熊熊')
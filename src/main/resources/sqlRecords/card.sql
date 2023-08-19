CREATE TABLE IF NOT EXISTS `card_series` (
  `id` int(11) NOT NULL COMMENT '系列ID',
  `name` varchar(255) NOT NULL COMMENT '系列名称',
  `desc` varchar(255) DEFAULT NULL COMMENT '系列描述'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS `card_template` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `series` int(11) DEFAULT 0 COMMENT '这个卡片属于什么系列',
  `image` varchar(255) DEFAULT NULL,
  `base_price` int(11) NOT NULL DEFAULT 100 COMMENT '卡片的基础价格'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS `card_instance` (
  `id` int(11) NOT NULL,
  `template_id` int(11) NOT NULL,
  `hard_work_rate` int(11) DEFAULT 1 COMMENT '卡片上附加的努力率，用于计算实际最终价值的因子'
  `price` int(11) COMMENT '卡片的实际最终价值=base_price * 1.05^{hard_work_rate}',
  `owner` int(11) NOT NULL DEFAULT 0 COMMENT '这个卡片当前属于谁',
  `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '卡片的状态0:入库，1:正在炼制'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

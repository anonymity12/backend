CREATE TABLE IF NOT EXISTS `flies` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `evaluate` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'when create this record',
  `owner` int(11) NOT NULL DEFAULT '1' COMMENT '这个蝴蝶属于谁',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '蝴蝶的状态0:得到，1:成年，-1:放生'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


ALTER TABLE `flies`
  ADD PRIMARY KEY (`id`);


ALTER TABLE `flies`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
CREATE TABLE `gold` (
  `owner_id` int(11) NOT NULL DEFAULT '1' COMMENT 'whom gold belongs to',
  `amount` int(11) NOT NULL DEFAULT '5' COMMENT 'his balance'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
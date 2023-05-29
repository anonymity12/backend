CREATE TABLE `task` (
 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '任务id',
 `title` varchar(255) NOT NULL COMMENT '任务标题',
 `status` int(11) NOT NULL DEFAULT '1' COMMENT '任务状态；0:cancle; 1:NotDone; 2:Done;default:1',
 `created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '任务创建时间',
 `edited` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '任务最近编辑时间',
 `owner` int(11) NOT NULL DEFAULT '1' COMMENT '任务属主',
 `matrix` int(11) NOT NULL DEFAULT '2' COMMENT '任务象限;default:2',
 `fly_id` int(11) NOT NULL COMMENT '对应的蝴蝶id',
 PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1504 DEFAULT CHARSET=utf8mb4
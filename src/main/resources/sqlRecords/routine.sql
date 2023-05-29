create table `routine` (
    `id` int(11) not null auto_increment comment '惯例ID',
    `content` varchar(255) not null comment '惯例内容',
    `owner` int(11) not null default '1' comment '惯例属主',
    primary key (`id`)
) engine=InnoDB auto_increment=1 default charset=utf8mb4


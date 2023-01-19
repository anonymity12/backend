drop table if exists `family_tree`;
create table `family_tree` (
    `leaf_id` int(11) not null comment "child id",
    `parent_id` int(11) not null default 0 comment "parent id, normally it's father's id",
)
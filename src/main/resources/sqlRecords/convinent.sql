
-- delete newest sixlog(who has biggest id);
select @v_max_id:=max(id) from xj.sixlog;
DELETE FROM `xj`.`sixlog` WHERE `sixlog`.`id` = @v_max_id;
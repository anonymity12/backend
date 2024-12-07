

addNewSixLog(logWithTags)
tags: "t1, t2,t3"

---

code ok: 添加 log   

---

code ok: 依据 tagA 查询所有包含 此 tagA 的 records
select * from sixlog2 where tag like '%tagA%' limit 5 offset 1;


---

随机 tags 10 

---

统计最高频的 tags 10
redis

1） java mybatis 提取出 tags 这一列的数据
2） 使用map 放置 <tagString, freqInteger>
3） 排序 map ，依据 freqInteger ，排序 tagString
4） 拿前十个 tagString ，再去 mysql 查询，包含这些 tag 的 logs，获得其id； 
4.1） 考虑： 可以保存 这些 tagString 放在今日 topHotestTag tbl 中
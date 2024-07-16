-- MySQL dump 10.13  Distrib 5.7.34, for Linux (x86_64)
--
-- Host: localhost    Database: xj
-- ------------------------------------------------------
-- Server version	5.7.34-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `birthday` date DEFAULT NULL COMMENT '出生日期',
  `name` varchar(32) DEFAULT NULL COMMENT '英文名缩写',
  `intro` varchar(255) NOT NULL DEFAULT '点击头像可以自定义' COMMENT '介绍',
  `userface` varchar(255) DEFAULT 'https://picgorepo.oss-cn-beijing.aliyuncs.com/2023-05-17-10-23-29.png' COMMENT '头像',
  `phone` char(11) DEFAULT NULL COMMENT '手机号码',
  `address` varchar(64) DEFAULT NULL COMMENT '联系地址',
  `enabled` tinyint(1) DEFAULT '1',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `cname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'2022-12-01','xk','无尽虚空的虚拟人','https://picgorepo.oss-cn-beijing.aliyuncs.com//2022-12-02-13-04-14img_repo.png',NULL,NULL,1,'123','虚空'),(13,'2015-09-02','yy','今年9岁的樱花玫瑰仔','https://picgorepo.oss-cn-beijing.aliyuncs.com//2022-11-23-13-28-38README.png',NULL,NULL,1,'123','樱花草莓派玥玥'),(14,'2018-10-02','xx','我爱玩，世界是昕昕的游乐场','https://picgorepo.oss-cn-beijing.aliyuncs.com/2022-11-23-13-27-57README.png',NULL,'月亮上的荷花池',1,'123','昕昕'),(15,'1995-08-11','gg','本人只是一个让她的爱人能幸福的普通天使','http://101.43.166.211:8081/api/img/bfmrv64.jpg','15280571512','整洁优雅的二人居室',1,'123','郭郭'),(16,'1995-12-22','tt','Android1, Java2, Web3,Life4Learn','http://101.43.166.211:8081/api/img/kw1gqejpeg','110119','locationApi',1,'123','天天'),(32,'1995-01-21','yanghao','还没有标签,点击头像编辑','http://101.43.166.211:8081/api/img/wyhkvg.jpeg',NULL,NULL,1,'yang123','杨浩'),(33,'1970-09-16','zsc','戒烟达人','http://101.43.166.211:8081/api/img/wkcaof.JPG',NULL,NULL,1,'123','学成'),(34,'1973-01-22','xab','还没有标签,点击头像编辑','http://101.43.166.211:8081/api/img/oocb87.JPG',NULL,NULL,1,'123','小花'),(35,'1967-05-26','zqz','还没有标签,点击头像编辑','http://101.43.166.211:8081/api/img/axvopr.JPG',NULL,NULL,1,'123','郑巧珍'),(36,'1969-09-27','yjl','还没有标签,点击头像编辑','http://101.43.166.211:8081/api/img/v0ilh3.JPG',NULL,NULL,1,'123','杨进良'),(37,'2003-11-07','hjh','普通的不用介绍的小朋友','http://101.43.166.211:8081/api/img/uqtzet.jpg',NULL,NULL,1,'123','寒寒'),(38,'1995-02-04','xiaoyu','还没有标签,点击头像编辑','http://101.43.166.211:8081/api/img/oq0bhg.JPG',NULL,NULL,1,'123','郑晓宇'),(39,'1996-04-10','yuenighty','还没有标签,点击头像编辑','https://picgorepo.oss-cn-beijing.aliyuncs.com//2022-12-02-13-04-14img_repo.png',NULL,NULL,1,'yuefang2','yuenighty'),(40,'1996-01-01','Zhongting','还没有标签,点击头像编辑','https://picgorepo.oss-cn-beijing.aliyuncs.com//2022-12-02-13-04-14img_repo.png',NULL,NULL,1,'140829','Zhongting'),(41,'1998-06-16','lianlian','还没有标签来形容我','http://101.43.166.211:8081/api/img/d66qln.jpeg',NULL,NULL,1,'zhuzhuzhu00','莲莲'),(42,'1972-07-01','bsy','学习永无止境，一天进步一点点！','http://101.43.166.211:8081/api/img/jr8llr.jpg',NULL,NULL,1,'123','大英子'),(43,'1971-10-23','gxp','每天少抽一根烟，少喝一杯酒！','http://101.43.166.211:8081/api/img/7ml6gt.jpg',NULL,NULL,1,'123','老郭'),(46,'1996-04-13','xiaohao','还没有标签来形容我','https://picgorepo.oss-cn-beijing.aliyuncs.com//2022-12-02-13-04-14img_repo.png',NULL,NULL,1,'957469','xiaohao'),(47,'2023-05-14','xhr','还没有标签来形容我','https://picgorepo.oss-cn-beijing.aliyuncs.com//2022-12-02-13-04-14img_repo.png',NULL,NULL,1,'Xhr@1234','xhr'),(48,'2023-07-23','liuwap008','点击头像可以自定义','https://picgorepo.oss-cn-beijing.aliyuncs.com/2023-05-17-10-23-29.png',NULL,NULL,1,'123123','liuwap008'),(49,'2023-07-24','alan','点击头像可以自定义','https://picgorepo.oss-cn-beijing.aliyuncs.com/2023-05-17-10-23-29.png',NULL,NULL,1,'123456','alan'),(50,'2003-07-30','blwang','点击头像可以自定义','https://picgorepo.oss-cn-beijing.aliyuncs.com/2023-05-17-10-23-29.png',NULL,NULL,1,'123456','blwang'),(52,'1994-10-19','xunyu','点击头像可以自定义','https://picgorepo.oss-cn-beijing.aliyuncs.com/2023-05-17-10-23-29.png',NULL,NULL,1,'903710210','荀玉'),(53,'2013-08-07','Mike','点击头像可以自定义','https://picgorepo.oss-cn-beijing.aliyuncs.com/2023-05-17-10-23-29.png',NULL,NULL,1,'903710210','Mike'),(54,'1994-10-19','Mile','点击头像可以自定义','https://picgorepo.oss-cn-beijing.aliyuncs.com/2023-05-17-10-23-29.png',NULL,NULL,1,'903710210','Mile'),(55,'1992-06-23','feiyuecanghai','点击头像可以自定义','https://picgorepo.oss-cn-beijing.aliyuncs.com/2023-05-17-10-23-29.png',NULL,NULL,1,'flovez9192','飞跃沧海'),(60,'2019-10-29','xiaoma','点击头像可以自定义','http://101.43.166.211:8081/api/img/ximdqs.jpeg',NULL,NULL,1,'123','小马'),(61,'1942-04-01','laowang','点击头像可以自定义','http://101.43.166.211:8081/api/img/rek3t0.jpeg',NULL,NULL,1,'123','老王'),(62,'2018-06-01','xiaodong','点击头像可以自定义','https://picgorepo.oss-cn-beijing.aliyuncs.com/2023-05-17-10-23-29.png',NULL,NULL,1,'123','小东'),(65,'1981-04-01','1292984839030680','点击头像可以自定义','https://picgorepo.oss-cn-beijing.aliyuncs.com/2023-05-17-10-23-29.png',NULL,NULL,1,'123','1292984839030680'),(66,'1984-07-17','huidaojiakandao','点击头像可以自定义','https://picgorepo.oss-cn-beijing.aliyuncs.com/2023-05-17-10-23-29.png',NULL,NULL,1,'123','回到家看到'),(67,'2024-07-07','haidekandekai','点击头像可以自定义','https://picgorepo.oss-cn-beijing.aliyuncs.com/2023-05-17-10-23-29.png',NULL,NULL,1,'131627','还得看得开'),(68,'2024-07-07','huidaojia','点击头像可以自定义','https://picgorepo.oss-cn-beijing.aliyuncs.com/2023-05-17-10-23-29.png',NULL,NULL,1,'123','回到家'),(69,'2024-07-07','hjingdiankuankexuan','点击头像可以自定义','https://picgorepo.oss-cn-beijing.aliyuncs.com/2023-05-17-10-23-29.png',NULL,NULL,1,'123','h经典款可选'),(70,'2024-07-07','xjian','点击头像可以自定义','https://picgorepo.oss-cn-beijing.aliyuncs.com/2023-05-17-10-23-29.png',NULL,NULL,1,'Shmilt30','xjian'),(71,'1971-06-11','erjiexiaochi','点击头像可以自定义','https://picgorepo.oss-cn-beijing.aliyuncs.com/2023-05-17-10-23-29.png',NULL,NULL,1,'123','二姐小吃');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-07-16 17:37:26

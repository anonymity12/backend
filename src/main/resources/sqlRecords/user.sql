-- generate by tt at 2024 1207
--  show create table user;
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
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=utf8mb4    

-- (2024 1207) todo we need a group_id 



-- phpMyAdmin SQL Dump
-- version 4.4.15.10
-- https://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: 2022-12-02 13:22:28
-- 服务器版本： 5.7.34-log
-- PHP Version: 5.6.40

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `xj`
--

-- --------------------------------------------------------

--
-- 表的结构 `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL COMMENT '用户ID',
  `birthday` date DEFAULT NULL COMMENT '出生日期',
  `name` varchar(32) DEFAULT NULL COMMENT '英文名缩写',
  `intro` varchar(255) DEFAULT NULL COMMENT '介绍',
  `userface` varchar(255) DEFAULT 'https://picgorepo.oss-cn-beijing.aliyuncs.com//2022-12-02-13-04-14img_repo.png' COMMENT '头像',
  `phone` char(11) DEFAULT NULL COMMENT '手机号码',
  `address` varchar(64) DEFAULT NULL COMMENT '联系地址',
  `enabled` tinyint(1) DEFAULT '1',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `cname` varchar(10) NOT NULL COMMENT '中文展示名'
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4;

--
-- 转存表中的数据 `user`
--

INSERT INTO `user` (`id`, `birthday`, `name`, `intro`, `userface`, `phone`, `address`, `enabled`, `password`, `cname`) VALUES
(13, '2016-10-01', 'yy', '今年6岁的樱花玫瑰仔', 'https://picgorepo.oss-cn-beijing.aliyuncs.com//2022-11-23-13-28-38README.png', NULL, NULL, 1, NULL, '玥玥');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',AUTO_INCREMENT=14;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

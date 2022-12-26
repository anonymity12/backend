DROP TABLE IF EXISTS `sixlog`;
CREATE TABLE `sixlog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `article_title` varchar(255) DEFAULT NULL,
  `article_content_html` longtext CHARACTER SET utf8mb4,
  `article_content_md` longtext CHARACTER SET utf8mb4,
  `article_abstract` varchar(255) DEFAULT NULL,
  `article_cover` varchar(255) DEFAULT NULL,
  `article_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4;

-- test data

INSERT INTO `xj`.`sixlog` (`id`, `article_title`, `article_content_html`, `article_content_md`, `article_abstract`, `article_cover`, `article_date`) VALUES (NULL, '30st test page', 'html: 30st test page', 'md: 1st test page', 'abs: 1st test page ', 'https://picgorepo.oss-cn-beijing.aliyuncs.com//2022-02-04-17-37-11img_repo.png', '2022-12-30 00:00:00');
INSERT INTO `xj`.`sixlog` (`id`, `article_title`, `article_content_html`, `article_content_md`, `article_abstract`, `article_cover`, `article_date`) VALUES (NULL, '2st test page', 'html: 2st test page', 'md: 2st test page', 'abs: 2st test page ', 'https://picgorepo.oss-cn-beijing.aliyuncs.com//2022-02-04-17-37-11img_repo.png', '2022-12-02 00:00:00');
INSERT INTO `xj`.`sixlog` (`id`, `article_title`, `article_content_html`, `article_content_md`, `article_abstract`, `article_cover`, `article_date`) VALUES (NULL, '3st test page', 'html: 3st test page', 'md: 3st test page', 'abs: 3st test page ', 'https://picgorepo.oss-cn-beijing.aliyuncs.com//2022-02-04-17-37-11img_repo.png', '2022-12-03 00:00:00');
INSERT INTO `xj`.`sixlog` (`id`, `article_title`, `article_content_html`, `article_content_md`, `article_abstract`, `article_cover`, `article_date`) VALUES (NULL, '4st test page', 'html: 4st test page', 'md: 4st test page', 'abs: 4st test page ', 'https://picgorepo.oss-cn-beijing.aliyuncs.com//2022-02-04-17-37-11img_repo.png', '2022-12-04 00:00:00');
INSERT INTO `xj`.`sixlog` (`id`, `article_title`, `article_content_html`, `article_content_md`, `article_abstract`, `article_cover`, `article_date`) VALUES (NULL, '5st test page', 'html: 5st test page', 'md: 5st test page', 'abs: 5st test page ', 'https://picgorepo.oss-cn-beijing.aliyuncs.com//2022-02-04-17-37-11img_repo.png', '2022-12-05 00:00:00');
INSERT INTO `xj`.`sixlog` (`id`, `article_title`, `article_content_html`, `article_content_md`, `article_abstract`, `article_cover`, `article_date`) VALUES (NULL, '6st test page', 'html: 6st test page', 'md: 6st test page', 'abs: 6st test page ', 'https://picgorepo.oss-cn-beijing.aliyuncs.com//2022-02-04-17-37-11img_repo.png', '2022-12-06 00:00:00');
INSERT INTO `xj`.`sixlog` (`id`, `article_title`, `article_content_html`, `article_content_md`, `article_abstract`, `article_cover`, `article_date`) VALUES (NULL, '7st test page', 'html: 7st test page', 'md: 7st test page', 'abs: 7st test page ', 'https://picgorepo.oss-cn-beijing.aliyuncs.com//2022-02-04-17-37-11img_repo.png', '2022-12-07 00:00:00');
INSERT INTO `xj`.`sixlog` (`id`, `article_title`, `article_content_html`, `article_content_md`, `article_abstract`, `article_cover`, `article_date`) VALUES (NULL, '8st test page', 'html: 8st test page', 'md: 8st test page', 'abs: 8st test page ', 'https://picgorepo.oss-cn-beijing.aliyuncs.com//2022-02-04-17-37-11img_repo.png', '2022-12-08 00:00:00');
INSERT INTO `xj`.`sixlog` (`id`, `article_title`, `article_content_html`, `article_content_md`, `article_abstract`, `article_cover`, `article_date`) VALUES (NULL, '9st test page', 'html: 9st test page', 'md: 9st test page', 'abs: 9st test page ', 'https://picgorepo.oss-cn-beijing.aliyuncs.com//2022-02-04-17-37-11img_repo.png', '2022-12-09 00:00:00');
INSERT INTO `xj`.`sixlog` (`id`, `article_title`, `article_content_html`, `article_content_md`, `article_abstract`, `article_cover`, `article_date`) VALUES (NULL, '10st test page', 'html: 10st test page', 'md: 10st test page', 'abs: 10st test page ', 'https://picgorepo.oss-cn-beijing.aliyuncs.com//2022-02-04-17-37-11img_repo.png', '2022-12-10 00:00:00');
INSERT INTO `xj`.`sixlog` (`id`, `article_title`, `article_content_html`, `article_content_md`, `article_abstract`, `article_cover`, `article_date`) VALUES (NULL, '11st test page', 'html: 11st test page', 'md: 11st test page', 'abs: 11st test page ', 'https://picgorepo.oss-cn-beijing.aliyuncs.com//2022-02-04-17-37-11img_repo.png', '2022-12-11 00:00:00');
-- phpMyAdmin SQL Dump
-- version 3.2.4
-- http://www.phpmyadmin.net
--
-- 主机: localhost
-- 生成日期: 2013 年 05 月 04 日 12:30
-- 服务器版本: 5.1.41
-- PHP 版本: 5.3.1

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- 数据库: `zpro`
--

-- --------------------------------------------------------

--
-- 表的结构 `authority`
--

CREATE TABLE IF NOT EXISTS `authority` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- 转存表中的数据 `authority`
--

INSERT INTO `authority` (`id`, `name`) VALUES
(1, '冰迪');

-- --------------------------------------------------------

--
-- 表的结构 `role`
--

CREATE TABLE IF NOT EXISTS `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=12 ;

--
-- 转存表中的数据 `role`
--

INSERT INTO `role` (`id`, `name`) VALUES
(8, '超级用户'),
(9, '管理员'),
(10, '普通用户'),
(11, '查询用户');

-- --------------------------------------------------------

--
-- 表的结构 `role_authority`
--

CREATE TABLE IF NOT EXISTS `role_authority` (
  `ROLE_ID` bigint(20) NOT NULL,
  `AUTHORITY_ID` bigint(20) NOT NULL,
  KEY `FK327EE9ACC516E9C` (`AUTHORITY_ID`),
  KEY `FK327EE9A341EDCF8` (`ROLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `role_authority`
--


-- --------------------------------------------------------

--
-- 表的结构 `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- 转存表中的数据 `user`
--

INSERT INTO `user` (`id`, `email`, `name`, `password`) VALUES
(1, '', '中国人', ''),
(2, '', '中国佃', ''),
(3, '', '测试2', '');

-- --------------------------------------------------------

--
-- 表的结构 `user_role`
--

CREATE TABLE IF NOT EXISTS `user_role` (
  `USER_ID` bigint(20) NOT NULL,
  `ROLE_ID` bigint(20) NOT NULL,
  KEY `FKBC16F46A341EDCF8` (`ROLE_ID`),
  KEY `FKBC16F46AD949A0D8` (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `user_role`
--

INSERT INTO `user_role` (`USER_ID`, `ROLE_ID`) VALUES
(3, 8),
(3, 10);

--
-- 限制导出的表
--

--
-- 限制表 `role_authority`
--
ALTER TABLE `role_authority`
  ADD CONSTRAINT `FK327EE9A341EDCF8` FOREIGN KEY (`ROLE_ID`) REFERENCES `role` (`id`),
  ADD CONSTRAINT `FK327EE9ACC516E9C` FOREIGN KEY (`AUTHORITY_ID`) REFERENCES `authority` (`id`);

--
-- 限制表 `user_role`
--
ALTER TABLE `user_role`
  ADD CONSTRAINT `FKBC16F46A341EDCF8` FOREIGN KEY (`ROLE_ID`) REFERENCES `role` (`id`),
  ADD CONSTRAINT `FKBC16F46AD949A0D8` FOREIGN KEY (`USER_ID`) REFERENCES `user` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

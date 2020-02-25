# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.7.12)
# Database: LWCBMSDB
# Generation Time: 2020-02-25 12:38:12 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table booktable
# ------------------------------------------------------------

DROP TABLE IF EXISTS `booktable`;

CREATE TABLE `booktable` (
  `bookid` int(11) NOT NULL AUTO_INCREMENT,
  `bookname` varchar(45) NOT NULL DEFAULT '',
  `author` varchar(45) DEFAULT '',
  `price` float DEFAULT NULL,
  `category` varchar(45) DEFAULT '',
  `remark` varchar(45) DEFAULT '',
  `bookinfo` varchar(1000) DEFAULT '',
  PRIMARY KEY (`bookid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `booktable` WRITE;
/*!40000 ALTER TABLE `booktable` DISABLE KEYS */;

INSERT INTO `booktable` (`bookid`, `bookname`, `author`, `price`, `category`, `remark`, `bookinfo`)
VALUES
	(1,'Objective-C基础教程','达尔林普尔',54,'计算机','我的ios开发起点','Objective-C是扩展C的面向对象编程语言，也是iphone开发用到的主要语言。本书结合理论知识与示例程序，全面而系统地讲述Objective-C在C的基础上引入的特性和Cocoa工具包的功能即其中的框架'),
	(2,'java','肖云鹏',55,'计算机','重点','（无详细信息）'),
	(3,'swift','佚名',50,'计算机','未来重点','（无详细信息）'),
	(6,'C++','陈君',48,'计算机','第一门语言','（无详细信息）'),
	(10,'Html','佚名',43,'计算机','第一次自学','（无详细信息）'),
	(11,'ios开发指南','关东升',51,'计算机','未来重点','（无详细信息）'),
	(12,'数据结构','肖云鹏',99,'计算机','基础知识','（无详细信息）'),
	(13,'数据库','佚名',47,'计算机','基础知识','（无详细信息）'),
	(14,'离散数学','胖子老师',42,'数学','自信及格','（无详细信息）'),
	(15,'高等数学','徐荣先',33,'数学','考研噩梦','（无详细信息）'),
	(16,'大学英语-读写译','陈红',20,'外语','无聊','（无详细信息）'),
	(17,'体育-羽毛球','彭国芳',30,'生活','忠实粉丝','（无详细信息）'),
	(18,'形势与政策','熊静',20,'哲学','作者好漂亮','《形势与政策》这本书依据教育部“形势与政策”最新教学要点，结合高校“形势与政策”课教学实际，在介绍当前国内外经济政治形势、国际关系以及国内外热点事件的基础上，阐明了我国政府的基本原则、基本立场与应对政策。'),
	(19,'爸爸','妈妈',999,'我','爱你们','想你们！~'),
	(21,'今天','是个',1,'好','日子','122'),
	(23,'这里是','修改',1,'图书','测试','1'),
	(26,'bookname','author',1111,'category','remark','（无详细信息）'),
	(32,'nice to meet you :)','大美女',99,'故事','一个浪漫的爱情故事','（无详细信息）');

/*!40000 ALTER TABLE `booktable` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table userlist
# ------------------------------------------------------------

DROP TABLE IF EXISTS `userlist`;

CREATE TABLE `userlist` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL DEFAULT '',
  `password` varchar(45) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `userlist` WRITE;
/*!40000 ALTER TABLE `userlist` DISABLE KEYS */;

INSERT INTO `userlist` (`id`, `username`, `password`)
VALUES
	(1,'小白云','920725'),
	(2,'administrator','920725'),
	(3,'user','920725');

/*!40000 ALTER TABLE `userlist` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

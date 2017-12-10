-- ----------------------------
-- Table structure for items
-- ----------------------------
create table `user` (
	`id` int(11) NOT NULL auto_increment,
	`username` varchar(50) default NULL,
	`password` varchar(50) default NULL,
	`gender` varchar(10) default NULL,
	`age` int(3) default NULL,
	PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
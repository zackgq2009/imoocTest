CREATE TABLE IF NOT EXISTS `user_cart` (
   `cart_id` INT(11) UNSIGNED AUTO_INCREMENT,
   `user_id` INT(11) NOT NULL,
   `iterm_id` INT(11) NOT NULL,
   `cart_iterm_amount` INT(6) NOT NULL,
   PRIMARY KEY (`cart_id`),
	 FOREIGN KEY(`user_id`) REFERENCES `user`(`id`) on delete cascade on update cascade,
	 FOREIGN KEY(`iterm_id`) REFERENCES `iterm`(`id`) on delete cascade on update cascade
)ENGINE=InnoDB AUTO_INCREMENT=1 CHARSET=utf8;
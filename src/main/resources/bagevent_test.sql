create database bagevent_test;
use bagevent_test;

create table  if not exists `User`(
 `user_id` int(11) not null auto_increment comment '用户id',
 `user_name` varchar(255) not null comment '用户名',
 `email` varchar(255) not null comment'用户邮箱',
 `cellphone` varchar(255) not null comment '手机号码',
 `password` varchar(255) not null comment '密码',
 `salt` varchar(255) default null comment'加密盐',
 `state` int(1) default null comment '0表示删除，1表示正常',
 `create_time` datetime comment '创建时间',
 primary key(`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table if not exists `UserLoginLog`(
 `login_id` int(11) not null auto_increment comment '用户登录记录',
 `user_id` int(11) not null comment '用户id',
 `login_time` datetime not null comment '登录时间',
 `login_ip` varchar(255) not null comment '登录ip',
 primary key(`login_id`),1
 foreign key(`user_id`) references User(`user_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into user(user_name,email,cellphone,password) values("admin","123@123.com","1234","admin");



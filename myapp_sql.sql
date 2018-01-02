

SET FOREIGN_KEY_CHECKS=0;

CREATE DATABASE `myapp`
    CHARACTER SET 'utf8'
    COLLATE 'utf8_general_ci';

#
# Structure for the `student` table : 
#

USE myapp;

CREATE TABLE `student` (
  `stu_number` VARCHAR(20) NOT NULL,
  `name` varchar(20) default NULL,
  `gender` varchar(4) default NULL,
  `city` varchar(20) default NULL,
  `id_number` varchar(120) default NULL,
  `phone` varchar(20) default NULL,
  `email` varchar(20) default NULL,
  `post_code` varchar(20) default NULL,
  `address` varchar(20) default NULL,
  PRIMARY KEY  (`stu_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Structure for the `grade` table : 
#

CREATE TABLE `grade` (
  `grade_id` bigint(20) NOT NULL auto_increment,
  `student_id` varchar(20) NOT NULL,
  `course` varchar(20) default NULL,
  `score` int(11) default NULL,
  PRIMARY KEY  (`grade_id`),
  KEY `FK41DCFB7D3895871` (`student_id`),
  CONSTRAINT `FK41DCFB7D3895871` FOREIGN KEY (`student_id`) REFERENCES `student` (`stu_number`),
  CONSTRAINT `FK_student_grade_relaitonship` FOREIGN KEY (`student_id`) REFERENCES `student` (`stu_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Structure for the `users` table : 
#

CREATE TABLE `users` (
  `user_id` bigint(20) NOT NULL auto_increment,
  `username` varchar(20) default NULL,
  `password` varchar(20) default NULL,
  `role` int(11) default NULL,
  PRIMARY KEY  (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for the `student` table  (LIMIT 0,500)
#

INSERT INTO `student` (`stu_number`, `name`, `gender`, `city`, `id_number`, `phone`, `email`, `post_code`, `address`) VALUES 
  ('2010139564','刘德华','1','合肥','441455222212120145','139','12@123.com','055110','glhy'),
  ('2010240379','张曼玉','0','安微','110212345698456321','135','xuepingjiao@163.com','230031','蜀山区贵池路广利花园1T?');

COMMIT;

#
# Data for the `users` table  (LIMIT 0,500)
#

INSERT INTO `users` (`user_id`, `username`, `password`, `role`) VALUES 
  (1,'admin','pass',1),
  (2,'user','pass',0);

COMMIT;
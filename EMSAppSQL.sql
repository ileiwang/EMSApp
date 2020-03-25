#若存在，先删除
DROP DATABASE IF EXISTS emsapp;
#创建数据库
CREATE DATABASE emsapp;
#使用数据库
USE emsapp;


#管理员号码 XXXX(入职年份)01-XXXX(入职年份)99
#学院编号 11-99
#专业编号 XX(学院编号)01-XX(学院编号)99
#班级编号 XXXX(专业编号)01-XXXX(专业编号)99
#学生编号 XXXX(入学年份)XXXXXX(班级编号)01-XXXX(入学年份)XXXXXX(班级编号)99
#教师编号 XXXX(入职年份)XXXX(专业编号)01-XXXX(入职年份)XXXX(专业编号)99
#课程号 XXXX(专业编号)001-XXXX(专业编号)999


#创建学院表
CREATE TABLE college(
	id INT(12) NOT NULL AUTO_INCREMENT,
	num VARCHAR(12) NOT NULL UNIQUE,
	name VARCHAR(18) NOT NULL UNIQUE,
	PRIMARY KEY (id)
)ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

#插入学院表
INSERT INTO college(num,name)
VALUES 
('11','矿业与安全工程学院'),
('12','测绘科学与工程学院'),
('13','地球科学与工程学院'),
('14','土木工程与建筑学院'),
('15','机械电子工程学院'),
('16','计算机科学与工程学院'),
('17','数学与系统科学学院'),
('18','经济管理学院'),
('19','电气与自动化工程学院'),
('20','电子通信与物理学院'),
('21','化学与环境工程学院'),
('22','材料科学与工程学院'),
('23','交通学院'),
('24','文法学院'),
('25','外国语学院'),
('26','艺术与设计学院'),
('27','马克思主义学院'),
('28','体育学院'),
('29','继续教育学院');


#建立学院表索引
CREATE UNIQUE INDEX collegeid ON college(id ASC);
CREATE UNIQUE INDEX collegenum ON college(num ASC);
CREATE UNIQUE INDEX collegename ON college(name);


#创建专业表
CREATE TABLE major(
	id INT(12) NOT NULL AUTO_INCREMENT,
	num VARCHAR(12) NOT NULL UNIQUE,
	name VARCHAR(18) NOT NULL UNIQUE,
	clazznum INT(5) NOT NULL,
	college_id INT(12) NOT NULL,
	PRIMARY KEY (id),
	KEY FK_MAJOR_COLLEGE (college_id),
	CONSTRAINT FK_MAJOR_COLLEGE FOREIGN KEY (college_id) REFERENCES college (id) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

#插入专业表数据
INSERT INTO major(num,name,clazznum,college_id)
VALUES
('1601','计算机科学与技术','3','6'),
('1602','软件工程','3','6'),
('1603','物联网工程','3','6'),
('1604','网络工程','1','6'),
('1605','信息安全','5','6');

#创建专业表索引
CREATE UNIQUE INDEX majorid ON major(id ASC);
CREATE UNIQUE INDEX majornum ON major(num ASC);
CREATE UNIQUE INDEX majorname ON major(name);


#建立教师表
CREATE TABLE teacher(
	id INT(12) NOT NULL AUTO_INCREMENT,
	num VARCHAR(12) NOT NULL UNIQUE,
	name VARCHAR(18) NOT NULL,
	birthday TIMESTAMP NOT NULL,
	idcard VARCHAR(20) NOT NULL,
	sex VARCHAR(5) NOT NULL CHECK(sex IN('男','女')),
	password VARCHAR(20) NOT NULL,
	tel VARCHAR(20) NOT NULL,
	qq VARCHAR(20) NOT NULL,
	email VARCHAR(30) NOT NULL,
	address VARCHAR(20) NOT NULL,
	major_id INT(12) NOT NULL,
	PRIMARY KEY (id),
	KEY FK_TEACHER_MAJOR (major_id),
	CONSTRAINT FK_TEACHER_MAJOR FOREIGN KEY (major_id) REFERENCES major (id)
)ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

#插入教师表
INSERT INTO teacher(num,name,birthday,idcard,sex,password,tel,qq,email,address,major_id)
VALUES
('2009160201','李一','1987-01-01 00:00:00','123456198701011234','男','liyi12345','17805412346','20001','liyi@qq.com','山东科技大学','2'),
('2000160202','李二','1987-02-02 00:00:00','123456198702021234','男','lier12345','17905412346','20002','lier@qq.com','山东科技大学','2'),
('2009160203','李三','1977-03-03 00:00:00','123456197703031234','男','lisan12345','13905412346','20003','lisan@qq.com','山东科技大学','2'),
('2009160204','李四','1987-04-04 00:00:00','123456198704041234','男','lisi12345','13805412346','20004','lisi@qq.com','山东科技大学','2'),
('2009160205','李五','1977-05-05 00:00:00','123456197705051234','男','liwu12345','15905412346','20005','liwu@qq.com','山东科技大学','2'),
('2009160206','李六','1979-05-05 00:00:00','123456197905051234','男','liliu12345','15505412346','20006','liliu@qq.com','山东科技大学','2'),
('2009160207','李七','1973-05-05 00:00:00','123456197305051234','男','liqi12345','15605412346','20007','liqi@qq.com','山东科技大学','2'),
('2009160208','李八','1974-05-05 00:00:00','123456197405051234','男','liba12345','15805412346','20008','liba@qq.com','山东科技大学','2'),
('2009160101','周一','1986-01-01 00:00:00','123456198601011234','男','zhouyi12345','17805422346','20011','zhouyi@qq.com','山东科技大学','1'),
('2001160102','周二','1986-02-02 00:00:00','123456198602021234','男','zhouer12345','17905422346','20012','zhouer@qq.com','山东科技大学','1'),
('2009160103','周三','1977-03-03 00:00:00','123456197703031234','男','zhousan12345','13905422346','20013','zhousan@qq.com','山东科技大学','1'),
('2009160104','周四','1986-04-04 00:00:00','123456198604041234','男','zhousi12345','13805422346','20014','zhousi@qq.com','山东科技大学','1'),
('2009160105','周五','1977-05-05 00:00:00','123456197705051234','男','zhouwu12345','15905422346','20015','zhouwu@qq.com','山东科技大学','1'),
('2009160106','周六','1979-05-05 00:00:00','123456197905051234','男','zhoulu12345','15505422346','20016','zhoulu@qq.com','山东科技大学','1'),
('2009160107','周七','1973-05-05 00:00:00','123456197305051234','男','zhouqi12345','15605422346','20017','zhouqi@qq.com','山东科技大学','1'),
('2009160108','周八','1974-05-05 00:00:00','123456197405051234','男','zhouba12345','15805422346','20018','zhouba@qq.com','山东科技大学','1'),
('2009160301','钱一','1985-01-01 00:00:00','123456198501011234','男','qianyi12345','17805432346','20021','qianyi@qq.com','山东科技大学','3'),
('2002160302','钱二','1985-02-02 00:00:00','123456198502021234','男','qianer12345','17905432346','20022','qianer@qq.com','山东科技大学','3'),
('2009160303','钱三','1979-03-03 00:00:00','123456197903031234','男','qiansan12345','13905432346','20023','qiansan@qq.com','山东科技大学','3'),
('2009160401','吴一','1990-01-01 00:00:00','123456199001011234','男','wuyi12345','17805432346','20031','wuyi@qq.com','山东科技大学','4'),
('2003160402','吴二','1990-02-02 00:00:00','123456199002021234','男','wuer12345','17605432346','20032','wuer@qq.com','山东科技大学','4'),
('2009160403','吴三','1976-03-03 00:00:00','123456197603031234','男','wusan12345','13905432346','20033','wusan@qq.com','山东科技大学','4'),
('2009160501','诸葛一','1978-01-01 00:00:00','123456197801011234','男','zhugeyi12345','17805442346','20041','zhugeyi@qq.com','山东科技大学','5'),
('2004160502','诸葛二','1978-02-02 00:00:00','123456197802021234','男','zhugeer12345','17205442346','20042','zhugeer@qq.com','山东科技大学','5'),
('2009160503','诸葛三','1972-03-03 00:00:00','123456197203031234','男','zhugesan12345','13785442346','20043','zhugesan@qq.com','山东科技大学','5');

#教师表索引
CREATE UNIQUE INDEX teacherid ON teacher(id ASC);
CREATE UNIQUE INDEX teachernum ON teacher(num ASC);
CREATE INDEX teachername ON teacher(name);


#创建课程表
CREATE TABLE course(
	id INT(12) NOT NULL AUTO_INCREMENT,
	num VARCHAR(12) NOT NULL UNIQUE,
	day INT(12) NOT NULL,
	coursetime INT(12) NOT NULL,
	start INT(12) NOT NULL,
	last INT(12) NOT NULL,
	credit INT(12) NOT NULL,
	place VARCHAR(50) NOT NULL,
	name VARCHAR(18) NOT NULL UNIQUE,
	major_id INT(12) NOT NULL,
	teacher_id INT(12) NOT NULL,
	PRIMARY KEY (id),
	KEY FK_COURSE_MAJOR(major_id),
	KEY FK_COURSE_TEACHER(teacher_id),
	CONSTRAINT FK_COURSE_MAJOR FOREIGN KEY (major_id) REFERENCES major(id) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT FK_COURSE_TEACHER FOREIGN KEY (teacher_id) REFERENCES teacher(id) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

#插入课程表
INSERT INTO course(num,day,coursetime,start,last,credit,place,name,major_id,teacher_id)
VALUES
('1602001','1','2','1','14','3','J5-302','计算机操作系统','2','1'),
('1602002','2','3','5','16','3','J5-208','软件构造','2','2'),
('1602003','1','1','1','8','3','J7-314','公共管理学','2','3'),
('1602004','2','2','1','12','3','J5-302','计算机网络','2','4'),
('1602005','1','3','11','18','3','J7-203','软件测试与质量','2','5'),
('1602006','1','5','11','18','3','J7-215','微机原理与接口技术','2','6'),
('1602007','3','3','11','18','3','J7-303','人机交互的软件','2','7'),
('1601001','1','2','1','14','3','J5-102','计算机科学','2','9'),
('1601002','2','3','5','16','3','J5-408','电路','2','10'),
('1601003','1','1','1','8','3','J7-114','数字逻辑','2','11'),
('1601004','2','2','1','12','3','J5-102','数字电路','2','12'),
('1601005','1','3','11','18','3','J7-103','模拟电路','2','13'),
('1601006','1','5','11','18','3','J7-115','人工智能','2','14'),
('1601007','3','3','11','18','3','J7-103','数据挖掘','2','15'),
('1603001','1','2','1','14','3','J1-102','物联网技术','2','17'),
('1603002','2','3','5','16','3','J1-408','物联网概论','2','18'),
('1603003','1','1','1','8','3','J1-114','物联网科学','2','19'),
('1604001','1','2','1','14','3','J1-102','网络安全','2','20'),
('1604002','2','3','5','16','3','J1-408','网络工程概论','2','21'),
('1604003','1','1','1','8','3','J1-114','网络原理','2','22'),
('1605001','1','2','1','14','3','J13-102','信息安全','2','23'),
('1605002','2','3','5','16','3','J13-408','信息安全专业导论','2','24'),
('1605003','1','1','1','8','3','J13-114','信息安全工程','2','25');

#建立课程表索引
CREATE UNIQUE INDEX courseid ON course(id ASC);
CREATE UNIQUE INDEX coursenum ON course(num ASC);
CREATE UNIQUE INDEX coursename ON course(name);


#创建班级表
CREATE TABLE clazz(
	id INT(12) NOT NULL AUTO_INCREMENT,
	num VARCHAR(12) NOT NULL UNIQUE,
	stunum INT(12) NOT NULL,
	name VARCHAR(18) NOT NULL UNIQUE,
	major_id INT(12) NOT NULL,
	PRIMARY KEY (id),
	KEY FK_CLAZZ_MAJOR (major_id),
	CONSTRAINT FK_CLAZZ_MAJOR FOREIGN KEY (major_id) REFERENCES major(id) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

#插入班级表数据
INSERT INTO clazz(num,stunum,name,major_id)
VALUES 
('160201','45','软件工程2016-1','2'),
('160202','50','软件工程2016-2','2'),
('160203','55','软件工程2016-3','2'),
('160101','45','计算机科学与技术2016-1','1'),
('160102','46','计算机科学与技术2016-2','1'),
('160103','47','计算机科学与技术2016-3','1'),
('160104','49','计算机科学与技术2016-4','1'),
('160401','49','网络工程2016','4'),
('160301','47','物联网工程2016-1','3'),
('160302','49','物联网工程2016-2','3'),
('160303','50','物联网工程2016-3','3'),
('160501','49','信息安全2016-1','5'),
('160502','49','信息安全2016-2','5');


#创建班级表索引
CREATE UNIQUE INDEX clazzid ON clazz(id ASC);
CREATE UNIQUE INDEX clazznum ON clazz(num ASC);
CREATE UNIQUE INDEX clazzname ON clazz(name);


#创建学生表
CREATE TABLE student(
	id INT(12) NOT NULL AUTO_INCREMENT,
	num VARCHAR(18) NOT NULL UNIQUE,
	name VARCHAR(18) NOT NULL,
	birthday TIMESTAMP NOT NULL,
	idcard VARCHAR(20) NOT NULL UNIQUE,
	sex VARCHAR(5) NOT NULL CHECK(sex IN('男','女')),
	password VARCHAR(20) NOT NULL,
	tel VARCHAR(20) NOT NULL,
	qq VARCHAR(20) NOT NULL,
	email VARCHAR(30) NOT NULL,
	address VARCHAR(20) NOT NULL,
	clazz_id INT(12) NOT NULL,
	PRIMARY KEY (id),
	KEY FK_STUDENT_CLAZZ (clazz_id),
	CONSTRAINT FK_STUDENT_CLAZZ FOREIGN KEY (clazz_id) REFERENCES clazz (id) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

#插入学生表数据
INSERT INTO student(num,name,birthday,idcard,sex,password,tel,qq,email,address,clazz_id)
VALUES
('201616020301','王一','1997-01-01 00:00:00','123456199701011234','男','wangyi12345','17805412345','10001','wangyi@qq.com','山东科技大学','3'),
('201616020302','王二','1997-02-02 00:00:00','123456199702021234','男','wanger12345','17905412345','10002','wanger@qq.com','山东科技大学','3'),
('201616020303','王三','1997-03-03 00:00:00','123456199703031234','男','wangsan12345','13905412345','10003','wangsan@qq.com','山东科技大学','3'),
('201616020304','王四','1997-04-04 00:00:00','123456199704041234','男','wangsi12345','13805412345','10004','wangsi@qq.com','山东科技大学','3'),
('201616020305','王五','1997-05-05 00:00:00','123456199705051234','男','wangwu12345','15905412345','10005','wangwu@qq.com','山东科技大学','3'),
('201616020306','王六','1997-06-06 00:00:00','123456199706061234','男','wangliu12345','13405412345','10006','wangliu@qq.com','山东科技大学','3'),
('201616020307','王七','1997-07-07 00:00:00','123456199707071234','男','wangqi12345','13505412345','10007','wangqi@qq.com','山东科技大学','3'),
('201616020308','王八','1997-08-08 00:00:00','123456199708081234','男','wangba12345','13605412345','10008','wangba@qq.com','山东科技大学','3'),
('201616020309','王九','1997-09-09 00:00:00','123456199709091234','男','wangjiu12345','13705412345','10009','wangjiu@qq.com','山东科技大学','3'),
('201616010101','张一','1998-01-01 00:00:00','123456199801011234','男','zhangyi12345','17815412345','10011','zhangyi@qq.com','山东科技大学','4'),
('201616010102','张二','1998-02-02 00:00:00','123456199802021234','男','zhanger12345','17915412345','10012','zhanger@qq.com','山东科技大学','4'),
('201616010103','张三','1998-03-03 00:00:00','123456199803031234','男','zhangsan12345','13915412345','10013','zhangsan@qq.com','山东科技大学','4'),
('201616010104','张四','1998-04-04 00:00:00','123456199804041234','男','zhangsi12345','13815412345','10014','zhangsi@qq.com','山东科技大学','4'),
('201616010105','张五','1998-05-05 00:00:00','123456199805051234','男','zhangwu12345','15915412345','10015','zhangwu@qq.com','山东科技大学','4'),
('201616010106','张六','1998-06-06 00:00:00','123456199806061234','男','zhangliu12345','13415412345','10016','zhangliu@qq.com','山东科技大学','4'),
('201616010107','张七','1998-07-07 00:00:00','123456199807071234','男','zhangqi12345','13515412345','10017','zhangqi@qq.com','山东科技大学','4'),
('201616010108','张八','1998-08-08 00:00:00','123456199808081234','男','zhangba12345','13615412345','10018','zhangba@qq.com','山东科技大学','4'),
('201616010109','张九','1998-09-09 00:00:00','123456199809091234','男','zhangjiu12345','13715412345','10019','zhangjiu@qq.com','山东科技大学','4'),
('201616040101','孙一','1996-01-01 00:00:00','123456199601011234','男','sunyi12345','17825412345','10021','sunyi@qq.com','山东科技大学','8'),
('201616040102','孙二','1996-02-02 00:00:00','123456199602021234','男','suner12345','17925412345','10022','suner@qq.com','山东科技大学','8'),
('201616040103','孙三','1996-03-03 00:00:00','123456199603031234','男','sunsan12345','13925412345','10023','sunsan@qq.com','山东科技大学','8'),
('201616040104','孙四','1996-04-04 00:00:00','123456199604041234','男','sunsi12345','13825412345','10024','sunsi@qq.com','山东科技大学','8'),
('201616040105','孙五','1996-05-05 00:00:00','123456199605051234','男','sunwu12345','15925412345','10025','sunwu@qq.com','山东科技大学','8'),
('201616040106','孙六','1996-06-06 00:00:00','123456199606061234','男','sunliu12345','13425412345','10026','sunliu@qq.com','山东科技大学','8'),
('201616040107','孙七','1996-07-07 00:00:00','123456199607071234','男','sunqi12345','13525412345','10027','sunqi@qq.com','山东科技大学','8'),
('201616040108','孙八','1996-08-08 00:00:00','123456199608081234','男','sunba12345','13625412345','10028','sunba@qq.com','山东科技大学','8'),
('201616040109','孙九','1996-09-09 00:00:00','123456199609091234','男','sunjiu12345','13725412345','10029','sunjiu@qq.com','山东科技大学','8'),
('201616030101','陈一','1999-01-01 00:00:00','123456199901011234','男','chenyi12345','17835412345','10031','chenyi@qq.com','山东科技大学','9'),
('201616030102','陈二','1999-02-02 00:00:00','123456199902021234','男','chener12345','17935412345','10032','chener@qq.com','山东科技大学','9'),
('201616030103','陈三','1999-03-03 00:00:00','123456199903031234','男','chensan12345','13935412345','10033','chensan@qq.com','山东科技大学','9'),
('201616030104','陈四','1999-04-04 00:00:00','123456199904041234','男','chensi12345','13835412345','10034','chensi@qq.com','山东科技大学','9'),
('201616030105','陈五','1999-05-05 00:00:00','123456199905051234','男','chenwu12345','15935412345','10035','chenwu@qq.com','山东科技大学','9'),
('201616030106','陈六','1999-06-06 00:00:00','123456199906061234','男','chenliu12345','13435412345','10036','chenliu@qq.com','山东科技大学','9'),
('201616030107','陈七','1999-07-07 00:00:00','123456199907071234','男','chenqi12345','13535412345','10037','chenqi@qq.com','山东科技大学','9'),
('201616030108','陈八','1999-08-08 00:00:00','123456199908081234','男','chenba12345','13635412345','10038','chenba@qq.com','山东科技大学','9'),
('201616030109','陈九','1999-09-09 00:00:00','123456199909091234','男','chenjiu12345','13735412345','10039','chenjiu@qq.com','山东科技大学','9'),
('201616050101','赵一','1995-01-01 00:00:00','123456199501011234','男','zhaoyi12345','17845412345','10041','zhaoyi@qq.com','山东科技大学','12'),
('201616050102','赵二','1995-02-02 00:00:00','123456199502021234','男','zhaoer12345','17945412345','10042','zhaoer@qq.com','山东科技大学','12'),
('201616050103','赵三','1995-03-03 00:00:00','123456199503031234','男','zhaosan12345','13945412345','10043','zhaosan@qq.com','山东科技大学','12'),
('201616050104','赵四','1995-04-04 00:00:00','123456199504041234','男','zhaosi12345','13845412345','10044','zhaosi@qq.com','山东科技大学','12'),
('201616050105','赵五','1995-05-05 00:00:00','123456199505051234','男','zhaowu12345','15945412345','10045','zhaowu@qq.com','山东科技大学','12'),
('201616050106','赵六','1995-06-06 00:00:00','123456199506061234','男','zhaoliu12345','13445412345','10046','zhaoliu@qq.com','山东科技大学','12'),
('201616050107','赵七','1995-07-07 00:00:00','123456199507071234','男','zhaoqi12345','13545412345','10047','zhaoqi@qq.com','山东科技大学','12'),
('201616050108','赵八','1995-08-08 00:00:00','123456199508081234','男','zhaoba12345','13645412345','10048','zhaoba@qq.com','山东科技大学','12'),
('201616050109','赵九','1995-09-09 00:00:00','123456199509091234','男','zhaojiu12345','13745412345','10049','zhaojiu@qq.com','山东科技大学','12');

#创建学生表索引
CREATE UNIQUE INDEX studentid ON student(id ASC);
CREATE UNIQUE INDEX studentnum ON student(num ASC);
CREATE INDEX studentname ON student(name);


#创建选课表
CREATE TABLE stucou_item(
student_id INT NOT NULL,
course_id INT NOT NULL,
PRIMARY KEY(student_id,course_id),
FOREIGN KEY (student_id) REFERENCES student(id) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (course_id) REFERENCES course(id) ON DELETE CASCADE ON UPDATE CASCADE
);

#插入选课表数据
INSERT INTO stucou_item(student_id,course_id)
VALUES
('1','1'),
('1','2'),
('1','3'),
('1','4'),
('1','5'),

('2','1'),
('2','2'),
('2','3'),
('2','4'),
('2','5'),


('3','1'),
('3','2'),
('3','3'),
('3','4'),
('3','5'),
('3','6'),
('3','7'),

('4','1'),
('4','2'),
('4','3'),
('4','4'),
('4','5'),
('4','6'),
('4','7'),


('5','1'),
('5','2'),
('5','3'),
('5','4'),

('10','8'),
('10','9'),
('10','10'),
('10','11'),
('10','12'),
('10','13'),
('10','14'),
('11','8'),
('11','9'),
('11','10'),
('11','11'),
('11','12'),
('11','13'),
('11','14'),

('12','8'),
('12','10'),
('12','11'),
('12','12'),
('12','14'),

('28','15'),
('28','16'),
('28','17'),
('29','15'),
('29','16'),
('29','17'),
('30','15'),
('30','16'),
('30','17');


#创建选课表索引
CREATE UNIQUE INDEX stucou ON stucou_item(student_id ASC,course_id ASC);


#创建成绩表
CREATE TABLE score(
	id INT(12) NOT NULL AUTO_INCREMENT,
	score INT(5) NOT NULL CHECK(score>=0 AND score<=100),
	course_id INT(12) NOT NULL,
	student_id INT(12) NOT NULL,
	PRIMARY KEY (id),
	KEY FK_SCORE_COURSE(course_id),
	KEY FK_SCORE_STUDENT(student_id),
	CONSTRAINT FK_SCORE_COURSE FOREIGN KEY (course_id) REFERENCES course(id) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT FK_SCORE_STUDENT FOREIGN KEY (student_id) REFERENCES student(id) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

#插入成绩表数据
INSERT INTO score(score,course_id,student_id)
VALUES
('98','1','1'),
('98','2','1'),
('73','3','1'),
('65','4','1'),
('59','5','1'),
('99','1','2'),
('97','2','2'),
('94','3','2'),
('92','4','2'),
('95','5','2'),
('99','1','3'),
('97','2','3'),
('94','3','3'),
('92','4','3'),
('95','5','3'),
('99','6','3'),
('97','7','3'),
('99','1','4'),
('97','2','4'),
('94','3','4'),
('92','4','4'),
('95','5','4'),
('99','6','4'),
('97','7','4'),
('99','1','5'),
('97','2','5'),
('94','3','5'),
('92','4','5'),
('94','8','10'),
('78','9','10'),
('89','10','10'),
('86','11','10'),
('85','12','10'),
('98','13','10'),
('97','14','10'),
('94','8','11'),
('78','9','11'),
('89','10','11'),
('86','11','11'),
('85','12','11'),
('98','13','11'),
('97','14','11'),
('89','8','12'),
('86','10','12'),
('85','11','12'),
('98','12','12'),
('97','14','12'),
('89','15','28'),
('86','16','28'),
('85','17','28'),
('89','15','29'),
('86','16','29'),
('85','17','29'),
('89','15','30'),
('86','16','30'),
('85','17','30');


#创建成绩表索引
CREATE UNIQUE INDEX scoreid ON score(id ASC);
CREATE INDEX scorescore ON score(score DESC);
CREATE UNIQUE INDEX scorestucou ON score(student_id ASC,course_id ASC);


#管理员表
CREATE TABLE admin(
	id INT(12) NOT NULL AUTO_INCREMENT,
	num VARCHAR(12) NOT NULL UNIQUE,
	name VARCHAR(18) NOT NULL,
	birthday TIMESTAMP NOT NULL,
	idcard VARCHAR(20) NOT NULL,
	sex VARCHAR(5) NOT NULL CHECK(sex IN('男','女')),
	password VARCHAR(20) NOT NULL,
	tel VARCHAR(20) NOT NULL,
	qq VARCHAR(20) NOT NULL,
	email VARCHAR(30) NOT NULL,
	address VARCHAR(20) NOT NULL,
	PRIMARY KEY (id)
)ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

#插入管理员表数据
INSERT INTO admin(num,name,birthday,idcard,sex,password,tel,qq,email,address)
VALUES 
('200301','管理员1','1978-01-01 00:00:00','123456197801010001','男','admin1','13987698765','1010102','1010102@qq.com','青岛市黄岛区前湾港路579号'),
('200302','管理员2','1979-02-01 00:00:00','123456197902010001','男','admin2','13987698766','1010103','1010103@qq.com','青岛市黄岛区前湾港路579号'),
('200301','管理员3','1980-01-01 00:00:00','123456198001010001','女','admin3','13987698767','1010104','1010104@qq.com','青岛市黄岛区前湾港路579号'),
('200301','管理员4','1981-01-01 00:00:00','123456198101010001','男','admin4','13987698768','1010105','1010105@qq.com','青岛市黄岛区前湾港路579号'),
('200301','管理员5','1982-01-01 00:00:00','123456198201010001','男','admin5','13987698769','1010106','1010106@qq.com','青岛市黄岛区前湾港路579号'),
('200301','管理员6','1983-01-01 00:00:00','123456198301010001','女','admin6','13987698760','1010107','1010107@qq.com','青岛市黄岛区前湾港路579号'),
('200301','管理员7','1983-01-01 00:00:00','123456198401010001','男','admin7','13987698761','1010108','1010108@qq.com','青岛市黄岛区前湾港路579号');

#创建索引
CREATE UNIQUE INDEX adminid ON admin(id ASC);
CREATE UNIQUE INDEX adminnum ON admin(num ASC);
CREATE INDEX adminname ON admin(name);


#公告表
CREATE TABLE notice(
	id INT(12) NOT NULL AUTO_INCREMENT,
	title VARCHAR(50) NOT NULL,
	content TEXT NOT NULL,
	createdate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	admin_id INT(12) NOT NULL,
	PRIMARY KEY (id),
	KEY FK_NOTICE_ADMIN (admin_id),
	CONSTRAINT FK_NOTICE_ADMIN FOREIGN KEY (admin_id) REFERENCES admin (id) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

#插入公告表数据
INSERT INTO notice (title,content,createdate,admin_id)
VALUES
('关于马克思主义中国化报告会的通知','教育部长江学者特聘教授、湘潭大学博士生导师李佑新教授《马克思主义中国化的几个基本问题》报告会，定于11月24日9：00在行政楼第三会议室举行，请思想政治理论课全体专兼职教师、马克思主义理论学科研究生及感兴趣的教职员工参加。','2018-11-23 12:12:12','1'),
('2018全国大学生环境资源模拟法庭大赛公告','为了弘扬环境资源司法实践理念、促进环境法学理论研究、创新环境法学科教育实践方法，提升环境法学教学应用能力和对环境资源司法实践的认知能力， 由最高人民法院环境资源司法研究中心、国家“2011计划”司法文明协同创新中心、中华环保联合会主办，山东科技大学承办的2018全国大学生环境资源模拟法庭大赛将于2018年11月17-18日在我校青岛校区举行，欢迎广大师生观摩。赛事日程安排见附表。','2018-11-29 12:12:12','1'),
('关于举办第16期“泰山讲坛”的通知','各校区党委、分党委，直属党支部，机关各部门：为全面落实现代大学制度，推进高校治理体系与治理能力现代化建设，学校举办第16期“泰山讲坛”，特邀浙江外国语学院党委书记、浙江工业大学现代大学制度研究中心主任宣勇教授来校作报告，现将有关事宜通知如下。','2018-11-29 12:12:13','1'),
('关于清明节放假通知','清明节放假定于4月5日至4月7日','2018-04-01 12:12:12','1'),
('关于劳动节放假通知','劳动节放假定于5月1日至5月3日','2018-04-29 11:12:25','2');

#建立索引
CREATE UNIQUE INDEX noticeid ON notice(id ASC);
CREATE INDEX noticetitle ON notice(title);
CREATE INDEX noticeadminid ON notice(admin_id ASC);


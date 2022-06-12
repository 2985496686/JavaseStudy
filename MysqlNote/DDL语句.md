Creat         drop           alter           ----------------------           对表结构的增删改


创建表：
语法格式如下：
Create table 表名（
      字段1     数据类型，
      字段2     数据类型，
      字段3     数据类型
       ……..
);

例：
     create table stu(
           no bigint,
           name varchar(255),
           sex char(1),
           classno varchar(255),
           birth char(10)
      );


关于Mysql中当中字段的常见类型
Int                                    整数型(相当于Java中的int)
Bigint                              长整型（相当于Java中的long）
Float                                 浮点数（相等于Java中的double，float）
Char                                定长字符串（相当于String）
Varchar                          可变长字符串（相当于StringBuilder和StringBuffer）
Date                                日期类型（相当于java中 java.sql.Date）
Blob                                 二进制大对象(存储图片，视频等媒体信息)
Clob                                字符大对象(可以存储较大的文本，比如说：4G的字符串)


Insert ， delete，updata   --------------        对表数据进行增删改



insert语句插入数据
语法格式：
Insert into 表名（字段名1 ，字段名2，字段名3………)  values(值1，值2，值3……..）
字段名的数量和值的数量必须保持一致
如果省略字段名，它会按照创建表的顺序，并且后边的值必须写全，不能省略。

未插入的属性会自动插入null，在建表的时候可以指定默认值，不指定默认值为null

指定默认值方法如下：
Create table 表名（
      字段1     数据类型 default  默认值
);


删表语句： drop table if exits 表名；


表的复制：
Create table 表名 as select语句；
将查询结果当作表创建出来。



修改数据：
语法格式：
Update表名 set 字段名1 = 值1，字段名2 = 值2……where 条件；
注意：没有where条件，整张表都会更新。

案例：将部门编号为10的部门的loc改为 SHANGHAI, dname修改为 RENSHIBU？
Update dept set loc = 'SHANGHAI',dname = 'RENSHIBU' where deptno = 10;


删除数据
语法格式如下：
Delete from 表名 where 条件；
删除部门标号为10的部门
delete from dept1 where dept1.deptno = 10;


删除大表
Truncate table 表名;
删完之后只剩下表名






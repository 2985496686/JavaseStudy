DQL语句

简单查询语法格式：
             select 字段名1,字段名2,字段名3,…… from 表名；
提示：
        1.任何一条sql语句必须以“；”结尾。
        2.sql语句不区分大小写。
        3.字段可以参与数学运算。
        4.字段名后面跟 as newname  可以更改展示出来的名字，其中as可以拿空格代替。
        5.标准sql语句字符串拿单引号括起来。
        6.select *from 表名；可以查询该表中所有字段信息，但是在实际开发中不建议使用，因为这样效率较低。


条件查询语法格式：
                            select 字段名1，字段名2,…….from 表名 where 条件；

例：找出工资大于3000的员工 ：select ename,sal from emp where sal > 3000;

      找出工资小于等于3000的员工 ：select ename,sal from emp where sal <= 3000;
     
        找出工资不等于3000的员工 ：select ename,sal from emp where sal <> 3000;

      找出领导1工资信息 ：select ename,sal from emp where ename = '领导1';

      找出工资大于3000，小于5000的员工 ：方法一：select ename,sal from emp where sal >= 3000 and sal <= 6000;
                                                                                      方法二：select ename,sal from emp where sal  between 3000 and 6000;
                                                                                                         (注意：between 后面跟的数据必须是左小右大)
      判断某项为null ---- is null；  判断某项不为空  ------- is not null；  或者 ----- or；    

       找到工资大于1200且员工编号是1或者3的员工：select empno, ename,sal from emp where sal > 1200 and (empno = 1 or empno =3 );
                                                                                 （注意：and的优先级要高于or）
        in相当于or，比如：找出工资是1000或者5000的，有以下两种写法：
        方法一：select sal from emp where sal = 1000 or sal = 5000;
        方法二：select sal from emp where sal in(1000,5000);

         not in表示不在这个范围内

         like：模糊查询，模糊查询中要用到的两个特殊字符 % 和 _  
                  %表示任意多个字符，_表示任意一个字符。
        例：查询名字中带有字符o的：select ename from emp where ename like '%o%';
               查询名字首字母是z的：    select ename from emp where ename like 'z%';
               查询名字第二个字母是z的：    select ename from emp where ename like '_z%';
               查询名字是以字母是z结尾的：    select ename from emp where ename like '%z';
               查询名字中有_的：    select ename from emp where ename like '%\_%';



 排序查询语法如下：
                              select 字段名1，字段名2，…… from 表名  order by 字段名；
                              （注意：这里默认是升序排序,这里的字段名也可以直接写数字，表示按照第几列排序）
                                如果想要指定升序排序，需要在最后面加上 asc
                                如果想要指定降序排序，需要在最后面加上 desc
              例：如果想让员工按照工资的降序排，在工资相同的情况下按照名字的升序排：
                    select ename ,sal from emp order by sal desc, ename;  


分组函数

单行处理函数：
count ---- 记数        sum------求和         avg -------- 取平均     最大值 -------max   最小值 --------min
以上5个函数遇到null会直接跳过

count(*) 和count(具体某一字段)区别：
                                                     count(*)统计该表中的总记录条数，与具体某个字段无关
                                                     count(具体某一字段) 统计该字段不为null的总记录条数
这五个函数也可以联合使用：
Select count(*),sum(sal),avg(sal),max(sal),min(sal) from emp;

group by 和 having

group by ：按照某个字段或者某些字段分组
having：having是对分组之后的数据进行再次过滤。

分组函数一般都与group by联合使用，并且任何一个分组函数都是在group by语句执行结束后执行。
一条sql语句在未使用group by时，整张表自成一组

关键字执行顺序和书写顺序：
Select                       5
…
From                         1
… 
Where                      2
…
group by                  3
… 
Having                     4
…
Order by                  6

分组函数不能使用在where后面执行，因为，分组函数都是在group by后面执行的，但是where后面的语句是要在group by之前执行
如何找出工资大于平均工资的员工？
错误写法：select ename , sal from emp where sal > avg(sal);

正确写法: select ename ,sal from emp where sal > (select avg(sal) from emp);


找出每个部门的最高工资：select deptno ,max(sal)  from emp group by deptno;
+-----------+-------------+
| deptno | max(sal)  |
+-----------+-------------+
|      1       |     6000    |
|      2       |     7300    |
+-----------+-------------+
以下语句正确吗？
Select deptno ,ename  ,max(sal)  from emp group by deptno;
以上语句不正确，select后面只能跟分组字段和分组函数。


找出每个部门，不同岗位的最高薪资？(要先按部门分组，再按岗位分组)
select deptno ,job,max(sal),avg(sal) from emp group by deptno, job;

要求找出每个部门的最高薪资，并且显示薪资大于6000的数据。
方法一： select deptno ,max(sal) from emp group by deptno having max(sal) > 6000;
                   这样效率较低，因为这样写是先进行分组，再筛选，有些本应该被筛出的数据再分组上花费了大量时间
方法二： select deptno ,max(sal)from emp  where sal > 6000 group by deptno;
              先使用where筛选，再进行分组，效率较高。

 要求找出每个部门的平均薪资，并且显示平均薪资大于2900 的数据？
这里不能再继续使用where，因为这个是拿平均工资进行比较的，where 后面不能加分组函数。
 正确写法：select deptno ,avg(sal) from emp where (select  avg(sal)>2000 ) group by deptno;



单行处理函数 ： 
ifnull(可能为null的数据 ， 被当做什么处理)
mysql中的的数学表达式遇到null，最终结果为空，ifnull函数就可以处理这种情况(注意：ifnull()是被当作字段处理的，所以要放在select后面)
例：select ename , ifnull(mgr,0) from emp;




查询结果去重：
   执行下面sql语句：select deptno from emp;
+-----------+
| deptno |
+-----------+
|      1       |
|      1       |
|      1       |
|      2       |
|      2       |
|      2       |
+-----------+

  可以使用distinct关键字去重：select distinct deptno from emp;
+-----------+
| deptno |
+-----------+
|      1       |
|      2       |
+-----------+

注意：distinct的前面不能加字段，可以再distinct的后面加多个字段，表示联合去重(两个都一样才算重复)。



连接查询：多张表联合查询获得最终结果。
分类

按年代分类：SQL92 ， SQL99

根据表的连接方式划分：
                               内连接：等值连接          非等值连接           自连接
                              
                               外连接：左外连接(左连接）      右外连接（右连接）           全连接

笛卡尔积现象：当两张表联合查询时，没有任何条件限制，最终查询结果条数是两张表记录条数的乘积：
查询每个学生的班级名称：
select ename ,dname from emp, dept;     查询次数：4*6 = 24次


如何减少查询结果，的得到正确数据：通过where筛选：
Select
        e. ename , d.dname
 from
        emp e,dept d 
Where
         e.deptno = d.deptno;
（这是SQL92语法，现在并不常用）
虽然这样写得到了想要的结果，但实际上并没有消除笛卡尔现象，数据任然匹配了24次，只是通过筛选去除了部分。

SQL92语法


内连接：假设A表和B表内连接，能够查询出A表和B表匹配上的记录，AB两张表没有主副之分，两张表是平等的。
  
内连接 ---- 等值连接
Select
          e.ename,d.dname
 from
          emp e
Inner join
          dept d
On
          e.deptno = d.deptno;

Inner 可以省略，带着inner只是增强了程序可读性，可以直接看出来这是内连接


内连接-----------非等值连接
例：找出每个员工的工资等级，要求显示员工名，工资，和工资等级
Select e.ename,s.sal,s.grade from emp e join salgrade s on e.sal  between s.losal  and s.hisal;



内连接 ---------- 自连接 ：一张表看成两张表，自己连接自己。
例：找出每个员工的领导，要求显示员工名和领导名
        select a.ename ,b.ename from emp a join emp b on a.mgr = b.empno; 


外连接   假设A表和B表外连接，AB两张表会有一张是主表，一张是副表，主要查询主表中内容，捎带查询附表中内容，当附表内容没有和主表内容匹配上，附表会自动模拟NULL与之匹配。

外连接分类：
                 左外连接：表示左边的表是主表
                 右外连接：表示右边的表是主表
 左连接有右连接的写法，右连接有左连接的写法

案例：找出每个员工的领导，要求显示员工名和领导名,如果没有领导，用null代替
  select a.ename ,b.ename from emp a left outer join emp b on a.mgr = b.empno;

其中outer可以省略 

***案例 ：找出没有员工的部门记录信息
select d.* from emp e right join dept  d on e.deptno = d. deptno where e.deptno is null;


多表连接：多个表联合查询

案例：找出每一个员工的部门名称，以及上级领导
查询部门名称需要内连接，查询上级领导需要外连接
sql语句如下：
select e1.ename ,d.dname ,e2.ename mgr from emp e1 join dept d on e1. deptno = d.deptno left join emp e2 on e1.mgr = e2.empno;


子查询：select语句中嵌套select语句
子查询主要出现的位置：select后边        from 后面         where后面

案例一：找出薪水高于平均水平的员工(select子句在where后边)
SQL语句： select ename ,sal from emp where sal > (select avg(sal)from emp);


案例二：找出每个部门员工平均薪水的等级 （select子句在from后面）
SQL语句：select e.deptno ,s.grade from (select deptno ,avg(sal) as avgsal from emp group by deptno) as e join salgrade s on avgsal between losal and hisal;

案例三：找出每个部门员工的平均薪水等级
不推荐写法(from后面用sql子句，会使效率降低，可以不用就不用)：
SQL语句：select t. deptno, avg(t.grade) from (select s.grade,e.deptno from emp e join salgrade s on e.sal between s.losal and s.hisal) t  group by t.deptno;
推荐写法：
SQlselect e.deptno,avg(s.grade) from emp e join salgrade s on e.sal between losal and hisal group by e.deptno;



案例四：查找每个员工的名字，和所在部门名称（不使用连接表） (在select后面使用select子句）
select e.ename ,(select d.dname from dept d where d.deptno = e.deptno) as dname from emp e;





关键字union：拼接两个查询结果
查询部门编号为10和20的员工
方法一：select *from emp where deptno in (10,20);
方法二：select  *from emp where deptno = 10
                  union
                  select *from emp where deptno = 20;

注意：使用select连接两个sql语句时，必须要保证两个查询语句所查列数是相同的(select后面跟的字段数量相同)



limit关键字是MySQL中特有的
语法机制：
Limit startIndex ，length
startIndex:起始位置            length： 要数据的条数
例：查询员工工资排在前五的员工。
Select ename ,sal from emp order by sal desc limit 0 ,5;
注意：limit是在sql语句中最后执行的环节。

例：查询员工工资排在第四到第五的员工
Select ename,sal from emp order by sal desc limit 3,6;



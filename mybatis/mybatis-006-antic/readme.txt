mybatis小技巧
1. #{}和${}的区别

#{}的执行结果
[main] DEBUG c.s.mybatis.mapper.CarMapper.selectByCarType - ==>  Preparing: select id, car_num as carNum, brand, guide_price as guidePrice, produce_time as produceTime, car_type as carType from t_car where car_type=?
[main] DEBUG c.s.mybatis.mapper.CarMapper.selectByCarType - ==> Parameters: 新能源(String)
[main] DEBUG c.s.mybatis.mapper.CarMapper.selectByCarType - <==      Total: 3

${}的执行结果
[main] DEBUG c.s.mybatis.mapper.CarMapper.selectByCarType - ==>  Preparing: select id, car_num as carNum, brand, guide_price as guidePrice, produce_time as produceTime, car_type as carType from t_car where car_type=新能源
[main] DEBUG c.s.mybatis.mapper.CarMapper.selectByCarType - ==> Parameters:

org.apache.ibatis.exceptions.PersistenceException:
### Error querying database.  Cause: java.sql.SQLSyntaxErrorException: Unknown column '新能源' in 'where clause'
### The error may exist in CarMapper.xml
### The error may involve defaultParameterMap
### The error occurred while setting parameters
### SQL: select             id,             car_num as carNum,             brand,             guide_price as guidePrice,             produce_time as produceTime,             car_type as carType         from             t_car         where             car_type=新能源
### Cause: java.sql.SQLSyntaxErrorException: Unknown column '新能源' in 'where clause'

#{}和${}的区别：
    #{}：底层使用PreparedStatement。特点：先进行SQL语句的编译，然后给SQL语句的占位符问号？传值。可以避免SQL注入的风险。
    ${}：底层使用Statement。特点：先进行SQL语句的拼接，然后再对SQL语句进行编译。存在SQL注入的风险。
    优先使用#{}，这是原则。避免SQL注入的风险。

#{}的执行结果
Preparing: select
                id, car_num as carNum, brand, guide_price as guidePrice, produce_time as produceTime, car_type as carType
           from t_car order by produce_time ?
Parameters: asc(String)

select
    id, car_num as carNum, brand, guide_price as guidePrice, produce_time as produceTime, car_type as carType
from t_car order by produce_time 'asc'

#{}的执行结果
Preparing:
    select id, car_num as carNum, brand, guide_price as guidePrice, produce_time as produceTime, car_type as carType
    from t_car order by produce_time asc
Parameters:

如果需要sql语句的关键字放到sql语句中，只能使用${}，因为#{}是以值的形式放到sql语句当中。

2. 向sql语句中拼接表名，就需要${}
    现实业务中，可能会存在分表存储的情况。因为一张表存的话，数据量太大。查询效率比较低。
    可以将这些数据有规律的分表存储，这样在查询的时候效率就比较高。因为扫描的数据量变少了。
    日志表：专门存储日志信息的。如果t_log只有一张表，这张表中每天都会产生很多log，慢慢的，这个表中数据会很多。
    怎么解决问题？
        每天生成一个新表。每张表以当天日期作为名称，例如：
            t_log_2023_2_4
            t_log_2023_2_5
            ...
    你想知道某一天的日志信息怎么办？
        假设今天是20230205,那么直接查t_log_20230205的表即可。

3. 批量删除：一尺删除多条记录
    批量删除的sql语句有两种写法：
        第一种or：delete from t_car where id=1 or id=2 or id=3;
        第二种in：delete from r_car where id in(1,2,3);

    应该采用${}的方式：
        delete from t_car where id in(${ids})

4. 模糊查询：like
    需求：根据汽车品牌进行模糊查询
        select * from t_car where brand like '%奔驰%';
        select * from t_car where brand like '%比亚迪%';

    第一种方案：
        '%${brand}%'
    第二种方案：concat函数，这个是mysql数据库当中的一个函数，专门进行字符串拼接
        concat('%',#{brand},'%')
    第三种方案：比较鸡肋。可以不算
        brand like concat('%','${brand}','%')
    第四种方案：
        "%"#{brand}"%"

5. 关于mybatis中别名机制：
    <typeAliases>
        <!--别名自己指定的-->
        <typeAlias type="com.shamengxin.mybatis.pojo.Car" alias="Car"/>
        <typeAlias type="com.shamengxin.mybatis.pojo.Log" alias="Log"/>

        <!--采用默认的别名机制-->
        <typeAlias type="com.shamengxin.mybatis.pojo.Car"/>
        <typeAlias type="com.shamengxin.mybatis.pojo.Log"/>

        <!--包下所有的类自动起别名。使用简名作为别名。-->
        <package name="com.shamengxin.mybatis.pojo"/>
    </typeAliases>

    所有别名不区分大小写。
    namespace不能使用别名机制。

6. mybatis-config.xml文件中的mappers标签
    <mapper resource="CarMapper.xml"/> 要求类的根路径下必须有：CarMapper.xml
    <mapper url="file:///d:/CarMapper.xml"/> 要求在d:/下有CarMapper.xml文件
    <mapper class="是全限定接口名，带有包名"/>

    mapper标签的属性可以有三个：
        resource：这种方式是从类的根路径下开始查找资源。采用这种方式的话，你的文件需要放到类路径当中才行。
        url：这种方式是一种绝对路径的方式，这种方式不要求配置文件必须放到类路径当中，哪里都行，只要提供一个绝对路径就行。这种方式使用极少，因为移植性太差。
        class：这个位置提供的是mapper接口的全限定接口名，必须带有包名的。
            思考：mapper标签的作用是指定SqlMapper.xml文件的路径，指定接口名有什么用呢？
                <mapper class="com.shamengxin.mybatis.mapper.CarMapper/>
                如果你class指定的是：com.shamengxin.mybatis.mapper.CarMapper
                那么mybatis框架会自动去com/shamengxin/mybatis/mapper/CarMapper目录下查找CarMapper.xml文件。
            注意：也就是说：如果你采用这种方式，那么你必须保证CarMappper.xml文件和CarMapper接口必须在同一个目录下。并且名字一致。
            CarMapper接口->CarMapper.xml
            LogMapper接口->LogMapper.xml
            ...

    提醒！！！！！！！！！！！
        在IDEA的resources目录下新建多重目录的话，必须是这样创建的：
            com/shamengxin/mybatis/mapper
        不能这样：
            com.shamengxin.mybatis.mapper


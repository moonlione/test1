/*
 * 作业:
	1.给昨天的课后作业从新编写一遍.参考课上编写答案.(略)
	2.记忆事物的ACID特性.以及关于数据库事物操作的四种隔离级别.
	3.使用JDBCUtil帮助类编写针对学生表的4个增删改查功能.(SQL语句需要参数的,采用PrepareStatement的占位符的写法编写.)
	4.给以上编写的增加,删除,修改功能增加事物处理.
	5.使用C3P0数据源连接池改写以上学生表的4个增删改查功能.
*/
/*
	2.记忆事物的ACID特性.以及关于数据库事物操作的四种隔离级别.
	事物：用来描述一组逻辑数据库的操作；A原子性、C一致性、I隔离性、D持久性。
	四种的隔离级别分别是：
	最低级别READ UNCOMMITTED,第二级别READ COMMITTED,第三级别 reapted read(默认级别)，
	最高级别SERIALIZABLE(所有是的都必须传行化、序列化)。
*/

package cn.crxy.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Task {

	public static void main(String[] args) throws Exception {
		//3.使用JDBCUtil帮助类编写针对学生表的4个增删改查功能.(SQL语句需要参数的,采用PrepareStatement的占位符的写法编写.)
		//a.插入一行
			//insert(25,95);
		//b.删
		 	//delete(25);
		//c.改
			//update(100);
		//d.查
		select();
	}
	
	public static void insert(int exameID,int score) throws Exception{
		//1、建立连接
		Connection conn=JdbcUtil.getConnection();
		//2、创建Statement对象.并直接传递SQL进行预编译.?:占位符.
		PreparedStatement ps=conn.prepareStatement("insert into score(exameID,score)values(?,?)");
		//3.对PreparedStatement传递占位符参数.
		ps.setInt(1, exameID);
		ps.setInt(2,score);
		//4.执行SQL并分析返回值.
			int num = ps.executeUpdate();
			if( num >0 ){
				System.out.println("inserting is successful!");
			}
				
		//5.关闭资源. ResultSet Statement
			JdbcUtil.closeSource( null , ps, conn);
	}
	public static void delete(int exameID) throws Exception{
		//1、建立连接
		Connection conn=JdbcUtil.getConnection();
		//2、创建Statement对象.并直接传递SQL进行预编译.?:占位符.
		PreparedStatement ps=conn.prepareStatement("delete from score where exameID=?");
		//3.对PreparedStatement传递占位符参数.
		ps.setInt(1, exameID);
		//4.执行SQL并分析返回值.
			int num = ps.executeUpdate();
			if( num >0 ){
				System.out.println("deleting is successful!");
			}
				
		//5.关闭资源. ResultSet Statement
			JdbcUtil.closeSource( null , ps, conn);
	}
	public static void update(int x) throws Exception{
		//1、建立连接
		Connection conn=JdbcUtil.getConnection();
		//2、创建Statement对象.并直接传递SQL进行预编译.?:占位符.
		PreparedStatement ps=conn.prepareStatement("update score set exameID=? where exameID=1");
		//3.对PreparedStatement传递占位符参数.
		ps.setInt(1, x);
		//4.执行SQL并分析返回值.
			int num = ps.executeUpdate();
			if( num >0 ){
				System.out.println("updating is successful!");
			}
				
		//5.关闭资源. ResultSet Statement
			JdbcUtil.closeSource( null , ps, conn);
	}
	
	public static void select() throws Exception{
		//1、建立连接
		Connection conn=JdbcUtil.getConnection();
		//2、创建Statement对象.并直接传递SQL进行预编译.?:占位符.
		PreparedStatement ps=conn.prepareStatement("select * from score ");
		//3.对PreparedStatement传递占位符参数.
		//ps.setString(1, colunmName);
		//4.执行SQL并分析返回值.
			ResultSet num = ps.executeQuery();
			if( num.next() ){
				int id=num.getInt(1);
				int score=num.getInt(2);
				System.out.println("selection is successful!");
				System.out.println(id+"---"+score);
			}
				
		//5.关闭资源. ResultSet Statement
			JdbcUtil.closeSource( null , ps, conn);
	}

}

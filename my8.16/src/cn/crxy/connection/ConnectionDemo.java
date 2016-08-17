package cn.crxy.connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

import com.mysql.jdbc.Driver;


public class ConnectionDemo {

	public static void main(String[] args) throws Exception {
		/*
		//1、注册驱动
		DriverManager.registerDriver(new Driver());
		//2、创建连接
		Connection conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/limengdb1", "root", "root");
		//3、获取可操作的SQL对象
		Statement stat= conn.createStatement();
		//4、解析查询结果
		ResultSet rs=stat.executeQuery("select * from score");
		while(rs.next()){
			int id=rs.getInt(1);
			int score=rs.getInt(2);
			System.out.println(id+"---"+score);
		}
		//5、关闭
		conn.close();
		stat.close();
		rs.close();*/
		
		//优化驱动、连接创建、关闭资源后
		test();
		
	}
	public static void test() throws Exception{
		//1、建立连接
		Connection connection=JdbcUtil.getConnection();//调用创建好的JdbcUtil工具类，注意：驱动已经在调用这个静态函数之前运行的静态代码块红运行了。
		//2、获取可操作的SQL对象Statement
		Statement state=connection.createStatement();
		//4.编写SQL执行.并返回结果集ResultSet.
		String str = "select * from score";
		ResultSet rs = state.executeQuery(str);
//		5.解析结果集ResultSet中的数据.
		while( rs.next() ){
			//获取rs对象中的查询数据方式一: 根据字段名.
//			int no = rs.getInt("exameID");
//			String name=  rs.getString("score");
			
			//获取rs对象中的查询数据方式二: 根据顺序获取.
			int exameID= rs.getInt(1);
			int score = rs.getInt(2);
			
			System.out.println(exameID+" -- "+score);
			
		}
//		6.关闭资源.
		
		JdbcUtil.closeSource(rs, state, connection);

		
	}

}

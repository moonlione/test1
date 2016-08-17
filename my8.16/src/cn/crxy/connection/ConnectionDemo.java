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
		//1��ע������
		DriverManager.registerDriver(new Driver());
		//2����������
		Connection conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/limengdb1", "root", "root");
		//3����ȡ�ɲ�����SQL����
		Statement stat= conn.createStatement();
		//4��������ѯ���
		ResultSet rs=stat.executeQuery("select * from score");
		while(rs.next()){
			int id=rs.getInt(1);
			int score=rs.getInt(2);
			System.out.println(id+"---"+score);
		}
		//5���ر�
		conn.close();
		stat.close();
		rs.close();*/
		
		//�Ż����������Ӵ������ر���Դ��
		test();
		
	}
	public static void test() throws Exception{
		//1����������
		Connection connection=JdbcUtil.getConnection();//���ô����õ�JdbcUtil�����࣬ע�⣺�����Ѿ��ڵ��������̬����֮ǰ���еľ�̬�����������ˡ�
		//2����ȡ�ɲ�����SQL����Statement
		Statement state=connection.createStatement();
		//4.��дSQLִ��.�����ؽ����ResultSet.
		String str = "select * from score";
		ResultSet rs = state.executeQuery(str);
//		5.���������ResultSet�е�����.
		while( rs.next() ){
			//��ȡrs�����еĲ�ѯ���ݷ�ʽһ: �����ֶ���.
//			int no = rs.getInt("exameID");
//			String name=  rs.getString("score");
			
			//��ȡrs�����еĲ�ѯ���ݷ�ʽ��: ����˳���ȡ.
			int exameID= rs.getInt(1);
			int score = rs.getInt(2);
			
			System.out.println(exameID+" -- "+score);
			
		}
//		6.�ر���Դ.
		
		JdbcUtil.closeSource(rs, state, connection);

		
	}

}

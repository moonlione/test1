package cn.crxy.connection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;



public class JdbcUtil {
	//���徲̬���Գ�Ա
	private static String url;
	private static String name;
	private static String password;
	private static String classname;
	//���徲̬����飬���ھ�̬����֮ǰִ��
	static{
		//��ȡ������Ϣ
		FileInputStream fis=null;
		try {
			fis = new FileInputStream("./src/dbinfo.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Properties p=new Properties();
		try {
			p.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		url=p.getProperty("url");
		name=p.getProperty("name");
		password=p.getProperty("password");
		classname=p.getProperty("classname");
		//�÷���ķ�����������
		try {
			Class.forName(classname);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//ע�⣺Class����ĸ��д
	}
	//���ӵ���ȡ�Ż�
	public static Connection getConnection() throws Exception{
		Connection conn=DriverManager.getConnection(url, name, password);	
		return conn;
	}
	
	//�رյ��Ż�
	public static void closeSource(ResultSet rs,Statement state,Connection conn){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(state!=null){
			try {
				state.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	

}

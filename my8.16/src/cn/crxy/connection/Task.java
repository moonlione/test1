/*
 * ��ҵ:
	1.������Ŀκ���ҵ���±�дһ��.�ο����ϱ�д��.(��)
	2.���������ACID����.�Լ��������ݿ�������������ָ��뼶��.
	3.ʹ��JDBCUtil�������д���ѧ�����4����ɾ�Ĳ鹦��.(SQL�����Ҫ������,����PrepareStatement��ռλ����д����д.)
	4.�����ϱ�д������,ɾ��,�޸Ĺ����������ﴦ��.
	5.ʹ��C3P0����Դ���ӳظ�д����ѧ�����4����ɾ�Ĳ鹦��.
*/
/*
	2.���������ACID����.�Լ��������ݿ�������������ָ��뼶��.
	�����������һ���߼����ݿ�Ĳ�����Aԭ���ԡ�Cһ���ԡ�I�����ԡ�D�־��ԡ�
	���ֵĸ��뼶��ֱ��ǣ�
	��ͼ���READ UNCOMMITTED,�ڶ�����READ COMMITTED,�������� reapted read(Ĭ�ϼ���)��
	��߼���SERIALIZABLE(�����ǵĶ����봫�л������л�)��
*/

package cn.crxy.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Task {

	public static void main(String[] args) throws Exception {
		//3.ʹ��JDBCUtil�������д���ѧ�����4����ɾ�Ĳ鹦��.(SQL�����Ҫ������,����PrepareStatement��ռλ����д����д.)
		//a.����һ��
			//insert(25,95);
		//b.ɾ
		 	//delete(25);
		//c.��
			//update(100);
		//d.��
		select();
	}
	
	public static void insert(int exameID,int score) throws Exception{
		//1����������
		Connection conn=JdbcUtil.getConnection();
		//2������Statement����.��ֱ�Ӵ���SQL����Ԥ����.?:ռλ��.
		PreparedStatement ps=conn.prepareStatement("insert into score(exameID,score)values(?,?)");
		//3.��PreparedStatement����ռλ������.
		ps.setInt(1, exameID);
		ps.setInt(2,score);
		//4.ִ��SQL����������ֵ.
			int num = ps.executeUpdate();
			if( num >0 ){
				System.out.println("inserting is successful!");
			}
				
		//5.�ر���Դ. ResultSet Statement
			JdbcUtil.closeSource( null , ps, conn);
	}
	public static void delete(int exameID) throws Exception{
		//1����������
		Connection conn=JdbcUtil.getConnection();
		//2������Statement����.��ֱ�Ӵ���SQL����Ԥ����.?:ռλ��.
		PreparedStatement ps=conn.prepareStatement("delete from score where exameID=?");
		//3.��PreparedStatement����ռλ������.
		ps.setInt(1, exameID);
		//4.ִ��SQL����������ֵ.
			int num = ps.executeUpdate();
			if( num >0 ){
				System.out.println("deleting is successful!");
			}
				
		//5.�ر���Դ. ResultSet Statement
			JdbcUtil.closeSource( null , ps, conn);
	}
	public static void update(int x) throws Exception{
		//1����������
		Connection conn=JdbcUtil.getConnection();
		//2������Statement����.��ֱ�Ӵ���SQL����Ԥ����.?:ռλ��.
		PreparedStatement ps=conn.prepareStatement("update score set exameID=? where exameID=1");
		//3.��PreparedStatement����ռλ������.
		ps.setInt(1, x);
		//4.ִ��SQL����������ֵ.
			int num = ps.executeUpdate();
			if( num >0 ){
				System.out.println("updating is successful!");
			}
				
		//5.�ر���Դ. ResultSet Statement
			JdbcUtil.closeSource( null , ps, conn);
	}
	
	public static void select() throws Exception{
		//1����������
		Connection conn=JdbcUtil.getConnection();
		//2������Statement����.��ֱ�Ӵ���SQL����Ԥ����.?:ռλ��.
		PreparedStatement ps=conn.prepareStatement("select * from score ");
		//3.��PreparedStatement����ռλ������.
		//ps.setString(1, colunmName);
		//4.ִ��SQL����������ֵ.
			ResultSet num = ps.executeQuery();
			if( num.next() ){
				int id=num.getInt(1);
				int score=num.getInt(2);
				System.out.println("selection is successful!");
				System.out.println(id+"---"+score);
			}
				
		//5.�ر���Դ. ResultSet Statement
			JdbcUtil.closeSource( null , ps, conn);
	}

}

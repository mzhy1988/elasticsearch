package com.chcit.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DBHelper {  

	private String sql;    //要传入的sql语句      
	public void setSql(String sql) {  
		this.sql = sql;  
	}  

	private List sqlValues;  //sql语句的参数  
	public void setSqlValues(List sqlValues) {  
		this.sqlValues = sqlValues;  
	}  
	private Connection con;  //连接对象  
	public void setCon(Connection con) {  
		this.con = con;  
	}  

	public DBHelper(){  
		this.con=getConnection();  //给Connection的对象赋初值  
	}  

	/** 
	 * 获取数据库连接 
	 * @return 
	 */  
	public static  Connection getConnection(){   

		String driver_class="oracle.jdbc.OracleDriver";  
		String driver_url="jdbc:oracle:thin:@192.168.20.240:1521:CHCINFODB";  
		String database_user="scm_b2b_dev";  
		String database_password="scm_b2b_dev";  
		try {  

			Class.forName(driver_class);  
			Connection con=DriverManager.getConnection(driver_url,database_user,database_password);  
			return con;

		} catch (ClassNotFoundException e) {  
			// TODO Auto-generated catch block  
			e.printStackTrace();  
		} catch (SQLException e) {  
			// TODO Auto-generated catch block  
			e.printStackTrace();  
		}   
		return null;  
	}  

	/** 
	 * 关闭数据库 
	 * @param con 
	 * @param pst 
	 * @param rst 
	 */  
	public static  void closeAll(Connection con,PreparedStatement pst,ResultSet rst){  
		if(rst!=null){  
			try {  
				rst.close();  
			} catch (SQLException e) {  
				// TODO Auto-generated catch block  
				e.printStackTrace();  
			}  
		}  

		if(pst!=null){  
			try {  
				pst.close();  
			} catch (SQLException e) {  
				// TODO Auto-generated catch block  
				e.printStackTrace();  
			}  
		}  
		if(con!=null){  
			try {  
				con.close();  
			} catch (SQLException e) {  
				// TODO Auto-generated catch block  
				e.printStackTrace();  
			}  
		}  
	}  

	/** 
	 * 增删改 
	 * @return 
	 */  
	public int executeUpdate(){  
		int result=-1;  
		PreparedStatement pst=null;  
		try {  
			pst=con.prepareStatement(sql);  
			if(sqlValues!=null&&sqlValues.size()>0){  //当sql语句中存在占位符时  
				setSqlValues(pst,sqlValues);  
			}  
			result=pst.executeUpdate();  
		} catch (SQLException e) {  
			// TODO Auto-generated catch block  
			e.printStackTrace();  
		}finally{  
			this.closeAll(con, pst, null);  
		}  


		return result;  
	}  

	/** 
	 * 给sql语句中的占位符赋值 
	 * @param pst 
	 * @param sqlValues 
	 */  
	private void setSqlValues(PreparedStatement pst,List sqlValues){  
		for(int i=0;i<sqlValues.size();i++){  
			try {  
				pst.setObject(i+1,sqlValues.get(i));  
			} catch (SQLException e) {  
				// TODO Auto-generated catch block  
				e.printStackTrace();  
			}  
		}  
	}  
}  
package com.chcit.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


public class EntityUtils {
	private String tablename = "";
	private String classname = "";
	private String packagename = "";
	private String primaryKey = "";
	private String[] colnames;
	private String[] colTypes;
	private int[] colSizes;  
	private int[] colScale;  
	private boolean importUtil = true;
	private boolean importSql = true;
	private boolean importMath = true;

	/**
	 * @param args
	 */
	public void tableToEntity(String tName,String path,String packageName) {
		tablename = tName;
		classname = tName.replaceAll("_", "");
		packagename = packageName;
		Connection conn = DBHelper.getConnection();
		String strsql = "SELECT * FROM " + tablename;//+" WHERE ROWNUM=1" ��һ�м�¼;
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		try {
			System.out.println(strsql);
			pstmt = conn.prepareStatement(strsql);
			rst = pstmt.executeQuery();
			ResultSetMetaData rsmd = pstmt.getMetaData();
			DatabaseMetaData dbmd = conn.getMetaData();
			ResultSet pkRSet = dbmd.getPrimaryKeys(null, null, tablename.toUpperCase());
			while( pkRSet.next() ) { 
				primaryKey = pkRSet.getString("COLUMN_NAME"); 
			} 
			int size = rsmd.getColumnCount();  
			colnames = new String[size];
			colTypes = new String[size];
			colSizes = new int[size];
			colScale = new int[size];
			for (int i = 0; i < rsmd.getColumnCount(); i++) {
				rsmd.getCatalogName(i + 1);
				colnames[i] = rsmd.getColumnName(i + 1).toLowerCase();
				colTypes[i] = rsmd.getColumnTypeName(i + 1).toLowerCase();
				colScale[i] = rsmd.getScale(i + 1);
				System.out.println(rsmd.getCatalogName(i+1));
				if ("datetime".equals(colTypes[i])) {
					importUtil = true;
				}
				if ("image".equals(colTypes[i]) || "text".equals(colTypes[i])) {
					importSql = true;
				}
				if(colScale[i]>0){
					importMath = true;
				}
				colSizes[i] = rsmd.getPrecision(i + 1);
			}
			String content = parse(colnames, colTypes, colSizes, packagename);
			try {
				FileWriter fw = new FileWriter(path+"/"+classname + ".java");
				PrintWriter pw = new PrintWriter(fw);
				pw.println(content);
				pw.flush();
				pw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DBHelper.closeAll(conn, pstmt, rst);
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 */
	private String parse(String[] colNames, String[] colTypes, int[] colSizes, String pack) {
		StringBuffer sb = new StringBuffer();
		sb.append("\r\npackage "+pack+";\r\n");
		sb.append("\r\nimport java.io.Serializable;\r\n");
		if (importUtil) {
			sb.append("import java.util.Date;\r\n");
		}
		if (importSql) {
			sb.append("import java.sql.*;\r\n\r\n");
		}
		if(importMath){
			sb.append("import java.math.*;\r\n\r\n");
		}
		sb.append("import javax.persistence.Entity;\r\n\r\n");
		sb.append("import javax.persistence.Table;\r\n\r\n");
		sb.append("import javax.persistence.GeneratedValue;\r\n\r\n");
		sb.append("import javax.persistence.Id;\r\n\r\n"); 
		//��ע��
		processColnames(sb);
		sb.append("@Entity\n"); 
		sb.append("@Table(name=\""+tablename+"\")\n");
		sb.append("public class " + classname + " implements Serializable {\r\n");
		processAllAttrs(sb);
		processAllMethod(sb);
		sb.append("}\r\n");
		System.out.println(sb.toString());
		return sb.toString();

	}
	/**
	 * @param sb
	 */
	private void processColnames(StringBuffer sb) {
		sb.append("\r\n/** " + tablename + "\r\n");
		String colsiz="";
		String colsca="";
		for (int i = 0; i < colnames.length; i++) {
			colsiz = colSizes[i]<=0? "" : (colScale[i]<=0? "("+colSizes[i]+")" : "("+colSizes[i]+","+colScale[i]+")");
			sb.append("\t" + colnames[i].toUpperCase() +"    "+colTypes[i].toUpperCase()+ colsiz+"\r\n");
			char[] ch = colnames[i].toCharArray();
			char c ='a';
			if(ch.length>3){
				for(int j=0;j <ch.length; j++){
					c = ch[j];
					if(c == '_'){
						if (ch[j+1]>= 'a' && ch[j+1] <= 'z') {
							ch[j+1]=(char) (ch[j+1]-32);
						}
					}
				}
			}
			String str = new String(ch);
			//colnames[i] = str.replaceAll("_", "");
		}
		sb.append("*/\r\n");
	}
	/**
	 * 
	 * @param sb
	 */
	private void processAllMethod(StringBuffer sb) {
		for (int i = 0; i < colnames.length; i++) {
			sb.append("\tpublic void set" + initcap(colnames[i]) + "("
					+ oracleSqlType2JavaType(colTypes[i],colScale[i],colSizes[i]) + " " + colnames[i]
					                                                                               + "){\r\n");
			sb.append("\t\tthis." + colnames[i] + "=" + colnames[i] + ";\r\n");
			sb.append("\t}\r\n");

			sb.append("\tpublic " + oracleSqlType2JavaType(colTypes[i],colScale[i],colSizes[i]) + " get"
					+ initcap(colnames[i]) + "(){\r\n");
			sb.append("\t\treturn " + colnames[i] + ";\r\n");
			sb.append("\t}\r\n");
		}
	}

	/**
	 * 
	 * @return
	 */
	private void processAllAttrs(StringBuffer sb) {
		sb.append("\tprivate static final long serialVersionUID = 1L;\r\n");
		for (int i = 0; i < colnames.length; i++) {
			if(primaryKey.equalsIgnoreCase(colnames[i])){
				sb.append("\t@Id\n");
				sb.append("\t@GeneratedValue\n");
				sb.append("\tprivate " + oracleSqlType2JavaType(colTypes[i],colScale[i],colSizes[i]) + " "
						+ colnames[i] + ";\r\n");
			}else{
				sb.append("\tprivate " + oracleSqlType2JavaType(colTypes[i],colScale[i],colSizes[i]) + " "
						+ colnames[i] + ";\r\n");	
			}

		}
		sb.append("\r\n");
	}

	/**
	 * @param str
	 * @return
	 */
	private String initcap(String str) {
		char[] ch = str.toCharArray();
		if (ch[0] >= 'a' && ch[0] <= 'z') {
			ch[0] = (char) (ch[0] - 32);
		}
		return new String(ch);
	}

	/**
	 * Oracle
	 * @param sqlType
	 * @param scale
	 * @return
	 */
	private String oracleSqlType2JavaType(String sqlType, int scale,int size) {
		if (sqlType.equals("integer")) {
			return "Integer";
		} else if (sqlType.equals("long")) {
			return "Long";
		} else if (sqlType.equals("float")
				|| sqlType.equals("float precision")
				|| sqlType.equals("double")
				|| sqlType.equals("double precision")
		) {
			return "BigDecimal";
		}else if (sqlType.equals("number")
				||sqlType.equals("decimal")
				|| sqlType.equals("numeric")
				|| sqlType.equals("real")) {
			return scale==0? (size<10? "Integer" : "Long") : "BigDecimal";
		}else if (sqlType.equals("varchar")
				|| sqlType.equals("varchar2")
				|| sqlType.equals("char")
				|| sqlType.equals("nvarchar")
				|| sqlType.equals("nchar")
				|| sqlType.equals("blob")
				|| sqlType.equals("clob")) {
			return "String";
		} else if (sqlType.equals("datetime")
				|| sqlType.equals("date")
				|| sqlType.equals("timestamp")) {
			return "Date";
		}
		return null;
	}

	/**
	 * @param args
	 */
//	public static void main(String[] args) {
//		String path = System.getProperty("user.dir")+"/src/main/java/com/chcit/shop/model";
//		String packageName =  "com.chcit.shop.model";
//		EntityUtils t = new EntityUtils();
//		t.tableToEntity("S_Cart",path,packageName);
//	}

}
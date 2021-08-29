package com.mirac.main.ypassport.service;

import java.sql.*;

/*连接数据库快速查询，数据一式两份，数据库一份，区块链一份*/
public class MySqlUtils {

	private static String driver="com.mysql.jdbc.Driver";

	private static String url="jdbc:mysql://rm-2ze5zk0f4v56za64a3o.mysql.rds.aliyuncs.com:3306/hesuan2?userSSL=false&serverTimezone=UTC&characterEncoding=utf8";
	
	private static String user = "suxiang";
	
	private static String pass = "Su1584699582";

	static{
		try {
			
			System.out.println("-----------start----------");
			String driveName = "com.mysql.jdbc.Driver";
			Class.forName(driveName);
			//Connection con = DriverManager.getConnection(url, user, pass);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	 public static Connection getConnection() throws SQLException {
	        return DriverManager.getConnection(url, user, pass);
	 }
	 
	 public static  void closeResorce(ResultSet resultSet , Statement statement, Connection connection){
		 closeResultSet(resultSet);
		 closeConnection(connection);
		 closeStatement(statement);
	 }
	 public static  void closeResorce(Statement statement,Connection connection){
		 closeConnection(connection);
		 closeStatement(statement);
	 }
	 
	 private static void closeStatement(Statement statement) {
		 if (statement != null) {
			 try {
				 statement.close();
			 } catch (SQLException e) {
				 e.printStackTrace();
			 }
		 }
	 }
	 
	 private static void closeConnection(Connection connection) {
		 if (connection != null) {
			 try {
				 connection.close();
			 } catch (SQLException e) {
				 e.printStackTrace();
			 }
		 }
	 }
	 
	 private static void closeResultSet(ResultSet resultSet) {
		 if (resultSet != null){
			 try {
				 resultSet.close();
			 } catch (SQLException e) {
				 e.printStackTrace();
			 }
		 }
	 }
	
	
	

}

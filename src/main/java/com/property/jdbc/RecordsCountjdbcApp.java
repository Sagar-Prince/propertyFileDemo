package com.property.jdbc;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class RecordsCountjdbcApp {

	public static void main(String[] args) throws Exception {
		//locate properties file
		InputStream is=new FileInputStream("src/main/java/com/property/commons/DBDetails.properties");
		//load Properties info from java.util.properties
		Properties pro=new Properties();
		pro.load(is);
		Class.forName(pro.getProperty("jdbc.driver"));
		Connection con = DriverManager.getConnection(pro.getProperty("jdbc.url"));
		pro.getProperty("db.user");
		pro.getProperty("db.pwd");
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select count(*) from propertydemo");
		int cnt=0;
		if(rs.next()) {
			cnt=rs.getInt(1);
		}
		System.out.println("Record counted"+cnt);
		//close jdbc object
		rs.close();
		st.close();
	}//main

}//class

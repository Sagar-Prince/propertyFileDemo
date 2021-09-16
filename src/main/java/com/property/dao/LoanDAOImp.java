package com.property.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.property.demo.bo.CustomerBO;

public class LoanDAOImp implements LoanDAO {

	private static final String insert= "INSERT INTO PROPERTYDEMO VALUES(?,?,?,?)";
	
	DataSource ds;
	
	public LoanDAOImp(DataSource ds) {
		super();
		this.ds = ds;
	}
	
	public int insert(CustomerBO cbo) {
		Connection con=null;
		int result=0;
		PreparedStatement ps=null;
		try {
			//get connection object from jdbc connection pool
			 con = ds.getConnection();
			 //create preparedstatement object.
			 ps=con.prepareStatement(insert);
			 //set query to query param.
			 ps.setInt(1, cbo.getCno());
			 ps.setString(2, cbo.getName());
			 ps.setFloat(3, cbo.getPamt());
			 ps.setFloat(4, cbo.getIntramt());
			 //execute the query
		     result = ps.executeUpdate();
			 
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(ps!=null) {
					ps.close();
				}
			}
			catch(Exception e){
				e.printStackTrace();
			}
			try {
				if(con!=null) {
					con.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}//finally
		
		return result;
	}//method
	
}//class

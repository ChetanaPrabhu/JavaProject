package com.connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyDemo 
{

	public static void main(String[] args) throws SQLException{
		
		Connection connect = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//.getConnection(string url , username , password)
			connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/phasetwo", "root", "Yaari@123");
			Statement sts= connect.createStatement();
			ResultSet res;
			res = sts.executeQuery("select * from customers");
			int custId;
			String custName;
			String custAddr;
			
			while(res.next()) {
				custId=res.getInt("custId");
				custName=res.getString("custName");
				custAddr=res.getString("custAddr");
				System.out.println("Customer ID:"+custId+"Customer Name:"+custName+"Customer Address:"+custAddr);
			}
			
			res.close();
			sts.close();
			connect.close();
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			}
		
		
	
	}



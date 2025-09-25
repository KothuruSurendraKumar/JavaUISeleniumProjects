package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JdbcConnection {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		String host = "localhost";
		String port = "3306";
		Connection conn = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/Qadbt", "root",
				"Surendra@1");

		Statement s = conn.createStatement();
		ResultSet rs = s.executeQuery("SELECT * FROM EmployeeInfo WHERE name='Jhon'");
		while (rs.next()) {
			System.out.println(rs.getString("name"));
			System.out.println(rs.getInt("id"));
			System.out.println(rs.getString("location"));
			System.out.println(rs.getInt("age"));
		}
		
		ResultSet rs1 = s.executeQuery("SELECT * FROM EmployeeInfo WHERE age > 30");
		while (rs1.next()) {
			System.out.println(rs1.getString("name"));
			System.out.println(rs1.getInt("id"));
			System.out.println(rs1.getString("location"));
			System.out.println(rs1.getInt("age"));
		}
		
		Connection con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/demo", "root",
				"Surendra@1");
		Statement s1 = con.createStatement();
		ResultSet rs2 = s1.executeQuery("SELECT * FROM loginDetails WHERE username ='Jhon'");
		String uname="";
		String pass="";
		while(rs2.next()) {
			
			uname=rs2.getString("username");
			pass=rs2.getString("password");
			System.out.println("uname :"+uname);
			System.out.println("pass :"+pass);
		}
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		
		driver.findElement(By.id("username")).sendKeys(uname);
		driver.findElement(By.id("password")).sendKeys(pass);
		
		

	}

}

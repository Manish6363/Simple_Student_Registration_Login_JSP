package students.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import students.dto.Student;

public class StudentCrud {
	public Connection createTable() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb?createDatabaseIfNotExist=true",
				"root", "root");
		Statement s = conn.createStatement();
		s.execute(
				"CREATE TABLE IF NOT EXISTS STUDENT (NAME VARCHAR(45) NOT NULL, ID INT PRIMARY KEY, EMAIL VARCHAR(50) UNIQUE NOT NULL, PHONE BIGINT(10) UNIQUE NOT NULL, AGE TINYINT NOT NULL, GENDER VARCHAR(15) NOT NULL, ADDRESS VARCHAR(150) NOT NULL, PASSWORD VARCHAR(45) NOT NULL)");
		return conn;
	}
	
	public void insertData(Student stud) throws ClassNotFoundException, SQLException {
		Connection conn=createTable();
		PreparedStatement ps=conn.prepareStatement("INSERT INTO STUDENT VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
		ps.setString(1, stud.getName());
		ps.setInt(2, stud.getId());
		ps.setString(3, stud.getEmail());
		ps.setLong(4, stud.getPhone());
		ps.setInt(5, stud.getAge());
		ps.setString(6, stud.getGender());
		ps.setString(7, stud.getAddress());
		ps.setString(8, stud.getPassword());
		ps.executeUpdate();
		ps.close();
		conn.close();
	}
	
	public Student fetchDataByEmail(String email) throws ClassNotFoundException, SQLException {
		Connection conn=createTable();
		PreparedStatement ps=conn.prepareStatement("SELECT * FROM STUDENT WHERE EMAIL=?");
		ps.setString(1, email);
		ResultSet res=ps.executeQuery();
		Student stud=null;
		if(res.next()) {
			stud=new Student(res.getString(1), res.getInt(2), res.getString(3), res.getLong(4), res.getInt(5), res.getString(6), res.getString(7), res.getString(8));
			return stud;
		}
		ps.close();
		conn.close();
		return null;
	}
	
	public Student fetchDataById(int id) throws ClassNotFoundException, SQLException {
		Connection conn=createTable();
		PreparedStatement ps=conn.prepareStatement("SELECT * FROM STUDENT WHERE ID=?");
		ps.setInt(1, id);
		ResultSet res=ps.executeQuery();
		Student stud=null;
		if(res.next()) {
			stud=new Student(res.getString(1), res.getInt(2), res.getString(3), res.getLong(4), res.getInt(5), res.getString(6), res.getString(7), res.getString(8));
			return stud;
		}
		ps.close();
		conn.close();
		return null;
	}
	
	public ArrayList<Student> fetchAll() throws ClassNotFoundException, SQLException {
		Connection conn=createTable();
		PreparedStatement ps=conn.prepareStatement("SELECT * FROM STUDENT");
		ResultSet res=ps.executeQuery();
		Student stud=null;
		ArrayList<Student> al=new ArrayList<Student>();
		while(res.next()) {
			stud=new Student(res.getString(1), res.getInt(2), res.getString(3), res.getLong(4), res.getInt(5), res.getString(6), res.getString(7), res.getString(8));
			al.add(stud);
		}
		ps.close();
		conn.close();
		return al;
	}
	
	public void delete(String email) throws ClassNotFoundException, SQLException {
		Connection conn=createTable();
		PreparedStatement ps=conn.prepareStatement("DELETE FROM STUDENT WHERE EMAIL=?");
		ps.setString(1, email);
		ps.execute();
		ps.close();
		conn.close();
	}
	
	public void updateData(Student stud, int id) throws ClassNotFoundException, SQLException {
		Connection conn=createTable();
		PreparedStatement ps=conn.prepareStatement("UPDATE STUDENT SET NAME=?, EMAIL=?, PHONE=?, AGE=?, GENDER=?, ADDRESS=?, PASSWORD=? WHERE ID=?");
		ps.setString(1, stud.getName());
		ps.setString(2, stud.getEmail());
		ps.setLong(3, stud.getPhone());
		ps.setInt(4, stud.getAge());
		ps.setString(5, stud.getGender());
		ps.setString(6, stud.getAddress());
		ps.setString(7, stud.getPassword());
		ps.setInt(8, id);
		ps.execute();
		ps.close();
		conn.close();
	}
}


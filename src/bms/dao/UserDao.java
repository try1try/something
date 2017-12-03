package bms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import bms.util.DBUtil;
import bms.entity.User;
import java.io.*;
public class UserDao {
	
	//增加用户
	public void addUser(User user) throws Exception{
		DBUtil db = new DBUtil();
		Connection conn = db.getConn();
		String sql = "INSERT INTO user_info(username, password, email) VALUES (?,?,?)";
		PreparedStatement pt = conn.prepareStatement(sql);
		//pt.setInt(1, 5);
		
		pt.setString(1, user.getUsername());
		pt.setString(2, user.getPassword());
		pt.setString(3, user.getEmail());
		pt.execute();
	}
	
	//删除用户
	public void delUser(User user) throws Exception{
		DBUtil db = new DBUtil();
		Connection conn = db.getConn();
		String sql = "DELETE FROM user_info WHERE username=?";
		PreparedStatement pt = conn.prepareStatement(sql);
		pt.setString(1, user.getUsername());
		pt.execute();
	}
	
	
	//根据用户名获取user
	public User get(String username) throws Exception{
		DBUtil db = new DBUtil();
		Connection conn = db.getConn();
		User user = null;
		String sql = "SELECT * FROM user_info WHERE username = ?";
		PreparedStatement pt = conn.prepareStatement(sql);
		pt.setString(1, username);
		ResultSet rs = pt.executeQuery();
		while(rs.next()){
			user = new User();
			//user.setId(rs.getInt("id"));
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setEmail(rs.getString("email"));
		}
		return user;
	}
	//修改用户邮箱
	public void updateEmail(String username, String email) throws Exception{
		DBUtil db = new DBUtil();
		Connection conn = db.getConn();
		String sql = "UPDATE user_info SET email = ? WHERE username = ?";
		PreparedStatement pt = conn.prepareStatement(sql);
		
		pt.setString(1, email);
		pt.setString(2, username);
		
		pt.execute();
	}
	
}

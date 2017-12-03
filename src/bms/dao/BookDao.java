package bms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import bms.util.DBUtil;
import bms.entity.Book;

public class BookDao {
	//查找全部书籍
	public List<Book> findAll() throws Exception{
		DBUtil db = new DBUtil();
		Connection conn = db.getConn();
   	    List<Book> books=new ArrayList<Book>();
		StringBuilder sb=new StringBuilder();
		sb.append(" select * from books");
		PreparedStatement ptmt = conn.prepareStatement(sb.toString());	
		ResultSet rs = ptmt.executeQuery();
		Book b=null;
		while(rs.next()){
			b=new Book();
			b.setId(rs.getInt("id"));
			b.setTitle(rs.getString("title"));
			b.setAuthor(rs.getString("author"));
			b.setPublish(rs.getString("publish"));
			b.setDate(rs.getString("date"));
			b.setScore(rs.getString("score"));
			b.setPerson(rs.getString("person"));
			b.setPrice(rs.getString("price"));
			b.setTag(rs.getString("tag"));
			books.add(b);
			
		}
		rs.close();
		conn.close();
   	return books;
	}
	//根据书名查找
	public List<Book> query(String key) throws Exception{
		DBUtil db = new DBUtil();
		Connection conn = db.getConn();
   	    List<Book> books=new ArrayList<Book>();
		StringBuilder sb=new StringBuilder();
		sb.append(" select * from books");
		sb.append(" where title like ? or author like ? or publish like ? or date like ? or "
				+ "score like ? or person like ? or price like ? or tag like ?");
		PreparedStatement ptmt = conn.prepareStatement(sb.toString());
		ptmt.setString(1,"%"+key+"%");
		ptmt.setString(2,"%"+key+"%");
		ptmt.setString(3,"%"+key+"%");
		ptmt.setString(4,"%"+key+"%");
		ptmt.setString(5,"%"+key+"%");
		ptmt.setString(6,"%"+key+"%");
		ptmt.setString(7,"%"+key+"%");
		ptmt.setString(8,"%"+key+"%");
		ResultSet rs = ptmt.executeQuery();
		Book b=null;
		while(rs.next()){
			b=new Book();
			b.setId(rs.getInt("id"));
			b.setTitle(rs.getString("title"));
			b.setAuthor(rs.getString("author"));
			b.setPublish(rs.getString("publish"));
			b.setDate(rs.getString("date"));
			b.setScore(rs.getString("score"));
			b.setPerson(rs.getString("person"));
			b.setPrice(rs.getString("price"));
			b.setTag(rs.getString("tag"));
			books.add(b);
			
		}
		rs.close();
		conn.close();
   	return books;
   	
   }
	//根据id查找
		public Book findBookById(int id) throws Exception{
			DBUtil db = new DBUtil();
			Connection conn = db.getConn();
			StringBuilder sb=new StringBuilder();
			sb.append(" select * from books");
			sb.append(" where id = ?");
			PreparedStatement ptmt = conn.prepareStatement(sb.toString());
			ptmt.setInt(1, id);
			
			ResultSet rs = ptmt.executeQuery();
			Book b=null;
			while(rs.next()){
				b=new Book();
				b.setId(rs.getInt("id"));
				b.setTitle(rs.getString("title"));
				b.setAuthor(rs.getString("author"));
				b.setPublish(rs.getString("publish"));
				b.setDate(rs.getString("date"));
				b.setScore(rs.getString("score"));
				b.setPerson(rs.getString("person"));
				b.setPrice(rs.getString("price"));
				b.setTag(rs.getString("tag"));
				
			}
			rs.close();
			conn.close();
	   	return b;
	   	
	   }
	//分页查询
	public List<Book> findBooks(int page, int count) throws Exception{
		DBUtil db = new DBUtil();
		Connection conn = db.getConn();
   	    List<Book> books=new ArrayList<Book>();
		String sql = "select * from books LIMIT ?,?";
		PreparedStatement ps = conn.prepareStatement(sql);
		 ps.setInt(1, (page-1)*count);
	     ps.setInt(2, count);
		
		ResultSet rs = ps.executeQuery();
		Book b=null;
		while(rs.next()){
			b=new Book();
			b.setId(rs.getInt("id"));
			b.setTitle(rs.getString("title"));
			b.setAuthor(rs.getString("author"));
			b.setPublish(rs.getString("publish"));
			b.setDate(rs.getString("date"));
			b.setScore(rs.getString("score"));
			b.setPerson(rs.getString("person"));
			b.setPrice(rs.getString("price"));
			b.setTag(rs.getString("tag"));
			books.add(b);
			
		}
		rs.close();
		conn.close();
   	return books;
   	
   }
	public int count() throws  Exception {
		DBUtil db = new DBUtil();
		Connection conn = db.getConn();
        PreparedStatement ps = conn.prepareStatement("SELECT COUNT(*) FROM books");
        ResultSet rs = ps.executeQuery();  
        int count = 0;
        if (rs.next()) {
            count = rs.getInt(1);
        }
        return count;
    }
}

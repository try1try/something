package bms.util;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSourceFactory;

public class DBUtil {
    
    private static Properties properties = new Properties();
    private static DataSource dataSource;
    public DBUtil(){
    	
    }
    //加载DBCP配置文件
    static{
        try{
        	InputStream in = DBUtil.class.getClassLoader().getResourceAsStream("dbcp.properties");
            properties.load(in);
        }catch(IOException e){
            e.printStackTrace();
        }
        
        try{
            dataSource = BasicDataSourceFactory.createDataSource(properties);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //从连接池中获取一个连接
    public Connection getConn(){
        Connection connection = null;
        try{
            connection = dataSource.getConnection();
        }catch(SQLException e){
            e.printStackTrace();
        }
        try {
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    
}
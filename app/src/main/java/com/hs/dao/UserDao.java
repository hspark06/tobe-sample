package com.hs.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.SQLClientInfoException;
import java.sql.SQLException;

import com.hs.domain.User;

public class UserDao {
    public void add(User user) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/TESTDB?useSSL=false&useUnicode=true&serverTimezone=Asia/Seoul", "dsic", "dsic");
        PreparedStatement ps = c.prepareStatement("insert into USERS(id, name, password) values(?,?,?)");
        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());

        ps.executeUpdate();
        c.close();
    }

    public User get(String id) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/TESTDB?useSSL=false&useUnicode=true&serverTimezone=Asia/Seoul", "dsic", "dsic");
        PreparedStatement ps = c.prepareStatement("select * from users where id = ?");
        ps.setString(1, id);
        
        ResultSet rs = ps.executeQuery();
        rs.next();
        
        User user = new User();
        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));
        
        rs.close();
        ps.close();
        c.close();

        return user;
    }
}

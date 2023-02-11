package com.hs;

import java.sql.SQLException;

import com.hs.dao.UserDao;
import com.hs.domain.User;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        System.out.println(new App().getGreeting());

        UserDao dao = new UserDao();
        
        User user =  new User();
        user.setId("whiteship");
        user.setName("백기선");
        user.setPassword("married");

        try {
            dao.add(user);
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException : " + e.toString());
        } catch(SQLException e1) {
            System.out.println("SQLException : " +e1.toString());
        } 

        System.out.println(user.getId() + " 등록 성공");

        User user2 = null;

        try {
            user2 = dao.get(user.getId());
            System.out.println(user2.getId() + " 조회 성공");
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException : " + e.toString());
        } catch(SQLException e1) {
            System.out.println("SQLException : " +e1.toString());
        } 


       

        
    }
}

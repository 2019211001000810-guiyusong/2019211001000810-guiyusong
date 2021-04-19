package com;

import com.guiyusong.dao.UserDao;
import com.guiyusong.model.user;


import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet",value = "/login")
public class LoginServlet extends HttpServlet {


    Connection con = null;
    @Override
    public void init()throws ServletException{
        super.init();
        FilterConfig sec = null;
        ServletContext context = sec.getServletContext();
        String driver=context.getInitParameter("driver");
        String url=context.getInitParameter("url");
        String username=context.getInitParameter("username");
        String password=context.getInitParameter("password");



        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,username,password);
            System.out.println("i am in contextInitialized()-->"+con);
            // System.out.println("init()-->"+con);
            context.setAttribute("con",con);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        con=(Connection) getServletContext().getAttribute("con");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException,ServletException{
        ServletResponse responses = null;
        request.getRequestDispatcher("WEB-INF/view/login.jsp").forward(request,responses);
        PrintWriter writer = response.getWriter();
        writer.println("Hellow Client !!!");
        writer.println("Name:Guiyusong");
        writer.println("ID:2019211001000810");
        writer.println("Data and Time : 2021/3/15 20:19:00 ");
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response){
        String username =request.getParameter("username");
        String password =request.getParameter("password");

        UserDao userDao=new UserDao();
        try {
            user user = null;
            request.setAttribute("user", user);
            user = userDao.findByUsernamePassword(con, username, password);
            if (user != null) {
                request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request, response);
            } else {
                request.setAttribute("message", "Username or Password Error!!!");
                request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String sql="select id,username,password,email,gender,birthdate from usertable where username'"+username+password;


        try {
            ResultSet rs =con.createStatement().executeQuery(sql);
            if(rs.next()){

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}

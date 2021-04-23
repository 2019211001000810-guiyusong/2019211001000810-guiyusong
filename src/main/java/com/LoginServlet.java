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
    public void init()throws ServletException {

        con = (Connection) getServletContext().getAttribute("con");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException,ServletException{

        request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);

    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username =request.getParameter("username");
        String password =request.getParameter("password");
        PrintWriter out=response.getWriter();
        UserDao userDao=new UserDao();
        try {
            user user=userDao.findByUsernamePassword(con,username,password);
            if(user!=null){
                request.setAttribute("user",user);
                request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request,response);
            }else{
                request.setAttribute("message","Username or Password Error!!!");
                request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
            }
        } catch (SQLException | ServletException throwables) {
            throwables.printStackTrace();
        }

    }
}

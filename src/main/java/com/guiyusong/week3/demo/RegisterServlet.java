package com.guiyusong.week3.demo;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(urlPatterns = {"/register"},loadOnStartup = 1)
public class RegisterServlet extends HttpServlet {
    Connection con = null;
    @Override
    public  void  init() throws  ServletException{
        super.init();
        con=(Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        String username =request.getParameter( "username");
    String password =request.getParameter( "password");
    String email =request.getParameter( "email");
    String gender =request.getParameter( "gender");
    String birthDate =request.getParameter( "birthDate");

    try{
        Statement st =con.createStatement();
        String sql="insert into usertable(username,password,email,gender,brithdate)"+
                "values ('"+username+"','"+password+"','"+email+"','"+gender+"','"+birthDate+"')";
        System.out.println("sql"+sql);
        ResultSet rs =st.executeQuery(sql);
        PrintWriter out =response.getWriter();
        int n= st.executeUpdate(sql);
        System.out.println("n-->"+n);
        //sql="select id,username,email,gender,brithdate from usertable";
        //ResultSet rs = st.executeQuery(sql);
        //PrintWriter out =response.getWriter();
        //request.setAttribute("rsname",rs);
        //request.getRequestDispatcher("userList.jsp").forward(request,response);
        request.setAttribute("rsname",rs);

        response.sendRedirect("login.jsp");
        request.getRequestDispatcher("userList.jsp").forward(request,response);
        System.out.println("i am in RegisterServlet-->doPost()--> after forward()");
    } catch (SQLException e){
        e.printStackTrace();
    }

    writer.println("<br> username:"+username);
    writer.println("<br> password :"+password);
    writer.println("<br> email :"+email);
    writer.println("<br> gender :+gender");
    writer.println("<br> brith Date"+birthDate);
    writer.close();


    }
}

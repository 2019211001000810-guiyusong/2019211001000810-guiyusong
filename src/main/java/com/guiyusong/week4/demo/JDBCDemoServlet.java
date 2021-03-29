package com.guiyusong.week4.demo;

import jdk.nashorn.internal.parser.Scanner;

import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(
        urlPatterns ={"/jdbc"},
        initParams = {
                @WebInitParam(name="driver",value="com.microsoft.sqlserver.jdbc.SQLServerDriver"),
                @WebInitParam(name="url",value ="jdbc:sqlserver://localhost;databaseName=userdb;"),
                @WebInitParam(name="username",value = "sa"),
                @WebInitParam(name = "password",value = "123456")
        },loadOnStartup = 1

)
public class JDBCDemoServlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException{
        //String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver ";
        //String url="jdbc:sqlsever://localhost:databaseName=userdb";
        //String username="sa";
        //String password="123456";
        ServletConfig config=getServletConfig();
        String driver =config.getInitParameter("driver");
        String url =config.getInitParameter("out");
        String username =config.getInitParameter("username");
        String password =config.getInitParameter("password");
        try{
            Class.forName(driver);
            con= DriverManager.getConnection(url,username,password);
            System.out.println("-->"+con);
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    System.out.println("i am in doGet()");
    String sql="select * from userTable";
    String sql1 = "insert into userTable(username,password) values (?,?)";
    String sql2= "delete from userTable where id= ?";
    String sql3= "update  userTable set username=?,password=? where id= ?";
    try{
        ResultSet rs=con.createStatement().executeQuery(sql);
        ResultSet rs1=con.createStatement().executeQuery(sql1);
        ResultSet rs2=con.createStatement().executeQuery(sql2);
        ResultSet rs3=con.createStatement().executeQuery(sql3);
        while(rs.next())
        {}
        while(rs1.next())
        {}
        while(rs2.next())
        {}
        while(rs3.next())
        {}
    }catch (SQLException throwables){
        throwables.printStackTrace();
    }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void destroy() {
        super.destroy();
        try {
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}

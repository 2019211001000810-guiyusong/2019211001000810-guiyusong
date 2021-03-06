package com.guiyusong.week4.demo;

import jdk.nashorn.internal.parser.Scanner;

import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(
        urlPatterns = {"/config"},
        initParams = {
                @WebInitParam(name="name",value = "wuchen"),
                @WebInitParam(name="studentid",value = "2019211001000806")
        },loadOnStartup = 1
)

public class JDBCDemoServlet  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=getServletConfig().getInitParameter("name");
        String studentid=getServletConfig().getInitParameter("studentid");
        PrintWriter writer= response.getWriter();
        writer.println("name:"+name);
        writer.println("studentid:"+studentid);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
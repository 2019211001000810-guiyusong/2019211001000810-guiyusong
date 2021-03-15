package com;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloWorldServlet  extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException {
        PrintWriter writer = response.getWriter();
        writer.println("Hellow Client !!!");
        writer.println("Name:Guiyusong");
        writer.println("ID:2019211001000810");
        writer.println("Data and Time : 2021/3/15 20:19:00 ");
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response){


    }
}

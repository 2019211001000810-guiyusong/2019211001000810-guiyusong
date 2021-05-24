package com.guiyusong.dao;

import com.guiyusong.model.Product;


import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao implements  IProductDao{

    @Override
    public int save(Product product, Connection con) throws SQLException {
        int n = 0;
        String sql = "insert into product(ProductName,ProductDescription,Picture,Price,CategoryID) values(?,?,?,?,?)";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setString(1, product.getProductName());
        pt.setString(2, product.getProductDescription());
        if(product.getPicture()!=null) {
            //for sql server
            //pt.setBinaryStream(3, product.getPicture());
            //for mysql
            pt.setBlob(3, product.getPicture());
        }
        pt.setDouble(4, product.getPrice());
        pt.setInt(5, product.getCategoryId());
        n = pt.executeUpdate();
        if (n > 0) {
            return n;
        }
        return 0;
    }//end save

    @Override
    public int delete(Integer productId, Connection con) throws SQLException {
        String sql = "delete from Product where ProductId = ?";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setInt(1,productId);
        return pt.executeUpdate();
    }

    @Override
    public int update(Product instance, Connection con) throws SQLException {
        int n = 0;
        String sql = "UPDATE Product SET ProductName=?,ProductDescription=?,Picture=?,price=?,CategoryID=? WHERE ProductID=?;";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setString(1, instance.getProductName());
        pt.setString(2, instance.getProductDescription());
        if (instance.getPicture() != null) {
            pt.setBlob(3, instance.getPicture());
        }
        pt.setDouble(4, instance.getPrice());
        pt.setInt(5, instance.getProductId());
        pt.setInt(6, instance.getProductId());
        n = pt.executeUpdate();
        if (n > 0) {
            return n;
        }
        return 0;
    }

    @Override
    public Product findById(Integer productId, Connection con) throws SQLException {
        String sql = "select * from Product where ProductID=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, productId);
        ResultSet rs = ps.executeQuery();
        Product product = new Product();
        if (rs.next()) {
            product.setProductId(rs.getInt("ProductID"));
            product.setProductName(rs.getString("ProductName"));
            product.setProductDescription(rs.getString("ProductDescription"));
            //product.setPicture((InputStream) rs.getBlob("Picture"));
            product.setPrice(rs.getDouble("Price"));
            product.setCategoryId(rs.getInt("CategoryID"));
        }
        return product;
    }

    @Override
    public List<Product> findByCategoryId(int categoryId, Connection con) throws SQLException {
        List<Product> productList = new ArrayList<Product>();
        String sql = "select * from Product where CategoryID=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, categoryId);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Product product = new Product();
            product.setProductId(rs.getInt("ProductID"));
            product.setProductName(rs.getString("ProductName"));
            product.setProductDescription(rs.getString("ProductDescription"));
            //product.setPicture((InputStream) rs.getBlob("Picture"));
            product.setPrice(rs.getDouble("Price"));
            product.setCategoryId(rs.getInt("CategoryID"));
            productList.add(product);
        }
        return productList;
    }

    @Override
    public List<Product> findByPrice(double minPrice, double maxPrice, Connection con) throws SQLException {
        List<Product> productList = new ArrayList<Product>();
        String sql = "select * from Product where Price between ? and ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setDouble(1, minPrice);
        ps.setDouble(2, maxPrice);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Product product = new Product();
            product.setProductId(rs.getInt("ProductID"));
            product.setProductName(rs.getString("ProductName"));
            product.setProductDescription(rs.getString("ProductDescription"));
            product.setPicture((InputStream) rs.getBlob("Picture"));
            product.setPrice(rs.getDouble("Price"));
            product.setCategoryId(rs.getInt("CategoryID"));
            productList.add(product);
        }
        return productList;
    }

    @Override
    public List<Product> findAll(Connection con) throws SQLException {
        List<Product> productList = new ArrayList<Product>();
        String sql = "select * from Product";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Product product = new Product();
            product.setProductId(rs.getInt("ProductID"));
            product.setProductName(rs.getString("ProductName"));
            product.setProductDescription(rs.getString("ProductDescription"));
            //product.setPicture((InputStream) rs.getBlob("Picture"));
            product.setPrice(rs.getDouble("Price"));
            product.setCategoryId(rs.getInt("CategoryID"));
            productList.add(product);
        }
        return productList;
    }

    @Override
    public List<Product> findByProductName(String productName, Connection con) throws SQLException {
        List<Product> productList = new ArrayList<Product>();
        String sql = "select * from Product where ProductName=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, productName);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Product product = new Product();
            product.setProductId(rs.getInt("ProductID"));
            product.setProductName(rs.getString("ProductName"));
            product.setProductDescription(rs.getString("ProductDescription"));
            product.setPicture((InputStream) rs.getBlob("Picture"));
            product.setPrice(rs.getDouble("Price"));
            product.setCategoryId(rs.getInt("CategoryID"));
            productList.add(product);
        }
        return productList;
    }

    @Override
    public List<Product> getPicture(Integer productId, Connection con) throws SQLException {
        List<Product> productList = new ArrayList<Product>();
        String sql = "select * from Product where ProductID=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, productId);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Product product = new Product();
            if (rs.getBlob("Picture") != null)
                product.setPicture((InputStream) rs.getBlob("Picture"));
            productList.add(product);
        }
        return productList;
    }
    public byte[] getPictureById(int productId, Connection con) throws SQLException {
        byte[] imgByte = null;
        String sql = "select Picture from product where ProductId=?";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setInt(1, productId);
        ResultSet rs = pt.executeQuery();
        while (rs.next()) {
            Blob blob = rs.getBlob("Picture");
            imgByte = blob.getBytes(1, (int) blob.length());
        }
        return imgByte;
    }
}

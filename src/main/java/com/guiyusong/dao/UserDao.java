package com.guiyusong.dao;

import com.guiyusong.model.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class UserDao implements IUserDao{
    @Override
    public boolean saveUser(Connection con, user user) throws SQLException {
        String sql="insert into usertable values(?,?,?,?,?,?)";
        PreparedStatement st=con.prepareStatement(sql);
        st.setInt(1,user.getId());
        st.setString(2,user.getUsername());
        st.setString(3, user.getPassword());
        st.setString(4, user.getEmail());
        st.setString(5, user.getGender());
        st.setDate(6,user.setBirthday());

        return false;
    }

    @Override
    public int deleteUser(Connection con, user user) throws SQLException {
        String sql="delete from usertable where id=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.executeUpdate(sql);
        ResultSet rs=st.executeQuery();
        if(rs.next()) {
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.getBrithdate(rs.getDate("birthdate"));
        }
        return 0;
    }

    @Override
    public int updateUser(Connection con, user user) throws SQLException {
        String sql="update  usertable set username=? where id=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.executeUpdate(sql);
        ResultSet rs=st.executeQuery();
        if(rs.next()) {
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthday(rs.getDate("birthdate"));

        }
        return 0;
    }

    @Override
    public user findById(Connection con, Integer id) throws SQLException {
        String sql="select * from usertable where  id=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setInt(1,id);
        ResultSet rs=st.executeQuery();
        user user=null;
        if (rs.next()){
            user=new user();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthday(rs.getDate("birthdate"));
        }
        return null;
    }

    @Override
    public user findByUsernamePassword(Connection con, String username, String password) throws SQLException {
        String sql="select id,username,password,email,gender,birthdate from usertable where username =? and password=?";
        PreparedStatement st =con.prepareStatement(sql);
        st.setString(1,username);
        st.setString(2,password);
        ResultSet rs = st.executeQuery();
        user user=null;
        if (rs.next())
        {
            user =new user();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("emsil"));
            user.setGender(rs.getString("gender"));
            user.setBirthday(rs.getDate("birthdate"));
        }
        return null;
    }

    @Override
    public List<user> findByUsername(Connection con, String username) throws SQLException {
        String sql="select * from usertable where  username=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,username);
        ResultSet rs=st.executeQuery();
        user user=null;
        if (rs.next()){
            user=new user();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthday(rs.getDate("birthdate"));
        }
        return null;
    }

    @Override
    public List<user> findByPassword(Connection con, String password) throws SQLException {
        String sql="select * from usertable where  password=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,password);
        ResultSet rs=st.executeQuery();
        user user=null;
        if (rs.next()){
            user=new user();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthday(rs.getDate("birthdate"));
        }

        return null;
    }

    @Override
    public List<user> findByEmail(Connection con, String email) throws SQLException {
        String sql="select * from usertable where  email=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,email);
        ResultSet rs=st.executeQuery();
        user user=null;
        if (rs.next()){
            user=new user();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthday(rs.getDate("birthdate"));
        }
        return null;
    }

    @Override
    public List<user> findByGender(Connection con, String gender) throws SQLException {
        String sql="select * from usertable where  gender=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,gender);
        ResultSet rs=st.executeQuery();
        user user=null;
        if (rs.next()){
            user=new user();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthday(rs.getDate("birthdate"));
        }
        return null;
    }

    @Override
    public List<user> findByBirthdate(Connection con, Date birthDate) throws SQLException {
        String sql="select * from usertable where  birthdate=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setDate(1, (java.sql.Date) birthDate);
        ResultSet rs=st.executeQuery();
        user user=null;
        if (rs.next()){
            user=new user();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthday(rs.getDate("birthdate"));
        }
        return null;
    }

    @Override
    public List<user> findAllUser(Connection con) throws SQLException {
        String sql="select * from usertable ";
        PreparedStatement st=con.prepareStatement(sql);
        ResultSet rs=st.executeQuery();
        user user=null;
        if (rs.next()){
            user=new user();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthday(rs.getDate("birthdate"));
        }
        return null;
    }
}




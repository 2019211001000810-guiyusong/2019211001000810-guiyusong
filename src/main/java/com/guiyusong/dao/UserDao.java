package com.guiyusong.dao;

import com.guiyusong.model.user;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class UserDao implements IUserDao{
    @Override
    public boolean saveUser(Connection con, user user) throws SQLException {
        return false;
    }

    @Override
    public int deleteUser(Connection con, user user) throws SQLException {
        return 0;
    }

    @Override
    public int updateUser(Connection con, user user) throws SQLException {
        try{
            Statement createDbStatement = con.createStatement();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String dbRequire="update usertable set username='"+user.getUsername()+"',password='"+user.getPassword()+"',email='"+user.getEmail()+"',gender='"+user.getGender()+"',birthdate='"+simpleDateFormat.format(user.getBirthday())+"' where id="+user.getId();
            createDbStatement.executeUpdate(dbRequire);
            System.out.println("update "+user.getId()+"success");
            return 1;
        }catch(Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    @Override
    public user findById(Connection con, Integer id) throws SQLException {
        return null;
    }

    @Override
    public user findByUsernamePassword(Connection con, String username, String password) throws SQLException {
        String sql="select * from usertable where username='"+username+"' and password='"+password+"'";
        PreparedStatement st=con.prepareStatement(sql);
        ResultSet rs=st.executeQuery();
       user user=null;
        if(rs.next()){
            user=new user();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("Username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("Email"));
            user.setGender(rs.getString("Gender"));
            user.setBirthDate(rs.getDate("BirthDate"));
        }
        return user;
    }

    @Override
    public List<user> findByUsername(Connection con, String username) throws SQLException {
        return null;
    }

    @Override
    public List<user> findByPassword(Connection con, String password) throws SQLException {
        return null;
    }

    @Override
    public List<user> findByEmail(Connection con, String email) throws SQLException {
        return null;
    }

    @Override
    public List<user> findByGender(Connection con, String gender) throws SQLException {
        return null;
    }

    @Override
    public List<user> findByBirthdate(Connection con, Date birthDate) throws SQLException {
        return null;
    }

    @Override
    public List<user> findAllUser(Connection con) throws SQLException {
        return null;
    }
}




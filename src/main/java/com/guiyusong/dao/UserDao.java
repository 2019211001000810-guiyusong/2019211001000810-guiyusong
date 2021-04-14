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
        return false;
    }

    @Override
    public int deleteUser(Connection con, user user) throws SQLException {
        return 0;
    }

    @Override
    public int updateUser(Connection con, user user) throws SQLException {
        return 0;
    }

    @Override
    public user findById(Connection con, Integer id) throws SQLException {
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
            user.setBrithdate(rs.getDate("birthdate"));
        }
        return null;
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

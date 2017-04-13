/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author dorado
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.PreparedStatement;
import java.util.List;
import model.*;
import java.util.ArrayList;

public class UserDaoImp implements UserDao {

    @Override
    public boolean addUser(UserBean u) {
        Connection con = DBConnect.getConnecttion();
        String sql = "insert into User value(?,?,?,?,?)";
        PreparedStatement ps;
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setLong(1, u.getUserId());
            ps.setString(2, u.getUsername());
            ps.setString(3, u.getEmail());
            ps.setString(4, u.getPassword());
            ps.setString(5, u.getGender());
            ps.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean exists(String username) {
        Connection con = DBConnect.getConnecttion();
        String sql = "SELECT * FROM User where username='" + username + "'";
        PreparedStatement ps;
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                con.close();
            } else {
                con.close();
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public int totalImagesPosted(long userId) {
        int count = 0;
        Connection con = DBConnect.getConnecttion();
        String sql = "select count(*) from Image where user_id=" + userId + "";
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
        return count;
    }
    
    @Override
    public List listImagesPosted(long userId) {
        Connection con = DBConnect.getConnecttion();
        String sql = "select image_id from Image where user_id=" + userId + " ORDER BY time DESC";
        PreparedStatement ps;
        ResultSet rs;
        List<Integer> list;
        list = new ArrayList<Integer>();

        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
    
    @Override
    public List listImagesPostedByFollowing(long userId) {
        Connection con = DBConnect.getConnecttion();
        Sy
        String sql = "select image_id  from Image inner join Followers where user_id = following_id and follower_id=" + userId + "";
        PreparedStatement ps;
        ResultSet rs;
        List<Integer> list;
        list = new ArrayList<Integer>();

        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public boolean login(String username, String password) {
        Connection con = DBConnect.getConnecttion();
        String sql = "SELECT * FROM User WHERE username='" + username
                + "' AND password='" + password + "'";
        PreparedStatement ps;
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                con.close();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        UserDaoImp obj = new UserDaoImp();
        //UserBean u = new UserBean(1, "username", "password", "email", "name", "gender");
//        List<Integer> result = obj.listImagesPosted(0);
        System.out.println(obj.listImagesPostedByFollowing(1));
    }

    @Override
    public long getIdFromUsername(String username) {
        Connection con = DBConnect.getConnecttion();
        String sql = "SELECT user_id FROM User WHERE username='" + username + "'";
        PreparedStatement ps;
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                long userId = rs.getLong("user_id");
                con.close();
                return userId;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    @Override
    public int totalFollowers(long userId) {
        int count = 0;
        Connection con = DBConnect.getConnecttion();
        String sql = "select count(*) from Followers where following_id=" + userId + "";
	PreparedStatement ps;
        ResultSet rs;
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) count = rs.getInt(1);
            con.close();
        } catch(SQLException e) {
            e.printStackTrace();
            return 0;
        }
        return count;
    }

    @Override
    public int totalFollowing(long userId) {
        int count = 0;
        Connection con = DBConnect.getConnecttion();
        String sql = "select count(*) from Followers where follower_id=" + userId + "";
	PreparedStatement ps;
        ResultSet rs;
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) count = rs.getInt(1);
            con.close();
        } catch(SQLException e) {
            e.printStackTrace();
            return 0;
        }
        return count;
    }
    
    @Override
    public List listFollowersOf(long userId) {
        Connection con = DBConnect.getConnecttion();
        String sql = "select follower_id from Followers where following_id=" + userId + "";
	PreparedStatement ps;
        ResultSet rs;
        List<Integer> list;
        list = new ArrayList<Integer>();
        
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return list;
    }
    
    @Override
    public List listFollowingOf(long userId) {
        Connection con = DBConnect.getConnecttion();
        String sql = "select following_id from Followers where follower_id=" + userId + "";
	PreparedStatement ps;
        ResultSet rs;
        List<Integer> list;
        list = new ArrayList<Integer>();
        
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return list;
    }
}

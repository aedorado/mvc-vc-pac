/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author swapnil
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import model.*;

public class FollowersDaoImp implements FollowersDao {

    @Override
    public boolean addFollower(FollowersBean f) {
        Connection con = DBConnect.getConnecttion();
        String sql = "insert into Followers value(?,?)";
	PreparedStatement ps;
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setLong(1, f.getFollowerId());
            ps.setLong(2, f.getFollowingId());          
            ps.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } 
        return true;
    }

    @Override
    public boolean deleteFollower(long followerId, long followingId) {
        Connection con = DBConnect.getConnecttion();
        String sql = "delete from Followers where following_id="+followingId + " and follower_id=" + followerId; 
	PreparedStatement ps;
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);       
            ps.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } 
        return true;
    }

    
    
    public static void main(String[] args) {
        FollowersDaoImp ob = new FollowersDaoImp();
     //   FollowersBean f = new FollowersBean(3, 1);
      //  boolean res = ob.addFollower(f);
      //  System.out.println(res);
        
      // res = ob.deleteFollower(1, 2);
      //  System.out.println(res);
        
     

    }
}

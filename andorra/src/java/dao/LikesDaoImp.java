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
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.PreparedStatement;
import java.util.List;
import model.*;
import java.util.ArrayList;

public class LikesDaoImp implements LikesDao{

    @Override
    public boolean addLike(LikesBean l) {
        Connection con = DBConnect.getConnecttion();
        String sql = "insert into Likes value(?,?)";
	PreparedStatement ps;
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setLong(1, l.getImageId());    
            ps.setLong(2, l.getUserId());
            ps.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } 
        return true;
    }

    @Override
    public int totalLikes(long imageId) {
        int count = 0;
        Connection con = DBConnect.getConnecttion();
        String sql = "select count(*) from Likes where image_id=" + imageId + "";
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
    
    public static void main(String[] args) {
        LikesDaoImp ob = new LikesDaoImp();
        //LikesBean l = new LikesBean(3, 5);
        int res = ob.totalLikes(3);
        System.out.println(res);
    } 
    
}

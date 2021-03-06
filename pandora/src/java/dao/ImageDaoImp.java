/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.PreparedStatement;
import model.*;

/**
 *
 * @author swapnil and dorado
 */
public class ImageDaoImp implements ImageDao {

    @Override
    public boolean addImage(ImageBean u) {
        Connection con = DBConnect.getConnecttion();
        String sql = "insert into Image value(?,?,?,?)";
        PreparedStatement ps;
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setLong(1, u.getImageId());
            ps.setLong(2, u.getUserId());
            ps.setString(3, u.getCaption());
            ps.setTimestamp(4, u.getTime());
            ps.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        ImageDaoImp ob = new ImageDaoImp();
//        boolean res = ob.isLikedBy(1L, 2L);
        ImageBean img = ob.getImageByID(1);
        System.out.println(img.getCaption());
    }

    @Override
    public int countTotalImages() {
        int count = 0;
        Connection con = DBConnect.getConnecttion();
        String sql = "select count(*) from Image";
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
    public ImageBean getImageByID(long imageId) {
        Connection con = DBConnect.getConnecttion();
        String sql = "select * from Image WHERE image_id = '" + imageId + "'";
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ImageBean img = new ImageBean();
                img.setImageId(rs.getLong("image_id"));
                img.setUserId(rs.getLong("user_id"));
                img.setCaption(rs.getString("caption"));
                img.setTime(rs.getTimestamp("time"));
                con.close();
                return img;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    @Override
    public boolean isLikedBy(long imageid, long userid) {
        Connection con = DBConnect.getConnecttion();
        String sql = "SELECT COUNT(*) FROM Likes WHERE user_id='" + userid + "' AND image_id = '" + imageid + "'";
        PreparedStatement ps;
        try {
            int count = 0;
            ps = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
                con.close();
            }
            if (count == 0) {
                return false;
            } else {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.PreparedStatement;
import java.util.List;
import model.*;
import java.util.ArrayList;
/**
 *
 * @author swapnil
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
        ImageBean I = new ImageBean(1, 5, "caption dasd da ", null);
        boolean res= ob.addImage(I);
        System.out.println(res);
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
}

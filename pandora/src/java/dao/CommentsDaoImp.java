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
import java.sql.SQLException;
import com.mysql.jdbc.PreparedStatement;
import model.*;

public class CommentsDaoImp implements CommentsDao {

    @Override
    public boolean addComment(CommentsBean c) {
       Connection con = DBConnect.getConnecttion();
        String sql = "insert into Comments value(?,?,?,?,?)";
	PreparedStatement ps;
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setLong(1, c.getCommentId());
            ps.setLong(2, c.getImageId());
            ps.setLong(3, c.getUserId());
            ps.setString(4, c.getComment());
            ps.setTimestamp(5, c.getTime());
            ps.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } 
        return true;
    }
    
    public static void main(String[] args) {
        CommentsDaoImp ob = new CommentsDaoImp();
        CommentsBean c = new CommentsBean(1, 2, 1, "fuck the world", null);
        boolean res= ob.addComment(c);
        System.out.println(res);
    }
    
}

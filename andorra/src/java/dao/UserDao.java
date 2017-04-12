/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author algoprentice
 */
import java.util.List;
import model.UserBean;
public interface UserDao {    
    //1 if user added successfuly else 0.
    public boolean addUser(UserBean u);
    //1 if username and password exist and match else 0.
    public boolean checkUser(String username, String password);
    //No. of images posted by the userId.
    public int totalImagesPosted(long userId);
    //List of images posted by the user/
    public List listImagesPosted(long userId);
}

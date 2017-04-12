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
import java.util.List;
import model.UserBean;
public interface UserDao {    
    //1 if user added successfuly else 0.
    public boolean addUser(UserBean u);
    //1 if username exists else 0.
    public boolean checkUser(String username);
    //No. of images posted by the userId.
    public int totalImagesPosted(long userId);
    //List of images posted by the user/
    public List listImagesPosted(long userId);
    // login user
    public boolean login(String username, String password);
}

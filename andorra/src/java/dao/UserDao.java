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
    public boolean exists(String username);

    //No. of images posted by the userId.
    public int totalImagesPosted(long userId);

    //List of images posted by the user/
    public List listImagesPosted(long userId);
    public List listImagesPostedByFollowing(long userId);
    // login user
    public boolean login(String username, String password);

    public long getIdFromUsername(String username);

    //Number of followers of user.
    public int totalFollowers(long userId);

    public List listFollowersOf(long userId);
    //Number of users, user is following.

    public int totalFollowing(long userId);

    public List listFollowingOf(long userId);
}

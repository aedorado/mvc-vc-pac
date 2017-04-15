/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAgent;

import dao.ImageDaoImp;
import dao.UserDaoImp;
import java.util.List;
import model.ImageBean;
import model.UserBean;

/**
 *
 * @author dorado
 */
public class DataAgentControl {

    private UserDaoImp udi;
    private ImageDaoImp idi;

    public DataAgentControl() {
        udi = new UserDaoImp();
        idi = new ImageDaoImp();
    }

    public boolean userExists(String username) {
        return (udi.exists(username));
    }

    public boolean addUser(UserBean userBean) {
        return (udi.addUser(userBean));
    }

    public boolean correctCredentials(String username, String password) {
        return (udi.login(username, password));
    }

    public long getIdFromUsername(String username) {
        return (udi.getIdFromUsername(username));
    }

    public List<Integer> listImagesPostedByFollowing(long userId) {
        return (udi.listImagesPostedByFollowing(userId));
    }

    public ImageBean getImageById(long imageId) {
        return (idi.getImageByID(imageId));
    }

    public UserBean getUserByID(long userId) {
        return (udi.getUserByID(userId));
    }

    public static void main(String args[]) {
        DataAgentControl d = new DataAgentControl();
        ImageBean ib = d.getImageById(1);
        System.out.println(ib.getCaption());
    }

    public List<Integer> listImagesPosted(long userId) {
        return (udi.listImagesPosted(userId));
    }

    public int getNumImagesPosted(long userId) {
        return (udi.totalImagesPosted(userId));
    }

    public int getTotalFollowers(long userId) {
        return (udi.totalFollowers(userId));

    }

    public int getTotalFollowing(long userId) {
        return (udi.totalFollowing(userId));
    }
    
    public int countTotalImages() {
        return (idi.countTotalImages());
    }

    public boolean addImage(ImageBean imageBean) {
        return (idi.addImage(imageBean));
    }

}

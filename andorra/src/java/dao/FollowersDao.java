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
import java.util.List;
import model.FollowersBean;
public interface FollowersDao {
    public boolean addFollower(FollowersBean F);
    public boolean deleteFollower(long followerId, long followingId);
    
    
}

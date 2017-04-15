/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.io.Serializable;

/**
 *
 * @author dorado and algoprentice
 */
public class FollowersBean implements Serializable {
    private long followerId;
    private long followingId;

    public FollowersBean() {
    }

    public FollowersBean(long followerId, long followingId) {
        this.followerId = followerId;
        this.followingId = followingId;
    }

    public long getFollowerId() {
        return followerId;
    }

    public long getFollowingId() {
        return followingId;
    }

    public void setFollowerId(long followerId) {
        this.followerId = followerId;
    }

    public void setFollowingId(long followingId) {
        this.followingId = followingId;
    }
    
}

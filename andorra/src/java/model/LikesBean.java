/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author algoprentice
 */
import java.io.Serializable;

public class LikesBean implements Serializable {
    private long imageId;
    private long userId;

    public LikesBean() {
    }

    public LikesBean(long imageId, long userId) {
        this.imageId = imageId;
        this.userId = userId;
    }

    public long getImageId() {
        return imageId;
    }

    public long getUserId() {
        return userId;
    }

    public void setImageId(long imageId) {
        this.imageId = imageId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    
}

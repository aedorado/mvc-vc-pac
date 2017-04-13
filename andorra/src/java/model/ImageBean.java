/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
/**
 *
 * @author dorado and algoprentice
 */
import java.io.Serializable;
import java.sql.Timestamp;

public class ImageBean implements Serializable {
    private long userId;
    private long imageId;
    private String caption;
    private Timestamp time;
    
    public ImageBean() {
    }

    public ImageBean(long userId, long imageId, String caption, Timestamp time) {
        this.userId = userId;
        this.imageId = imageId;
        this.caption = caption;
        this.time = time;
    }
    
    public long getUserId() {
        return userId;
    }

    public long getImageId() {
        return imageId;
    }

    public String getCaption() {
        return caption;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setImageId(long imageId) {
        this.imageId = imageId;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }
    
    public void setTime(Timestamp time) {
        this.time = time;
    }
}

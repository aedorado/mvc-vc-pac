/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author swapnil
 */
import java.sql.Timestamp;
import java.io.Serializable;
public class CommentsBean implements Serializable {
    private long userId;
    private long imageId;
    private long commentId;
    private String comment;
    private Timestamp time;

    public CommentsBean() {
    }

    public CommentsBean(long userId, long imageId, long commentId, String comment, Timestamp time) {
        this.userId = userId;
        this.imageId = imageId;
        this.commentId = commentId;
        this.comment = comment;
        this.time = time;
    }
    
    
    public long getUserId() {
        return userId;
    }

    public long getImageId() {
        return imageId;
    }

    public long getCommentId() {
        return commentId;
    }

    public String getComment() {
        return comment;
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

    public void setCommentId(long commentId) {
        this.commentId = commentId;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }
    
}

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
import model.LikesBean;
public interface LikesDao {
    //1 if added else 0.
    public boolean addLike(LikesBean L);
    //total number of likes on image.
    public int totalLikes(long imageId);
}

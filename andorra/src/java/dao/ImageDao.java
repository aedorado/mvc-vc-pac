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
import model.ImageBean;

public interface ImageDao {

    //1 if added else 0.
    public boolean addImage(ImageBean I);

    public int countTotalImages();

    public ImageBean getImageByID(long imageId);
    
    public boolean isLikedBy(long imageid, long userid);

}

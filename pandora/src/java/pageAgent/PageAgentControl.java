/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pageAgent;

import dataAgent.DataAgentControl;
import java.util.List;
import model.ImageBean;
import model.UserBean;
/**
 *
 * @author dorado
 */
public class PageAgentControl {

    private DataAgentControl dac;
    
    public PageAgentControl() {
        dac = new DataAgentControl();
    }
    

    public String imageIdToHTML(int i) {
        ImageBean img = dac.getImageById(i);
        UserBean uploader = dac.getUserByID(img.getUserId());
        String placeholder = "";
        placeholder += "<div class='image-div'>";
        placeholder += "<img class='img-rounded img-thumbnail img-responsive my-img' src='uploads/" + i + ".jpg'>";
        placeholder += "<div>" + img.getCaption() + "</div>";
        placeholder += "<div>By: <a href='profile.jsp?user_id=" + img.getUserId() + "'>" + uploader.getUsername() + "</a></div>";
        placeholder += "<div class='interaction-div'>";
////        if (idi.isLikedBy(i, (Long)session.getAttribute("user_id"))) {
////            placeholder += "<img class='like-button' src='img/liked.svg'>";
////        } else {
////            placeholder += "<img class='unlike-button' src='img/unliked.svg'>";
////        }
        placeholder += "</div>";
        placeholder += "</div><br>";
        return placeholder;
    }

    public String getHomepageImageHTML(long userId) {
        List<Integer> imgIdList = dac.listImagesPostedByFollowing(userId);
        String html = "";
        for (Integer img: imgIdList) {
            html += imageIdToHTML(img.intValue());
        }
        return html;
    }
    
    public String getProfileImageHTML(long userId) {
        List<Integer> imgIdList = dac.listImagesPosted(userId);
        String html = "";
        for (Integer img: imgIdList) {
            html += imageIdToHTML(img.intValue());
        }
        return html;
    }

    public int getNumImagesPosted(long userId) {
        return dac.getNumImagesPosted(userId);
    }

    public int getTotalFollowers(long userId) {
        return dac.getTotalFollowers(userId);
    }

    public int getTotalFollowing(long userId) {
        return dac.getTotalFollowing(userId);
    }

}

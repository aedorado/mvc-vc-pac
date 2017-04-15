/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package profileAgent;

import pageAgent.PageAgentControl;

/**
 *
 * @author dorado
 */
public class ProfileAgentControl {

    private PageAgentControl pac;

    public ProfileAgentControl() {
        pac = new PageAgentControl();
    }

    public String getProfileImageHTML(long userId) {
        return pac.getProfileImageHTML(userId);
    }

    public int getNumImagesPosted(long userId) {
        return pac.getNumImagesPosted(userId);
    }

    public int getTotalFollowers(long userId) {
        return pac.getTotalFollowers(userId);
    }

    public int getTotalFollowing(long userId) {
        return pac.getTotalFollowing(userId);
    }

}

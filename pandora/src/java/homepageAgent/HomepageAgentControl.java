/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homepageAgent;

import pageAgent.PageAgentControl;

/**
 *
 * @author dorado
 */
public class HomepageAgentControl {

    private PageAgentControl pac;

    public HomepageAgentControl() {
        pac = new PageAgentControl();
    }

    public String getHomepageImageHTML(long userId) {
        return pac.getHomepageImageHTML(userId);
    }
}

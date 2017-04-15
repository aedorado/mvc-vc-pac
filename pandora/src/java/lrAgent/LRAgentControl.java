/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lrAgent;

import dataAgent.DataAgentControl;
import model.UserBean;

/**
 *
 * @author dorado
 */
public class LRAgentControl {

    private DataAgentControl dac;

    public LRAgentControl() {
         dac = new DataAgentControl();
    }
    
    public boolean userExists(String username) {
        return (dac.userExists(username));
    }

    public boolean addUser(UserBean userBean) {
         return (dac.addUser(userBean));
    }

    public boolean correctCredentials(String username, String password) {
        return (dac.correctCredentials(username, password));
    }

    public long getIdFromUsername(String username) {
        return (dac.getIdFromUsername(username));
    }

}

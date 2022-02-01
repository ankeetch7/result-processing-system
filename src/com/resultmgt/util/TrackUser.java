/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resultmgt.util;

import com.resultmgt.controller.UserDAO;
import com.resultmgt.controller.UserRoleDAO;

import com.resultmgt.model.Users;
import com.resultmgt.view.Main;

/**
 *
 * @author AnkeetPC
 */
public class TrackUser {
    
    public void getRoles(Users ob){
        int role_id = ob.getRole_id();
        
        if(role_id==1){
            Main.jMenu_Records.setEnabled(true);
            Main.jMenu2.setEnabled(true);
 
        }else if(role_id==2){
            Main.jMenu_Records.setEnabled(true);
            Main.jMenu2.setEnabled(false);

        }
        
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.digitalmodules;

import java.io.*;

/**
 *
 * @author calin
 */
public class UserLogicStubModule extends DigitalModule{
    
    void User_Logic() throws FileNotFoundException{
        File dir=new File("HDL");
        dir.mkdir();
        File user_logic=new File("HDL/user_logic.v");
        FileOutputStream fos=new FileOutputStream(user_logic);
        
        
    }
    
}

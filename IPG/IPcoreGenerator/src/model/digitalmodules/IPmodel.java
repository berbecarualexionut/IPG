/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.digitalmodules;

import java.util.ArrayList;

/**
 *
 * @author calin
 */
public class IPmodel {

    String mIP_name;
    boolean mIP_interrupt_signal;
    
    ArrayList <DigitalModule> modules;
    public IPmodel(String name, boolean IP_interrupt_signal) {
        mIP_name = name;
        mIP_interrupt_signal = IP_interrupt_signal;
        modules = new ArrayList();
    }

    public void add(DigitalModule module) {
        modules.add(module);
    }
    
    @Override
    public String toString() {
        String ret = "IPmodel named " + mIP_name + "\n";
        ret += " with" + ((mIP_interrupt_signal == true) ? "" : "out") + " interrupt signal \n";
        ret += " with following modules: " + "\n";
        for (DigitalModule module : modules) {
            ret += module.toString() + "\n";
        }
        
        return ret;
    }
}

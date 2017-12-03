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
    public boolean lite;
    public int in_streams;
    public int out_streams;
   public static ArrayList <Axi4StreamAdaptModule> axi4in;
    ArrayList <DigitalModule> modules;
    public static ArrayList <Axi4StreamAdaptModule> axi4out;
    public IPmodel(String name, boolean IP_interrupt_signal,boolean c,int a,int b) {
        mIP_name = name;
        mIP_interrupt_signal = IP_interrupt_signal;
        axi4in=new ArrayList<Axi4StreamAdaptModule>();
        axi4out=new ArrayList<Axi4StreamAdaptModule>();
        modules = new ArrayList();
        in_streams=a;
        out_streams=b;
        lite=c;
    }

    public void add(DigitalModule module) {
        modules.add(module);
    }
    
    public void addNewAdaptModuleIn(Axi4StreamAdaptModule e){
        axi4in.add(e);
    }
    
    public void addNewAdaptModuleOut(Axi4StreamAdaptModule e){
        axi4out.add(e);
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
    
    public int get_in(){
        return in_streams;
    }
    
    public int get_out(){
        return out_streams;
    }
}

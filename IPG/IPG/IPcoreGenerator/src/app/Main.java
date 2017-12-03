/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import model.digitalmodules.Axi4LiteModule;
import model.digitalmodules.Axi4StreamAdaptModuleIn;
import model.digitalmodules.Axi4StreamAdaptModuleOut;
import model.digitalmodules.IPmodel;

/**
 *
 * @author calin
 */
public class Main {
        public static void main(String[] _args) {
        
            //App app = new App("IpCoreGenerator");
            //System.out.println(app);
            
            IPmodel IP = new IPmodel("XeonIPcore", false,true,3,2);
            IP.add(new Axi4LiteModule(16, 17,true));
            IP.add(new Axi4StreamAdaptModuleIn(0, 1, 2, 3));
            IP.add(new Axi4StreamAdaptModuleIn(1, 4, 5, 6));
            IP.add(new Axi4StreamAdaptModuleIn(2, 7, 8, 9));

            IP.add(new Axi4StreamAdaptModuleOut(0, 1, 2, 3));
            IP.add(new Axi4StreamAdaptModuleOut(1, 4, 5, 6));
            
            System.out.println(IP);
        }
}

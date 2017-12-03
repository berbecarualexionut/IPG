/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelGenerator;

import gui.modules.Axi4BaseGuiModule;
import gui.modules.Axi4LiteGuiModule;
import gui.modules.Axi4StreamAdaptGuiModule;
import gui.modules.Axi4StreamAdaptGuiModuleIn;
import gui.modules.Axi4StreamAdaptGuiModuleOut;
import gui.modules.GUImodel;
import model.digitalmodules.Axi4LiteModule;
import model.digitalmodules.Axi4StreamAdaptModuleIn;
import model.digitalmodules.Axi4StreamAdaptModuleOut;
import model.digitalmodules.IPmodel;

/**
 *
 * @author calin
 */
public class ModelGenerator {
    
    GUImodel mGuiModel;
    
    public ModelGenerator(GUImodel GuiModel) {
        mGuiModel = GuiModel;
    }
    
    public IPmodel regenerateModel() {
        IPmodel IP = new IPmodel("demo", false,true,5,5);
        for (Axi4BaseGuiModule module : mGuiModel.getAxi4s()) {
            if (module instanceof Axi4LiteGuiModule) {
                Axi4LiteGuiModule m = (Axi4LiteGuiModule)module;
                IP.add(new Axi4LiteModule(m.getAddrWidth(), m.getDataWidth(),true));
            }
            else if (module instanceof Axi4StreamAdaptGuiModuleIn) {
                Axi4StreamAdaptGuiModule m = (Axi4StreamAdaptGuiModule)module;
                IP.add(new Axi4StreamAdaptModuleIn(m.getIndex(), m.getDepthLog(), m.getTdataSize(), m.getTuserSize()));
            }
            else if (module instanceof Axi4StreamAdaptGuiModuleOut) {
                Axi4StreamAdaptGuiModule m = (Axi4StreamAdaptGuiModule)module;
                IP.add(new Axi4StreamAdaptModuleOut(m.getIndex(), m.getDepthLog(), m.getTdataSize(), m.getTuserSize()));
            }
        }
        
        return IP;
    }
}

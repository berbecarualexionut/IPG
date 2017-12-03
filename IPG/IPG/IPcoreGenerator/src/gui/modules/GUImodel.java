/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.modules;

import java.util.ArrayList;
import javax.swing.text.JTextComponent;

/**
 *
 * @author calin
 */
public class GUImodel {
    
    static GUImodel sInstance;
    
    static int mAxi4StreamAdaptInIndex;
    static int mAxi4StreamAdaptOutIndex;
    
    ArrayList<Axi4BaseGuiModule> Axi4s;
    
    // prevent user from getting multiple objects: singleton design pattern
    private GUImodel() {
        Axi4s = new ArrayList();
    }
    
    public GUImodel getInstance() {
        if (sInstance == null)
            sInstance = new GUImodel();
        
        return sInstance;
    }
    
    public void addAxi4Lite(JTextComponent textfieldAddrWidth, 
                            JTextComponent textfieldDataWidth) {
        
        getInstance().Axi4s.add(new Axi4LiteGuiModule(textfieldAddrWidth, textfieldDataWidth));
    }
    
    public void addAxi4StreamAdaptIn(JTextComponent textfieldDepthLog, 
                            JTextComponent textfieldTdataSize, 
                            JTextComponent textfieldTuserSize) {
        
        getInstance().Axi4s.add(new Axi4StreamAdaptGuiModuleIn(mAxi4StreamAdaptInIndex++, textfieldDepthLog, textfieldTdataSize, textfieldTuserSize));
    }

    public void addAxi4StreamAdaptOut(JTextComponent textfieldDepthLog, 
                            JTextComponent textfieldTdataSize, 
                            JTextComponent textfieldTuserSize) {
        
        getInstance().Axi4s.add(new Axi4StreamAdaptGuiModuleIn(mAxi4StreamAdaptOutIndex++, textfieldDepthLog, textfieldTdataSize, textfieldTuserSize));
    }
    
    public ArrayList<Axi4BaseGuiModule> getAxi4s() {
        return Axi4s;
    }
}

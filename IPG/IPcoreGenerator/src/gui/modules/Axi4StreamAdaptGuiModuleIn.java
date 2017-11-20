/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.modules;

import javax.swing.text.JTextComponent;

/**
 *
 * @author calin
 */
public class Axi4StreamAdaptGuiModuleIn extends Axi4StreamAdaptGuiModule{
    
    public Axi4StreamAdaptGuiModuleIn(int index, JTextComponent textfieldDepthLog, JTextComponent textfieldTdataSize, JTextComponent textfieldTuserSize) {
        super(index, textfieldDepthLog, textfieldTdataSize, textfieldTuserSize);
        isOutput = false;
    }
}

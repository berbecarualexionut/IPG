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
public abstract class Axi4StreamAdaptGuiModule extends Axi4BaseGuiModule{

    boolean isOutput;
    JTextComponent mTextfieldDepthLog;
    JTextComponent mTextfieldTdataSize;
    JTextComponent mTextfieldTuserSize;

    public Axi4StreamAdaptGuiModule(
                    int index,
                    JTextComponent textfieldDepthLog, 
                    JTextComponent textfieldTdataSize, 
                    JTextComponent textfieldTuserSize) {
        
        mIndex = index;
        mTextfieldDepthLog = textfieldDepthLog;
        mTextfieldTdataSize = textfieldTdataSize;
        mTextfieldTuserSize = textfieldTuserSize;
    }
    
    public int getDepthLog() {
        return Integer.parseInt(mTextfieldDepthLog.getText());
    }
    
    public int getTdataSize() {
        return Integer.parseInt(mTextfieldTdataSize.getText());
    }

    public int getTuserSize() {
        return Integer.parseInt(mTextfieldTuserSize.getText());
    }
}

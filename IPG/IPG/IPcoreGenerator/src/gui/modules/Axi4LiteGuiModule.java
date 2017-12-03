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
public class Axi4LiteGuiModule extends Axi4BaseGuiModule {

    JTextComponent mTextfieldAddrWidth;
    JTextComponent mTextfieldDataWidth;

    public Axi4LiteGuiModule(
                    JTextComponent textfieldAddrWidth, 
                    JTextComponent textfieldDataWidth) {
        
        mIndex = 0;
        mTextfieldAddrWidth = textfieldAddrWidth;
        mTextfieldDataWidth = textfieldDataWidth;
    }
    
    public int getAddrWidth() {
        return Integer.parseInt(mTextfieldAddrWidth.getText());
    }
    
    public int getDataWidth() {
        return Integer.parseInt(mTextfieldDataWidth.getText());
    }
}

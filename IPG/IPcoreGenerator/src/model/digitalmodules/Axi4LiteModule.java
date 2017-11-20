/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.digitalmodules;

/**
 *
 * @author calin
 */
public class Axi4LiteModule extends DigitalModule{
    int mADDR_WIDTH;
    int mDATA_WIDTH;
    
    public Axi4LiteModule(int ADDR_WIDTH, int DATA_WIDTH) {
        try{
        mIndex = 0;
        mADDR_WIDTH = ADDR_WIDTH;
        if(mADDR_WIDTH<0 && mADDR_WIDTH>32){
            throw new Exception("Parameter out of bounds");
        }
        mDATA_WIDTH = DATA_WIDTH;
        if(mDATA_WIDTH<32 && mDATA_WIDTH>64){
            throw new Exception("Parameter out of bounds");
        }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
    @Override
    public String toString() {
        return "AXI_LITE_" + mIndex + " with ADDR_WIDTH = " + mADDR_WIDTH + ", "
                + "with DATA_WIDTH = " + mDATA_WIDTH;
    }     
}

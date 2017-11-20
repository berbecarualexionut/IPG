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
public abstract class Axi4StreamAdaptModule extends DigitalModule {

    private int mDepthLog;
    private int mTdataSize; 
    private int mTuserSize;
    protected boolean isOutput; // true output, false for input
    
    public Axi4StreamAdaptModule(int Index, 
                                int DepthLog, 
                                int TdataSize, 
                                int TuserSize) {
        
        try{
        mIndex = Index;
        mDepthLog = DepthLog;
        if(mDepthLog<0 && mDepthLog>10){
            throw new Exception("Parameter out of bounds");
        }
        mTdataSize = TdataSize;
        if(mTdataSize<0){
            throw new Exception("Parameter out of bounds");
        }
        mTuserSize = TuserSize;
        if (mTuserSize<0){
            throw new Exception("Parameter out of bounds");
        }
        
        }
        catch(Exception e){
            System.out.println(e);
        }
        
    }
    
    @Override
    public String toString() {
        return "AXI_STREAM_" + mIndex + " with DepthLog = " + mDepthLog + ", "
                + "with TdataSize = " + mTdataSize + ", "
                + "with TuserSize = " + mTuserSize;
    }    
}

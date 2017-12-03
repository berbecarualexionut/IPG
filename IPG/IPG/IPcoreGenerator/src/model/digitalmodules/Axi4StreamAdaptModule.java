/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.digitalmodules;

import java.io.*;

/**
 *
 * @author calin
 */
public class Axi4StreamAdaptModule extends DigitalModule {

    private int mDepthLog;
    int mTdataSize; 
    int mTuserSize;
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
    
    
    public static void main(String[] args) throws FileNotFoundException, IOException{
        int number;//assign the number of axis4streams 
        File f=new File("HDL/axis_async_fifo.v");
        FileOutputStream fos=new FileOutputStream(f);
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(fos));
        bw.write("module axis_async_fifo");
        bw.write("#(");
        Axi4StreamAdaptModule axi=new Axi4StreamAdaptModule(1,10,16,2);
        bw.write("parameter DEPTH_LOG=" +axi.mDepthLog+",");
        bw.write("parameter TDATA_SIZE=" +axi.mTdataSize+",");
        bw.write("parameter TUSER_SIZE="+axi.mTuserSize);
        bw.write(")");
        bw.write("(");
        bw.write("input aresetn,");
        bw.write("/*AXI Stream input Interface*/");
        bw.write("input s_axis_aclk,");
        bw.write("input[TDATA_SIZE-1:0] s_axis_tdata,");
        bw.write("input  s_axis_tvalid,");
        bw.write("output s_axis_tvready,");
        bw.write("input  s_axis_tlast,");
        bw.write("input [TUSER_SIZE-1:0 s_axis_tuser,");
        bw.write("/*AXI Stream output Interface*/");
        bw.write("input                    m_axis_aclk,");
        bw.write("output [TDATA_SIZE-1:0]  m_axis_tdata,");
        bw.write("output                  m_axis_tvalid,");
        bw.write("input                    m_axis_tready,");
        bw.write("output                  m_axis_tlast,");
        bw.write("output [TUSER_SIZE-1:0]  m_axis_tuser");
        bw.write("),");
        
        
    }
    
    
}

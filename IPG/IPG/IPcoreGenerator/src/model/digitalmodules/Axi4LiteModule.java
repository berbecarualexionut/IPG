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
public class Axi4LiteModule extends DigitalModule{
    static int mADDR_WIDTH;
    static int mDATA_WIDTH;
    static boolean exist;
    
    public Axi4LiteModule(int ADDR_WIDTH, int DATA_WIDTH,boolean exi) {
        try{
        mIndex = 0;
        mADDR_WIDTH = ADDR_WIDTH;
        if(mADDR_WIDTH<0 && mADDR_WIDTH>32){
            throw new Exception("Parameter out of bounds");
        }
        mDATA_WIDTH = DATA_WIDTH;
        if(mDATA_WIDTH!=32 || mDATA_WIDTH!=64){
            throw new Exception("Parameter out of bounds");
        }
        }
        catch(Exception e){
            System.out.println(e);
        }
        exist=exi;
    }
    
    @Override
    public String toString() {
        return "AXI_LITE_" + mIndex + " with ADDR_WIDTH = " + mADDR_WIDTH + ", "
                + "with DATA_WIDTH = " + mDATA_WIDTH;
    }     
    
    
    public static int  getADDR(){
        return mADDR_WIDTH;
    }
    
    public static int getDATA(){
        return mDATA_WIDTH;
    }

    public static void main(String[] args) throws FileNotFoundException, IOException{
        Axi4LiteModule lite=new Axi4LiteModule(32,32,true);
        File f=new File("HDL/axi4lite_slave.v");
        FileOutputStream fos=new FileOutputStream(f);
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(fos));
        bw.write("module axi4lite_slave");
        bw.write("#(");
        bw.write("parameter ADDR_WIDTH ="+mADDR_WIDTH+",");
        bw.write("parameter DATA_WIDTH ="+mDATA_WIDTH);
        bw.write(")");
        bw.write("(");
        bw.write("input axi4l_aclk,");
        bw.write("input axi4l_aresetn,");
        bw.write("output reg                  axi4l_awready,");
        bw.write("input                       axi4l_awvalid,");
        bw.write("input [ADDR_WIDTH-1:0]      axi4l_awaddr,");
        bw.write("input [2:0]                 axi4l_awprot,");
        bw.write("output reg                  axi4l_wready,"); 
        bw.write("input                       axi4l_wvalid,");
        bw.write("input [DATA_WIDTH-1:0]      axi4l_wdata,");           
        bw.write("input [(DATA_WIDTH/8)-1:0]  axi4l_wstrb,");
        bw.write("input                       axi4l_bready,");
        bw.write("output reg                  axi4l_bvalid,");
        bw.write("output reg [1:0]            axi4l_bresp,");
        bw.write("output reg                  axi4l_arready,"); 
        bw.write("input                       axi4l_arvalid,"); 
        bw.write("input [ADDR_WIDTH-1:0]      axi4l_araddr,");
        bw.write("input [2:0]                 axi4l_arprot,");
        bw.write("input                       axi4l_rready,");
        bw.write("output reg                  axi4l_rvalid,");
        bw.write("output reg [1:0]            axi4l_rresp,");
        bw.write("output reg [DATA_WIDTH-1:0] axi4l_rdata,");
        bw.write("//User Logic Interface");
        bw.write("input                       ip_clk,");
        bw.write("output                      ip_ren,");
        bw.write("output                      ip_wen,");
        bw.write("output [ADDR_WIDTH-1:0]     ip_addr,");
        bw.write("output [(DATA_WIDTH/8)-1:0] ip_wstrb,");
        bw.write("output [DATA_WIDTH-1:0]     ip_wdata,");
        bw.write("input                       ip_wack,");
        bw.write("input                       ip_rack,");
        bw.write("input [DATA_WIDTH-1:0]      ip_rdata,");
        bw.write("input                       ip_error");
        bw.write(");");
        
    
    
    
    }
    

}

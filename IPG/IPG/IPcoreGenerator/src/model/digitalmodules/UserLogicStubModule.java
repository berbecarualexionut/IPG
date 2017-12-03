/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.digitalmodules;

import java.io.*;
import java.util.ArrayList;
import static model.digitalmodules.Axi4LiteModule.getADDR;
import static model.digitalmodules.Axi4LiteModule.getDATA;
import static model.digitalmodules.IPmodel.axi4in;
import static model.digitalmodules.IPmodel.axi4out;




/**
 *
 * @author calin
 */
public class UserLogicStubModule extends DigitalModule{
  
    
    
    public static void main(String[] args) throws FileNotFoundException, IOException{
        File dir=new File("HDL");
        dir.mkdir();
        IPmodel ip=new IPmodel("Model",false,true,2,1);
        File user_logic=new File("HDL/user_logic.v");
        FileOutputStream fos=new FileOutputStream(user_logic);
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(fos));
        bw.write("module user_logic");
        bw.write("#(");
        if(ip.lite==true){
        bw.write("parameter AXI4L_ADDR_WIDTH =" +getDATA());
        bw.write("parameter AXI4L_DATA_WIDTH = " +getADDR());
        }
        for(Axi4StreamAdaptModule axi:axi4in){
            if(axi.isOutput==false){
                bw.write("parameter S_AXIS_"+ axi.getIndex()+1 +"_TDATA_SIZE = "+axi.mTdataSize);
                bw.write("parameter S_AXIS_"+axi.getIndex()+1+"_TUSER_SIZE = "+axi.mTuserSize);
                
            }
        }
        for(Axi4StreamAdaptModule axi:axi4out){
            if(axi.isOutput==true){
                bw.write("parameter M_AXIS_"+axi.getIndex()+1+"_TDATA_SIZE= "+axi.mTdataSize);
                bw.write("parameter M_AXIS_"+axi.getIndex()+1+"_TUSER_SIZE= "+axi.mTuserSize);
            }
        }
        bw.write(")");
        bw.write("(");
        bw.write("input user_clk,");
        bw.write("output user_irq,");
        bw.write("");
        
        if(ip.lite==true){
        File axilite=new File("HDL/axi4lite_slave.v");
        FileInputStream fis=new FileInputStream(axilite);
        BufferedReader br=new BufferedReader(new InputStreamReader(fis));
        while(br.readLine().equals("//User Logic Interface")==false);
        {br.readLine();
                }
        while(br.readLine().equals(");")==false){
            String temp=br.readLine();
            if(temp.startsWith("input")){
                temp.replace("input","output");
                bw.write(temp);
            }
            else{
                temp.replace("output","input");
                bw.write(temp);
                
            }
        }
        }
           for(Axi4StreamAdaptModule axi:axi4in){
               bw.write("output s_axis_"+axi.getIndex()+1 +"s_axis_"+axi.getIndex()+1+"_tdata,");
               bw.write("input[S_AXIS_"+axi.getIndex()+1+"_TDATA_SIZE-1:0] s_axis_"+axi.getIndex()+1+"_tdata,");
               bw.write("input s_axis_"+axi.getIndex()+1+"_tvalid,");
               bw.write("output s_axis_"+axi.getIndex()+1+"_tvready,");
               bw.write("input s_axis_"+axi.getIndex()+1+"_tlast,");
               bw.write("input[S_AXIS_"+axi.getIndex()+1+"_TUSER_SIZE-1:0] s_axis_"+axi.getIndex()+1+"_tuser,");
               bw.write("");
           }
           
           for(Axi4StreamAdaptModule axi:axi4out){
                bw.write("output m_axis_"+axi.getIndex()+1 +"m_axis_"+axi.getIndex()+1+"_tdata,");
               bw.write("output[M_AXIS_"+axi.getIndex()+1+"_TDATA_SIZE-1:0] m_axis_"+axi.getIndex()+1+"_tdata,");
               bw.write("output m_axis_"+axi.getIndex()+1+"_tvalid,");
               bw.write("input m_axis_"+axi.getIndex()+1+"_tvready,");
               bw.write("output m_axis_"+axi.getIndex()+1+"_tlast,");
               bw.write("output[M_AXIS_"+axi.getIndex()+1+"_TUSER_SIZE-1:0] m_axis_"+axi.getIndex()+1+"_tuser,");
           }
          
           
           bw.write(");");
           bw.write("");
           bw.write("assign ip_clk=user_clk;");
           for(int i=0;i<axi4in.size();i++){
           bw.write("assing s_axis_"+i+1+"_aclk=user_clk;");}
           for(int i=0;i<axi4out.size();i++){
               bw.write("assign m_axis_"+i+1+"aclk=user_clk");
           }
           bw.write("");
           bw.write("endmodule");
           
           
           
           
           
           
           
           
            
        }
    }
    


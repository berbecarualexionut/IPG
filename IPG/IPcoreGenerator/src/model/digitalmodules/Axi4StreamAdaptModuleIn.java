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
public class Axi4StreamAdaptModuleIn extends Axi4StreamAdaptModule{
    
    public Axi4StreamAdaptModuleIn(int Index, int DepthLog, int TdataSize, int TuserSize) {
        super(Index, DepthLog, TdataSize, TuserSize);
        isOutput = false;
    }
   
    @Override
    public String toString() {
        return "AxiIn:  " + super.toString();
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculator.controller;

/**
 *
 * @author User
 */
import calculator.controller.utils.Response;
import calculator.controller.utils.Status;
import calculator.model.Operation;
import calculator.model.storage.History;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.DefaultListModel;

public class HistoryController {

    public static Response getHistory() {

        try{
        //Fetch History singleton
        History hist = History.getInstance();
        
        //Fetch data stored inside History
        ArrayList<Operation> operationHist = hist.getOperations();
        
        //Validate if its empty
        if(operationHist.isEmpty()){
            return new Response("Empty operation history.", Status.NOT_FOUND);
        }
        
        //Apply format 
        ArrayList<String> operationStrings = new ArrayList<>();
        DecimalFormat formatter = new DecimalFormat(".###");
        for(Operation op : operationHist){
            String[] rawString = String.valueOf(op).split(" = ");
            String opString = rawString[0] + " = " + formatter.format(Float.parseFloat(rawString[1])).replaceAll(",", ".");
            operationStrings.add(opString);
        }
        
        //Instance Model that is to be displayed in the View
        Collections.reverse(operationStrings);
        DefaultListModel operationModel = new DefaultListModel();
        operationModel.addAll(operationStrings);
        return new Response("History found.", Status.OK, operationModel);
        
        } catch(Exception ex){
            ex.printStackTrace();
            return new Response("Unexpected error!", Status.INTERNAL_SERVER_ERROR);
        }
        
    }

}

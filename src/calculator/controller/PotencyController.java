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
import calculator.model.Add;
import calculator.model.Operation;
import calculator.model.Potency;
import calculator.model.storage.History;
import java.text.DecimalFormat;

public class PotencyController {

    public static Response createOperation(String jTextField1, String jTextField2) {
        DecimalFormat formatter = new DecimalFormat(".###");

        try {
        double number1, number2;

            // Validación de entrada
            if (jTextField1.isEmpty()) {
                return new Response("NUMBER 1 CAN NOT BE EMPTY", Status.BAD_REQUEST);
            }

            if (jTextField2.isEmpty()) {
                return new Response("NUMBER 2 CAN NOT BE EMPTY", Status.BAD_REQUEST);
            }

            try {
                number1 = Double.parseDouble(jTextField1);
            } catch (NumberFormatException e) {
                return new Response("NUMBER 1 CAN BE  NUMERIC", Status.BAD_REQUEST);
            }

            try {
                number2 = Double.parseDouble(jTextField2);
            } catch (NumberFormatException e) {
                return new Response("NUMBER 2 CAN BE  NUMERIC", Status.BAD_REQUEST);
            }

            History history = History.getInstance();
            Operation op = new Potency(number1, number2);
            String result = formatter.format(op.getResult());
            
            history.addOperation(op);
            
            return new Response("Operated Succesfully", Status.OK, result.replace(",","."));

        } catch (Exception e) {
            return new Response("Unexpected error", Status.INTERNAL_SERVER_ERROR);
        }
    }
}


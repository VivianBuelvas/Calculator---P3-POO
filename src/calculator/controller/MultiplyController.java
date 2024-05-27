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
import calculator.model.Multiply;
import calculator.model.Operation;
import calculator.model.storage.History;
import java.text.DecimalFormat;

public class MultiplyController {
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

            if (!isValidDecimalPlaces(jTextField1) || !isValidDecimalPlaces(jTextField2)) {
                return new Response("Numbers can be up to 3 decimal places", Status.BAD_REQUEST);
            }

            History history = History.getInstance();
            Operation op = new Multiply(number1, number2);
            String result = formatter.format(op.getResult());

            history.addOperation(op);
            

            // Devolver respuesta exitosa con el resultado
            return new Response("Operated Successfully", Status.OK, result.replace(",", "."));

        } catch (Exception e) {
            e.printStackTrace();
            return new Response("Unexpected error", Status.INTERNAL_SERVER_ERROR);
        }
    }

    private static boolean isValidDecimalPlaces(String number) {
        String[] parts = number.split("\\.");
        return parts.length <= 1 || parts[1].length() <= 3;
    }
}

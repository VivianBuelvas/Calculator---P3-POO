/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculator.Main;

import calculator.view.CalculatorFrame;

/**
 *
 * @author User
 */
public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // Instancia y muestrar la ventana de la calculadora
                CalculatorFrame calculatorFrame = new CalculatorFrame();
                calculatorFrame.setVisible(true);
            }
        });
    }
}

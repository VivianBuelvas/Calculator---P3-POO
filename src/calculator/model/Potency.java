/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculator.model;

/**
 *
 * @author User
 */
public class Potency extends Operation{

    public Potency(double number1, double number2) {
        super(number1, number2, "^");
    }

    @Override
    public double operate() {
        return Math.pow(this.number1, this.number2);
    }
}

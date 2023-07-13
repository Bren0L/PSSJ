package org.example.desafio_quatro;

import javax.swing.JOptionPane;
import java.awt.HeadlessException;

public class Desafio4 {
    private static String text;
    private static String left;
    private static String right;
    public static void main(String[] args) {
        getText();
        splitIntoRightAndLeft(); //sets the first half of the text to the left and the second to the right
        right = reverseString(right);
        left = reverseString(left);

        printText(left+right);
    }

    private static void printText(String s) {
        System.out.println(s);
    }

    private static String reverseString(String text) {
        return new StringBuilder(text).reverse().toString();
    }

    private static void splitIntoRightAndLeft() {
        left = text.substring(0, text.length()/2);
        right = text.substring(text.length()/2);
    }

    private static void getText() {
        try{
            text = JOptionPane.showInputDialog("Insira o texto");
        }catch (HeadlessException e){
            System.err.println(e.getMessage());
        }

        if(text == null)
            System.exit(0);
    }
}

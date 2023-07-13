package org.example.desafio_um;

import javax.swing.JOptionPane;
import java.awt.HeadlessException;
import java.util.*;

public class Desafio1 {
    private static final List<Integer> numbers = new ArrayList<>();
    private static final List<Integer> even = new ArrayList<>();
    private static final List<Integer> odd = new ArrayList<>();

    public static void main(String[] args) {
        insertNumbers(getAndVerifyNumberQuantity());
        separateIntoEvenOdd(); //separates numbers array into even and odd
        sortEven();
        reverseSortOdd();
        printEven();
        printOdd();

    }

    private static void printOdd() {
        System.out.println("\n\nNúmeros ímpares:");
        for(int n : odd)
            System.out.println(n);
    }

    private static void printEven() {
        System.out.println("Números pares:");
        for(int n : even)
            System.out.println(n);
    }

    private static void reverseSortOdd() {
        Collections.sort(odd);
        Collections.reverse(odd);
    }

    private static void sortEven() {
        Collections.sort(even);
    }

    private static void insertNumbers(int loop) {
        while(loop != 0) {
            try{
                String n = JOptionPane.showInputDialog("Insira um número:");

                if(n == null)
                    System.exit(0);

                numbers.add(Integer.parseInt(n));

                loop--;

            }catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null, "O número inserido deve ser um inteiro positivo menor ou igual á " + Integer.MAX_VALUE);
            }
        }
    }

    private static void separateIntoEvenOdd() {
        for(int n : numbers){
            if(n%2 == 0)
                even.add(n);
            else
                odd.add(n);
        }
    }

    //gets user quantity and verify if it´s value is right
    private static int getAndVerifyNumberQuantity() {
        int numberQuantity;

        while(true){
            try{
                String n = JOptionPane.showInputDialog("Insira quantos números serão inseridos:");
                if(n == null)
                    System.exit(0);

                numberQuantity = Integer.parseInt(n);

                if(numberQuantity > 1 && numberQuantity <= 100000)
                    break;

            }catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null, "O número inserido deve ser inteiro, acima de 1 e menor ou igual a 100000.");
            }catch (HeadlessException e){
                System.err.println(e.getMessage());
                System.exit(0);
            }
        }


        return numberQuantity;
    }
}
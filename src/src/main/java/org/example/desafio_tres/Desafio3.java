package org.example.desafio_tres;

import javax.swing.JOptionPane;
import java.awt.HeadlessException;

public class Desafio3 {
    static int target;
    static int size = 0;
    static int[] arr;
    private static int targetPairs;
    public static void main(String[] args) {
        getTargetValue();
        getArraySize();
        initializeArray();
        insertNumbers();
        countTargetPairs();
        printTargetPairsValue(targetPairs);

    }

    private static void printTargetPairsValue(int qnt) {
        System.out.println("O número de pares entre os elementos do array onde a sua diferença seja igual ao valor alvo é: " + qnt);
    }

    private static void countTargetPairs() {
        for(int x : arr){
            for(int y : arr){
                if(x - y == target)
                    targetPairs++;
            }
        }
    }

    private static void insertNumbers() {
        String n;
        for(int i = 0; i < arr.length;){
            n = JOptionPane.showInputDialog("Insira um número:");

            try{
                arr[i] = Integer.parseInt(n);

                i++;
            }catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Formato errado. Tente novamente");
            }
        }
    }

    private static void initializeArray() {
        arr = new int[size];
    }

    private static void getArraySize() {
        String s;
        while (true){
            try{
                s = JOptionPane.showInputDialog("Insira o tamanho do array");
                if(s == null)
                    System.exit(0);

                size = Integer.parseInt(s);

                break;
            }catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Formato errado. Tente novamente");
            }
        }
    }

    private static void getTargetValue() {
        String t;
        while (true){
            try{
                t = JOptionPane.showInputDialog("Insira o número alvo:");
                if(t == null)
                    System.exit(0);

                target = Integer.parseInt(t);
                break;
            }catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Formato errado. Tente novamente");
            }catch (HeadlessException e){
                System.err.println(e.getMessage());
                System.exit(0);
            }
        }
    }
}

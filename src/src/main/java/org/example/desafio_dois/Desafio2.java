package org.example.desafio_dois;

import javax.swing.JOptionPane;
import java.awt.HeadlessException;

public class Desafio2 {
    private static float value;
    private static final float[] NOTES_AND_COINS = {100, 50, 20, 10, 5, 2, 1, .5F, .25F, .1F, .05F, .01F}; //it´s important to put in order
    private static final int NOTE_TYPES_QUANTITY = 6; //just to discern coins from notes
    private static final int NOTES_AND_COINS_QUANTITY = NOTES_AND_COINS.length; //useful for loops
    private static final int[] decomposedNotesAndCoins = new int[NOTES_AND_COINS_QUANTITY]; //stores each note and coin quantity from decomposed value
    public static void main(String[] args) {
        getAndVerifyValue();
        decomposeIntoNotesAndCoins();

    }

    private static void decomposeIntoNotesAndCoins() {
        for(int i = 0; i < NOTES_AND_COINS_QUANTITY; i++){
            divideAndRound(i);
        }

        printNotesAndCoins();
    }

    private static void printNotesAndCoins() {
        for(int i = 0; i < NOTES_AND_COINS_QUANTITY; i++){
            if(i >= NOTE_TYPES_QUANTITY){
                System.out.printf("Moedas de R$ %.2f:\n", NOTES_AND_COINS[i]);
                System.out.println(decomposedNotesAndCoins[i]);
            } else{
                System.out.printf("Notas de R$ %.2f:\n", NOTES_AND_COINS[i]);
                System.out.println(decomposedNotesAndCoins[i]);
            }
        }
    }

    //divide the value by the note and rounds the value to 2 decimal
    private static void divideAndRound(int pos) {
        decomposedNotesAndCoins[pos] = (int) ((value*100)/(NOTES_AND_COINS[pos]*100));
        value = (value*100)%(NOTES_AND_COINS[pos]*100)/100;
    }

    //gets user value and verifies if its rightly formatted
    private static void getAndVerifyValue() {

        while (true){
            try{
                String v = JOptionPane.showInputDialog("Insira o valor.");

                if(v == null)
                    System.exit(0);

                value = Float.parseFloat(v);

                if(value*100%1 != 0 || value < 0 || value > 1000000)
                    throw new NumberFormatException();
                else
                    break;


            }catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Formato incorreto. Tente novamente");
            }catch (HeadlessException e){
                System.err.println(e.getMessage());
                System.exit(1);
            }
        }
    }
}

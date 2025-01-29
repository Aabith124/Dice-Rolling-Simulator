package com.abith.dice;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
public class simulator {
    public static void main(String args[]) {
        Scanner in =new Scanner(System.in);
        boolean appCompleted=false;
        do{
        try {
            System.out.println("How many dice you want to roll?");
            int numberOfdice = in.nextInt();
            appCompleted=true;
            System.out.println("About to roll "+ numberOfdice + " dice");
            Random rand = new Random();
            for(int i=0;i<numberOfdice;i++) {
                int rolledNumber = rand.nextInt(6) + 1;
                System.out.println(display(rolledNumber));
            }
        }

            catch(InputMismatchException e){
                System.out.println("enter valid number!");
                in.next();
            }}while(!appCompleted);

    }

    static String display(int value) {
        switch (value) {

            case 1:
                return "---------\n|       |\n|   o   |\n|       |\n---------";
            case 2:
                return "---------\n| o     |\n|       |\n|     o |\n---------";
            case 3:
                return "---------\n| o     |\n|   o   |\n|     o |\n---------";

            case 4:
                return "---------\n| o   o |\n|       |\n| o   o |\n---------";
            case 5:
                return "---------\n| o   o |\n|   o   |\n| o   o |\n---------";
            case 6:
                return "---------\n| o   o |\n| o   o |\n| o   o |\n---------";
            default:
                return "invalid";
        }
    }
}

package pkg.yhan;

import java.util.Scanner;

public class InArgsApp {

    public static void main(String[] args) {
        double goal, payment, interestRate;

        if (args.length >= 3) {
            // Parse command-line arguments
            goal = Double.parseDouble(args[0]);
            payment = Double.parseDouble(args[1]);
            interestRate = Double.parseDouble(args[2]);
        } else {
            // Fallback to interactive input
            Scanner in = new Scanner(System.in);

            System.out.print("How much money do you need to retire? ");
            goal = in.nextDouble();

            System.out.print("How much money will you contribute every year? ");
            payment = in.nextDouble();

            System.out.print("Interest rate in %: ");
            interestRate = in.nextDouble();

            in.close();
        }

        double balance = 0;
        int years = 0;

        while (balance < goal) {
            balance += payment;
            double interest = balance * interestRate / 100;
            balance += interest;
            years++;
        }

        System.out.println("You can retire in " + years + " years.");
    }
}

package Exer3;

import java.util.Locale;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Program4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        List<TaxPayer> list = new ArrayList<>();
        System.out.print("Enter the number of tax payers:");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.print("Tax payer #" + i + " data:");
            sc.nextLine();
            System.out.print("Individual or company (i/c)?");
            char ch = sc.next().charAt(0);
            if (ch == 'i') {
                System.out.print("Name: ");
                String name = sc.nextLine();
                sc.nextLine();
                System.out.print("Anual Income: ");
                double anualIncome = sc.nextDouble();
                System.out.print("Health expenditures:");
                double healthExpenditures = sc.nextDouble();
                list.add(new individual(name, anualIncome, healthExpenditures));
            } else {
                System.out.print("Name: ");
                String name = sc.nextLine();
                sc.nextLine();
                System.out.print("Anual Income: ");
                double anualIncome = sc.nextDouble();
                System.out.print("Number of employees:");
                double numberOfEmployees = sc.nextInt();
                list.add(new company(name, anualIncome, numberOfEmployees));

            }
        }
        double sum = 0.0;
        System.out.println();
        System.out.println("Taxes Paid: ");
        for (TaxPayer tp : list) {
            double tax = tp.tax();
            System.out.println(tp.getName() + ": $" + String.format("%.2f", tax));
            sum += tax;
        }

        System.out.println();
        System.out.println("Total Taxes : $ " + String.format("%.2f", sum));

        sc.close();
    }
}

package application;

import entities.Person;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Person[] vect;

        System.out.print("How many people will be entered into the registry? ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Error: The number you entered is invalid!");
        } else {
            vect = new Person[n];
            for (int i=0; i< vect.length; i++) {
                System.out.println("---------------------------");
                System.out.printf("Data from the %da person:\n", i + 1);
                System.out.print("Name: ");
                sc.nextLine();
                String tName = sc.nextLine();
                System.out.print("Age: ");
                int tAge = sc.nextInt();
                System.out.print("Height: ");
                double tHeight = sc.nextDouble();
                vect[i] = new Person(tName, tAge, tHeight);
            }

            double sumHeight = 0.0;
            int minors = 0;
            for (int i=0; i< vect.length; i++) {
                if (vect[i].getAge() < 16) {
                    minors++;
                }
                sumHeight += vect[i].getHeight();
            }

            double avgHeight = sumHeight / vect.length;
            double percentageOfMinors = ((double)minors / vect.length) * 100;

            System.out.println("---------------------------");
            System.out.printf("Average height: %.2f%n", avgHeight);
            System.out.printf("People under the age of 16: %.1f%n", percentageOfMinors);
            System.out.println("Names of minors:");
            for (int i=0; i< vect.length; i++) {
                if (vect[i].getAge() < 16) {
                    System.out.println(vect[i].getName());
                }
            }
        }

        sc.close();
    }
}

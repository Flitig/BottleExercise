package com.flitig;

import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {

    public static void main(String[] args) {
        boolean run = false;
        int targetVolume = 0;
        int firstBottle = 0;
        int secondBottle = 0;

        int[] input;
        do {
            System.out.println("Please provide three integers: target volume and the capacity of two bottles. Example: 1 5 3 \nInput anything else to quit.");
            Scanner sc = new Scanner(System.in);

            try {
                targetVolume = sc.nextInt();
                firstBottle = sc.nextInt();
                secondBottle = sc.nextInt();
            } catch (InputMismatchException e) {
                exit(0);
            }
            finally {
                sc.close();
            }


            input = new int[]{targetVolume, firstBottle, secondBottle};
            System.out.println(BottleExercise(input));

        } while (run);
    }

    private static String BottleExercise(int[] args) {
        return String.format(Integer.toString(args[0]));
    }
}

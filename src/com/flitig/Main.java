package com.flitig;

import java.util.*;

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


            System.out.println(bottleExercise(targetVolume, firstBottle, secondBottle));

        } while (run);
    }

    private static String bottleExercise(int targetVolume, int firstBottleCapacity, int secondBottleCapacity) {
        // create needed objects
        HashSet<INode> visitedNodes = new HashSet<>();
        Queue<INode> children = new LinkedList<>();
        Stack<INode> currentPath = new Stack<>();

        IBottle firstBottle = new Bottle(firstBottleCapacity, 0);
        IBottle secondBottle = new Bottle(secondBottleCapacity, 0);

        INode root = new Node(firstBottle, secondBottle);

        ISearcher searcher = new Searcher(visitedNodes, children, currentPath);
        INode targetNode = searcher.search(root, targetVolume);

        return String.format(Integer.toString(targetVolume));
    }
}

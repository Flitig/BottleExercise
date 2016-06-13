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
            } finally {
                sc.close();
            }


            System.out.println(bottleExercise(targetVolume, firstBottle, secondBottle));

        } while (run);
    }

    private static String bottleExercise(int targetVolume, int firstBottleCapacity, int secondBottleCapacity) {
        // create needed objects
        HashSet<Integer> visitedNodes = new HashSet<>();
        Queue<INode> children = new LinkedList<>();

        IBottle firstBottle = new Bottle(firstBottleCapacity, 0);
        IBottle secondBottle = new Bottle(secondBottleCapacity, 0);

        INode root = new Node(firstBottle, secondBottle);

        ISearcher searcher = new Searcher();
        INode targetNode = searcher.search(root, targetVolume, visitedNodes, children);

        NodeHelper nodeHelper = new NodeHelper();
        List<Integer> path = nodeHelper.getPath(targetNode);

        return String.format("The shortest path is %d steps. The steps are: %s", 5, "3");
    }
}

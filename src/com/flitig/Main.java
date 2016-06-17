package com.flitig;

import java.util.*;
import java.util.stream.Collectors;

import static java.lang.System.exit;

class Main {

    public static void main(String[] args) {
        boolean run = false;
        int targetVolume = 0;
        int firstBottle = 0;
        int secondBottle = 0;

        // get input and extract data
        do {
            System.out.println("Please provide three integers: target volume and the capacity of two bottles. Example: 1 5 3 \nInput anything else to quit.");

            try (Scanner sc = new Scanner(System.in)) {
                targetVolume = sc.nextInt();
                firstBottle = sc.nextInt();
                secondBottle = sc.nextInt();
            } catch (InputMismatchException e) {
                exit(0);
            }

            bottleExercise(targetVolume, firstBottle, secondBottle).forEach(System.out::println);

        } while (run);
    }

    private static List<String> bottleExercise(int targetVolume, int firstBottleCapacity, int secondBottleCapacity) {

        // create needed objects
        HashSet<Integer> visitedNodes = new HashSet<>();
        Queue<INode> children = new LinkedList<>();

        IBottle firstBottle = new Bottle(firstBottleCapacity, 0);
        IBottle secondBottle = new Bottle(secondBottleCapacity, 0);

        INode root = new Node(firstBottle, secondBottle);
        NodeHelper nodeHelper = new NodeHelper(); // this will extract the steps needed for solution

        ISearcher searcher = new Searcher();

        // perform search which generates a linked list of nodes visited in the shortest solution
        INode targetNode = null;
        try {
            targetNode = searcher.search(root, targetVolume, visitedNodes, children);
        } catch (NoPossiblePathException nppe) {
            System.out.println("No possible path found to target volume with bottle configuration.");
            exit(0);
        }
        catch (NullPointerException npe){
            npe.printStackTrace();
            System.out.println("Null pointer");
            exit(0);
        }

        List<Integer> path = nodeHelper.getPath(targetNode);

        int numberOfSteps = path.size() - 1;


        List<String> message = new LinkedList<>();
        message.add(String.format("The shortest path has %d number of steps. ", numberOfSteps));
        message.add("The steps are: \n");
        message.addAll(path.stream().map(p -> String.format("%d\n", p)).collect(Collectors.toList()));

        return message;
    }
}

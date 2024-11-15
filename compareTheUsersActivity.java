/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecoaware;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


/**
 *
 * @author taifa
 */

public class compareTheUsersActivity {
    private ArrayList<Double> distances;
    private ArrayList<String> users;
    
    
    public compareTheUsersActivity(User user, ArrayList<String[]> data) {
        distances = new ArrayList<>();
        users = new ArrayList<>();
        compareActivity(user, data);
    }

   

   

    private void compareActivity(User user, ArrayList<String[]> data) {
        boolean isInPlace3 = false;
        int place = 0;

        for (String[] record : data) {
            String userEmail = record[0];
            double distance = Double.parseDouble(record[2]);

            int index = users.indexOf(userEmail);
            if (index == -1) {
                users.add(userEmail);
                distances.add(distance);
            } else {
                distances.set(index, distances.get(index) + distance);
            }
        }

        // Sort the users list based on the total distance for each user
        for (int i = 0; i < distances.size() - 1; i++) {
            for (int j = i + 1; j < distances.size(); j++) {
                if (distances.get(j) > distances.get(i)) {
                    double tempDistance = distances.get(i);
                    distances.set(i, distances.get(j));
                    distances.set(j, tempDistance);

                    String tempUser = users.get(i);
                    users.set(i, users.get(j));
                    users.set(j, tempUser);
                }
            }
        }

        System.out.println("Places sorted by total distances:");
        for (int i = 0; i < users.size(); i++) {
            if (i == 3) {
                break;
            }
            String userEmail = users.get(i);
            double distance = distances.get(i);
            System.out.printf((i + 1) + "- %s has a total distance of %.1f\n", userEmail, distance);

            if (user.getEmail().equals(userEmail)) {
                isInPlace3 = true;
                place = i + 1;
            }
        }

        if (isInPlace3) {
            System.out.println("Congratulation, Place " + (place));
            System.out.println("Congratulations on your win! To claim your prize, please press 1 and hit enter to roll the virtual roller.");
            Scanner input = new Scanner(System.in);

            input.next();

            String[] prizes = {"Vox Cinema Ticket", "Dinner for Two at a 5-star Restaurant", "Amazon Gift Card", "Smartwatch", "Wireless Headphones"};

            Random random = new Random();
            int randomIndex = random.nextInt(prizes.length); // generate a random index
            String prize = prizes[randomIndex]; // get the prize at the random index

            System.out.println("You won the following prize: " + prize + "\n\n");

        } else {
            System.out.println("Great effort, but you didn't quite make it to the top! Don't give up though, keep pushing yourself and you'll get there!\n\n");
        }
    }
}
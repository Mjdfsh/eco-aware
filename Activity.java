/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecoaware;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author taifa
 */

class Activity {
    private String ActivityType;
    private double distance;
    Activity (String ActivityType, double distance) {
        this.ActivityType = ActivityType;
        this.distance = distance;
    }

    

    

    
    
    
    
    public String getType() {
        return ActivityType; }
    
    public double getDistance() {
        return distance;}
    
    public double getCarbonEmissions() {
        switch (ActivityType.toLowerCase()) {
            case "walking":
                return distance * 0.0;
            case "biking":
                return distance * 0.01;
            case "driving":
                return distance * 0.4;
            default:
                return 0.0;
        }   
}
  
public  void viewActivities(User user) {
        List<Activity> activities = user.getActivities();
        if (activities.isEmpty()) {
            System.out.println("There is no activities found.");
            return;
        }
        System.out.println("Yur Activities:");
        for (Activity activity : activities) {
            System.out.println(activity.getType() + ": " + activity.getDistance() + " km");
        }
    }


    public  void addActivity(Scanner scanner, User user) {
        System.out.println("Please enter the activity type(Walking , biking , driving)");
        String type = scanner.nextLine();
        System.out.println("Please enter the distance in km:");
        double distance = scanner.nextDouble();
        scanner.nextLine();
        Activity activity = new Activity(type, distance);
        user.addActivity(activity);
        System.out.println("Your Activity successfully added.");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Activity.txt", true))) {
            writer.write(user.getEmail() + "," + type + "," + distance);
            writer.write("\n");
            writer.close();
        } catch (IOException e) {
            System.err.println("Error writing to users file: " + e);
        }


    }    
    
    
    
    
    
}


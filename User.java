/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecoaware;

/**
 *
 * @author taifa
 */



import java.io.*;
import java.util.*;


 class User {
    private String email;
    private String password;
    private List<Activity> activities;
    private static UserDatabase database;
    private static EcoAware ecoaware;
    private static Activity activity;
    
    
    
    public User(String email, String password) {
        this.email = email;
        this.password = password;
        this.activities = new ArrayList<>();
        this.ecoaware=new EcoAware();
    }

    

    public String getEmail() {
        return email; }
    
    public String getPassword() {
        return password; }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void addActivity(Activity activity) {
        activities.add(activity); }
     
    public List<Activity> getActivities() {
        return activities; }
   
    public double getTotalCarbonEmissions() {
        double total = 0.0;
        for (Activity activity : activities) {
            total += activity.getCarbonEmissions(); }
        return total;
    }
    
 /* public  void registerUser(Scanner scanner) {
     
  

     
        System.out.println("Please enter your email:");
        String email = scanner.nextLine();
        User existingUser = database.getUser(email);
        if (existingUser != null) {
            System.out.println("User with email " + email + " already exists. Please try again.");
            return;
        }
        System.out.println("Please enter your password:");
        String password = scanner.nextLine();
        User user = new User(email, password);
        database.addUser(user);
        System.out.println("User with email " + email + " successfully registered.");
    }

    public  void loginUser(Scanner scanner) {
        System.out.println("Please enter your email:");
        String email = scanner.nextLine();
        User user = database.getUser(email);
        if (user == null) {
            System.out.println("User with email " + email + " does not exist. Please try again.");
            return;
        }
        System.out.println("Please enter your password:");
        String password = scanner.nextLine();
        if (!user.getPassword().equals(password)) {
            System.out.println("Incorrect password. Please try again.");
            return;
        }
        while (true) {
            System.out.println("Welcome " + email + "To EcoAwre !");
            System.out.println("1. Add activity");
            System.out.println("2. View activities");
            System.out.println("3. View Your total carbon emissions");
            System.out.println("4. Join Computation with friends");
            System.out.println("5. Edit Profile");
            System.out.println("6. Show activity analysing ");
            System.out.println("7. Logout");

            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                  
                    activity.addActivity(scanner, user);
                    break;
                case 2:
                    activity.viewActivities(user);
                    break;
                case 3:
                   ecoaware.viewTotalCarbonEmissions(user);
                    break;
                case 4:
                   ComptiationFriends comptiationFriends = new ComptiationFriends(user);
                   comptiationFriends.compareTheUsersActivity();
                    break;
                case 5:
                    EditProfile editProfile = new EditProfile(user);
                    editProfile.chooseEdit();
                    break;
                    
                case 6:
                    ActivityAnalyzer analyzer = new ActivityAnalyzer();
                    analyzer.printAnalysis();
                    
                    break;
                    
                case 7:
                     System.out.println("Logged out.");
                    return;
                  
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }    
    */
    
    
    
    


}
package model;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       
        System.out.print("Enter user ID: ");
        int userID = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        User user = new User(userID, username);

       
        System.out.print("Enter website URL to monitor: ");
        String url = scanner.nextLine();

        System.out.print("Enter subscription preferences (Immediate, Daily): ");
        String preferences = scanner.nextLine();

        Website website = new Website(url);
        user.registerForUpdates(website, preferences);

        
        CommunicationChannel channel = new CommunicationChannel("Email");

        System.out.println("Starting website monitoring...");
        while (true) {
            website.checkForUpdates();
            System.out.print("Type 'exit' to stop monitoring: ");
            String input = scanner.nextLine();
            if (input.equals("exit")) {
                break;
            }
            try {
                Thread.sleep(10000); 
            } catch (InterruptedException e) {
                System.out.println("Monitoring interrupted");
            }
        }

        scanner.close();
        System.out.println("Website monitoring stopped.");
    }
}

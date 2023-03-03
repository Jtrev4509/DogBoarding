package view;

import java.util.Scanner;

public class Menu {


    private Scanner scanner = new Scanner(System.in);

    public void homeScreenWelcome(){
        System.out.println();
        System.out.println("~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*");
        System.out.println("      Welcome to Jenn's Dog Boarding Page     ");
        System.out.println("~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*");
        System.out.println();
    }

    public String menuOne() {
        System.out.println("Please select one of the following:");
        System.out.println("1) Register Dog");
        System.out.println("2) Check Existing Registration");
        System.out.println("3) Exit");
        System.out.print("What is your selection? ");
        String userInput = scanner.nextLine();
        System.out.println();
        if (userInput.equalsIgnoreCase("1")) {
            userInput = "register dog";
        } else if (userInput.equalsIgnoreCase("2")) {
            userInput = "check existing registration";
        } else if (userInput.equalsIgnoreCase("3")) {
            userInput = "exit";
        } else {
            userInput = "";
        }
        return userInput;
    }

    public String addDogDisplay(){
        System.out.print("What is your first and last name? ");
        String ownerName = scanner.nextLine();
        System.out.print("What is your dogs name? ");
        String dogName = scanner.nextLine();
        System.out.print("What is your dogs breed? ");
        String dogBreed = scanner.nextLine();
        System.out.print("What is your dogs age (in years)? ");
        String dogAge = scanner.nextLine();
        System.out.print("How big is your dog (in lbs)? ");
        String dogWeight = scanner.nextLine();
        System.out.print("Is your dog (m)ale or (f)emale? ");
        String dogMOrF = scanner.nextLine();
        System.out.println();
        System.out.println("You entered the following:");
        System.out.println("Your name:" + ownerName + "\nmDog's name:" + dogName + "\nBreed:" + dogBreed + "\nAge:" + dogAge + "\nWeight:" + dogWeight + "lbs \nm/f:" + dogMOrF);
        System.out.print("Is this information correct y/n? ");
        String userInput = scanner.nextLine();
        //if statement for yes or no
        if(userInput.equalsIgnoreCase(""))
        System.out.println();
        return ownerName + dogName + dogBreed + dogAge + dogWeight + dogMOrF;
    }

    public String checkRegistrationDisplay() {
        System.out.print("What is your full name? ");
        String userInput = scanner.nextLine();
        System.out.println();
        if (userInput.equalsIgnoreCase(""))
            System.out.println("We found you in our system!");
        System.out.println("Here are your dogs already in the system: ");
        System.out.print("Would you like to register another dog? ");
        String userInput2 = scanner.nextLine();
        if (userInput2.equalsIgnoreCase("yes")) {
            System.out.println();
            menuOne();
        } else if (userInput2.equalsIgnoreCase("no")) {
            System.out.println();
            System.out.println("Thanks for checking registration, have a nice day!");
            System.out.println();
            //if statement to see if name in system already
            //will list pets if name already in system
            //can add new pet if this pet isn't in system yet
            //back to menuOne if owner is not in system, they will need to register
        }
        else if(!userInput.equalsIgnoreCase("")){
            System.out.println("Sorry, we didn't find you in our system.");
            System.out.println();
            menuOne();
        }
        return userInput;
    }


    public void displayMessage(String message){
        System.out.println();
        System.out.println(message);
    }

}

package com.jlu.CarPurchaseAgency;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class CarPurchaseAgency {

    static Dealership localChevyDealership;
    static Dealership localHondaDealership;
    static ArrayList<Dealership> listOfDealerships;
    static HashMap<String, UserChoices> userProfiles;
    static UserChoices currentUser;
    private static Scanner input;

    public static void main(String[] args) {
        initData();
        greet();
        getUserInfo();
        checkForFavs();
        goodBye();
    }

    private static void initData() {
        input = new Scanner(System.in);
        if (listOfDealerships == null) {
            listOfDealerships = new ArrayList<>();
        }
        if (localChevyDealership == null) {
            localChevyDealership = new Dealership("Chevy", "123 Chevy Street");
            localChevyDealership.setName("Hackworth Chevy");
            listOfDealerships.add(localChevyDealership);
        }
        if (localHondaDealership == null) {
            localHondaDealership = new Dealership("Honda", "456 Honda Drive");
            localHondaDealership.setName("Roundabout Honda");
            listOfDealerships.add(localHondaDealership);
        }
        if (userProfiles == null) {
            userProfiles = new HashMap<>();
        }
    }

    private static void greet() {
        printBars(2);
        System.out.println("Welcome to our car purchasing agency!");
        printBars(2);
        System.out.println("We currently have the following dealerships:");
        printBar();
        for (int i = 0; i < listOfDealerships.size(); i++) {
            System.out.println(listOfDealerships.get(i).getName());
        }
        printBar();
        pauseForInput();
    }

    private static void getUserInfo() {
        System.out.println("Are you a new or existing user?");

        // TODO: Get user input
        // Demo user
        System.out.println("Nevermind, you're a demo user for now!");
        UserChoices demoUser = new UserChoices("DemoUser", 12, "Chevy");
        userProfiles.put(demoUser.name, demoUser);

        currentUser = demoUser;

        System.out.println("I've got your details listed as such:");
        System.out.printf("Name: %s\n", currentUser.name);
        System.out.printf("Favorite Brand: %s\n", currentUser.favoriteBrand);
        pauseForInput();
    }

    private static void checkForFavs() {
        System.out.printf("Our profile system says that your favorite brand is: %s\n", currentUser.favoriteBrand);
        boolean haveThatBrand = false;
        ArrayList<Dealership> applicableDealers = new ArrayList<>();
        for (Dealership thisDealership : listOfDealerships
        ) {
            if (thisDealership.getBrand().equalsIgnoreCase(currentUser.favoriteBrand)) {
                haveThatBrand = true;
                applicableDealers.add(thisDealership);
            }
        }
        pauseForInput();

        printBar();
        if (haveThatBrand) {
            System.out.println("We DO have some dealerships of that brand in our network!" +
                    "\nHere is the list:");
            printBar();
            for (Dealership thisDealership : applicableDealers) {
                System.out.printf("%s, located at: %s\n", thisDealership.getName(), thisDealership.getAddress());
            }
        } else {
            System.out.printf("I'm sorry, but we don't have any dealerships in our network that sell %ss.\n",
                    currentUser.favoriteBrand);
        }
        printBar();

        pauseForInput();
    }

    private static void goodBye() {
        printBar();
        System.out.println("Goodbye!");
        printBar();
        pauseForInput();
    }

    private static void printBars(int numBars){
        for (int i = 0; i < numBars ; i++) {
            printBar();
        }
    }

    private static void printBar() {
        System.out.println("===========================================");
    }

    private static void pauseForInput() {
        System.out.println("<Press Enter to continue...>");
        input.nextLine();
    }

}

class UserChoices {
    String name;
    int age;
    String favoriteBrand;

    UserChoices() {
        this.name = "";
        this.age = 0;
        this.favoriteBrand = "";
    }

    UserChoices(String newName, int newAge, String newFavBrand) {
        this.name = newName;
        this.age = newAge;
        this.favoriteBrand = newFavBrand;
    }
}

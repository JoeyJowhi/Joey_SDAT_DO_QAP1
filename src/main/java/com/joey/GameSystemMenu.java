package com.joey;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GameSystemMenu {
    public static void main(String[] args) {
        GameStoreSystem gameStoreSystem = new GameStoreSystem();
        Scanner userInput = new Scanner(System.in);
        int userChoice = 0;

        while(userChoice != 7) {
            System.out.print("\n\n---------------\nJoey's Game Emporium\n---------------");

            if (!gameStoreSystem.getStoreInventory().isEmpty()) {
                System.out.print("\n   Our Inventory");

                for (Game game : gameStoreSystem.getStoreInventory()) {
                    System.out.print(game);
                }

                System.out.print("\n===============\n\nMenu Options:\n---------------");
            }

            System.out.print("\n1. (StoreInventory) Add a game.\n2. (StoreInventory) Remove a game by ID.\n3. Search by gameID.\n4. Add a game to your cart.\n5. Remove a game from you cart.\n6. Take your cart to checkout\n7. Exit.\n---------------\n");

            System.out.print("\nChoose an option: ");
            try {
                userChoice = userInput.nextInt();
            } catch (InputMismatchException e) {
                userChoice = 0;
            }
            userInput.nextLine();

            switch(userChoice) {
                case 1:
                    String gameTitle, gameDescription;
                    int gameReleaseYear;
                    BigDecimal gamePrice;

                    do {
                        System.out.print("\n\nEnter the game's title: ");

                        if (!userInput.hasNext()) {
                            userInput.nextLine();
                            System.out.println("   Error: Please enter a valid string for the title.");
                            continue;
                        }

                        gameTitle = userInput.next();
                        userInput.nextLine();
                        break;
                    } while (true);

                    do {
                        System.out.print("\nEnter a description of the game:\n");

                        if (!userInput.hasNext()) {
                            userInput.nextLine();
                            System.out.println("   Error: Please enter a valid string for the description.");
                            continue;
                        }

                        gameDescription = userInput.next();
                        userInput.nextLine();
                        break;
                    } while (true);

                    do {
                        System.out.print("\nEnter the game's release year: ");

                        if (!userInput.hasNextInt()) {
                            userInput.nextLine();
                            System.out.println("   Error: Please enter a valid four digit integer for the game's release year.");
                            continue;
                        }

                        gameReleaseYear = userInput.nextInt();
                        userInput.nextLine();

                        if (gameReleaseYear < 1972 || gameReleaseYear > 2030) {
                            System.out.println("   Error: Please ensure the release year is between 1972 (When the first console released) and 2030 (games set to release after the current year will be listed as pre-orders).");
                            continue;
                        }
                        break;
                    } while (true);

                    do {
                        System.out.print("\nEnter a retail price for the game: ");

                        if (!userInput.hasNextBigDecimal()) {
                            userInput.nextLine();
                            System.out.println("   Error: Please enter a valid decimal value for the game's price.");
                            continue;
                        }

                        gamePrice = userInput.nextBigDecimal();
                        userInput.nextLine();
                        break;
                    } while (true);

                    Game newGame = new Game(gameStoreSystem.getStoreInventory().size() + 1, gameTitle, gameDescription, gameReleaseYear, gamePrice);
                    gameStoreSystem.addGameToStoreInventory(newGame);
                    System.out.println("===Game successfully added to StoreInventory===");
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:
                    System.out.println("Thank you for visiting, come again!");
                    break;
                default:
                    System.out.println("   Error: Invalid choice, please try again.");

            }

            if (userChoice != 7) {
                System.out.print("Press 'Enter' to return to menu: ");
                userInput.nextLine();
            }
        }

        userInput.close();
    }
}
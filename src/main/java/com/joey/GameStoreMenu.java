package com.joey;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GameStoreMenu {
    public static void main(String[] args) {
        GameStoreSystem gameStoreSystem = new GameStoreSystem();

        ArrayList<Game> defaultInventory = new ArrayList<>();
        Game defaultGame1 = new Game(1, "Project Zomboid", "An isometric open-world zombie apocalypse survival game. Complete with a steep skill curve and unforgiving difficulty.", 2013, new BigDecimal("29.99"));
        Game defaultGame2 = new Game(2, "Rimworld", "Crash-landed on a sparsely populated lawless planet at the edge of the observable universe, a small group of people must form a colony with the goal of building a new ship to escape the planet.", 2013, new BigDecimal("34.99"));
        Game defaultGame3 = new Game(3, "Baldur's Gate 3", "Unfortunately for you, an Illithid parasite has been implanted in your head. Which means you are now a ticking time-bomb until you become a Mindflayer! Find whatever allies you can and search for a cure, because if not... I hope you don't mind sporting tentacles.", 2023, new BigDecimal("79.99"));
        defaultInventory.add(defaultGame1);
        defaultInventory.add(defaultGame2);
        defaultInventory.add(defaultGame3);

        gameStoreSystem.setStoreInventory(defaultInventory);
        Scanner userInput = new Scanner(System.in);
        int userChoice = 0;

        while(userChoice != 6) {
            System.out.print("\n\n---------------\nJoey's Game Emporium\n---------------");

            if (!gameStoreSystem.getStoreInventory().isEmpty()) {
                System.out.print("\nOur Inventory");

                for (Game game : gameStoreSystem.getStoreInventory()) {
                    System.out.print(game);
                }

                System.out.print("\n===============\n\nMenu Options:\n---------------");
            }

            System.out.print("\n1. (StoreInventory) Add a game.\n2. (StoreInventory) Remove a game by ID.\n3. Add a game to your cart.\n4. Remove a game from you cart.\n5. Take your cart to checkout\n6. Exit.\n---------------\n");

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
                    int gameIdForRemoval;

                    do {
                        System.out.print("\n\nEnter the id for the game you'd like to remove: ");

                        if (!userInput.hasNextInt()) {
                            userInput.nextLine();
                            System.out.println("   Error: Please enter a valid integer for the game's id.");
                            continue;
                        }

                        gameIdForRemoval = userInput.nextInt();
                        userInput.nextLine();
                        break;
                    } while (true);

                    gameStoreSystem.removeGameFromStoreInventoryById(gameIdForRemoval);
                    System.out.println("===Game Successfully Removed from StoreInventory===");
                    break;
                case 3:
                    int gameIdToAddToCart;

                    do {
                        System.out.print("\n\nEnter the id for the game you'd like to add to your cart: ");

                        if (!userInput.hasNextInt()) {
                            userInput.nextLine();
                            System.out.println("   Error: Please enter a valid integer for the game's id.");
                            continue;
                        }

                        gameIdToAddToCart = userInput.nextInt();
                        userInput.nextLine();
                        break;
                    } while (true);

                    gameStoreSystem.addGameToUserCart(gameIdToAddToCart);
                    System.out.println("===Game Successfully Added to Cart===");
                    break;
                case 4:
                    int gameIdToRemoveFromCart;

                    do {
                        System.out.print("\n\nEnter the id for the game you'd like to remove from your cart: ");

                        if (!userInput.hasNextInt()) {
                            userInput.nextLine();
                            System.out.println("   Error: Please enter a valid integer for the game's id.");
                            continue;
                        }

                        gameIdToRemoveFromCart = userInput.nextInt();
                        userInput.nextLine();
                        break;
                    } while (true);

                    gameStoreSystem.removeGameFromUserCart(gameIdToRemoveFromCart);
                    System.out.println("===Game Successfully Removed from Cart===");
                    break;
                case 5:
                    System.out.println("===Checkout Receipt===");
                    gameStoreSystem.checkoutUserCart();
                    System.out.println("===Thank you for choosing Joey's Game Emporium===");
                    break;
                case 6:
                    System.out.println("Thank you for visiting, come again!");
                    break;
                default:
                    System.out.println("   Error: Invalid choice, please try again.");

            }

            if (userChoice != 6) {
                System.out.print("Press 'Enter' to return to menu: ");
                userInput.nextLine();
            }
        }

        userInput.close();
    }
}
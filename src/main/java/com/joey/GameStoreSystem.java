package com.joey;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class GameStoreSystem {
    private ArrayList<Game> storeInventory, userCart = new ArrayList<>();


    //Constructor(s)
    public GameStoreSystem(ArrayList<Game> storeInventory) {
        this.storeInventory = storeInventory;
    }


    //Instance Methods
    public void addGameToStoreInventory(Game game) throws IllegalArgumentException {
        ArrayList<Game> storeInventory = this.getStoreInventory();

        if (!storeInventory.contains(game)) {
            storeInventory.add(game);
        } else {
            throw new IllegalArgumentException("   Error: This game already exists within the store's inventory.");
        }
    }

    public void removeGameFromStoreInventoryById(int gameId) throws NoSuchElementException {
        try {
            Game gameToRemove = this.searchStoreInventoryByGameId(gameId);

            this.getStoreInventory().remove(gameToRemove);
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException(String.format("   Error: There was no game with the id \"%d\" found within the store's inventory.", gameId));
        }
    }

    public Game searchStoreInventoryByGameId(int gameId) throws NoSuchElementException {
        for (Game game : this.getStoreInventory()) {
            if (gameId == game.getId()) {
                return game;
            }
        }

        throw new NoSuchElementException(String.format("   Error: No game with the id \"%d\" exists in the store's inventory.", gameId));
    }

    public void addGameToUserCart(int gameId) {
        Game game = this.searchStoreInventoryByGameId(gameId);

        this.getUserCart().add(game);
    }

    public void removeGameFromUserCart(int gameId) throws NoSuchElementException {
        Game gameToRemove = this.searchStoreInventoryByGameId(gameId);
        ArrayList<Game> cartToRemoveFrom = this.getUserCart();

        if (cartToRemoveFrom.contains(gameToRemove)) {
            cartToRemoveFrom.remove(gameToRemove);
        } else {
            throw new NoSuchElementException("   Error: The designated game does not currently exist within your cart, therefore it cannot be removed from it.");
        }
    }

    public void checkoutUserCart() {
        BigDecimal subTotal = new BigDecimal("0");
        ArrayList<Game> cartToCheckout = this.getUserCart();

        if (cartToCheckout.isEmpty()) {
            throw new IllegalStateException("   Error: Cannot checkout an empty cart.");
        }

        for (Game game : cartToCheckout) {
            System.out.print(game);

            subTotal = subTotal.add(game.getPrice());
        }

        BigDecimal hstTotal = subTotal.multiply(new BigDecimal(".15"));
        BigDecimal grandTotal = subTotal.add(hstTotal);

        System.out.printf("\n===============\n\nSubtotal: $%,.2f\nHST: $%,.2f\n\nTotal: $%,.2f\n", subTotal, hstTotal, grandTotal);

        getUserCart().clear();
    }


    //Getter Methods
    public ArrayList<Game> getStoreInventory() {
        return this.storeInventory;
    }

    public ArrayList<Game> getUserCart() {
        return this.userCart;
    }


    //Setter Methods
    public void setStoreInventory(ArrayList<Game> storeInventory) {
        this.storeInventory = storeInventory;
    }

    public void setUserCart(ArrayList<Game> userCart) {
        this.userCart = userCart;
    }
}
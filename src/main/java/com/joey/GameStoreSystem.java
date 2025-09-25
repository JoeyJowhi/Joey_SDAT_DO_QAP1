package com.joey;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class GameStoreSystem {
    private ArrayList<Game> storeInventory, userCart = new ArrayList<>();;


    //Constructor(s)
    public GameStoreSystem(ArrayList<Game> storeInventory) {
        this.storeInventory = storeInventory;
    }


    //Instance Methods
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

    public void removeGameFromUserCart(int gameId) {
        Game gameToRemove = this.searchStoreInventoryByGameId(gameId);
        ArrayList<Game> cartToRemoveFrom = this.getUserCart();

        if (cartToRemoveFrom.contains(gameToRemove)) {
            cartToRemoveFrom.remove(gameToRemove);
        } else {
            throw new NoSuchElementException("   Error: The designated game does not currently exist within your cart, therefore it cannot be removed from it.");
        }
    }

    public void checkoutUserCart() {

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


    //Storefront Menu
    public static void main(String[] args) {

    }
}
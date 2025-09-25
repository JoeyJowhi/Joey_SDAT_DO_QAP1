package com.joey;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class GameStoreSystemTest {
    @Test public void testSearchStoreInventoryByGameId() {
        Game testGame = new Game(1, "Project Zomboid", "An isometric open-world zombie apocalypse survival game. Complete with a steep skill curve and unforgiving difficulty.", 2013, new BigDecimal("29.99"));
        ArrayList<Game> storeInventory = new ArrayList<>();
        storeInventory.add(testGame);

        GameStoreSystem storeTestSubject = new GameStoreSystem(storeInventory);

        Assertions.assertEquals(storeTestSubject.searchStoreInventoryByGameId(1), testGame);
    }

    @Test public void testSearchStoreInventoryByGameIdNoSuchElementException() {
        ArrayList<Game> storeInventory = new ArrayList<>();

        GameStoreSystem storeTestSubject = new GameStoreSystem(storeInventory);

        Assertions.assertThrows(NoSuchElementException.class, ()->storeTestSubject.searchStoreInventoryByGameId(1));
    }

    @Test public void testAddGameToUserCart() {
        Game testGame = new Game(1, "Project Zomboid", "An isometric open-world zombie apocalypse survival game. Complete with a steep skill curve and unforgiving difficulty.", 2013, new BigDecimal("29.99"));
        ArrayList<Game> storeInventory = new ArrayList<>();
        storeInventory.add(testGame);

        GameStoreSystem storeTestSubject = new GameStoreSystem(storeInventory);

        storeTestSubject.addGameToUserCart(1);
        Assertions.assertEquals(1, storeTestSubject.getUserCart().size());
    }

    @Test public void testRemoveGameFromUserCart() {
        Game testGame = new Game(1, "Project Zomboid", "An isometric open-world zombie apocalypse survival game. Complete with a steep skill curve and unforgiving difficulty.", 2013, new BigDecimal("29.99"));
        ArrayList<Game> storeInventory = new ArrayList<>();
        storeInventory.add(testGame);

        GameStoreSystem storeTestSubject = new GameStoreSystem(storeInventory);

        storeTestSubject.addGameToUserCart(1);

        storeTestSubject.removeGameFromUserCart(1);
        Assertions.assertFalse(storeTestSubject.getUserCart().contains(testGame));
    }

    @Test public void testRemoveGameFromUserCartNoSuchElementException() {
        Game testGame = new Game(1, "Project Zomboid", "An isometric open-world zombie apocalypse survival game. Complete with a steep skill curve and unforgiving difficulty.", 2013, new BigDecimal("29.99"));
        ArrayList<Game> storeInventory = new ArrayList<>();
        storeInventory.add(testGame);

        GameStoreSystem storeTestSubject = new GameStoreSystem(storeInventory);

        Assertions.assertThrows(NoSuchElementException.class, ()->storeTestSubject.removeGameFromUserCart(1));
    }
}
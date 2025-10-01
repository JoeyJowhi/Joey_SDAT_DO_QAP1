package com.joey;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class GameStoreSystemTest {
    @Test public void testAddGameToStoreInventory() {
        Game testGame = new Game(1, "Project Zomboid", "An isometric open-world zombie apocalypse survival game. Complete with a steep skill curve and unforgiving difficulty.", 2013, new BigDecimal("29.99"));
        ArrayList<Game> storeInventory = new ArrayList<>();
        storeInventory.add(testGame);

        GameStoreSystem storeTestSubject = new GameStoreSystem(storeInventory);

        Game testGame2 = new Game(2, "Rimworld", "Crash-landed on a sparsely populated lawless planet at the edge of the observable universe, a small group of people must form a colony with the goal of building a new ship to escape the planet.", 2013, new BigDecimal("34.99"));

        storeTestSubject.addGameToStoreInventory(testGame2);

        Assertions.assertEquals(2, storeTestSubject.getStoreInventory().size());
    }

    @Test public void testAddGameToStoreInventoryIllegalArgumentException() {
        Game testGame = new Game(1, "Project Zomboid", "An isometric open-world zombie apocalypse survival game. Complete with a steep skill curve and unforgiving difficulty.", 2013, new BigDecimal("29.99"));
        ArrayList<Game> storeInventory = new ArrayList<>();
        storeInventory.add(testGame);

        GameStoreSystem storeTestSubject = new GameStoreSystem(storeInventory);

        Assertions.assertThrowsExactly(IllegalArgumentException.class, ()->storeTestSubject.addGameToStoreInventory(testGame));
    }

    @Test public void testRemoveGameFromStoreInventoryById() {
        Game testGame = new Game(1, "Project Zomboid", "An isometric open-world zombie apocalypse survival game. Complete with a steep skill curve and unforgiving difficulty.", 2013, new BigDecimal("29.99"));
        ArrayList<Game> storeInventory = new ArrayList<>();
        storeInventory.add(testGame);

        GameStoreSystem storeTestSubject = new GameStoreSystem(storeInventory);
        storeTestSubject.removeGameFromStoreInventoryById(1);

        Assertions.assertEquals(0, storeTestSubject.getStoreInventory().size());
    }

    @Test public void testRemoveGameFromStoreInventoryByIdNoSuchElementException() {
        Game testGame = new Game(1, "Project Zomboid", "An isometric open-world zombie apocalypse survival game. Complete with a steep skill curve and unforgiving difficulty.", 2013, new BigDecimal("29.99"));
        ArrayList<Game> storeInventory = new ArrayList<>();
        storeInventory.add(testGame);

        GameStoreSystem storeTestSubject = new GameStoreSystem(storeInventory);

        Assertions.assertThrowsExactly(NoSuchElementException.class, ()->storeTestSubject.removeGameFromStoreInventoryById(2));
    }

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

        Assertions.assertThrowsExactly(NoSuchElementException.class, ()->storeTestSubject.searchStoreInventoryByGameId(1));
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

        Assertions.assertThrowsExactly(NoSuchElementException.class, ()->storeTestSubject.removeGameFromUserCart(1));
    }

    @Test public void testCheckoutUserCart() {
        Game testGame = new Game(1, "Project Zomboid", "An isometric open-world zombie apocalypse survival game. Complete with a steep skill curve and unforgiving difficulty.", 2013, new BigDecimal("29.99"));
        Game testGame2 = new Game(2, "Rimworld", "Crash-landed on a sparsely populated lawless planet at the edge of the observable universe, a small group of people must form a colony with the goal of building a new ship to escape the planet.", 2013, new BigDecimal("34.99"));
        Game testGame3 = new Game(3, "Baldur's Gate 3", "Unfortunately for you, an Illithid parasite has been implanted in your head. Which means you are now a ticking time-bomb until you become a Mindflayer! Find whatever allies you can and search for a cure, because if not... I hope you don't mind sporting tentacles.", 2023, new BigDecimal("79.99"));

        ArrayList<Game> storeInventory = new ArrayList<>();
        storeInventory.add(testGame);
        storeInventory.add(testGame2);
        storeInventory.add(testGame3);

        GameStoreSystem storeTestSubject = new GameStoreSystem(storeInventory);

        storeTestSubject.addGameToUserCart(1);
        storeTestSubject.addGameToUserCart(2);
        storeTestSubject.addGameToUserCart(3);

        storeTestSubject.checkoutUserCart();
        Assertions.assertEquals(0, storeTestSubject.getUserCart().size());
    }
}
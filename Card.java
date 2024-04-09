// package phase3;


// /*
//  * Project Name: Uno Game
//  * Author: [Your Name]
//  * Date: [Current Date]
//  * Description: This class represents a card in the Uno game.
//  */

// public class Card {
//     private int number;
//     private String color;
    
//     // Constructor to initialize a card with a number and a color
//     public Card(int number, String color) {
//         this.number = number;
//         this.color = color;
//     }
    
//     // Method to get the card's number
//     public int getNumber() {
//         return number;
//     }
    
//     // Method to set the card's number
//     public void setNumber(int number) {
//         this.number = number;
//     }
    
//     // Method to get the card's color
//     public String getColor() {
//         return color;
//     }
    
//     // Method to set the card's color
//     public void setColor(String color) {
//         this.color = color;
//     }
// }


//Beginning of card game
package phase3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UnoGame {
    private List<Card> deck;
    private List<Card> discardPile;
    private List<Player> players;
    private int currentPlayerIndex;

    public UnoGame(String[] playerNames) {
        deck = new ArrayList<>();
        discardPile = new ArrayList<>();
        players = new ArrayList<>();

        // Initialize deck
        initializeDeck();

        // Shuffle deck
        Collections.shuffle(deck);

        // Initialize players
        for (String playerName : playerNames) {
            players.add(new Player(playerName));
        }

        // Deal initial cards to players
        dealInitialCards();

        // Start game with first player
        currentPlayerIndex = 0;
    }

    private void initializeDeck() {
        String[] colors = {"Red", "Blue", "Green", "Yellow"};
        for (String color : colors) {
            // Add number cards (0-9) for each color
            for (int number = 0; number <= 9; number++) {
                deck.add(new Card(number, color));
                if (number != 0) {
                    deck.add(new Card(number, color)); // Add twice for numbers 1-9
                }
            }
            // Add special action cards (Skip, Reverse, Draw Two)
            deck.add(new Card(10, color)); // Skip
            deck.add(new Card(11, color)); // Reverse
            deck.add(new Card(12, color)); // Draw Two
        }
    }

    private void dealInitialCards() {
        for (Player player : players) {
            for (int i = 0; i < 7; i++) {
                player.addCard(drawCard());
            }
        }
        discardPile.add(drawCard()); // Draw top card for discard pile
    }

    private Card drawCard() {
        if (deck.isEmpty()) {
            // Reshuffle discard pile into deck (except top card)
            Card topDiscard = discardPile.remove(discardPile.size() - 1);
            deck.addAll(discardPile);
            discardPile.clear();
            discardPile.add(topDiscard);
            Collections.shuffle(deck);
        }
        return deck.remove(deck.size() - 1);
    }

    public void playGame() {
        boolean gameWon = false;
        while (!gameWon) {
            Player currentPlayer = players.get(currentPlayerIndex);

            // Simulate player's turn (implement player logic here)

            // Next player's turn
            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        }
    }

    public static void main(String[] args) {
        String[] playerNames = {"Alice", "Bob", "Charlie"}; // Example players
        UnoGame unoGame = new UnoGame(playerNames);
        unoGame.playGame();
    }
}

// Player Card Code
package phase3;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Card> hand;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Card> getHand() {
        return hand;
    }

    public void addCard(Card card) {
        hand.add(card);
    }

    public Card playCard(Card topCard) {
        // Implement logic to choose a valid card from hand to play
        // based on topCard's color or number
        return null; // Placeholder
    }

    public void drawCard(Card card) {
        hand.add(card);
    }

    public boolean hasUno() {
        return hand.size() == 1;
    }

    public boolean hasEmptyHand() {
        return hand.isEmpty();
    }
}



//End of card Game



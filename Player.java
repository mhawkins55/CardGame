package phase3;

import java.util.ArrayList;

/*
 * Project Name: Uno Game
 * Author: Mason Hawkins
 * Date: 04/6/2024
 * Description: This class represents a player in the Uno game.
 */

public class Player {
    private String name;
    private ArrayList<Card> hand;
    
    // Constructor to initialize a player with a name and an empty hand
    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }
    
    // Method to get the player's name
    public String getName() {
        return name;
    }
    
    // Method to set the player's name
    public void setName(String name) {
        this.name = name;
    }
    
    // Method to get the player's hand
    public ArrayList<Card> getHand() {
        return hand;
    }
    
    // Method to add a card to the player's hand
    public void addCardToHand(Card card) {
        hand.add(card);
    }
    
    // Method to remove a card from the player's hand
    public void removeCardFromHand(Card card) {
        hand.remove(card);
    }
}

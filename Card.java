package phase3;


/*
 * Project Name: Uno Game
 * Author: [Your Name]
 * Date: [Current Date]
 * Description: This class represents a card in the Uno game.
 */

public class Card {
    private int number;
    private String color;
    
    // Constructor to initialize a card with a number and a color
    public Card(int number, String color) {
        this.number = number;
        this.color = color;
    }
    
    // Method to get the card's number
    public int getNumber() {
        return number;
    }
    
    // Method to set the card's number
    public void setNumber(int number) {
        this.number = number;
    }
    
    // Method to get the card's color
    public String getColor() {
        return color;
    }
    
    // Method to set the card's color
    public void setColor(String color) {
        this.color = color;
    }
}


Uno Game Project

Description:
This project aims to implement a functional Uno game in Java.

Class Structure:

Player Class

Description: Represents a player in the Uno game.
Attributes:
name (String): Name of the player.
hand (ArrayList<Card>): List of cards in the player's hand.
Methods:
Player(String name): Constructor to initialize a player with a name and an empty hand.
String getName(): Returns the player's name.
void setName(String name): Sets the player's name.
ArrayList<Card> getHand(): Returns the player's hand.
void addCardToHand(Card card): Adds a card to the player's hand.
void removeCardFromHand(Card card): Removes a card from the player's hand.
Card Class

Description: Represents a card in the Uno game.
Attributes:
number (int): Number/Value of the card.
color (String): Color of the card.
Methods:
Card(int number, String color): Constructor to initialize a card with a number and a color.
int getNumber(): Returns the card's number.
void setNumber(int number): Sets the card's number.
String getColor(): Returns the card's color.
void setColor(String color): Sets the card's color.
Authors:

Mason Hawkins

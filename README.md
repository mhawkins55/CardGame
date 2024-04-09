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


UNO CARD GAME 
The First Code explains the UnoGame Class

Second code built Player Class

In this Uno card game, when the game starts, a deck of Uno cards is shuffled and dealt to the players. The game begins with the first player taking a turn. During each player's turn, they can play cards from their hand that match either the color or number of the card on top of the discard pile. If they can't play a card, they must draw from the deck. Players try to be the first to get rid of all their cards. Once a player has no cards left, they win the game. Special cards like Skips, Reverses, and Draw Twos add twists to the game, making it more exciting and strategic. The game continues until someone empties their hand and wins! More rules and features can be added to make the game more interesting and challenging based on the official Uno rules.

Mustapha Ibrahim

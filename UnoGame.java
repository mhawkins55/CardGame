package project1test;

import java.util.ArrayList;
import java.util.Scanner;

public class UnoGame {
    private Deck deck;
    private ArrayList<Card> discardPile;
    private Player humanPlayer;
    private Player computerPlayer;
    private boolean reverseDirection;
    private String currentColor;
    private int cardsPlayed;

    public UnoGame() {
        deck = new Deck();
        discardPile = new ArrayList<>();
        humanPlayer = new Player();
        computerPlayer = new Player();
        reverseDirection = false;
        currentColor = "";
        cardsPlayed = 0;
    }

    private void dealCards(int numCards) {
        ArrayList<Card> deckCards = deck.getDeck(); // Get the deck cards
        for (int i = 0; i < numCards; i++) {
            Card card = deckCards.remove(deckCards.size() - 1); // Remove card from deck
            humanPlayer.addCard(card); // Add card to human player's hand
            computerPlayer.addCard(deckCards.remove(deckCards.size() - 1)); // Add card to computer player's hand
        }
        humanPlayer.setOriginalHand(new ArrayList<>(humanPlayer.getHand())); // Store original dealt cards for human player
        computerPlayer.setOriginalHand(new ArrayList<>(computerPlayer.getHand())); // Store original dealt cards for computer player
    }

    public void startGame(int numStartingCards) {
        deck.shuffle();
        dealCards(numStartingCards);
        discardPile.add(deck.drawCard());
        currentColor = discardPile.get(0).getColor();

        while (!isGameOver()) {
            playTurn(humanPlayer);
            if (!isGameOver()) {
                playTurn(computerPlayer);
            }
        }

        declareWinner();
    }

private void playTurn(Player player) {
    System.out.println("\nCurrent card: " + discardPile.get(discardPile.size() - 1));
    if (player == humanPlayer) {
        System.out.println("Your hand: " + player.getHand());
    }
    
    // Check if any card can be played
    boolean canPlayAnyCard = false;
    for (Card card : player.getHand()) {
        if (canPlay(card)) {
            canPlayAnyCard = true;
            break;
        }
    }
    
    if (canPlayAnyCard) {
        if (player == humanPlayer) {
            System.out.println("Enter the name of the card you want to play (e.g., Red 6) or -1 to draw: ");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if (input.equals("-1")) {
                player.drawCards(1, deck.getDeck());
                System.out.println("You drew a card.");
            } else {
                player.playCard(input, discardPile);
                if (input.startsWith("Draw Two") || input.startsWith("Wild Draw Four")) {
                    humanPlayer.drawCards(input.startsWith("Draw Two") ? 2 : 4, deck.getDeck());
                }
                cardsPlayed++; // Increment cards played counter
            }
        } else {
            // Implement computer player's logic here
            boolean cardPlayed = false;
            for (Card card : player.getHand()) {
                if (canPlay(card)) {
                    player.playCard(card.toString(), discardPile);
                    if (card.getValue().startsWith("Draw Two") || card.getValue().startsWith("Wild Draw Four")) {
                        humanPlayer.drawCards(card.getValue().startsWith("Draw Two") ? 2 : 4, deck.getDeck());
                    }
                    System.out.println("Computer played: " + card);
                    cardsPlayed++; // Increment cards played counter
                    cardPlayed = true;
                    break;
                }
            }
            if (!cardPlayed) {
                Card drawnCard = deck.drawCard();
                computerPlayer.addCard(drawnCard);
                if (!canPlay(drawnCard)) {
                    System.out.println("Computer couldn't play a card. Turn skipped.");
                }
                cardsPlayed++; // Increment cards played counter
            }
        }
    } else {
        Card drawnCard = deck.drawCard();
        if (player == humanPlayer) {
            humanPlayer.addCard(drawnCard);
            if (!canPlay(drawnCard)) {
                System.out.println("You couldn't play the card. Turn skipped.");
            }
            if (drawnCard.getValue().startsWith("Draw Two") || drawnCard.getValue().startsWith("Wild Draw Four")) {
                humanPlayer.drawCards(drawnCard.getValue().startsWith("Draw Two") ? 2 : 4, deck.getDeck());
            }
        } else {
            computerPlayer.addCard(drawnCard);
            if (!canPlay(drawnCard)) {
                System.out.println("Computer couldn't play a card. Turn skipped.");
            }
            if (drawnCard.getValue().startsWith("Draw Two") || drawnCard.getValue().startsWith("Wild Draw Four")) {
                humanPlayer.drawCards(drawnCard.getValue().startsWith("Draw Two") ? 2 : 4, deck.getDeck());
            }
        }
        cardsPlayed++; // Increment cards played counter
    }

    // Check if a player has won the game
    if (player.getHand().isEmpty()) {
        if (player == humanPlayer) {
            System.out.println("You Won!");
        } else {
            System.out.println("You Lost :(");
        }
        System.exit(0); // End the game
    }

    // Check if it's time to refresh the hand with remaining original cards or if a player has won
    if (cardsPlayed >= 108 || isGameOver()) {
        humanPlayer.refreshHand();
        computerPlayer.refreshHand();
        cardsPlayed = 0; // Reset cards played counter
    }
}

    private boolean canPlay(Card card) {
        Card topCard = discardPile.get(discardPile.size() - 1);
        return card.getColor().equals(currentColor) || card.getValue().equals(topCard.getValue()) || card.getColor().equals("Wild");
    }

    private void declareWinner() {
        // Implement winner declaration logic here
    }

    private boolean isGameOver() {
        return humanPlayer.getHand().isEmpty() || computerPlayer.getHand().isEmpty();
    }

    public static void main(String[] args) {
        UnoGame game = new UnoGame();
        game.startGame(5); // Start with 5 cards each
    }
}
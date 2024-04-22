package Uno;

import java.util.ArrayList;
import java.util.Scanner;

class UnoGame {
    private Deck deck;
    private ArrayList<Card> discardPile;
    private Player humanPlayer;
    private Player computerPlayer;
    private boolean reverseDirection;
    private String currentColor;

    public UnoGame() {
        deck = new Deck(); // Initialize the deck
        discardPile = new ArrayList<>();
        humanPlayer = new Player();
        computerPlayer = new Player();
        reverseDirection = false;
        currentColor = "";
    }

    private void dealCards(int numCards) {
        for (int i = 0; i < numCards; i++) {
            humanPlayer.addCard(deck.drawCard());
            computerPlayer.addCard(deck.drawCard());
        }
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
        System.out.println("Your hand: " + player.getHand());
        
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
                }
            } else {
                // Implement computer player's logic here
                // For simplicity, let's make the computer play the first card it can
                for (Card card : player.getHand()) {
                    if (canPlay(card)) {
                        player.playCard(card.toString(), discardPile);
                        System.out.println("Computer played: " + card);
                        break;
                    }
                }
            }
        } else {
            Card drawnCard = deck.drawCard();
            System.out.println("No card can be played. Drawing a card...");
            player.addCard(drawnCard);
            if (!canPlay(drawnCard)) {
                System.out.println("You couldn't play the card. Turn skipped.");
            }
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

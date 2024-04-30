package Uno;

import java.util.ArrayList;

public class Player {
    private ArrayList<Card> hand;
    private ArrayList<Card> originalHand;

    public Player() {
        hand = new ArrayList<>();
        originalHand = new ArrayList<>();
    }

    public void addCard(Card card) {
        hand.add(card);
    }

    public void removeCard(Card card) {
        hand.remove(card);
    }

    public void drawCards(int numCards, ArrayList<Card> deck) {
        for (int i = 0; i < numCards; i++) {
            if (!deck.isEmpty()) {
                Card card = deck.remove(deck.size() - 1);
                hand.add(card);
            }
        }
    }

    public void playCard(String cardName, ArrayList<Card> discardPile) {
        for (Card card : hand) {
            if (card.toString().equalsIgnoreCase(cardName)) {
                discardPile.add(card);
                hand.remove(card);
                return;
            }
        }
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public ArrayList<Card> getOriginalHand() {
        return originalHand;
    }

    public void setOriginalHand(ArrayList<Card> originalHand) {
        this.originalHand = originalHand;
    }

    public void refreshHand() {
        hand.clear();
        hand.addAll(originalHand);
    }
}

package Uno;

import java.util.ArrayList;

class Player {
    private ArrayList<Card> hand;

    public Player() {
        hand = new ArrayList<>();
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void addCard(Card card) {
        hand.add(card);
    }

    public void playCard(String cardName, ArrayList<Card> discardPile) {
        Card playedCard = null;
        for (Card card : hand) {
            if (card.toString().equalsIgnoreCase(cardName)) {
                playedCard = card;
                break;
            }
        }
        if (playedCard != null) {
            hand.remove(playedCard);
            discardPile.add(playedCard);
        } else {
            System.out.println("You don't have that card in your hand.");
        }
    }

    public void drawCards(int numCards, ArrayList<Card> deck) {
        for (int i = 0; i < numCards; i++) {
            hand.add(deck.remove(deck.size() - 1));
        }
    }
}

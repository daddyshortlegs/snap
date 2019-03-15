package com.andy;

public class Snap {
    private final Deck deck;
    private final Player player1;
    private final Player player2;
    private final GameOutputter outputter;

    public Snap(Deck deck, Player player1, Player player2, GameOutputter outputter) {
        this.deck = deck;
        this.player1 = player1;
        this.player2 = player2;
        this.outputter = outputter;
    }

    public static void main(String[] args) {
        Snap snap = new Snap(new Deck(),
                new Player("Derek"),
                new Player("James"),
                new GameOutputter());

        snap.play();
    }

    public void play() {
        deck.shuffle();
        boolean snap = playUntilWinnerOrNoCardsLeft();
        outputEndingGameState(snap);
    }

    private boolean playUntilWinnerOrNoCardsLeft() {
        String card = "", previousCard;
        int i = 0;
        boolean snap;
        do {
            previousCard = card;
            card = alternatePlayerTurn(i++);
            snap = isSnap(previousCard, card);
        } while (card != null && !snap);
        return snap;
    }

    private String alternatePlayerTurn(int i) {
        return i % 2 == 0 ? takeTurn(player1) : takeTurn(player2);
    }

    private boolean isSnap(String previousCard, String card) {
        if (previousCard.equals("") || card == null) {
            return false;
        }

        return previousCard.charAt(0) == card.charAt(0);
    }

    private void outputEndingGameState(boolean snap) {
        if (snap) {
            decideWinner();
        } else {
            outputter.output("No winner");
        }
    }

    private void decideWinner() {
        if (player1.getReactionTime() < player2.getReactionTime()) {
            outputter.output(player1.getName() + " wins!");
        } else {
            outputter.output(player2.getName() + " wins!");
        }
    }

    private String takeTurn(Player player) {
        String card = player.takeCard(deck);
        outputter.output(player.getName() + " turns '" + card + "'");
        return card;
    }

}

package jack;

public class Player {

    private Card playersCard;
    private CardDeck playerDeck;
    private CardDeck originalDeck;

    public Player(CardDeck playerDeck, CardDeck originalDeck) {
        this.playerDeck = playerDeck;
        this.originalDeck = originalDeck;
    }

    public void draw() {
        playersCard = originalDeck.getOneCardFromDeck();
        playerDeck.addCardToCardDeck(playersCard);
    }

    public void pass() {
        System.out.println("Player passes");
    }

    public Card showYourCard() {
        return playersCard;
    }
}

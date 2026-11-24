package src.monopoly;

/**
 * Class Represents a card with a name and type being the card type.
 *
 * @author Benjamin Shaw
 */
public class Card {

    private String name;
    private Type cardType;

    /**
     * makes a card with a name and card type.
     *
     * @param name of card
     * @param cardType type of card
     */
    public Card(String name, Type cardType) {
        this.name = name;
        this.cardType = cardType;
    }

    /**
     * returns the name of the card.
     *
     * @return name of card
     */
    public String getName() {
        return name;
    }

    /**
     * returns the card type.
     *
     * @return cardType card type
     */
    public Type getCardType() {
        return cardType;
    }
}

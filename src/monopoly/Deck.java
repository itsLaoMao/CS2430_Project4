package src.monopoly;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * The class deck
 *
 * @author Benjamin Shaw
 */
public class Deck {

    private Queue<Card> deckOfCards;
    private List<Card> disardDeck;

    /**
     * Deck takes in the file path to make all the cards the
     *
     * @param filePath
     */
    public Deck(String filePath) {

        try{
            FileInputStream fis = new FileInputStream(filePath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }



        Scanner scnr = new Scanner(System.in);
        this.deckOfCards = null;
    }

    /**
     * The draw method draws a card from the deck which is a queue.
     *
     * @return Card
     */
    public Card draw(){

        // checks if the deck of cards is empty and shuffles
        if (deckOfCards.isEmpty()){
            shuffle();
        }

        // copies the card to the discard deck to then use.
        disardDeck.add(deckOfCards.peek());

        // returns the card from the deck of cards and removes the card.
        return deckOfCards.remove();
    }

    /**
     * Shuffles the discard deck and then adds it to the deck of
     * cards.  After that the discard deck is then cleared.
     */
    private void shuffle(){
        Collections.shuffle(disardDeck);
        deckOfCards.addAll(disardDeck);
        disardDeck.clear();
    }
}

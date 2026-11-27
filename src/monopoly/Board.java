package src.monopoly;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class acts as the board for the monopoly game, A standard 40 space board
 * Along with it this class will store the names/type of each square
 * Track the number of times the simulation will land on each square
 * Manages the additional mechanics of Chance and Community Chest decks as collection of shuffled cards, 
 * including a discard pile that gets reshuffled into a new and usuable deck when it empties
 * 
 * Board
 */

public class Board {

    private int totalMovesMade;

    public static final int BOARD_SIZE = 40;
    public static final int GO_SPACE_INDEX = 0;
    public static final int JAIL_SPACE_INDEX = 10;
    public static final int GO_TO_JAIL_SPACE_INDEX = 30;
    


/**
 * This class is a representation of a single tile/space on the board
 * Space
 */
private static class Space{
    int index;
    String name;
    TileType type;

    public Space(int index, String name, TileType type){
        this.index = index;
        this.name = name;
        this.type = type;
    }

    public int getIndex(){
        return index;
    }
    public String getName(){
        return name;
    }
    public TileType getType(){
        return type;
    }
}


private Space[] spaces = new Space[BOARD_SIZE];

// This is a count that keeps track of the total number of landings per space
private int[] landingCounter = new int[BOARD_SIZE];

//Chance and Community Chest decks that can be shuffled and reshuffled once their decks are fully fully empty
private List<ChanceCard> chanceDeck = new ArrayList<ChanceCard>();
private List<ChanceCard> chanceDiscard = new ArrayList<ChanceCard>();
private List<CommunityChestCard> communityChestDeck = new ArrayList<CommunityChestCard>();
private List<CommunityChestCard> communityChestDiscard = new ArrayList<CommunityChestCard>();


public Board(){
    initializeBoard();
    initializeDecks();
}

/**
 * Creation of the board after initialization of every space with it's
 * spaces name, type and where it gets indexed
 */

  private void initializeBoard(){
        spaces[0] = new Space(0, "Go", TileType.GO);
        spaces[1] = new Space(1, "Mediterranean Avenue", TileType.PROPERTY);
        spaces[2] = new Space(2, "Community Chest", TileType.COMMUNITY_CHEST);
        spaces[3] = new Space(3, "Baltic Avenue", TileType.PROPERTY);
        spaces[4] = new Space(4, "Income Tax", TileType.TAX);
        spaces[5] = new Space(5, "Reading Railroad", TileType.RAILROAD);
        spaces[6] = new Space(6, "Oriental Avenue", TileType.PROPERTY);
        spaces[7] = new Space(7, "Chance", TileType.CHANCE);
        spaces[8] = new Space(8, "Vermont Avenue", TileType.PROPERTY);
        spaces[9] = new Space(9, "Connecticut Avenue", TileType.PROPERTY);
        spaces[10] = new Space(10, "Jail", TileType.JAIL);
        spaces[11] = new Space(11, "St. Charles Place", TileType.PROPERTY);
        spaces[12] = new Space(12, "Electric Company", TileType.UTILITY);
        spaces[13] = new Space(13, "States Avenue", TileType.PROPERTY);
        spaces[14] = new Space(14, "Virginia Avenue", TileType.PROPERTY);
        spaces[15] = new Space(15, "Pennsylvania Railroad", TileType.RAILROAD);
        spaces[16] = new Space(16, "St. James Place", TileType.PROPERTY);
        spaces[17] = new Space(17, "Community Chest", TileType.COMMUNITY_CHEST);
        spaces[18] = new Space(18, "Tennessee Avenue", TileType.PROPERTY);
        spaces[19] = new Space(19, "New York Avenue", TileType.PROPERTY);
        spaces[20] = new Space(20, "Free Parking", TileType.FREE_PARKING);
        spaces[21] = new Space(21, "Kentucky Avenue", TileType.PROPERTY);
        spaces[22] = new Space(22, "Chance", TileType.CHANCE);
        spaces[23] = new Space(23, "Indiana Avenue", TileType.PROPERTY);
        spaces[24] = new Space(24, "Illinois Avenue", TileType.PROPERTY);
        spaces[25] = new Space(25, "B. & O. Railroad", TileType.RAILROAD);
        spaces[26] = new Space(26, "Atlantic Avenue", TileType.PROPERTY);
        spaces[27] = new Space(27, "Ventnor Avenue", TileType.PROPERTY);
        spaces[28] = new Space(28, "Water Works", TileType.UTILITY);
        spaces[29] = new Space(29, "Marvin Gardens", TileType.PROPERTY);
        spaces[30] = new Space(30, "Go To Jail", TileType.GO_TO_JAIL);
        spaces[31] = new Space(31, "Pacific Avenue", TileType.PROPERTY);
        spaces[32] = new Space(32, "North Carolina Avenue", TileType.PROPERTY);
        spaces[33] = new Space(33, "Community Chest", TileType.COMMUNITY_CHEST);
        spaces[34] = new Space(34, "Pennsylvania Avenue", TileType.PROPERTY);
        spaces[35] = new Space(35, "Short Line", TileType.RAILROAD);
        spaces[36] = new Space(36, "Chance", TileType.CHANCE);
        spaces[37] = new Space(37, "Park Place", TileType.PROPERTY);
        spaces[38] = new Space(38, "Luxury Tax", TileType.TAX);
        spaces[39] = new Space(39, "Boardwalk", TileType.PROPERTY);
    }

/**
 * A list of cards in the Chance Deck that strictly advance or move the player back spaces
 * ChanceCard
 */
        public enum ChanceCard{
        ADVANCE_TO_BOARDWALK,
        ADVANCE_TO_GO,
        ADVANCE_TO_ILLINOIS_AVENUE,
        ADVANCE_TO_ST_CHARLES_PLACE,
        ADVANCE_TO_NEAREST_RAILROAD_ONE,
        ADVANCE_TO_NEAREST_RAILROAD_TWO,
        ADVANCE_TO_NEAREST_UTILITY,
        BANK_DIVIDEND,
        GET_OUT_OF_JAIL_FREE,
        GO_BACK_THREE_SPACES,
        GO_TO_JAIL,
        GENERAL_REPAIRS,
        SPEEDING_FINE,
        ADVANCE_TO_READING_RAILROAD,
        CHAIRMAN_OF_THE_BOARD,
        BUILDING_LOAN_MATURES
    }

        public enum CommunityChestCard{
        ADVANCE_TO_GO,
        BANK_ERROR,
        DOCTORS_FEE,
        SALE_OF_STOCK,
        GET_OUT_OF_JAIL_FREE,
        GO_TO_JAIL,
        HOLIDAY_FUND,
        INCOME_TAX_REFUND,
        BIRTHDAY,
        LIFE_INSURANCE,
        HOSPITAL_FEES,
        SCHOOL_FEES,
        CONSULTANCY_FEE,
        STREET_REPAIRS,
        BEAUTY_CONTEST,
        INHERITANCE
    }
}


import sofia.battleship.*;

//-------------------------------------------------------------------------
/**
 *  A game of "Battleship".
 *
 *  @author Christopher Aska Toda (aska192)
 *  @version 2.2.1-14 (2013.10.29)
 */
public class BattleshipGame extends Game
{
    //~ Fields ................................................................



    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new BattleshipGame object.
     */
    public BattleshipGame()
    {
        super();
    }


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * Create a strategy object representing your player strategy.
     * @return The strategy I want to use in this game.
     */
    public BattleshipStrategy createMyStrategy()
    {
        return new MyStrategy();
    }


    // ----------------------------------------------------------
    /**
     * Create a strategy object representing your opponent's strategy.
     * @return The strategy my opponent will use in this game.
     */
    public BattleshipStrategy createOpponentsStrategy()
    {
        return new RandomStrategy();
    }
}

import sofia.battleship.*;
import sofia.util.Random;

//-------------------------------------------------------------------------
/**
 *  This class is MyStrategy, and contains the 
 *  methods of the Battleship game. The class
 *  has the customly made strategy made by myself.
 *
 *  @author Christopher Aska Toda (aska192)
 *  @version 2.2.1-14 (2013.10.29)
 */
public class MyStrategy implements BattleshipStrategy
{
    //~ Fields ................................................................

    //~ Constructor ...........................................................
    // ----------------------------------------------------------
    /**
     * Creates a new MyStrategy object.
     */
    public MyStrategy()
    {
        // Nothing to initialize.
    }

    //~ Methods ...............................................................
    // ----------------------------------------------------------
    
    /**
     * The callShotMove method makes a shot on
     * the opponent's board, and checks if it either
     * hit or miss. 
     * 
     * @param  currentGameState   A sample parameter for a method.
     * @return  move   The act for the battleship.
     */
    public CallShotMove callNextShot(GameState currentGameState)
    {
        int xValue = Random.generator().nextInt(9);
        int yValue = Random.generator().nextInt(9);

        while (!(currentGameState.getOpponentsBoard()
            .canFireAt(xValue, yValue)))
        {
            xValue = Random.generator().nextInt(9);
            yValue = Random.generator().nextInt(9);

        }
        CallShotMove move = new CallShotMove(xValue, yValue);
        return move;
    }

    /**
     * The canPlayDeviously boolean is set to false.
     * 
     * @return  false   It is defining that the game can't
     * be played deviously. 
     */
    public boolean canPlayDeviously()
    {
        return false;
    }

    /**
     * The getName string that creates the name
     * of the username, which is aska192 in this case.
     * 
     * @return  "aska192"   Defining the name of the user.
     */
    public String getName()
    {
        return "aska192";
    }

    /**
     * The method below is just declaring a method
     * called newGame, which is left blank.
     */
    public void newGame()
    {
        // Nothing to initialize.
    }

    /**
     * The ShipPlacementMove method places the ships
     * in random places on my board, not the opponent's
     * board.
     * 
     * @param  currentGameState   A sample parameter for a method.
     * @return  move   The act for the battleship. 
     */
    public ShipPlacementMove placeShips(GameState currentGameState)
    {
        int xValue = Random.generator().nextInt(9);
        int yValue = Random.generator().nextInt(6);

        ShipPlacementMove move = new ShipPlacementMove(currentGameState);

        while (!move.isValid())
        {
            move.placeShip(ShipType.DESTROYER, xValue, yValue, false);
            xValue = Random.generator().nextInt(9);
            yValue = Random.generator().nextInt(4);
            move.placeShip(ShipType.CARRIER, xValue, yValue, false);
            xValue = Random.generator().nextInt(9);
            yValue = Random.generator().nextInt(5);
            move.placeShip(ShipType.BATTLESHIP, xValue, yValue, false);
            xValue = Random.generator().nextInt(9);
            yValue = Random.generator().nextInt(7);
            move.placeShip(ShipType.PATROL, xValue, yValue, false);
            xValue = Random.generator().nextInt(9);
            yValue = Random.generator().nextInt(6);
            move.placeShip(ShipType.SUBMARINE, xValue, yValue, false);
        }
        return move;
    }

}

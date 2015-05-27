import sofia.micro.*;
import sofia.battleship.*;
import sofia.util.Random;

// -------------------------------------------------------------------------
/**
 *  This class is testing MyStrategy methods 
 *  and checking if each different methods result
 *  into the expected outcome.
 *
 *  @author Christopher Aska Toda (aska192)
 *  @version 2.2.1-14 (2013.10.29)
 */
public class MyStrategyTest extends TestCase
{
    //~ Fields ................................................................
    private TestableGameState gameState;
    private MyStrategy strategy;

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new MyStrategyTest test object.
     */
    public MyStrategyTest()
    {
        // The constructor is usually empty in unit tests, since it runs
        // once for the whole class, not once for each test method.
        // Per-test initialization should be placed in setUp() instead.
    }

    //~ Methods ...............................................................
    // ----------------------------------------------------------
    /**
     * Sets up the test fixture.
     * Called before every test case method.
     */
    public void setUp()
    {
        gameState = new TestableGameState();
        strategy = new MyStrategy();

        // Call newGame(), so the strategy is ready to play a new game
        strategy.newGame();        
    }

    // ----------------------------------------------------------
    /**
     * The test for canPlayDeviously() checking
     * that it is always false in the Battleship game.
     */
    public void testCanPlayDeviously()
    {
        assertFalse(strategy.canPlayDeviously());
    }

    /**
     * The test for getName() checking
     * that the display for the username
     * is always aska192 in the Battleship game.
     */
    public void testGetName()
    {
        assertEquals(strategy.getName(), "aska192");
    }

    /**
     * The test for shipPlacements() checking
     * that there would be always 5 ship on both
     * board at the end of the battleship game.
     */
    public void testShipPlacements()
    {
        ShipPlacementMove move = strategy.placeShips(gameState);

        // Make sure the move places 5 ships on the board
        assertEquals(5, move.getShips().size());

        // Make sure the ships are arranged legally
        assertTrue(move.isValid());
    }

    /**
     * The test for callNextShot() checking
     * that the shot would be decided where
     * to be placed on the opponent's board.
     */
    public void testCallNextShot()
    {
        Random.setNextInts(4, 4);
        Random.setNextInts(4, 4);
        
        CallShotMove shot = strategy.callNextShot(gameState);
        
        
        assertEquals(4, shot.getX());
        assertEquals(4, shot.getY());
    }
    
    /**
     * The test for callNextShot() checking
     * that the shot would be decided where
     * to be placed on the opponent's board. 
     * However in this test case, there would
     * be another shot on the same spot twice
     * therefore the test would check that
     * the next shot won't happen in the
     * same place.
     */
    public void testCallNextShotSamePlace()
    {
        Random.setNextInts(5, 5, 4, 3);
        
        gameState.getOpponentsBoard().fireAt(5, 5);
        
        CallShotMove sameShot = strategy.callNextShot(gameState);
        
        assertEquals(4, sameShot.getX());
        assertEquals(3, sameShot.getY());        
    }
    
}

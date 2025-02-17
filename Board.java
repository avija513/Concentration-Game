 import java.util.ArrayList;
 import java.util.Random;
 
//  import java.ut
//  * A game board of NxM board of tiles.
//  * 
//  *  @author PLTW
//  * @version 2.0
//  */

/** 
 * A Board class for concentration
 */
public class Board
{  
  private static String[] tileValues = {"lion", "lion",
                                        "penguin", "penguin",
                                        "dolphin", "dolphin",
                                        "fox", "fox",
                                        "monkey", "monkey",
                                        "turtle", "turtle"}; 
  private Tile[][] gameboard = new Tile[3][4];

  /**  
   * Constructor for the game. Creates the 2D gameboard
   * by populating it with card values
   * 
   */
  public Board()
  {
    ArrayList<String> arraylist = new ArrayList<>();


    for(int i = 0; i<tileValues.length; i++){
      arraylist.add(tileValues[i]);
    }
   for(int c = 0; c<gameboard.length; c++){
    for(int r = 0; r<gameboard[c].length; r++){
      int x = (int)(Math.random()*arraylist.size());
      gameboard[c][r] = new Tile(arraylist.get(x));
      arraylist.remove(x);
    }
   }
 
   }
    /* your code here */ 
   


  
 /** 
   * Returns a string representation of the board, getting the state of
   * each tile. If the tile is showing, displays its value, 
   * otherwise displays it as hidden.
   * 
   * Precondition: gameboard is populated with tiles
   * 
   * @return a string represetation of the board
   */
  public String toString()
  {
    String table = "";
    for(int c = 0; c<gameboard.length; c++){
      for(int r = 0; r<gameboard[c].length; r++){
        if(gameboard[c][r].isShowingValue() == true){
          table += gameboard[c][r].getValue() + "\t";
      }else{
        table +=  gameboard[c][r].getHidden() + "\t";
      }
      
      }
     table += "\n";
    /* your code here */
     }
    return table;
  }
    
  

  /** 
   * Determines if the board is full of tiles that have all been matched,
   * indicating the game is over.
   * 
   * Precondition: gameboard is populated with tiles
   * 
   * @return true if all tiles have been matched, false otherwse
   */
  public boolean allTilesMatch()
  {
    for(int r = 0; r<gameboard.length; r++){
      for(int c = 0; c<gameboard[r].length; r++){
        if(gameboard[r][c].matched() == false){
          return false;
        }
      }
    }
    /* your code  here */
    
    return true;
  }

  /** 
   * Sets the tile to show its value (like a playing card face up)
   * 
   * Preconditions:
   *   gameboard is populated with tiles,
   *   row values must be in the range of 0 to gameboard.length,
   *   column values must be in the range of 0 to gameboard[0].length
   * 
   * @param row the row value of Tile
   * @param column the column value of Tile
   */
  public void showValue (int row, int column)
  {
   gameboard[column][row].show();
    /* your code here */
  }  

  /** 
   * Checks if the Tiles in the two locations match.
   * 
   * If Tiles match, show Tiles in matched state and return a "matched" message
   * If Tiles do not match, re-hide Tiles (turn face down).
   * 
   * Preconditions:
   *   gameboard is populated with Tiles,
   *   row values must be in the range of 0 to gameboard.length,
   *   column values must be in the range of 0 to gameboard[0].length
   * 
   * @param row1 the row value of Tile 1
   * @param col1 the column value of Tile 1
   * @param row2 the row value of Tile 2
   * @param col2 the column vlue of Tile 2
   * @return a message indicating whether or not a match occured
   */
  public String checkForMatch(int col1, int row1, int col2, int row2)
  {
    String msg = "";

    if(gameboard[row1][col1].getValue().equals(gameboard[row2][col2].getValue())){
      msg+="matched";
      showValue(row1,col1);
      showValue(row2, col2);
      gameboard[row1][col1].foundMatch();
      gameboard[row2][col2].foundMatch();
    }else{
      gameboard[row1][col1].hide();
      gameboard[row2][col2].hide();
    }
     /* your code here */
    
     return msg;
  }

  /** 
   * Checks the provided values fall within the range of the gameboard's dimension
   * and that the tile has not been previously matched
   * 
   * @param rpw the row value of Tile
   * @param col the column value of Tile
   * @return true if row and col fall on the board and the row,col tile is unmatched, false otherwise
   */
  public boolean validateSelection(int row, int col)
  {

    /* your code here */

    return true;
  }

}

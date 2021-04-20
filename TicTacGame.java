
import java.util.*;

public class TicTacGame{

    public enum CellState {
        O, //there is an O in the cell
        X, //there is an X in the cell
        Empty //the cell is empty 
    }
 
    public enum BoardState{
        INPROGRESS, //the game is being played
        DRAW, //the result of the game is a draw
        WIN_X, //player X won the game
        WIN_O //player O won the game
    }
 
    private BoardState BState;              //an instance var to store the state of the board
    CellState[] CellStateArray;             //single dim array to store the state of each cell
    private int  n, m, k, size;             //instance that stores n,m,k and n*m
    private int turn = 1;

    List<Integer> savedMoves = new ArrayList<>(); //Used to store the indices played

    /*--------- Constructors ---------*/
    public TicTacGame(){
        n = 3;
        m = 3;
        k = 3;
        size = n*m;
        CellStateArray = new CellState[size];
        InitializeCells(n,m);
        BState = BoardState.INPROGRESS;
    }
 
    public TicTacGame(int n, int m){
        this.n = n;
        this.m = m;
        k = 3;
        size = n*m;
        CellStateArray = new CellState[size];
        InitializeCells(n,m);
        BState = BoardState.INPROGRESS;
    }
 
    public TicTacGame(int n, int m, int k){
        this.n = n;
        this.m = m;
        this.k = k;
        size = n*m;
        CellStateArray = new CellState[size];
        InitializeCells(n,m);
        BState = BoardState.INPROGRESS;
    }
    
    /*--------- Getters for all vars---------*/
    public CellState GetCellState(int index){
		return CellStateArray[index-1];
    }
    
    public BoardState GetBoardState(){
        return BState;
    }
 
    public int GetTurn(){
        return turn;
    }
 
    public int Getn(){
        return n;
    }
 
    public int Getm(){
        return m;
    }
 
    public int Getk(){
        return k;
    }

    public int GetSize() {
        return size;
    }
    
    public List<Integer> GetSavedMoves() {
        return savedMoves;
    }
 
    /*--------- setters for all vars ---------*/
 
    public void SetBoardState(BoardState BState){
        this.BState = BState;
    }
 
    public void SetTurn(int turn){
        this.turn = turn;
    }
 
    public void Setn(int n){
        this.n = n;
    }
 
    public void Setm(int m){
        this.m = m;
    }
 
    public void Setk(int k){
        this.k = k;
    }
    
    public void SetCellStateArray(int index){ //only used for testing
        if(turn % 2 != 0) 
            CellStateArray[index-1] = CellState.X;
        else
            CellStateArray[index-1] = CellState.O;
    }
    /*--------- Prints ---------*/
    //print the positions of the board
    public void PrintPlacements(){
    	System.out.print("\n ********************************\n\n These are the positions of each cell \n");
    	int digitnum = 0;
        int num = 1; 
        String str;  
        //get number of digits in n * m
        while(size != 0) {size /= 10;
         ++digitnum;
        }
        size = n*m; //reset size
        System.out.print("\n");
        for(int i = 0; i < n; i++)
        {
        	System.out.print(" | ");
            for(int j = 0; j < m; j++)
            {
            	str = String.format("%"+digitnum+"d", num);  
        		System.out.print(str);
        		System.out.print(" | ");
				num++;
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }
    //print board cells
    public void PrintCells(){
  
        int num = 0;
        String str = null;
        System.out.print("\n");
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
            	str = String.format("%"+5+"s", CellStateArray[num]);  
            	System.out.printf( " | " + str);
                num++;
            }
            System.out.print(" | \n");
        }
        System.out.print("\n");
    }
 
    //print board state
    public void PrintBoardState(){
        System.out.print("\n");
        if(BState == BoardState.INPROGRESS)
            System.out.print("INPROGRESS");
        if(BState == BoardState.DRAW)
            System.out.print("DRAW");
        if(BState == BoardState.WIN_X)
            System.out.print("Player X won the game");
        if(BState == BoardState.WIN_O)
            System.out.print("Player O won the game");
    }
    
    /*--------- Other functions ---------*/
    
    //returns which player is next to take turn 
    public CellState NextPlayer() {
        if(turn % 2 == 0) //currently 2nd player playing
        	return CellState.X; //next is 1st player 
        else
        	return CellState.O; //next is 2nd player 
    }

    public CellState CurrentPlayer()
    {
        if(turn % 2 == 0) //currently 2nd player playing
            return CellState.O; //next is 1st player 
        else
            return CellState.X; //next is 2nd player 
    }
 
    //sets the state of a given cell to X or O
    public void Play(int index) {
  
            if(CellStateArray[index-1]==CellState.Empty) {
                //current turn for player 1
	    		if(turn % 2 != 0) {
                    CellStateArray[index-1] = CellState.X;
                    savedMoves.add(index);
                }
                    
                //current turn for player 2
	           else  {
                    CellStateArray[index-1] = CellState.O;
                    savedMoves.add(index);
               } 
	                
	    	}
    }
 
    public void InitializeCells(int n, int m) {
    	for(int i = 0; i < n * m; i++)
    	{
    		CellStateArray[i] = CellState.Empty;
    	}
    }

    public int UpdateBoardState(int index, int turn) {
        
        //checks if it's an X
        if (turn % 2 != 0)
        {
            //this runs for k times
            for (int i = 0; i < k; i++) 
            {
                
                int a = 0;	//to iterate the while

                int rowX = 0; 
                int colX = 0; 
                int diagX = 0; 
                int c_diagX = 0; 

                while (a < k) 
                {
                    int rowChecker = 1 - k + i + a;
                    int colChecker = (1 - k + i + a) * m;
                    int diagChecker = colChecker + rowChecker;
                    int c_diagChecker = colChecker - rowChecker;

                    int calcRowVariable = index - 1 + rowChecker;
                    int calcColVariable = index - 1 + colChecker;
                    int calcDiagVariable = index - 1 + diagChecker;
                    int calcCDiagVariable = index - 1 + c_diagChecker;
                    
                    //this calculates if the tests will be out of bounds in a 2D array or not
                    //this is done by seeing if the diagonals will be in the same row as the 
                    //columnVariable (which will always be correctly right above or below the played move)
                    double outOf2DBound_mainChecker;
                    double outOf2DBound_diagChecker;
                    double outOf2DBound_cDiagChecker;

                    outOf2DBound_mainChecker = Math.floor((double)calcColVariable / (double)m);
                    outOf2DBound_diagChecker = Math.floor((double)calcDiagVariable / (double)m);
                    outOf2DBound_cDiagChecker = Math.floor((double)calcCDiagVariable / (double)m);

                    
                    //this calculates whether the rowChecker is actually in the same row
                    //as the currently played move
                    double sameRow_PlayedMove = Math.floor((double) (index - 1) / (double) m);
                    double sameRow_RowChecker = Math.floor((double) calcRowVariable / (double) m);
                    
                    //row out of bounds, X's turn
                    if ((calcRowVariable < 0) || (calcRowVariable >= m*n)) 
                        rowX = 0;
                    

                    //row not out of bounds
                    else 
                    {
                        //checking if it's an X, and it's the same row
                        if (CellStateArray[calcRowVariable] == CellState.X && (sameRow_PlayedMove == sameRow_RowChecker))
                            rowX += 1;

                        //makes sure that if it's empty, that it doesn't include a wrong row
                        else 
                            rowX = 0;
                        
                    }   


                    //column out of bounds
                    if ((calcColVariable < 0) || (calcColVariable >= m*n))
                        colX = 0;

                    //columns not out of bounds
                    else 
                    {
                        //checking if it's an X
                        if (CellStateArray[calcColVariable] == CellState.X) 
                            colX += 1;

                        //makes sure that if it's empty, that it doesn't include a wrong column
                        else
                            colX = 0;
                    }

                    //diagonal out of bounds and diagonal isn't in the correct row
                    if ((calcDiagVariable < 0) || (calcDiagVariable >= m*n) 
                    || outOf2DBound_mainChecker != outOf2DBound_diagChecker)
                        diagX = 0;

                    //diagonal not out of bounds
                    else 
                    {
                        //checking if it's an X
                        if (CellStateArray[calcDiagVariable] == CellState.X) 
                            diagX += 1;

                        //makes sure that if it's empty, that it doesn't include a wrong column
                        else
                            diagX = 0;
                    }
                    
                    //cross-diagonal out of bounds, and cross-diagonal isn't in the correct row
                    if ((calcCDiagVariable < 0) || (calcCDiagVariable >= m*n) 
                    || outOf2DBound_mainChecker != outOf2DBound_cDiagChecker)
                        c_diagX = 0;

                    //cross-diagonal not out of bounds
                    else 
                    {
                        //checking if it's an X
                        if (CellStateArray[calcCDiagVariable] == CellState.X) 
                            c_diagX += 1;

                        //makes sure that if it's empty, that it doesn't include a wrong column
                        else
                            c_diagX = 0;
                    }

                    a++;
                }

                //X wins
                if ((rowX == k || colX == k || diagX == k || c_diagX == k)) {
                    //wins
                    //System.out.print("X WON");
                    BState = BoardState.WIN_X;
                    return -1000;
                }
                
                //no winner yet
                else
                    BState = BoardState.INPROGRESS;
            }
        }
    
        //it's O's turn
        else {

            //this runs for k times
            for (int i = 0; i < k; i++) 
            {
                
                int a = 0;	//to iterate the while

                int rowO = 0;
                int colO = 0; 
                int diagO = 0;
                int c_diagO = 0; 

                while (a < k) 
                {
                    int rowChecker = 1 - k + i + a;
                    int colChecker = (1 - k + i + a) * m;
                    int diagChecker = rowChecker + colChecker;
                    int c_diagChecker = (-1 * rowChecker) + colChecker;

                    int calcRowVariable = index - 1 + rowChecker;
                    int calcColVariable = index - 1 + colChecker;
                    int calcDiagVariable = index - 1 + diagChecker;
                    int calcCDiagVariable = index - 1 + c_diagChecker;

                    
                    //this calculates if the tests will be out of bounds in a 2D array or not
                    //this is done by seeing if the diagonals will be in the same row as the 
                    //columnVariable (which will always be correctly right above or below the played move)
                    double outOf2DBound_mainChecker;
                    double outOf2DBound_diagChecker;
                    double outOf2DBound_cDiagChecker;

                    outOf2DBound_mainChecker = Math.floor((double)calcColVariable / (double)n);
                    outOf2DBound_diagChecker = Math.floor((double)calcDiagVariable / (double)n);
                    outOf2DBound_cDiagChecker = Math.floor((double)calcCDiagVariable / (double)n);

                    //this calculates whether the rowChecker is actually in the same row
                    //as the currently played move
                    double sameRow_PlayedMove = Math.floor((double) (index - 1) / (double) n);
                    double sameRow_RowChecker = Math.floor((double) calcRowVariable / (double) n);
                    
                    
                    //row out of bounds, X's turn
                    if ((calcRowVariable < 0) || (calcRowVariable >= m*n))
                        rowO = 0;

                    //row not out of bounds
                    else 
                    {
                        //checking if it's an O, and it's the same row
                        if (CellStateArray[calcRowVariable] == CellState.O && (sameRow_PlayedMove == sameRow_RowChecker))
                            rowO += 1;

                        //makes sure that if it's empty or X, that it doesn't include a wrong row
                        else 
                            rowO = 0;
                    
                    }   


                    //column out of bounds
                    if ((calcColVariable < 0) || (calcColVariable >= m*n))
                        colO = 0;

                    //columns not out of bounds
                    else 
                    {
                        //checking if it's an O
                        if (CellStateArray[calcColVariable] == CellState.O) 
                            colO += 1;

                        //makes sure that if it's empty or an X, that it doesn't include a wrong column
                        else
                            colO = 0;
                    }

                    //diagonal out of bounds, and diagonal isn't in the correct row
                    if ((calcDiagVariable < 0) || (calcDiagVariable >= m*n)
                    || outOf2DBound_mainChecker != outOf2DBound_diagChecker)
                        diagO = 0;

                    //diagonal not out of bounds
                    else 
                    {
                        //checking if it's an O
                        if (CellStateArray[calcDiagVariable] == CellState.O) 
                            diagO += 1;

                        //makes sure that if it's empty or an X, that it doesn't include a wrong column
                        else
                            diagO = 0;
                    }
                    
                    //cross-diagonal out of bounds, and cross-diagonal isn't in the correct row
                    if ((calcCDiagVariable < 0) || (calcCDiagVariable >= m*n)
                    || outOf2DBound_mainChecker != outOf2DBound_cDiagChecker)
                        c_diagO = 0;

                    //cross-diagonal not out of bounds
                    else 
                    {
                        //checking if it's an O
                        if (CellStateArray[calcCDiagVariable] == CellState.O) 
                            c_diagO += 1;

                        //makes sure that if it's empty or an X, that it doesn't include a wrong column
                        else
                            c_diagO = 0;
                    }


                    a++;
                }
                
                //O wins
                if ((rowO == k || colO == k || diagO == k || c_diagO == k)) {
                    //wins
                    //System.out.print("O WON");
                    BState = BoardState.WIN_O;
                    return 1000;
                }
                
                //no winner yet
                else
                    BState = BoardState.INPROGRESS;
            }
        }

         //checks if board is full, and neither X or O won
         if ((turn == size) && (BState != BoardState.WIN_X) && (BState != BoardState.WIN_O)) {
            //System.out.print("DRAW");
            BState = BoardState.DRAW;
            return 0;
      }
      return 0;
    }

    /*--------------------------------------------- Functions for AI ---------------------------------------------*/
    public int WinOrLoss() {
    	
    	if(BState == BoardState.WIN_O) //AI wins
    		return 1000;
    	if(BState == BoardState.WIN_X) //Other player wins
    		return -1000;
    	return 0;
    	
    }
	public List<Integer> ValidMoves(){
		List<Integer> validMoves = new ArrayList<>();
		  
		// Search for empty cells and add to the List
	      for (int i = 0; i < size; i++) {
	            if (CellStateArray[i] == CellState.Empty)
	            	validMoves.add(i + 1);  
	         }
	     return validMoves;
    }
    
    public boolean isFull() {
        boolean full = true;
        for(int i = 0; i < size; i++) {
            if(CellStateArray[i] == CellState.Empty) {
                return(!full);
            }   
        }
        return full;
    }
    
    //return best score and best move. Uses alpha/beta pruning.
    public int[] MiniMax(CellState symbol, int depth, int alpha, int beta, int currentMove, int tempTurn) {
        
        //stores best score and move + currentMove and tempTurn (if needed)
        int[] scoreAndMove = new int[2]; 
        int bestScore; int bestMove = -1;
 
        List<Integer> legalMoves  = ValidMoves();
        
        if(symbol == CellState.O)
            bestScore = -1000;
        else
            bestScore = 1000;
        
        int WhoWon = UpdateBoardState(currentMove + 1, tempTurn + 1);
 
        //board is full and it didn't reach a draw
        if(isFull() || WhoWon != 0) {
            bestScore = WinOrLoss();
            scoreAndMove[0] = bestScore;
            scoreAndMove[1] = bestMove; 
            return scoreAndMove;
        }
        
        for(int i = 0; i < legalMoves.size(); i++) {
 
            currentMove = legalMoves.get(i) - 1;
            tempTurn = size - legalMoves.size();
            CellStateArray[currentMove] = symbol;
            //PrintCells();
 
            if(symbol == CellState.O) {
                int[] backScore = MiniMax(CellState.X, depth + 1, alpha, beta, currentMove, tempTurn);
                int score = backScore[0];
                if(bestScore < score) {
                    bestScore = score - depth * 10;
                    bestMove = currentMove;
 
                    //getting the max between alpha and bestScore
                    if (bestScore > alpha)
                        alpha = bestScore;
                    else
                        ; //alpha = alpha basically
 
                    CellStateArray[currentMove] = CellState.Empty;
 
                    if (beta <= alpha)
                        break;
                }
                
            }
            
            else {
                int[] backScore = MiniMax(CellState.O, depth + 1, alpha, beta, currentMove, tempTurn);
                int score = backScore[0];
                if(bestScore > score) {
                    bestScore = score + depth * 10;
                    bestMove = currentMove;
 
                //getting the min between beta and bestScore
                if (bestScore < beta)
                    beta = bestScore;
                else
                    ; //beta = beta basically
 
                CellStateArray[currentMove] = CellState.Empty;
                if (beta <= alpha)
                    break;
                }
            }
            
            CellStateArray[currentMove] = CellState.Empty;
        }
    
        scoreAndMove[0] = bestScore;
        scoreAndMove[1] = bestMove; 
        return scoreAndMove;    
    }
    
    public int[] DoMinMax() {
        int[] doMove = new int[2];
 
        //for saving the state of the board
        CellState[] TempStateArray = new CellState[size];
        for (int i = 0; i < size; i++)
            TempStateArray[i] = CellStateArray[i];
 
        doMove = MiniMax(CellState.O, 0, -1000, 1000, 0, turn);
 
        //revert back to the original state of the board
        for (int i = 0; i < size; i++)
            CellStateArray[i] = TempStateArray[i];
    
        System.out.print("\nBest move is " + (doMove[1] + 1));
        return doMove;
    }
    /*--------------------------------------------- Replay ---------------------------------------------*/
    public void Replay(int start, int end) {
        InitializeCells(n,m);
        //place all moves that occured before start turn in board 
        for(int i = 0; i < start; i++){
            if(i % 2 == 0) //if it was X's turn 
                CellStateArray[savedMoves.get(i)-1] = CellState.X;
            else //it was O's turn 
                CellStateArray[savedMoves.get(i)-1] = CellState.O;
        }
          //to delay the printing 
        try
        {
            Thread.sleep(1500);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
        PrintCells(); //print starting board
        for(int i = start; i < end; i++) {
            //if it was X's turn 
            if(i % 2 == 0) {
                CellStateArray[savedMoves.get(i)-1] = CellState.X;
                 //to delay the printing 
                 try
                 {
                     Thread.sleep(1500);
                 }
                 catch(InterruptedException ex)
                 {
                     Thread.currentThread().interrupt();
                 }
                PrintCells();
            }
            else {
                CellStateArray[savedMoves.get(i)-1] = CellState.O;
                PrintCells();
            }
        }
    }
    
}
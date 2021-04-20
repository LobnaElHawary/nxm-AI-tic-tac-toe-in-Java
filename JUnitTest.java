import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class JUnitTest {
    @Test
    public void TestTicTacGame() { //3x3 board by default

        TicTacGame tester1 = new TicTacGame(); // Testing TicTac Game 
        //setting 3x3 board to have 3 Xs row win 

            tester1.SetCellStateArray(1); //play X in position 1
            tester1.UpdateBoardState(1, tester1.GetTurn()); //index, turn
            tester1.SetTurn(tester1.GetTurn()+1); //increment turn

            tester1.SetCellStateArray(6); //play O in position 6
            tester1.UpdateBoardState(6, tester1.GetTurn());
            tester1.SetTurn(tester1.GetTurn()+1);

            tester1.SetCellStateArray(2); //play X in position 2
            tester1.UpdateBoardState(2, tester1.GetTurn());
            tester1.SetTurn(tester1.GetTurn()+1);

            tester1.SetCellStateArray(7); //play O in position 7
            tester1.UpdateBoardState(7, tester1.GetTurn());
            tester1.SetTurn(tester1.GetTurn()+1);

            tester1.SetCellStateArray(3); //play X in position 3
            tester1.UpdateBoardState(3, tester1.GetTurn());
            tester1.SetTurn(tester1.GetTurn()+1);
     
        //test on n = 3, m = 3, k = 2
        TicTacGame tester2 = new TicTacGame(3,3,2); // Testing TicTac Game 
        //setting 3x3 board to have 2 Xs col win

            tester2.SetCellStateArray(2); //play X in position 2
            tester2.UpdateBoardState(2, tester2.GetTurn()); //index, turn
            tester2.SetTurn(tester2.GetTurn()+1); //increment turn

            tester2.SetCellStateArray(3); //play O in position 3
            tester2.UpdateBoardState(3, tester2.GetTurn());
            tester2.SetTurn(tester2.GetTurn()+1);

            tester2.SetCellStateArray(5); //play X in position 5
            tester2.UpdateBoardState(5, tester2.GetTurn());

        //test on n = 3, m = 4, k = 3
        TicTacGame tester3 = new TicTacGame(3,4,3); // Testing TicTac Game 
        //setting 3x4 board to have 3 Xs diagonal win
            tester3.SetCellStateArray(1); //play X in position 1
            tester3.UpdateBoardState(1, tester3.GetTurn()); //index, turn
            tester3.SetTurn(tester3.GetTurn()+1); //increment turn

            tester3.SetCellStateArray(2); //play O in position 2
            tester3.UpdateBoardState(2, tester3.GetTurn());
            tester3.SetTurn(tester3.GetTurn()+1);

            tester3.SetCellStateArray(6); //play X in position 6
            tester3.UpdateBoardState(6, tester3.GetTurn());
            tester3.SetTurn(tester3.GetTurn()+1);

            tester3.SetCellStateArray(5); //play O in position 5
            tester3.UpdateBoardState(5, tester3.GetTurn());
            tester3.SetTurn(tester3.GetTurn()+1);

            tester3.SetCellStateArray(11); //play X in position 11
            tester3.UpdateBoardState(11, tester3.GetTurn());

        TicTacGame tester4 = new TicTacGame(5,4,4); // Testing TicTac Game 
        //setting 5x4 board to have 4 Os cross diagonal win
            tester4.SetCellStateArray(2); //play X in position 2
            tester4.UpdateBoardState(2, tester4.GetTurn()); //index, turn
            tester4.SetTurn(tester4.GetTurn()+1); //increment turn

            tester4.SetCellStateArray(1); //play O in position 1
            tester4.UpdateBoardState(1, tester4.GetTurn());
            tester4.SetTurn(tester4.GetTurn()+1);

            tester4.SetCellStateArray(5); //play X in position 5
            tester4.UpdateBoardState(5, tester4.GetTurn());
            tester4.SetTurn(tester4.GetTurn()+1);

            tester4.SetCellStateArray(6); //play O in position 6
            tester4.UpdateBoardState(6, tester4.GetTurn());
            tester4.SetTurn(tester4.GetTurn()+1);

            tester4.SetCellStateArray(10); //play X in position 10
            tester4.UpdateBoardState(10, tester4.GetTurn());
            tester4.SetTurn(tester4.GetTurn()+1);

            tester4.SetCellStateArray(11); //play O in position 11
            tester4.UpdateBoardState(11, tester4.GetTurn());
            tester4.SetTurn(tester4.GetTurn()+1);

            tester4.SetCellStateArray(15); //play X in position 10
            tester4.UpdateBoardState(15, tester4.GetTurn());
            tester4.SetTurn(tester4.GetTurn()+1);

            tester4.SetCellStateArray(16); //play O in position 10
            tester4.UpdateBoardState(16, tester4.GetTurn());

        TicTacGame tester5 = new TicTacGame();
        //setting 3x3 board to have a draw 
            tester5.SetCellStateArray(2); //play X in position 2
            tester5.UpdateBoardState(2, tester5.GetTurn()); //index, turn
            tester5.SetTurn(tester5.GetTurn()+1); //increment turn

            tester5.SetCellStateArray(3); //play O in position 3
            tester5.UpdateBoardState(3, tester5.GetTurn()); //index, turn
            tester5.SetTurn(tester5.GetTurn()+1); //increment turn

            tester5.SetCellStateArray(5); //play X in position 5
            tester5.UpdateBoardState(5, tester5.GetTurn()); //index, turn
            tester5.SetTurn(tester5.GetTurn()+1); //increment turn

            tester5.SetCellStateArray(6); //play O in position 6
            tester5.UpdateBoardState(6, tester5.GetTurn()); //index, turn
            tester5.SetTurn(tester5.GetTurn()+1); //increment turn

            tester5.SetCellStateArray(4); //play X in position 4
            tester5.UpdateBoardState(4, tester5.GetTurn()); //index, turn
            tester5.SetTurn(tester5.GetTurn()+1); //increment turn

            tester5.SetCellStateArray(1); //play O in position 1
            tester5.UpdateBoardState(1, tester5.GetTurn()); //index, turn
            tester5.SetTurn(tester5.GetTurn()+1); //increment turn

            tester5.SetCellStateArray(9); //play X in position 9
            tester5.UpdateBoardState(9, tester5.GetTurn()); //index, turn
            tester5.SetTurn(tester5.GetTurn()+1); //increment turn

            tester5.SetCellStateArray(8); //play O in position 8
            tester5.UpdateBoardState(8, tester5.GetTurn()); //index, turn
            tester5.SetTurn(tester5.GetTurn()+1); //increment turn

            tester5.SetCellStateArray(7); //play X in position 7
            tester5.UpdateBoardState(7, tester5.GetTurn()); //index, turn
            tester5.SetTurn(tester5.GetTurn()+1); //increment turn

        //checking all the results.
        assertEquals(TicTacGame.BoardState.WIN_X, tester1.GetBoardState(), "X should have won...\n");
        assertEquals(TicTacGame.BoardState.WIN_X, tester2.GetBoardState(), "X should have won...\n");
        assertEquals(TicTacGame.BoardState.WIN_X, tester3.GetBoardState(), "X should have won...\n");
        assertEquals(TicTacGame.BoardState.WIN_O, tester4.GetBoardState(), "O should have won...\n");
        assertEquals(TicTacGame.BoardState.DRAW, tester5.GetBoardState(), "The game should have been a draw...\n");
    }
}

import java.util.Scanner;

public class Main {
	static int MenuOptions = 0;
	public static void main(String[] args) {
		PlayTicTacToe();
	}

	public static void PlayTicTacToe() { 
		Scanner scanner = new Scanner(System.in);
		boolean first = true;
		int inputn = 3; int inputm = 3; int inputk = 3;
		int index, GameMode = 0, MenuOptions = 0, start, end,maxBetween_N_M;
		int temp[] = new int[2];

		//takes in GameMode and checks it is valid input 
		do {	
			if(first) {
				System.out.print("\nPress 1 to play 1 vs 1\nPress 2 to play vs the computer\n");
				first = false;
			}

			else
				System.out.print("\nInvalid input.\nPress 1 to play 1 vs 1\nPress 2 to play vs the computer\n");

			while (!scanner.hasNextInt()) {
				String input = scanner.next();
				System.out.printf("\"%s\" is not a valid input.\n Press 1 to play 1 vs 1\nPress 2 to play vs the computer...\n", input);
			}
			GameMode = scanner.nextInt();
		} while (GameMode != 1 && GameMode != 2);

		System.out.print(" ***************************************\n\n\tTic Tac Toe!\n\n Player 1 is X\t Player 2 is O \n\n ***************************************");
		first = true;
		//takes in n and checks it is valid input 
		do {	
			if(first) {
				System.out.print("\nEnter the number of rows of the game's board (n)\n");
				first = false;
			}

			else
				System.out.print("\nInvalid number. Re-enter the number of rows of the game's board... (n)\n");
				
			while (!scanner.hasNextInt()) {
				String input = scanner.next();
				System.out.printf("\"%s\" is not a valid row number. Re-enter a valid row number...\n", input);
			}
			inputn = scanner.nextInt();
		} while (inputn <= 0);
		
		first = true;
		//takes in m and checks it is valid input 
		do {	
			if(first) {
				System.out.print("\nEnter the number of columns of the game's board (m)\n");
				first = false;
			}
			
			else
				System.out.print("\nInvalid number. Re-enter the number of columns of the game's board (n)\n");
				
			while (!scanner.hasNextInt()) {
				String input = scanner.next();
				System.out.printf("\"%s\" is not a valid column number. Re-enter a valid column number.\n", input);
			}
			inputm = scanner.nextInt();
		} while (inputm <= 0);

		first = true;
		//takes in k and checks it is valid input 
		do {	
			if(first) {
				System.out.print("\nEnter the required number of consecutive X's or O's to win (k)\n");
				first = false;
			}

			else
				System.out.print("\nInvalid number. Re-enter k... \n");

			while (!scanner.hasNextInt()) {
				String input = scanner.next();
				System.out.printf("\"%s\" is not a valid column number. Re-enter a valid number...\n", input);
			}

			if (inputn > inputm)
				maxBetween_N_M = inputn;
			else
				maxBetween_N_M = inputm;

			inputk = scanner.nextInt();
		} while ((inputk > maxBetween_N_M)||(inputk<=0));
		
		TicTacGame TG  = new TicTacGame(inputn, inputm, inputk); 
		TG.PrintPlacements(); //prints indeces correspinding to board cells, for user's reference
		
		while(TG.GetBoardState() == TicTacGame.BoardState.INPROGRESS) {
			if(GameMode == 1) {
				if (TG.GetTurn() % 2 != 0) {//first player's turn 
					//get first player's played position and validate it
					first = true;
					do {	
						if(first) {
							System.out.print("\nIt's player X's turn, enter the position you would like to play\n");
							first = false;
						}

						else
							System.out.print("\nThe position you have picked is not allowed, re-enter a new position... \n");

						while (!scanner.hasNextInt()) {
							String input = scanner.next();
							System.out.printf("\"%s\" is not a position. Re-enter a valid position\n", input);
						}
							index = scanner.nextInt();
					} while (index < 1 || index > TG.GetSize());
				}

				//second player's turn
				//get second player's played position and validate it
				else { 
					first = true;

					do {	
						if(first) {
							System.out.print("\nIt's player O's turn, enter the position you would like to play\n");
							first = false;
						}

						else
							System.out.print("\nThe position you have picked is not allowed, re-enter a new position... \n");

						while (!scanner.hasNextInt()) {
							String input = scanner.next();
							System.out.printf("\"%s\" is not a position. Re-enter a valid position\n", input);
						}
							index = scanner.nextInt();
					} while (index < 1 || index > TG.GetSize());
				}
				
				//in case position is not empty (has already been played)
				while(TG.GetCellState(index) != TicTacGame.CellState.Empty) {
					System.out.print("\n The position you have picked has been played, re-enter a new position... \n");
					index = scanner.nextInt();
				}

				TG.Play(index);
				TG.PrintCells();
				TG.UpdateBoardState(index, TG.GetTurn()); 
				TG.SetTurn(TG.GetTurn() + 1); 	// increment turn 
			}

			else if(GameMode == 2) {
				if (TG.GetTurn() % 2 != 0) { //first player's turn
				//get first player's played position and validate it
				first = true;
				do {	
					if(first) {
						System.out.print("\nIt's player X's turn, enter the position you would like to play\n");
						first = false;
					
					}
					else
						System.out.print("\nThe position you have picked is not allowed, re-enter a new position... \n");
						
					while (!scanner.hasNextInt()) {
						String input = scanner.next();
						System.out.printf("\"%s\" is not a position. Re-enter a valid position\n", input);
					}
						index = scanner.nextInt();
				} while (index < 1 || index > TG.GetSize());

				//in case position is not empty 
				while(TG.GetCellState(index) != TicTacGame.CellState.Empty) {
					System.out.print("\n The position you have picked has been played, re-enter a new position... \n");
					index = scanner.nextInt();
				}
		
				TG.Play(index);
				TG.PrintCells();
				TG.UpdateBoardState(index, TG.GetTurn());
				TG.SetTurn (TG.GetTurn() + 1); 	// increment turn 
			}

				//Computer's turn, second turn
				else { 
					temp = TG.DoMinMax();
					TG.Play(temp[1]+1);
					TG.PrintCells();
					TG.UpdateBoardState(temp[1], TG.GetTurn());
					TG.SetTurn(TG.GetTurn() + 1); // increment turn 
				}	
			}
		}

		if (TG.GetBoardState() == TicTacGame.BoardState.WIN_X)
            System.out.print("\n X is the final winner! Congratulations! \n");
        else if (TG.GetBoardState() == TicTacGame.BoardState.WIN_O)
            System.out.print("\n O is the final winner! Congratulations! \n");
        else if (TG.GetBoardState() == TicTacGame.BoardState.DRAW)
            System.out.print("\n Game ended in a draw! \n");
        else
            ;
		//sc.close();
		System.out.print("\n------------------------------------- Menu -------------------------------------\n");
		System.out.print("\n To start a new game, enter 1 and to replay the game, enter 2 \n");
		System.out.print("\n------------------------------------- Menu -------------------------------------\n");
		
		first = true;
		do {	
			if(first)
				first = false;
			else
				System.out.print("\nInvalid input. Press 1 to play a new game, Press 2 to replay previously played game\n");

			while (!scanner.hasNextInt()) {
				String input = scanner.next();
				System.out.printf("\"%s\" is not a valid input. Enter a valid input\n", input);
			}
			MenuOptions = scanner.nextInt();
		} while (MenuOptions <= 0 || MenuOptions > 2);
		first = true;

		if(MenuOptions == 1) //start a new game
			PlayTicTacToe();
		
		else if(MenuOptions == 2){ //replay

			//take start as input, and validate it
			first = true;
			do {	
				if(first) {
					System.out.print("\nEnter the replay starting point\n");
					first = false;
				}
				else
					System.out.print("Invalid input. The start has to be within the range 1 - "+TG.GetSavedMoves().size()+"\n");

				while (!scanner.hasNextInt()) {
					String input = scanner.next();
					System.out.printf("\"%s\" is not a valid input. Enter a valid input \n", input);
				}
				start = scanner.nextInt(); 
			} while (start < 1 || start > TG.GetSavedMoves().size());

			//take end as input, and validate it
			first = true;
			do {	
				if(first) {
					System.out.print("\nEnter the replay ending point\n");
					first = false;
				}
				else
					System.out.print("Invalid input. The end has to be within the range "+start+" - " + TG.GetSavedMoves().size()+"\n");

				while (!scanner.hasNextInt()) {
					String input = scanner.next();
					System.out.printf("\"%s\" is not a valid input. Enter a valid input \n", input);
				}
				end = scanner.nextInt();
			} while (end < 1 || end > TG.GetSavedMoves().size() || end<start);

			TG.Replay(start, end);
		}
		scanner.close();
	}
}

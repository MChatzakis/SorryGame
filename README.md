

*********************************************************
*      Sorry Game // 6.1.2020 // Manos Chatzakis		*
* 														*
*														*
* This readme file contains useful tips to play			*
* the board game, in a way that the game works 			*
* properly without bugs.	          					*
*														*
*														*
*														*
*                   Manos Chatzakis, csd4238@csd.uoc.gr *
*********************************************************


---------------------------------------------------------
1. How to run:
	No executable jar file is provided yet. To play the game
	open the project in an IDE(etc. eclipse, netBeans, atom..)
	and run the Game class provided inside the application package.
---------------------------------------------------------

---------------------------------------------------------
2. How to start the game:
	Once you run the game class, the default action of the game is to start a new game.
	Insert your names and then draw a card.
	Notice that the first player to enter a name is the red player.
	Also, in the begging, the turn is decided right after a card is drawn, so to see who will move a pawn first, just draw the first card.
---------------------------------------------------------

---------------------------------------------------------	
3. How to begin from start:
	From the start square, pawns may only move using 1,2 or sorry card.
	If you draw other cards and both of your pawns are unavailable to move, then you can choose fold and the turn will change.
---------------------------------------------------------

---------------------------------------------------------
4. How to move a pawn:
	-For classic cards:
		Assuming that your pawn is available to move according to the rules of the game, just click the pawn you want to move (indeed it must be one of your two pawns.)
		If the move is valid according the opened card, your pawn will move to the desired position.
		Otherwise, a warning dialog will occur.
		This works for the no. 1 2 3 4 5 8 12 cards.
	-For special cards(no. 7, 10, 11, Sorry):
		>No. 7:
			Two dialogs will occur once you click a pawn. The first asks you to enter the value for your first pawn and the second for your second pawn.
			If the input is ok, then the move will be made, othewise a warning dialog will occur.	
		>No. 10:
			Once you click your pawn you want to move, a dialog will occur. Enter 10 if you want to increment the position by 10 squares, else enter -1 if you want to go a square back. If the move is unavailable, a warning message occurs.
		>No. 11:
			Once you click the pawn you want to move, a dialog will occur. Enter 1 if you want to increment the position by 11 squares, else enter 2 to swap with an enemy pawn.
			Notice that red pawn 1 is 0 index, while yellow pawn 2 is 3 index.
		>Sorry:
			Once this card occurs, you may click the pawn you want to move and then choose the enemy pawn to swap using the dialog that occurs.
---------------------------------------------------------

---------------------------------------------------------
5. When is fold available:
	Only if you cant make a move, or when number eleven card is opened.
---------------------------------------------------------

---------------------------------------------------------
6. How to win:
	Send both of your pawns to their home.
---------------------------------------------------------

---------------------------------------------------------
7. How to start a new game:
	a. Click Game button from game menu.
	b. Click "New Game".
---------------------------------------------------------

---------------------------------------------------------
8. How to save a current progress of the game:
	a. Make sure that the current round is ended.
	b. Click "Game" button from game menu.
	c. Click "Save" button.
	d. Choose a directory to save the progress.
---------------------------------------------------------

---------------------------------------------------------
9. How to continue a game:
	a. Click "Game" button from game menu.
	b. Click "Continue previous game" button.
	c. Select the file of the progress to continue.
	d. Once the progress is loaded, open a card and continue playing. The turn will be shown in the info box after the card is drawn.
---------------------------------------------------------

---------------------------------------------------------
10. How to exit the game:
	a. Click "About" button from game menu.
	b. Click "Exit game" button.
	c. NOTICE THIS CANNOT BE UNDONE
---------------------------------------------------------

Notice that new game also begins everytime you open the game.

Enjoy :)
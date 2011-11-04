package Controller;

import java.util.Stack;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import Model.Game;
import Model.Square;
import View.GameButton;
import View.GameWindow;

public class GameController {

	private Game game;
	private GameWindow gameWindow;

	// public Vector myGameField;
	// public Vector communicates with Game by ID, with Fields by X,Y
	// coordinates;
	// public GameWindow window asks for Gameproperties after beeing created;

	GameController(Game game) {
		this.game = game;
		Integer sizeX = game.getSizeX();
		Integer sizeY = game.getSizeY();
		this.gameWindow = new GameWindow(this, "Spielfenster", sizeX, sizeY);
	}

	public void SquareEventLeftClick(GameButton gameButton, Boolean LeftClick) {
		Integer x = gameButton.getThisX();
		Integer y = gameButton.getThisY();		
		Square clickedSquare = game.getSquareAt(x, y);
		if (LeftClick) {
			game.invokeSquare(clickedSquare);
			clickedSquare = game.getSquareAt(x, y);
			updateView();
		} else {
			game.setOrUnsetFlag(clickedSquare);
			clickedSquare = game.getSquareAt(x, y);
			updateFlag(clickedSquare);
		}
		
	}

	private void updateView() {
		if (game.isWon()) {
			sieg();
		} else if (game.isLost()) {
			niederlage();
		} else {
			Stack<Square> changedSquares = game.getChanges();
			System.out.println(!changedSquares.empty());
			while(!changedSquares.empty()) {
				Square square = changedSquares.pop();
				Integer x = square.getThisX();
				Integer y = square.getThisY();
				GameButton button = gameWindow.getButton(x, y);
				matchAttributes(button, square);
			}
		}
	}
	private void updateFlag(Square square) {
				Integer x = square.getThisX();
				Integer y = square.getThisY();
				GameButton button = gameWindow.getButton(x, y);
				Boolean flaged = square.isFlaged();
				buttonFlagAttribute(button, flaged);
				button.updateUI();
			}

	// Methods to match the button- to the Squareattributes.

	public void matchAttributes(GameButton button, Square square){
	
				String squareText = square.getSquareText();
				openButtonValue(button, squareText);

				Boolean enabled = square.isEnabled();
				buttonClickAbility(button, enabled);
	}
	
	public void openButtonValue(GameButton button, String squareText) {

		if (squareText.equals("m")) {
			button.setIcon((Icon) new ImageIcon("images/mine.gif"));
			button.setText("");

		} else if (squareText.equals(" ")) {
			button.setText(" ");
		} else {
			button.setText(squareText);
		}


	}

	public void buttonClickAbility(GameButton button, Boolean enabled) {
		button.setEnabled(enabled);
	}

	public void buttonFlagAttribute(GameButton button, Boolean flaged) {
		if (flaged) {
			button.setIcon((Icon) new ImageIcon("images/flagge.gif"));
		} else {
			button.setIcon(null);
		}
	}

	public void niederlage() {
		for (GameButton[] buttonX : gameWindow.getButtons()) {
			for (GameButton buttonY : buttonX) {
				buttonY.setEnabled(false);
			}
		}
		gameWindow.youLoseImage();
	}

	public void sieg() {
		for (GameButton[] buttonX : gameWindow.getButtons()) {
			for (GameButton button : buttonX) {
				Integer x = button.getThisX();
				Integer y = button.getThisY();
				matchAttributes(button, game.getSquareAt(x, y));				
			}
		}
		gameWindow.youWinImage();
	}

	public void restartGame() {
		game.setGameArea(false);
		int x=0;
		for (GameButton[] buttonX : gameWindow.getButtons()) {
			int y=0;
			for (GameButton buttonY : buttonX) {
				matchAttributes(buttonY, game.getSquareAt(x, y));
				buttonY.setIcon(null); 
				y++;				
			}
			x++;
		}
		gameWindow.inGameImage();
	}
}

package Model;

import java.util.Collections;
import java.util.Stack;



import Model.GameAdministration;
import Model.Square;

public class Game {

	private Square[][] game;
	private Stack<Boolean> minefield = new Stack<Boolean>();
	private Integer squares;
	private Integer sizeX;
	private Integer sizeY;
	private Integer mines;
	private Integer openSquares = 0;
	private boolean won = false;
	private boolean lost = false;
	private Stack<Square> latestSquaresChanged = new Stack<Square>();



//creates New game	
	
	Game(GameAdministration spielinstanz, String bezeichnung, Integer kantenlaengeX, Integer kantenlaengeY, Integer anzahlMinen) {
		this.sizeY = kantenlaengeY;
		this.sizeX = kantenlaengeX;
		this.squares = kantenlaengeX * kantenlaengeY;
		this.mines = anzahlMinen;
		setGameArea(true);
	}

	
//Creates new Squares and or new Properties for the Squares 
	
	public void setGameArea(Boolean newField) {
		createMinenfield();
		if (newField) {
			game = new Square[sizeX][sizeY];
		}
		for (Integer x = 0; x < sizeX; x++) {
			for (Integer y = 0; y < sizeY; y++) {
				if (newField) {
					game[x][y] = new Square(this, x, y);
					game[x][y].setMine(minefield.pop());				
				} else {
					this.setLost(false);
					this.setWon(false);
					this.openSquares = 0;
					game[x][y].setMine(minefield.pop());
					game[x][y].setEnabled(true);
					game[x][y].setFlaged(false);
					game[x][y].setTested(false);					
					game[x][y].setSurroundingMines(0);
					game[x][y].setSquareText(x+""+y);
				}
			}
		}
	}

//creates shuffled Stack of Mines for a game Area

	public void createMinenfield() {
		for (int i = 0; i < squares; i++) {
			if (i < this.mines) {
				minefield.add(true);
			} else {
				minefield.add(false);
			}
		}
		Collections.shuffle(minefield);
	}
//Actions on Squares	

	public void invokeSquare(Square invokedSquare) {		
		
		if (invokedSquare.isMine()) {
			mineClicked();
		} else {
			invokedSquare.reactOnClick();
			if (!hiddenSquaresLeft()) {
				sieg();
			}
			System.out.println(invokedSquare.getSquareText() + "leftClick");
		}

	}

	public void setOrUnsetFlag(Square affectedSquare) {
		if (affectedSquare.isFlaged()) {
			affectedSquare.setFlaged(false);
		} else if (affectedSquare.isEnabled()) {
			affectedSquare.setFlaged(true);
		}
	}

// Management of Action Results	
	
	public void mineClicked() {
		niederlage();
	}
	public Stack<Square> getChanges() {
		Stack<Square> squares = this.latestSquaresChanged;
		return squares;
	}
	
	public boolean hiddenSquaresLeft() {
		if (this.openSquares >= (this.squares - this.mines)) {
			return false;
		} else
			return true;
	}
	

	
//GameEndings	
	
	public void reset() {
		setGameArea(false);
	}

	public void niederlage() {

		for (Square[] squareX : this.game) {
			for (Square squareY : squareX) {
				squareY.reactOnClick();
			}
		}
		lost = true;
	}

	public void sieg() {

		for (Square[] squareX : this.game) {
			for (Square squareY : squareX) {
				squareY.setEnabled(false);
			}
		}
		won = true;
	}

	
//Getter & Setter	
	
	
	public Square getSquareAt(Integer x, Integer y) {
		return game[x][y];
	}

	public Integer getSizeX() {
		return sizeX;
	}

	public Integer getSizeY() {
		return sizeY;
	}

	public Integer getMines() {
		return mines;
	}

	public void setMines(Integer mines) {
		this.mines = mines;
	}

	public Integer getOpenSquares() {
		return openSquares;
	}

	public void setOpenSquares(Integer openSquares) {
		this.openSquares = openSquares;
	}

	public void addToChangedSquares(Square square) {
		this.latestSquaresChanged.add(square);
	}

	public boolean isWon() {
		return won;
	}

	public void setWon(boolean won) {
		this.won = won;
	}

	public boolean isLost() {
		return lost;
	}

	public void setLost(boolean lost) {
		this.lost = lost;
	}
}
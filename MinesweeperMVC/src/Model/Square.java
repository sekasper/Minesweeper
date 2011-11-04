package Model;

public class Square {
	private boolean mine;
	private Integer surroundingMines = 0;	
	private Integer thisX;
	private Integer thisY;
	private Game game;	
	private boolean tested;
	private boolean enabled;
	private boolean flaged;
	private String squareText;
	
	public Square(Game game, Integer x, Integer y) {
		tested = false;
		enabled = true;
		flaged = false;		
		this.thisX = x;
		this.thisY = y;
		this.game = game;
		this.squareText = this.thisY+""+this.thisX;
		System.out.println(this.thisY+""+this.thisX);
	}

	public String check(boolean durchLeeresFeldAufgerufen) {
		if (this.mine == true) {
			return "m";
		} else {
			getChecked(durchLeeresFeldAufgerufen);
			if (this.surroundingMines == 0) {
				if (durchLeeresFeldAufgerufen) {
					this.check(false);
				}
				if (!durchLeeresFeldAufgerufen && this.isEnabled()) {
					this.reactOnClick();
				}
				return " ";
			} else {
				return this.surroundingMines.toString();
			}

		}

	}




	// Exemplarmethoden

	
	public void reactOnClick() {
		this.setEnabled(false);		
		String squareText = this.check(true);
		this.setSquareText(squareText);
		this.game.addToChangedSquares(this);
		this.game.setOpenSquares(this.game.getOpenSquares()+1);
	}
	
	public void getChecked(boolean aufrufDurchKlick) {
		for (Integer x = -1; x < 2; x++) {
			for (Integer y = -1; y < 2; y++) {
				if (!(x == 0 && y == 0)) {
					Integer getAtX = this.thisX + x;
					Integer getAtY = this.thisY + y;
					if(game.getSizeX()>getAtX && getAtX>=0 && game.getSizeY()>getAtY && getAtY>=0 ) {
						Square untersuchtesFeld = game.getSquareAt(getAtX,
								getAtY);
						if (untersuchtesFeld.isMine() == true && this.tested ==false) {
							this.surroundingMines = this.surroundingMines + 1;
						} else if (!aufrufDurchKlick && this.surroundingMines.equals(0) && this.tested){
								if(untersuchtesFeld.isMine() == false && untersuchtesFeld.isEnabled()==true && untersuchtesFeld.isTested() == false){
									untersuchtesFeld.reactOnClick();
							}
						}
					}
				}
			}
		}
		this.tested = true;
	}

	public boolean isMine() {
		return this.mine;
	}



	public void setMine(boolean mine) {
		this.mine = mine;
	}



	public Integer getThisX() {
		return this.thisX;
	}



	public void setThisX(Integer thisX) {
		this.thisX = thisX;
	}



	public Integer getThisY() {
		return this.thisY;
	}



	public void setThisY(Integer thisY) {
		this.thisY = thisY;
	}



	public boolean isTested() {
		return tested;
	}



	public void setTested(boolean tested) {
		this.tested = tested;
	}



	public boolean isEnabled() {
		return enabled;
	}



	public void setEnabled(boolean e) {
		this.enabled = e;
	}



	public boolean isFlaged() {
		return flaged;
	}



	public void setFlaged(boolean flaged) {
		this.flaged = flaged;
	}



	public String getSquareText() {
		return squareText;
	}



	public Integer getSurroundingMines() {
		return surroundingMines;
	}



	public void setSurroundingMines(Integer surroundingMines) {
		this.surroundingMines = surroundingMines;
	}



	public void setSquareText(String squareText) {
		this.squareText = squareText;
	}

}
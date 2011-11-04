package View;
import javax.swing.AbstractButton;
import javax.swing.JButton;

import Controller.GameController;

public class GameButton extends JButton{
/**
	 * 
	 */
private static final long serialVersionUID = 1L;
private Integer thisX;
private Integer thisY;
private String buttonText = this.thisX +""+ this.thisY;

	
	GameButton( Integer x, Integer y) {
		super(x+""+y);
		this.thisX = x;
		this.thisY = y;
		this.setVerticalTextPosition(AbstractButton.CENTER);
		this.setHorizontalTextPosition(AbstractButton.RIGHT);
		this.setEnabled(true);
		this.setActionCommand(this.buttonText);
	}


	public Integer getThisX() {
		return thisX;
	}


	public void setThisX(Integer thisX) {
		this.thisX = thisX;
	}


	public Integer getThisY() {
		return thisY;
	}


	public void setThisY(Integer thisY) {
		this.thisY = thisY;
	}


	public void listenerWithController(GameController gameContr) {
		this.addMouseListener(new GameButtonListener(gameContr));
	}



}
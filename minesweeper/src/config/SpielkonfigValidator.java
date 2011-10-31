/**
 * 
 */
package config;

/**
 * @author seka
 *
 */
public class SpielkonfigValidator {
	public static boolean validateKantenlaengeX(Integer kanteX) {
		if(kanteX>10 || kanteX<4){
			return false;
		}
		else return true;
	}
	public static boolean validateKantenlaengeY(Integer kanteY){
		if(kanteY>10 || kanteY<4){
			return false;
		}
		else return true;
	}
	public static boolean validateMinenanzahl(Integer Minananzahl, Integer kanteX, Integer kanteY){
		if(Minananzahl == 0|| Minananzahl>(kanteX *kanteY)){
			return false;
		}
		else return true;
	}
	
}

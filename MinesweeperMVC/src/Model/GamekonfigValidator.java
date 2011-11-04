/**
 * 
 */
package Model;

/**
 * @author seka
 *
 */
public class GamekonfigValidator {
	public static boolean validateKantenlaenge(Integer kante) {
		if(kante>=20 || kante<4){//evl eigene Klasse für Wertegrenzen (in Verbindung mit dem IGamekonfig)
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

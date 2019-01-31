package projPuissance4;

import java.io.*;

/**
 * Classe permettant de g�rer les entr�es clavier dans le projet (notamment en mode d'affichage
 * console), pour ne pas avoir � �crire de lourdes m�thodes dans les contr�leurs d�j�
 * suffisamment charg�s
 * Elle efface aussi les erreurs
 * 
 * @author Ewald
 *
 */
public class ClavierReader {
	private static BufferedReader mybr=new BufferedReader(new InputStreamReader(System.in));

	/**
	 * M�thode permettant de r�cup�rer le caract�re saisi par l'utilisateur
	 * 
	 * @return le caract�re en question
	 */
	public static char getChar() {
		return getString().charAt(0);
	}

	/**
	 * M�thode permettant de r�cup�rer le tableau de caract�res saisi par l'utilisateur
	 * Utile pour un code par exemple
	 * 
	 * @return le tableau de caract�res en question
	 */
	public static char[] getChars() {
		String s = getString();
		return s.toCharArray();
	}
				
	/**
	 * M�thode permettant de r�cup�rer la cha�ne saisie par l'utilisateur
	 * 
	 * @return la cha�ne en question
	 */
	public static String getString() {
		return getLine();
	}
		
	/**
	 * M�thode permettant de r�cup�rer l'entier saisi par l'utilisateur
	 * 
	 * @return l'entier en question
	 */
	public static int getInt() {
		try{
			return Integer.parseInt(getLine());
		} catch(NumberFormatException e) { return -1;}
	}
	
	/**
	 * Permet de faire une pause dans la demande de caract�re
	 */
	public static void pause() {
		try{
			mybr.read();
		} catch(IOException e) {}
	}

	/**
	 * Permet de r�cup�rer la ligne compl�te saisie par l'utilisateur
	 * 
	 * @return toute la ligne
	 */
	private static String getLine() {
		String line;
		try{
			line = mybr.readLine();
		} catch(IOException e) { return "";}
		return line;
	}
}

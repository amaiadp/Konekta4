package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.Jokalaria;
import model.Jokoa;
import model.Ordenagailua;
import model.Tablero;

public class OrdenagailuaTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		//komentatu graifkarekin loturak
		
		Jokoa j = Jokoa.getNireJokoa();
		j.hasieratuZaila();
		Jokalaria jokalari = j.lortuJokalaria();
		Tablero t = Tablero.getNireTablero();
		j.txandaGehitu();
		Ordenagailua o = (Ordenagailua) j.lortuJokalaria();
		

		//Jokalariak 4
		//Horizontal erdian
		t.setTablero(5, 1, jokalari.getFitxa());
		t.setTablero(5, 3, jokalari.getFitxa());
		jokalari.fitxaSartu(4);
		
		assertNull(t.getNorena(5, 2));		
		/** ordenagailuaren hurrengoa = X
		 *  +---+---+---+---+---+---+---+---+---+
			|   |   |   |   |   |   |   |   |   |
			+---+---+---+---+---+---+---+---+---+
			|   |   |   |   |   |   |   |   |   |
			+---+---+---+---+---+---+---+---+---+
			|   |   |   |   |   |   |   |   |   |
			+---+---+---+---+---+---+---+---+---+
			|   |   |   |   |   |   |   |   |   |
			+---+---+---+---+---+---+---+---+---+
			|   |   |   |   |   |   |   |   |   |
			+---+---+---+---+---+---+---+---+---+
			|   | J | X | J | J |   |   |   |   |
			+---+---+---+---+---+---+---+---+---+
		 */
		o.jokatuZaila();
		assertEquals(o.getFitxa(),t.getNorena(5, 2));
		
		
		//Horizontal erdian
		t.setTablero(5, 3, null);
		t.setTablero(5, 2, null);
		jokalari.fitxaSartu(3);
		
		assertNull(t.getNorena(5, 2));		
		/** ordenagailuaren hurrengoa = X
		 *  +---+---+---+---+---+---+---+---+---+
			|   |   |   |   |   |   |   |   |   |
			+---+---+---+---+---+---+---+---+---+
			|   |   |   |   |   |   |   |   |   |
			+---+---+---+---+---+---+---+---+---+
			|   |   |   |   |   |   |   |   |   |
			+---+---+---+---+---+---+---+---+---+
			|   |   |   |   |   |   |   |   |   |
			+---+---+---+---+---+---+---+---+---+
			|   |   |   |   |   |   |   |   |   |
			+---+---+---+---+---+---+---+---+---+
			|   | J | X | J | J |   |   |   |   |
			+---+---+---+---+---+---+---+---+---+
		 */
		o.jokatuZaila();
		assertEquals(o.getFitxa(),t.getNorena(5, 2));
		
		
		
		
		
		//Horizontal erdian
		t.setTablero(5, 1, null);
		t.setTablero(5, 2, null);
		t.setTablero(5, 4, jokalari.getFitxa());
		t.setTablero(5, 3, jokalari.getFitxa());
		jokalari.fitxaSartu(1);
		
		assertNull(t.getNorena(5, 2));		
		/** ordenagailuaren hurrengoa = X
		 *  +---+---+---+---+---+---+---+---+---+
			|   |   |   |   |   |   |   |   |   |
			+---+---+---+---+---+---+---+---+---+
			|   |   |   |   |   |   |   |   |   |
			+---+---+---+---+---+---+---+---+---+
			|   |   |   |   |   |   |   |   |   |
			+---+---+---+---+---+---+---+---+---+
			|   |   |   |   |   |   |   |   |   |
			+---+---+---+---+---+---+---+---+---+
			|   |   |   |   |   |   |   |   |   |
			+---+---+---+---+---+---+---+---+---+
			|   | J | X | J | J |   |   |   |   |
			+---+---+---+---+---+---+---+---+---+
		 */
		o.jokatuZaila();
		assertEquals(o.getFitxa(),t.getNorena(5, 2));
		
		//bertikal
		
		jokalari.fitxaSartu(3);
		jokalari.fitxaSartu(3);
		assertNull(t.getNorena(2, 3));		
		
		/** ordenagailuaren hurrengoa = X
		 *  +---+---+---+---+---+---+---+---+---+
			|   |   |   |   |   |   |   |   |   |
			+---+---+---+---+---+---+---+---+---+
			|   |   |   |   |   |   |   |   |   |
			+---+---+---+---+---+---+---+---+---+
			|   |   |   | X |   |   |   |   |   |
			+---+---+---+---+---+---+---+---+---+
			|   |   |   | J |   |   |   |   |   |
			+---+---+---+---+---+---+---+---+---+
			|   |   |   | J |   |   |   |   |   |
			+---+---+---+---+---+---+---+---+---+
			|   | J | O | J | J |   |   |   |   |
			+---+---+---+---+---+---+---+---+---+
		 */
		
		o.jokatuZaila();
		assertEquals(o.getFitxa(),t.getNorena(2, 3));
		
		//diagonal ezker goi erdian
		t.setTablero(4, 1, o.getFitxa());
		t.setTablero(3, 1, o.getFitxa());
		t.setTablero(4, 2, o.getFitxa());
		jokalari.fitxaSartu(1);
		assertNull(t.getNorena(3, 2));		
		
		/** ordenagailuaren hurrengoa = X
		 *  +---+---+---+---+---+---+---+---+---+
			|   |   |   |   |   |   |   |   |   |
			+---+---+---+---+---+---+---+---+---+
			|   |   |   |   |   |   |   |   |   |
			+---+---+---+---+---+---+---+---+---+
			|   | J |   | O |   |   |   |   |   |
			+---+---+---+---+---+---+---+---+---+
			|   | O | X | J |   |   |   |   |   |
			+---+---+---+---+---+---+---+---+---+
			|   | O | O | J |   |   |   |   |   |
			+---+---+---+---+---+---+---+---+---+
			|   | J | O | J | J |   |   |   |   |
			+---+---+---+---+---+---+---+---+---+
		 */
		t.inprimatu();
				
		o.jokatuZaila();
		assertEquals(o.getFitxa(),t.getNorena(3, 2));
		
		//Ordenagailuak 4 diagonalean
		assertNull(t.getNorena(5, 0));		
		
		/** ordenagailuaren hurrengoa = X
		 *  +---+---+---+---+---+---+---+---+---+
			|   |   |   |   |   |   |   |   |   |
			+---+---+---+---+---+---+---+---+---+
			|   |   |   |   |   |   |   |   |   |
			+---+---+---+---+---+---+---+---+---+
			|   | J |   | O |   |   |   |   |   |
			+---+---+---+---+---+---+---+---+---+
			|   | O | O | J |   |   |   |   |   |
			+---+---+---+---+---+---+---+---+---+
			|   | O | O | J |   |   |   |   |   |
			+---+---+---+---+---+---+---+---+---+
			| X | J | O | J | J |   |   |   |   |
			+---+---+---+---+---+---+---+---+---+
		 */
				
		o.jokatuZaila();
		assertEquals(o.getFitxa(),t.getNorena(5, 0));
		
		//Ordenagailuak 4 bertikalean
		assertNull(t.getNorena(2, 2));		
		
		/** ordenagailuaren hurrengoa = X
		 *  +---+---+---+---+---+---+---+---+---+
			|   |   |   |   |   |   |   |   |   |
			+---+---+---+---+---+---+---+---+---+
			|   |   |   |   |   |   |   |   |   |
			+---+---+---+---+---+---+---+---+---+
			|   | J | X | O |   |   |   |   |   |
			+---+---+---+---+---+---+---+---+---+
			|   | O | O | J |   |   |   |   |   |
			+---+---+---+---+---+---+---+---+---+
			|   | O | O | J |   |   |   |   |   |
			+---+---+---+---+---+---+---+---+---+
			| O | J | O | J | J |   |   |   |   |
			+---+---+---+---+---+---+---+---+---+
		 */
				
		o.jokatuZaila();
		assertEquals(o.getFitxa(),t.getNorena(2, 2));
		
		//TABLEROA HUSTU
		t.hasieratu();
		t = Tablero.getNireTablero();
		
		//Ordenagailuak 4 diagonalean
		t.setTablero(5, 8, jokalari.getFitxa());
		t.setTablero(4, 8, jokalari.getFitxa());
		t.setTablero(3, 8, jokalari.getFitxa());
		t.setTablero(2, 8, o.getFitxa());
		t.setTablero(5, 7, jokalari.getFitxa());
		t.setTablero(4, 7, jokalari.getFitxa());
		t.setTablero(5, 6, jokalari.getFitxa());
		t.setTablero(4, 6, o.getFitxa());
		
		jokalari.fitxaSartu(4);
		
		assertNull(t.getNorena(5, 5));
		assertNull(t.getNorena(3, 7));
		
		/** ordenagailuaren hurrengoa = X
		 * 						  Y
		 *  +---+---+---+---+---+---+---+---+---+
			|   |   |   |   |   |   |   |   |   |
			+---+---+---+---+---+---+---+---+---+
			|   |   |   |   |   |   |   |   |   |
			+---+---+---+---+---+---+---+---+---+
			|   |   |   |   |   |   |   |   | O |
			+---+---+---+---+---+---+---+---+---+
			|   |   |   |   |   |   |   | X | J |
			+---+---+---+---+---+---+---+---+---+
			|   |   |   |   |   |   | O | J | J |
			+---+---+---+---+---+---+---+---+---+
			|   |   |   |   | J | O | J | J | J |
			+---+---+---+---+---+---+---+---+---+
		 */
				
		o.jokatuZaila();
		assertEquals(o.getFitxa(),t.getNorena(5, 5));
		o.jokatuZaila();
		assertEquals(o.getFitxa(),t.getNorena(3, 7));
		
		//Ordenagailuak 4 diagonalean
		t.setTablero(4, 6, null);
		t.setTablero(3, 7, null);
		
		jokalari.fitxaSartu(5);
		
		assertNull(t.getNorena(4, 6));
		assertNull(t.getNorena(3, 7));
		
		/** ordenagailuaren hurrengoa = X
		 * 						  	  Y
		 *  +---+---+---+---+---+---+---+---+---+
			|   |   |   |   |   |   |   |   |   |
			+---+---+---+---+---+---+---+---+---+
			|   |   |   |   |   |   |   |   |   |
			+---+---+---+---+---+---+---+---+---+
			|   |   |   |   |   |   |   |   | O |
			+---+---+---+---+---+---+---+---+---+
			|   |   |   |   |   |   |   | X | J |
			+---+---+---+---+---+---+---+---+---+
			|   |   |   |   |   | J | O | J | J |
			+---+---+---+---+---+---+---+---+---+
			|   |   |   |   | J | O | J | J | J |
			+---+---+---+---+---+---+---+---+---+
		 */
				
		o.jokatuZaila();
		assertEquals(o.getFitxa(),t.getNorena(4, 6));
		o.jokatuZaila();
		assertEquals(o.getFitxa(),t.getNorena(3, 7));
		
		
		//Ordenagailuak 4 diagonalean
		t.setTablero(2, 8, null);
		t.setTablero(3, 7, null);
		t.setTablero(3, 8, null);
		
		jokalari.fitxaSartu(8);
		
		assertNull(t.getNorena(3, 7));
		assertNull(t.getNorena(2, 8));
	
		
		/** ordenagailuaren hurrengoa = X
		 * 						  			  Y
		 *  +---+---+---+---+---+---+---+---+---+
			|   |   |   |   |   |   |   |   |   |
			+---+---+---+---+---+---+---+---+---+
			|   |   |   |   |   |   |   |   |   |
			+---+---+---+---+---+---+---+---+---+
			|   |   |   |   |   |   |   |   | O |
			+---+---+---+---+---+---+---+---+---+
			|   |   |   |   |   |   |   | X | J |
			+---+---+---+---+---+---+---+---+---+
			|   |   |   |   |   | J | O | J | J |
			+---+---+---+---+---+---+---+---+---+
			|   |   |   |   | J | O | J | J | J |
			+---+---+---+---+---+---+---+---+---+
		 */
				
		
		o.jokatuZaila();
		assertEquals(o.getFitxa(),t.getNorena(2, 8));
		o.jokatuZaila();
		assertEquals(o.getFitxa(),t.getNorena(3, 7));
		
		//Jokalariak 4
		//Horizontal erdian
		t = t.hasieratu();
		
		t.setTablero(5, 1, jokalari.getFitxa());
		t.setTablero(5, 2, jokalari.getFitxa());
		t.setTablero(5, 6, jokalari.getFitxa());
		jokalari.fitxaSartu(4);
		
		assertNull(t.getNorena(5, 3));
		assertNull(t.getNorena(5, 5));
		/** ordenagailuaren hurrengoa = X
		 *  +---+---+---+---+---+---+---+---+---+
			|   |   |   |   |   |   |   |   |   |
			+---+---+---+---+---+---+---+---+---+
			|   |   |   |   |   |   |   |   |   |
			+---+---+---+---+---+---+---+---+---+
			|   |   |   |   |   |   |   |   |   |
			+---+---+---+---+---+---+---+---+---+
			|   |   |   |   |   |   |   |   |   |
			+---+---+---+---+---+---+---+---+---+
			|   |   |   |   |   |   |   |   |   |
			+---+---+---+---+---+---+---+---+---+
			|   | J | J | X | J |   | J |   |   |
			+---+---+---+---+---+---+---+---+---+
		 */
		o.jokatuZaila();
		assertNull(t.getNorena(5, 5));
		assertEquals(o.getFitxa(),t.getNorena(5, 3));
		
		//horizontal 2 hutsune
		t.setTablero(5, 3, null);
		t.setTablero(5, 7, jokalari.getFitxa());
		t.setTablero(5, 4, null);
		jokalari.fitxaSartu(4);
		
		assertNull(t.getNorena(5, 3));
		assertNull(t.getNorena(5, 5));
		/** ordenagailuaren hurrengoa = X
		 *  +---+---+---+---+---+---+---+---+---+
			|   |   |   |   |   |   |   |   |   |
			+---+---+---+---+---+---+---+---+---+
			|   |   |   |   |   |   |   |   |   |
			+---+---+---+---+---+---+---+---+---+
			|   |   |   |   |   |   |   |   |   |
			+---+---+---+---+---+---+---+---+---+
			|   |   |   |   |   |   |   |   |   |
			+---+---+---+---+---+---+---+---+---+
			|   |   |   |   |   |   |   |   |   |
			+---+---+---+---+---+---+---+---+---+
			|   | J | J |X2 | J | X | J | J |   |
			+---+---+---+---+---+---+---+---+---+
		 */
		o.jokatuZaila();
		assertNull(t.getNorena(5, 3));
		assertEquals(o.getFitxa(),t.getNorena(5, 5));
		o.jokatuZaila();
		assertEquals(o.getFitxa(),t.getNorena(5, 3));
		
		//diagonal
		t.setTablero(5, 0, jokalari.getFitxa());
		t.setTablero(4, 1, o.getFitxa());
		t.setTablero(4, 2, o.getFitxa());
		t.setTablero(5, 1, o.getFitxa());
		t.setTablero(4, 0, jokalari.getFitxa());
		t.setTablero(3, 0, o.getFitxa());
		t.setTablero(3, 1, jokalari.getFitxa());
		t.setTablero(2, 0, o.getFitxa());
				//diagonala prestatu
		t.setTablero(4, 3, jokalari.getFitxa());
		jokalari.fitxaSartu(1);
		
		assertNull(t.getNorena(3, 2));
		/** ordenagailuaren hurrengoa = X
		 * 		  Y
		 *  +---+---+---+---+---+---+---+---+---+
			|   |   |   |   |   |   |   |   |   |
			+---+---+---+---+---+---+---+---+---+
			|   |   |   |   |   |   |   |   |   |
			+---+---+---+---+---+---+---+---+---+
			| O | J |   |   |   |   |   |   |   |
			+---+---+---+---+---+---+---+---+---+
			| O | J | X |   |   |   |   |   |   |
			+---+---+---+---+---+---+---+---+---+
			| J | O | O | J |   |   |   |   |   |
			+---+---+---+---+---+---+---+---+---+
			| J | O | J | O | J | O | J | J |   |
			+---+---+---+---+---+---+---+---+---+
		 */
		o.jokatuZaila();
		assertEquals(o.getFitxa(),t.getNorena(3, 2));
		
		//diagonala prestatu
		t.setTablero(3, 2, null);
		t.setTablero(4, 3, null);
		jokalari.fitxaSartu(3);
		
		assertNull(t.getNorena(3, 2));
		/** ordenagailuaren hurrengoa = X
		 * 		  		  Y
		 *  +---+---+---+---+---+---+---+---+---+
			|   |   |   |   |   |   |   |   |   |
			+---+---+---+---+---+---+---+---+---+
			|   |   |   |   |   |   |   |   |   |
			+---+---+---+---+---+---+---+---+---+
			| O | J |   |   |   |   |   |   |   |
			+---+---+---+---+---+---+---+---+---+
			| O | J | X |   |   |   |   |   |   |
			+---+---+---+---+---+---+---+---+---+
			| J | O | O | J |   |   |   |   |   |
			+---+---+---+---+---+---+---+---+---+
			| J | O | J | O | J | O | J | J |   |
			+---+---+---+---+---+---+---+---+---+
		 */
		o.jokatuZaila();
		assertEquals(o.getFitxa(),t.getNorena(3, 2));
		
		
		//diagonala prestatu

		t.setTablero(3, 2, null);
		t.setTablero(5, 4, null);
		jokalari.fitxaSartu(4);
		
		assertNull(t.getNorena(3, 2));
		/** ordenagailuaren hurrengoa = X
		 * 		  			  Y
		 *  +---+---+---+---+---+---+---+---+---+
			|   |   |   |   |   |   |   |   |   |
			+---+---+---+---+---+---+---+---+---+
			|   |   |   |   |   |   |   |   |   |
			+---+---+---+---+---+---+---+---+---+
			| O | J |   |   |   |   |   |   |   |
			+---+---+---+---+---+---+---+---+---+
			| O | J | X |   |   |   |   |   |   |
			+---+---+---+---+---+---+---+---+---+
			| J | O | O | J |   |   |   |   |   |
			+---+---+---+---+---+---+---+---+---+
			| J | O | J | O | J | O | J | J |   |
			+---+---+---+---+---+---+---+---+---+
		 */
		o.jokatuZaila();
		assertEquals(o.getFitxa(),t.getNorena(3, 2));
		
		//diagonala prestatu

		t.setTablero(3, 2, null);
		jokalari.fitxaSartu(0);
		
		assertNull(t.getNorena(3, 2));
		/** ordenagailuaren hurrengoa = X
		 * 	  Y	  			  
		 *  +---+---+---+---+---+---+---+---+---+
			|   |   |   |   |   |   |   |   |   |
			+---+---+---+---+---+---+---+---+---+
			|   |   |   |   |   |   |   |   |   |
			+---+---+---+---+---+---+---+---+---+
			| O | J |   |   |   |   |   |   |   |
			+---+---+---+---+---+---+---+---+---+
			| O | J | X |   |   |   |   |   |   |
			+---+---+---+---+---+---+---+---+---+
			| J | O | O | J |   |   |   |   |   |
			+---+---+---+---+---+---+---+---+---+
			| J | O | J | O | J | O | J | J |   |
			+---+---+---+---+---+---+---+---+---+
		 */
		o.jokatuZaila();
		assertEquals(o.getFitxa(),t.getNorena(3, 2));
		
		
		//hurrengoak jokalariak 4ez, 	tablero ia bete
		j.hasieratuZaila();
		j = Jokoa.getNireJokoa();
		jokalari = j.lortuJokalaria();
		j.txandaGehitu();
		o = (Ordenagailua) j.lortuJokalaria();
		t= Tablero.getNireTablero();

		t.setTablero(5, 0, jokalari.getFitxa());
		t.setTablero(4, 0, jokalari.getFitxa());
		t.setTablero(3, 0, o.getFitxa());
		t.setTablero(2, 0, o.getFitxa());
		t.setTablero(1, 0, jokalari.getFitxa());
		t.setTablero(0, 0, jokalari.getFitxa());
		t.setTablero(5, 1, o.getFitxa());
		t.setTablero(4, 1, o.getFitxa());
		t.setTablero(3, 1, jokalari.getFitxa());
		t.setTablero(2, 1, jokalari.getFitxa());
		t.setTablero(1, 1, o.getFitxa());
		t.setTablero(0, 1, jokalari.getFitxa());
		t.setTablero(5, 2, jokalari.getFitxa());
		t.setTablero(4, 2, o.getFitxa());
		t.setTablero(3, 2, o.getFitxa());
		t.setTablero(2, 2, jokalari.getFitxa());
		t.setTablero(5, 3, o.getFitxa());
		t.setTablero(4, 3, jokalari.getFitxa());
		t.setTablero(3, 3, jokalari.getFitxa());
		t.setTablero(2, 3, o.getFitxa());
		t.setTablero(1, 3, o.getFitxa());
		t.setTablero(5, 4, jokalari.getFitxa());
		t.setTablero(4, 4, jokalari.getFitxa());
		t.setTablero(3, 4, o.getFitxa());
		t.setTablero(2, 4, jokalari.getFitxa());
		t.setTablero(1, 4, jokalari.getFitxa());
		t.setTablero(0, 4, o.getFitxa());
		t.setTablero(5, 5, o.getFitxa());
		t.setTablero(4, 5, jokalari.getFitxa());
		t.setTablero(3, 5, o.getFitxa());
		t.setTablero(2, 5, o.getFitxa());
		t.setTablero(1, 5, o.getFitxa());
		t.setTablero(0, 5, jokalari.getFitxa());
		t.setTablero(5, 6, jokalari.getFitxa());
		t.setTablero(4, 6, o.getFitxa());
		t.setTablero(3, 6, jokalari.getFitxa());
		t.setTablero(2, 6, o.getFitxa());
		t.setTablero(1, 6, jokalari.getFitxa());
		t.setTablero(0, 6, o.getFitxa());
		t.setTablero(5, 7, jokalari.getFitxa());
		t.setTablero(4, 7, o.getFitxa());
		t.setTablero(3, 7, jokalari.getFitxa());
		t.setTablero(2, 7, jokalari.getFitxa());
		t.setTablero(1, 7, o.getFitxa());
		t.setTablero(0, 7, jokalari.getFitxa());
		
		jokalari.fitxaSartu(3);
		
		assertNull(t.getNorena(0, 2));
		assertNull(t.getNorena(1, 2));
		assertNull(t.getNorena(5, 8));
		assertNull(t.getNorena(4, 8));
		assertNull(t.getNorena(3, 8));
		/** ordenagailuaren hurrengoa = X
		 * 	  			  Y	  			  	  X
		 *  +---+---+---+---+---+---+---+---+---+
			| J | J |   | J | O | J | O | J |   |
			+---+---+---+---+---+---+---+---+---+
			| J | O |   | O | J | O | J | O |   |
			+---+---+---+---+---+---+---+---+---+
			| O | J | J | O | J | O | O | J |   |
			+---+---+---+---+---+---+---+---+---+
			| O | J | O | J | O | O | J | J |   |
			+---+---+---+---+---+---+---+---+---+
			| J | O | O | J | J | J | O | O |   |
			+---+---+---+---+---+---+---+---+---+
			| J | O | J | O | J | O | J | J |   |
			+---+---+---+---+---+---+---+---+---+
		 */
		o.jokatuZaila();
		assertEquals(o.getFitxa(),t.getNorena(5, 8));
		assertNull(t.getNorena(0, 2));
		assertNull(t.getNorena(1, 2));
		assertNull(t.getNorena(4, 8));
		assertNull(t.getNorena(3, 8));
		o.jokatuZaila();
		assertEquals(o.getFitxa(),t.getNorena(5, 8));
		assertEquals(o.getFitxa(),t.getNorena(4, 8));
		assertNull(t.getNorena(0, 2));
		assertNull(t.getNorena(1, 2));
		assertNull(t.getNorena(3, 8));
		o.jokatuZaila();
		assertEquals(o.getFitxa(),t.getNorena(5, 8));
		assertEquals(o.getFitxa(),t.getNorena(4, 8));
		assertEquals(o.getFitxa(),t.getNorena(3, 8));
		assertNull(t.getNorena(0, 2));
		assertNull(t.getNorena(1, 2));
		
		
	}

}

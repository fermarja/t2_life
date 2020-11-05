package es.jcyl.cag.cursotesting.life;

import org.junit.Assert;
import org.junit.Test;

public class LifeTest {

	private static final boolean TRUE = true;
	
	public LifeTest() {
		super();
	}
	
	@Test
	public void testTodoMuertoSigueMuerto() {
		Life life = new Life(10);
		life.calcularNuevoCiclo();
		Assert.assertEquals(0, life.getContadorCelulasVivas());	
	}
	@Test
	public void inicializaTodoAMuerto() {
		Life life = new Life(10);
		Assert.assertEquals(0, life.getContadorCelulasVivas());		
	}
	
	@Test
	public void inicializaTodoAMuertoCheckIndividual() {
		Life life = new Life(10);
		Assert.assertFalse(life.estaViva(5, 5));
	}
	
	@Test
	public void mantieneElTableroInicial() {
		Life life = new Life(new boolean[][]{
			{false, false, false},
			{false, TRUE,  false},
			{false, false, false}
		});
		Assert.assertEquals(1, life.getContadorCelulasVivas());
		Assert.assertTrue(life.estaViva(1, 1));
	}
}


package es.jcyl.cag.cursotesting.life;

import org.junit.Assert;
import org.junit.Test;

public class LifeTest {

	public LifeTest() {
		super();
	}
	
	@Test
	public void testTodoMuertoSigueMuerto() {
		Life life = new Life(10);
		life.calcularNuevoCiclo();
		Assert.assertEquals(0, life.getCelulasVivas());	
	}
	@Test
	public void inicializaTodoAMuerto() {
		Life life = new Life(10);
		Assert.assertEquals(0, life.getCelulasVivas());		
	}
	
	@Test
	public void inicializaTodoAMuertoCheckIndividual() {
		Life life = new Life(10);
		Assert.assertFalse(life.estaViva(5, 5));
	}
}

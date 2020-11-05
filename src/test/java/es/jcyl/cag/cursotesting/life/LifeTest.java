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
	
	@Test
	public void muereSiEstaSola() {
		Life life = new Life(new boolean[][]{
			{false, false, false},
			{false, TRUE,  false},
			{false, false, false}
		});
		life.calcularNuevoCiclo();
		Assert.assertEquals(0, life.getContadorCelulasVivas());
	}
	
	@Test
	public void reviveConTresVecinos() {
		Life life = new Life(new boolean[][]{
			{TRUE, TRUE, TRUE},
			{false, false,  false},
			{false, false, false}
		});
		life.calcularNuevoCiclo();
		Assert.assertTrue(life.estaViva(1, 1));
	}
	
	@Test
	public void sigueVivaConDosVecinos() {
		Life life = new Life(new boolean[][]{
			{TRUE, false, TRUE},
			{false, TRUE,  false},
			{false, false, false}
		});
		life.calcularNuevoCiclo();
		Assert.assertTrue(life.estaViva(1, 1));
	}
	
	@Test
	public void sigueVivaConTresVecinos() {
		Life life = new Life(new boolean[][]{
			{TRUE, TRUE, TRUE},
			{false, TRUE,  false},
			{false, false, false}
		});
		life.calcularNuevoCiclo();
		Assert.assertTrue(life.estaViva(1, 1));
	}
	
	
	@Test
	public void muereConCuatroVecinos() {
		Life life = new Life(new boolean[][]{
			{TRUE, TRUE, TRUE},
			{false, TRUE,  TRUE},
			{false, false, false}
		});
		life.calcularNuevoCiclo();
		Assert.assertFalse(life.estaViva(1, 1));
	}
	
	
	
}


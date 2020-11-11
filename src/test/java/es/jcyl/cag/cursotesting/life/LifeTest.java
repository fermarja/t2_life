package es.jcyl.cag.cursotesting.life;

import org.junit.Assert;
import org.junit.Test;

import static es.jcyl.cag.cursotesting.life.EstadoVital.MUERTA;
import static es.jcyl.cag.cursotesting.life.EstadoVital.VIVA;

public class LifeTest {

	
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
		Assert.assertEquals(MUERTA, life.getEstadoVital(5, 5));
	}
	
	@Test
	public void mantieneElTableroInicial() {
		Life life = new Life(new EstadoVital[][]{
			{MUERTA, MUERTA, MUERTA},
			{MUERTA, VIVA,  MUERTA},
			{MUERTA, MUERTA, MUERTA}
		});
		Assert.assertEquals(1, life.getContadorCelulasVivas());
		Assert.assertTrue(life.estaViva(1, 1));
	}
	
	@Test
	public void muereSiEstaSola() {
		Life life = new Life(new EstadoVital[][]{
			{MUERTA, MUERTA, MUERTA},
			{MUERTA, VIVA,  MUERTA},
			{MUERTA, MUERTA, MUERTA}
		});
		life.calcularNuevoCiclo();
		Assert.assertEquals(0, life.getContadorCelulasVivas());
	}
	
	@Test
	public void reviveConTresVecinos() {
		Life life = new Life(new EstadoVital[][]{
			{VIVA, VIVA, VIVA},
			{MUERTA, MUERTA,  MUERTA},
			{MUERTA, MUERTA, MUERTA}
		});
		life.calcularNuevoCiclo();
		Assert.assertTrue(life.estaViva(1, 1));
	}
	
	@Test
	public void sigueVivaConDosVecinos() {
		Life life = new Life(new EstadoVital[][]{
			{VIVA, MUERTA, VIVA},
			{MUERTA, VIVA,  MUERTA},
			{MUERTA, MUERTA, MUERTA}
		});
		life.calcularNuevoCiclo();
		Assert.assertTrue(life.estaViva(1, 1));
	}
	
	@Test
	public void sigueVivaConTresVecinos() {
		Life life = new Life(new EstadoVital[][]{
			{VIVA, VIVA, VIVA},
			{MUERTA, VIVA,  MUERTA},
			{MUERTA, MUERTA, MUERTA}
		});
		life.calcularNuevoCiclo();
		Assert.assertTrue(life.estaViva(1, 1));
	}
	
	
	@Test
	public void muereConCuatroVecinos() {
		Life life = new Life(new EstadoVital[][]{
			{VIVA, VIVA, VIVA},
			{MUERTA, VIVA,  VIVA},
			{MUERTA, MUERTA, MUERTA}
		});
		life.calcularNuevoCiclo();
		Assert.assertFalse(life.estaViva(1, 1));
	}
	
	
	
}


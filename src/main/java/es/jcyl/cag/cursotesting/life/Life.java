package es.jcyl.cag.cursotesting.life;

public class Life {

	
	private boolean[][] tablero;
	
	public Life() {
		this(10, 10);
	}
	
	public Life(int tamano) {
		this(tamano, tamano);
	}
	
	public Life(int ancho, int alto) {
		super();
		this.tablero = new boolean[ancho][alto];
	}
	
	public Life(boolean[][] tablero) {
		super();
		reemplazarTablero(tablero);
	}
	
	public void calcularNuevoCiclo() {
		
	}
	
	private void reemplazarTablero(boolean[][] nuevo) {
		this.tablero = new boolean[nuevo.length][nuevo[0].length];
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				this.tablero[i][j] = nuevo[i][j];
			}
		}
	}
	
	public int getCelulasVivas() {
		int cantidad = 0;
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				if (tablero[i][j]) {
					cantidad++;
				}
			}
		}
		return cantidad;
	}
	
}

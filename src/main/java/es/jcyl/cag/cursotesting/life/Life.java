package es.jcyl.cag.cursotesting.life;

public class Life {

	
	private EstadoVital[][] tablero;
	
	public Life() {
		this(10, 10);
	}
	
	public Life(int tamano) {
		this(tamano, tamano);
	}
	
	public Life(int ancho, int alto) {
		super();
		this.tablero = new EstadoVital[ancho][alto];
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				this.tablero[i][j] = EstadoVital.MUERTA;
			}
		}
	}
	
	public Life(EstadoVital[][] tablero) {
		super();
		reemplazarTablero(tablero);		
	}
	
	public void calcularNuevoCiclo() {
		EstadoVital[][] nuevo = new EstadoVital[this.tablero.length][this.tablero[0].length];
		for (int i = 0; i < nuevo.length; i++) {
			for (int j = 0; j < nuevo[i].length; j++) {
				nuevo[i][j] = calcularNuevoEstado(i, j);
			}
		}
		reemplazarTablero(nuevo);
	}
	
	private EstadoVital calcularNuevoEstado(int x, int y) {
		boolean viva = estaViva(x, y);
		int vecinos = contarVecinosVivos(x,y);
		
		boolean vivaEnNuevoEstado = true;
		if (viva) {
			vivaEnNuevoEstado = vecinos >= 2 && vecinos <= 3;
		}
		else {
			vivaEnNuevoEstado = vecinos == 3;
		}
		
		if (vivaEnNuevoEstado) {
			return EstadoVital.VIVA;
		}
		else {
			return EstadoVital.MUERTA;
		}
	}
	
	private int contarVecinosVivos(int x, int y) {
		int contador = 0;
		for (int i = x - 1; i <= x+1; i++) {
			for (int j = y-1; j<= y+1; j++) {
				if (i == x && j == y) {
					// No se cuenta a si misma
					continue;
				}
				if (i >= 0 && j >= 0 && i < this.tablero.length && j < this.tablero[i].length) {
					if (estaViva(i, j)) {
						contador++;
					}
				}
			}
		}
		return contador;
	}

	private void reemplazarTablero(EstadoVital[][] nuevo) {
		this.tablero = new EstadoVital[nuevo.length][nuevo[0].length];
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				this.tablero[i][j] = nuevo[i][j];
			}
		}
	}
	
	public boolean estaViva(int x, int y) {
		return getEstadoVital(x, y) == EstadoVital.VIVA;
	}
	
	public EstadoVital getEstadoVital(int x, int y) {
		return this.tablero[x][y];
	}

	public int getContadorCelulasVivas() {
		int cantidad = 0;
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				if (tablero[i][j] == EstadoVital.VIVA) {
					cantidad++;
				}
			}
		}
		return cantidad;
	}
	
}

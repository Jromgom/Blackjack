package juego;

public class jugador {
	
	//Inicializamos los atributos
	private int puntos = 0;
	
	private int tieneAs = 0;
	
	//Añadimos la baraja como un Array
	public static final String[] baraja = {"As","2", "3", "4", "5","6", "7", "8", "9","10", "J", "Q", "K"};
	//Otro Array con el valor de la carta en su misma posición 
	public static final int[] PuntosBaraja = {11,2,3,4,5,6,7,8,9,10,10,10,10};
	
	//Añadimos los gets y sets necesarios
	public int getPuntos() {
		return puntos;
	}
	
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public int getTieneAs() {
		return tieneAs;
	}
	
	public void newAs() {
		tieneAs += 1;
	}
	public void restaAs() {
		puntos -= 10;
		tieneAs -= 1;
	}
	//funcion para Generar la carta aleatoria
	public String generarCarta() {
		
		int aleatorio = (int) (Math.random() * 13); 
		puntos += PuntosBaraja[aleatorio];
		if(aleatorio == 0) {
			tieneAs += 1;
		}
		return baraja[aleatorio];
	}
	
}

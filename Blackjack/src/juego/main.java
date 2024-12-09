package juego;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		//Declaramos todas las variables 
		Scanner Scanner = new Scanner(System.in);
		int salida = 0;
		int eleccion;
		int salida2 = 0;
		int eleccion2;
		int salida3 = 0;
		int puntosCrupier;
		int As;
		int AsCrupier;
		//Explicamos el programa
		System.out.println("Este programa realiza una simulación de una partida de Blackjack contra el crupier");
		System.out.println("cuenta con las funciones y normas básicas del Blackjack");
		System.out.println("");

		do {
			//igualamos las variables de eleccion a 0 para que no falle al volver a inicar una partida
			salida = 0;
			salida2 = 0;
			salida3 = 0;
			As = 0;
			AsCrupier = 0;

			System.out.println("-------------------------------------------");
			System.out.println("Elije una de las siguientes funciones:");
			System.out.println("1 - nueva mano");
			System.out.println("0 - Salir");
			System.out.println("-------------------------------------------");
			//usamos un try para controlar que no se introduzcan letras
			try {
				eleccion = Integer.parseInt(Scanner.nextLine());
	
				switch(eleccion){
	
				case 1:
					//inicializamos los objetos y damos las primeras cartas 
					jugador crupier = new jugador();
					jugador jugador = new jugador();
	
					jugador.setPuntos(0);
					crupier.setPuntos(0);
	
					System.out.println("La primera carta del crupier es: " + crupier.generarCarta());
					System.out.println("");
					System.out.println("Tus cartas iniciales son: " + jugador.generarCarta() + " y " + jugador.generarCarta());
					System.out.println("");
	
					int puntos = jugador.getPuntos();
					//En el primer if vemos si tiene Blackjack con sus 2 primeras cartas
					if(puntos != 21) {
						do {
							puntos = jugador.getPuntos();
							As = jugador.getTieneAs();
							//Añadimos un if para que As cuente como 11 o 1
							if(puntos > 21 && As > 0) {
								puntos -= 10;
								As -= 1;
								jugador.restaAs();
							}
							//Añadimos la opción de pedir nuevas cartas pero solo si tus cartas no suman 21
							if(puntos <= 21) {
								System.out.println("La suma de tus cartas es: " + jugador.getPuntos());
								System.out.println("¿Deseas una nueva carta?");
								System.out.println("1 - Si");
								System.out.println("0 - No");
								eleccion2 = Integer.parseInt(Scanner.nextLine());
								switch(eleccion2){
								case 1:
									System.out.println("La nueva carta es: " + jugador.generarCarta());
									break;
								case 0:
									salida2 = 1;
									break;
								}
							//Si tus cartas superan los 21, pierdes
							}else {
								System.out.println("La suma de tus cartas sobrepasa 21, perdiste la mano");
								salida2 = 1;
							}
						}while(salida2 == 0);
						puntos = jugador.getPuntos();
						//Si no has superado 21 empiezan a salir las cartas del crupier
						if(puntos <= 21 ) {
							do {
								System.out.println("La nueva carta del crupier es: " + crupier.generarCarta());
								puntosCrupier = crupier.getPuntos();
								AsCrupier = crupier.getTieneAs();
								//añadimos un if por si el crupier tiene As
								if(puntosCrupier > 21 && AsCrupier > 0) {
									puntosCrupier -= 10;
									AsCrupier -= 1;
									crupier.restaAs();
								}
								//Si el crupier tiene mayor de 16 deja de coger cartas
								if(puntosCrupier >= 17) {
									salida3 = 1;
								}
							}while(salida3 == 0);
							//Aqui valoramos los puntos y damos los resultados
							if(puntosCrupier > 21) {
								System.out.println("Los puntos del crupier son: " + crupier.getPuntos());
								System.out.println("Las sumas de las cartas del crupier superan 21, ganaste la mano.");
							}else {
								if(puntos > puntosCrupier) {
									System.out.println("Los puntos del crupier son: " + crupier.getPuntos());
									System.out.println("Las sumas de tus cartas superan la del crupier, ganaste la mano");
								}else if(puntos == puntosCrupier) {
									System.out.println("Los puntos del crupier son: " + crupier.getPuntos());
									System.out.println("Las sumas de tus cartas son igual que las del crupier, empataste la mano");
								}else {
									System.out.println("Los puntos del crupier son: " + crupier.getPuntos());
									System.out.println("Las sumas de tus cartas son inferiores que las del crupier, perdiste la mano");
								}
							}
						}
					}else {
						System.out.println("Has conseguido Blackjack, ganaste la mano.");
					}
					break;
					
				case 0:
					salida = 1;
					break;
	
				default: 
					System.out.println("Introduce un número entero válido");
				}
			//cerramos el try para controlar que no se introduzcan letras
			}catch(NumberFormatException e) {
				System.out.println("Introduce un número entero válido");
			}
		}while(salida == 0);
		Scanner.close();
	}
}

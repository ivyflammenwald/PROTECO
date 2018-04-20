/**@author prebe17
@version 1.2
*/


import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.ArrayList;

class EntreCeroEx extends Exception{
	EntreCeroEx(){
		super();
	}
}

class OpcionInvalidaEx extends Exception{
	OpcionInvalidaEx(){
		super();
	}
}

class Calculadora{

	static double suma (double a, double b){
		double x = -9999.9999; // la variable de retorno del metodo debe estar afuera del bloque try, por lo que se denomina este valor como retorno en caso de excepcion
		try{
			x=a+b;
		}catch(Exception e){
			System.out.println("sucedio alguna excepcion, la neta no me preguntes cual");
		}
		return x;
	}

	static double resta (double a, double b){
		double x = -9999.9999; // la variable de retorno del metodo debe estar afuera del bloque try, por lo que se denomina este valor como retorno en caso de excepcion
		try{
			x=a-b;
		}catch(Exception e){
			System.out.println("sucedio una excepcion");
		}
	return x;
	}

	static double multiplicacion (double a, double b){
		double x = -9999.9999; 
		try{
			x=a*b;
		}catch(ArrayIndexOutOfBoundsException aioobe){
			aioobe.printStackTrace();
		}catch(Exception e){
			System.out.println("algo salio mal alv");
		}
		return x;
	}


	static double division(double a, double b){
		double x= -9999.9999;
		try{
			if (b ==0){
			throw new EntreCeroEx();
		}
			x=a/b;
		}catch(EntreCeroEx exe){
			System.out.println("no puedes dividir entre 0");
		}catch(Exception e){
			System.out.println("error");
		}
		return x;
	}
	
}


class Ejercicio8{

	public static void main (String[] args){

		Scanner sc = new Scanner(System.in);
		boolean continuar = true;
		
		
		while(continuar){
			try{
			System.out.println(" ------------------------- ");
			System.out.println("");
			System.out.println("Calculadora de escalares racionales de ivy\n");
			System.out.println(" ingrese una opcion ");
			System.out.println("1) suma");
			System.out.println("2) resta");
			System.out.println("3) multiplicacion");
			System.out.println("4) division");
			System.out.println("5) salir");
			System.out.println("");
			
			int opcion=sc.nextInt();
			System.out.println("");

			switch(opcion){

				case 1: //sumas
					System.out.println("elija dos numeros a sumar");
					double a1 =sc.nextDouble();
					double b1 =sc.nextDouble();
					double c1 = Calculadora.suma(a1, b1);
					System.out.println(a1+" + "+b1+" = "+c1);
					if (c1== (-9999.9999)){
						System.out.println(" el resultado de tu operacion fue -9999.9999, esto puede deberse a que surgio una excepcion o a que ese sea el resultado");
					}
				break;

				case 2: //resta
					System.out.println("elija dos numeros a restar");
					double a2 =sc.nextDouble();
					double b2 =sc.nextDouble();
					double c2 = Calculadora.resta(a2, b2);
					System.out.println(a2+" - "+b2+" = "+c2);
					if (c2== (-9999.9999)){
						System.out.println(" el resultado de tu operacion fue -9999.9999, esto puede deberse a que surgio una excepcion o a que ese sea el resultado");
					}
				break;

				case 3: //multiplicacion
					System.out.println("elija dos numeros a multiplicar");
					double a3 =sc.nextDouble();
					double b3 =sc.nextDouble();
					double c3 = Calculadora.multiplicacion(a3, b3);
					System.out.println(a3+" * "+b3+" = "+c3);
					if (c3== (-9999.9999)){
						System.out.println(" el resultado de tu operacion fue -9999.9999, esto puede deberse a que surgio una excepcion o a que ese sea el resultado");
					}
				break;

				case 4: //division
					System.out.println("elija dos numeros a dividir");
					double a4 =sc.nextDouble();
					double b4 =sc.nextDouble();
					double c4 = Calculadora.division(a4, b4);
					System.out.println(a4+" / "+b4+" = "+c4);
					if (c4== (-9999.9999)){
						System.out.println(" el resultado de tu operacion fue -9999.9999, esto puede deberse a que surgio una excepcion o a que ese sea el resultado");
					}

				break;

				case 5://salir
					System.out.println("has finalizado la aplicacion");
					continuar = false;
				break;

				default:
					throw new OpcionInvalidaEx();

				}
			}catch( OpcionInvalidaEx oie){
				System.out.println(" ingresa una opcion valida 1 - 5");
				continue; 	// para continuar en el ciclo while
			}catch(InputMismatchException imme){
				System.out.println("escribe bien, numeros enteros"); //cae en un loop infinito de impresion, hasta que se detiene la ejecucion del proceso desde terminal
				continue; 
			}
		}
	}
}
import java.util.Scanner;

//este programa solo imprime la configuracion de los bloques, no encontre solucion al problema (no la termine)

public class AlmacenLluvia
{ 
	public static void main(String [] args)
	{
		Scanner teclado = new Scanner(System.in);
		System.out.println("cuantos bloques quieres colocar?");
		int tam = teclado.nextInt();
		int[] bloques = new int[tam];
		System.out.println("indica el arreglo de bloques, de enteros");

		for(int i =0 ; i<tam; i++){
			System.out.println("ingresa el tamaño del bloque numero "+i);
			bloques[i] = teclado.nextInt();
		}
		
		System.out.println("estos son los bloques que insertaste (en orden vertical)");


		for(int i =0 ; i<tam; i++){
			for (int k = 0; k < bloques[i]; k++){
				System.out.print("*");
			}
		System.out.println("");
		}


		int agua;
		for(int i =0 ; i<tam; i++){
			
		}


	}

}
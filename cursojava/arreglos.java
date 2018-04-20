import java.util.Scanner;

public class ArreglosPrubeba{
	public static void main (String[] args){

		System.out.println("programa de arreglos ")
		Scanner teclado = new Scanner(System.in);	
		int arr1[] = new int[5];
		
		for(int i =0; i<arr1.length; i++){
			System.out.println("ingresa el elemetno "+i);
			arr1[i] = teclado.nextInt();
		}

		for(int i =0; i<arr1.length; i++){
			System.out.println("el elemento en "+i+"es "+arr1[i]);
		}	

	}
}

/*

apuntes de la clase



*/
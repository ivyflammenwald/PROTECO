import java.util.Random;
import java.util.Scanner;


public class Dados
{
	public static void main (String[] args)
	{

		Random dado1 = new Random();
		Random dado2 = new Random();
		Scanner sc = new Scanner(System.in);

		System.out.println("ingresa el numero de tiradas");
		int tiradas= sc.nextInt();
		int[] probabilidad= new int [12];
		int tirada;
		
		for (int i=0; i<tiradas; i++){
			int r1 = dado1.nextInt(6);
			int r2 = dado2.nextInt(6);
			tirada= r1+r2;
			probabilidad[tirada]+=1;
			System.out.println("tirada "+i+" salio "+tirada);
		}

		System.out.println("arreglo de probabilidades");

		for(int i = 1; i <= probabilidad.length; i++){
			System.out.println(i+" ");
			for(int k = 0; k<probabilidad[i]; k++ ){
					System.out.print("*");
			}
		}

	}
}

/**@author prebe 17
 Esta es la primer version del programa, que hicimos en clase, utiliza un buffered reader; funciona bien pero arroja una excepcion, 
creoo que es mas eficiente copiar archivos usando imput y output stream con un buffer (arr de byte)
*/

import java.io.FileReader;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;




class CopiarArchivo{
	public static void copy(String rutaor, String rutades){
			try{
				
				File origen = new File(rutaor);
				File destino = new File(rutades);
				FileReader fr   = new FileReader(origen);
				FileWriter fw = new FileWriter(destino);		
				BufferedReader br= new BufferedReader(fr);
				BufferedWriter bw = new BufferedWriter(fw);

				String linea;
				while((linea=br.readLine())!= null){
					System.out.println(linea);
					bw.write(linea);
					bw.write("\n");
				}
				
				fr.close();
				fw.close();
				br.close();
				bw.close();
		}catch(IOException e){
			e.printStackTrace();
		}	
	}
}

class CopiarArch{
	public static void main(String[] args) {
		System.out.println("Ingresa la ruta absoluta del archivo a  copiar");
		Scanner sc = new Scanner(System.in);
		String r1 = sc.nextLine();
		System.out.println("Ingrese la ruta absoluta del destino");
		String r2 = sc.nextLine();
		CopiarArchivo.copy(r1,r2);
		System.out.println("Hecho.");

	}
}

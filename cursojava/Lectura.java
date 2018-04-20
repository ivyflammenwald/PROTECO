import java.io.*;
import java.util.*;

class Leer{
	public void leer(){
		try{
		FileReader fr=new FileReader("/home/ivy/Escritorio/TAREAS");
		char c;
		int caracter;
		while((caracter = fr.read()!= -1)){
			System.out.print((char)(caracter));
		}
		System.out.println("");
		fr.close();
		}catch(IOException e){}
	}
}

class LeerBuffer{
	public void Lectura(){
		try{
			File F = new File("/home/ivy/Escritorio/TAREAS");
			FileReader fr   = new FileReader(F);
			BufferedReader br = new BufferedReader(fr);
			String linea;
			while((linea=br.readLine())!= null){
				System.out.println(linea);
			}
			fr.close();
			br.close();
		}catch(IOException e){}
}

class UsoFile {

    File f;
    
    public UsoFile(String ruta){
        f = new File(ruta);
        
        if(f.exists()){
            System.out.println("\nNombre del archivo: "+f.getName());
            System.out.println("\nTamanio: "+f.length());
            System.out.println("\nRuta absoluta: "+f.getAbsolutePath());
            System.out.println("\nPuede leerse: "+f.canRead());
            System.out.println("\nPuede editarse: "+f.canWrite());
            System.out.println("\nEs archivo: "+f.isFile());
            System.out.println("\nModificado por ultima vez: "+ new Date(f.lastModified()));
            System.out.println("\nEs directorio: "+f.isDirectory());
            if(f.isDirectory()){
                System.out.println("\nContenido de la carpeta:");
                System.out.println("---------------------------");
                String[] list = f.list();
                for(String archivo : list){
                    System.out.println("-->"+archivo);
                }
            }
            
        }
    }

class EscrituraSinBuffer{
	public void escribir(){
		try{
			String cadena = " ....................... "
			FileWritter fw = new FileWritter("/home/ivy/Escritorio/");
			for (int i = 0; i< cadena.length(); i++){
				fw.writte(cadena.charAt(i));
			}
		}catch(IOException ioe){ }
	}
}

class EscrituraConBuffer{
	public void escribe(){
		String cadena;
		File archivo;
		FileWritter fw;
		BufferedWritter bw;

		try{
			archivo = new File("/home/ivy/Escritorio/");
			fw = new FileWritter(archivo, true);  //el segundo papram es  para no sobreescribir el archivo
			bw = new BufferedWritter(fw);
			Scanner teclado = new Scanner(System.in);
			do{
				cadena = teclado.nextLine();
				bw. write(cadena+"\n");
			} while(!cadena.equals("adios"));
			bw.flush();
			bw.close();
			fw.close();
		}catch(IOException ioe){}
	}
}

class PruebasFile{
	public static void main(String[] args) {
		EscrituraConBuffer esb = new EscrituraConBuffer();
		ecb.escribe();
	}
}



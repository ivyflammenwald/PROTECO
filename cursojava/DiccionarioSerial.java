import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Map;
import java.io.Serializable;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
//import java.util.Arrays;
import java.io.FileOutputStream;
import java.util.Collection;


class DiccionarioSerial{
	static Map<String, String> dicciotoeng;
	static Map<String, String> dicciotoesp;

	public static void main(String[] args){
		boolean salir = false;
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader sc = new BufferedReader (isr); 	
		System.out.println("si ya tiene un diccionario presione 1");

		try{
			if(Integer.parseInt(sc.readLine())==1){
				System.out.println("ingrese la ruta de su diccionario(sin nombre)");
				String ruta = sc.readLine();
				try { //diccionario 1 toeng
					String ruta1=ruta+"/dicciotoeng";
			        FileInputStream fileIn = new FileInputStream(ruta1);
			        ObjectInputStream in = new ObjectInputStream(fileIn);
			        dicciotoeng = (HashMap) in.readObject();
			        in.close();
			        fileIn.close();
			        System.out.println("diccionario 1 cargado correctamente");		
				}catch (IOException i) {
			        i.printStackTrace();
			        System.out.println("algo salio mal"); 
			        salir =true;    
				}catch(ClassNotFoundException c){
					c.printStackTrace();
					System.out.println("No se encontro la clase");
					salir = true;
				}
				try { //diccionario 2 toesp
					String ruta2=ruta+"/dicciotoesp";
			        FileInputStream fileIn = new FileInputStream(ruta2);
			        ObjectInputStream in = new ObjectInputStream(fileIn);
			        dicciotoeng = (HashMap)in.readObject();
			        in.close();
			        fileIn.close();
			        System.out.println("diccionario 2 cargado con exito");
				}catch (IOException i) {
			        i.printStackTrace();
			        System.out.println("algo salio mal"); 
			        salir =true;    
				}catch(ClassNotFoundException c){
					c.printStackTrace();
					System.out.println("No se encontro la clase");
					salir = true;
				}

				Collection c= dicciotoeng.values();
				Object[] v =c.toArray();
				System.out.println("\n contenido diccionario1 :\n");
				for (int i =0; i< dicciotoeng.size();  i++){
					System.out.print (v[i]+" - ");
				//	System.out.print(dicciotoesp.get(v[i])+"\n");
				}
				/*Collection x = dicciotoesp.values();
				Object[] v1 =x.toArray();
				System.out.println("\n contenido diccionario2 :\n");
				for (int i =0; i< dicciotoesp.size();  i++){
					System.out.print (v1[i]+" - ");
				}
				*/
			}else{
				dicciotoeng = new HashMap <String,String>();
				dicciotoesp = new HashMap <String,String>();

				dicciotoeng.put("casa","house");
				dicciotoesp.put("house","casa");

				dicciotoeng.put("perro","dog");
				dicciotoesp.put("dog","perro");

				dicciotoeng.put("tarea","homework");
				dicciotoesp.put("homework","tarea");

				dicciotoeng.put("dormir","sleep");
				dicciotoesp.put("sleep","dormir");

				dicciotoeng.put("pez","fish");
				dicciotoesp.put("fish","pez");
			}

			System.out.println("\nmini Diccionaro Traductor\n ");

			while(salir == false){
				try{
					System.out.println("\n Seleccione una opcion : \n1) Ingresar nuevo \n2) de Espa;ol a ingles \n3) de ingles a espa;ol  \n4) verificar numero de traducciones e imprimir el diccionario");
					System.out.println("5) salir y guardar cambios");
					System.out.println("\nEl diccionario se hidrata de forma automatica al iniciar el programa \ny se guarda con la opcion salir\n");
					switch(Integer.parseInt(sc.readLine())){
						case 1:
								System.out.println("\nIngresar nuevo\n");
								System.out.println("\nPalabra en espa;ol : \n");
								String es = sc.readLine();
								//a=sc.nextLine();
								System.out.println("\nPalabra en ingles : \n");
								String in =sc.readLine(); 
								//o =sc.nextLine();
								dicciotoeng.put(es,in);
								dicciotoesp.put(in, es);
							break;
							
						case  2:
							System.out.println("\ntraducir de esp a ingles\n");
							System.out.println("\nIngrese su palabra a traducir en esp\n");
							String toing = sc.readLine();
							boolean t = dicciotoeng.containsKey(toing);
							if (t==false){
								System.out.println("no se ha encontrado traduccion");
							}else{
								System.out.println("La traduccion es "+dicciotoeng.get(toing));
							}
							break;
						case  3:
							System.out.println("\ntranslation english - spanish\n");
							System.out.println("\nenter a word to be translated\n");
							String toesp = sc.readLine();
							boolean t2 = dicciotoesp.containsKey(toesp);
							if (t2==false){
								System.out.println("no translation for such element found");
							}else{
								System.out.println("translation is:  "+dicciotoesp.get(toesp));
							}
						
							
							break;

						case 5: 
							System.out.println("\nexit - se guardaran los diccionarios en la ruta que especifique: ");
							String ruta = sc.readLine();
							String ruta1=ruta+"/dicciotoeng";
							String ruta2 =ruta+"/dicciotoesp";
							try { //diccio1
						        FileOutputStream fileOut = new FileOutputStream(ruta1);
						        ObjectOutputStream out = new ObjectOutputStream(fileOut);
						        out.writeObject(dicciotoeng);
						        out.close();
						        fileOut.close();
						        System.out.println("guardado con exito diccionario 1");
					      	} catch (IOException i) {
					        	 i.printStackTrace();
					      	}
					      	try { //diccio1
						        FileOutputStream fileOut = new FileOutputStream(ruta2);
						        ObjectOutputStream out = new ObjectOutputStream(fileOut);
						        out.writeObject(dicciotoesp);
						        out.close();
						        fileOut.close();
						        System.out.println("guardado con exito diccionario 2");
					      	} catch (IOException i) {
					        	 i.printStackTrace();
					      	}

					      	salir = true;
							break;


						case 4:
							System.out.println("se tienen "+dicciotoeng.size()+" traducciones en el diccionario"); 
							Collection c= dicciotoeng.values();
							Object[] v =c.toArray();
							System.out.println("\n contenido:\n");
							for (int i =0; i< dicciotoeng.size();  i++){
								System.out.print (v[i]+" - ");
								System.out.print(dicciotoesp.get(v[i])+"\n");
							}
							break;

						default:
							System.out.println("\nopcion no valida\n");
							break;
					}	
				}catch(Exception e){}	
			}
			sc.close();
		}catch(IOException ioe){
			ioe.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}

	}
}
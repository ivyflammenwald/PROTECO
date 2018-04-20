import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Map;


class Freetests{ //DiccionaroTraductor
	static Map<String, String> dicciotoeng = new HashMap <String,String>();
	static Map<String, String> dicciotoesp = new HashMap <String,String>();
	public static void main(String[] args){
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader sc = new BufferedReader (isr); 	
		boolean salir = false;
		System.out.println("\nmini Diccionaro Traductor\n ");

		dicciotoeng.put("casa","house");
		dicciotoesp.put("house","casa");

		dicciotoeng.put("perro","dog");
		dicciotoesp.put("dog","perro");

		dicciotoeng.put("homework","tarea");
		dicciotoesp.put("tarea","homework");

		dicciotoeng.put("dormir","sleep");
		dicciotoesp.put("sleep","dormir");

		dicciotoeng.put("pez","fish");
		dicciotoesp.put("fish","pez");

		
		try{
			do{
				try{
					System.out.println("\n Seleccione una opcion : \n1) Ingresar nuevo 2) de Espa;ol a ingles 3) de ingles a espa;ol  4) salir\n\n");
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

						case 4: 
							System.out.println("\nexit");
							salir = true;
							break;
						default:
							System.out.println("\nopcion no valida\n");
							break;
					}	
				}catch(Exception e){}	
			}while(salir == false);
			sc.close();
		}catch(IOException e){}
	}
}


/**@author prebe17
@version 2.2.5
*/

import java.util.Scanner;
import java.util.ArrayList;

class Matriz{

	double matrix [][];
	final int orden;

	Matriz(int orden){
		this.orden= orden;
		matrix = new double[orden][orden];
	}

	void setElemento(int a, int b, double x){
		this.matrix[a][b] = x;
	}

	double getElemento(int a, int b){
		return matrix[a][b];
	}

	int getOrden(){
		return this.orden;
	}

	Matriz suma (Matriz b){
		Matriz x = new Matriz(this.getOrden());
		try{
			if(this.getOrden()!= b.getOrden()){
				throw new Exception();
			}
			for (int i = 0; i<this.getOrden(); i++){
				for (int j =0; j<this.getOrden(); j++){
					double c = this.getElemento(i,j) + b.getElemento(i,j);
					x.setElemento(i,j,c);
				}
			}
		}catch(Exception e){
			System.out.println("las matrices deben ser del mismo orden, las matrices no se han sumado");
			return this;
		}
	return x;
	}

	Matriz resta (Matriz b){
		Matriz x = new Matriz(this.getOrden());
		try{
			
			if(this.getOrden()!= b.getOrden()){
				throw new Exception();
			}

			for (int i = 0; i<this.getOrden(); i++){
				for (int j =0; j<this.getOrden(); j++){

					double d = b.getElemento(i,j);
					d *= (-1);
					double c = this.getElemento(i,j);
					c += d;
					x.setElemento(i,j,c);
				}
			}
		}catch(Exception e){
			System.out.println("las matrices deben ser del mismo orden, la matriz no se ha restado ");
			return this;
		}
	return x;
	}

	Matriz multiplicacion (Matriz b){
		//para que el producto de dos matrices pueda llevarse a cabo, el numero de columnas de la primer matriz debe ser igual al numero
		//de filas de la segunda matriz; en este programa las matrices son cuadradas por lo que tienen el mismo numero de filas y de columnas
		//por lo tanto en este programa, para que dos matrices puedan multiplicarse deben ser del mismo orden  
		Matriz x = new Matriz(this.getOrden());
		try{
			if(this.getOrden()!= b.getOrden()){
				throw new Exception();
			}
			double elem=0;
			for (int i = 0; i<x.getOrden(); i++){ //insercion de elementos en la matriz resultado - recorrer filas
				for (int j =0; j<x.getOrden(); j++){ //columnas
					for (int k=0;k<this.getOrden();k++){
						elem =x.getElemento(i,j);
						elem += (this.getElemento(i,k)*b.getElemento(k,j));  //multiplicacion de matrices matC[i][j]+=(matA[i][k]*matB[k][j]);
						x.setElemento(i,j,elem);
					}
				}
			}
		}catch(ArrayIndexOutOfBoundsException aioobe){
			aioobe.printStackTrace();
		}catch(Exception e){
			System.out.println("las matrices deben ser del mismo orden, la matriz no se ha multiplicado");
			return this;
		}
		return x;
	}

	void multiplicacionEscalar (double alfa){
		for (int i=0; i< this.getOrden(); i++){
			for(int j= 0; j<this.getOrden(); j++){
				double n = this.getElemento(i,j)*alfa;
				this.setElemento(i,j,n);
			}
		}
	}

	Matriz transponer(){
		Matriz m2 = new Matriz(this.getOrden());

		for(int i=0;i<m2.getOrden();i++){
			for (int j = 0; j<m2.getOrden();j++){
				double d = this.getElemento(i,j);
				m2.setElemento(j,i,d);
			}
		}
		return m2;
	}

	double traza(){
		double tr=0;
		for (int i=0; i< this.getOrden(); i++){
			for(int j= 0; j<this.getOrden(); j++){
				if (i == j){
					tr += this.getElemento(i,j);
				}
			}
		}
		return tr;
	}
	
}


class Ejercicio4{

	public static void main (String[] args){

		Scanner sc = new Scanner(System.in);
		boolean continuar = true;
		ArrayList<Matriz> matrices= new ArrayList<Matriz>();
		
		while(continuar){
			System.out.println(" ------------------------- ");
			System.out.println("");
			System.out.println("Calculadora de matrices de ivy\n");
			System.out.println(" ingrese una opcion ");
			System.out.println("1) crear matriz");
			System.out.println("2) ver matrices");
			System.out.println("3) sumar matrices");
			System.out.println("4) restar matrices");
			System.out.println("5) trasponer una matriz");
			System.out.println("6) sacar la traza de una matriz"); 
			System.out.println("7) multiplicacion de una matriz por un escalar");
			System.out.println("8) multiplicacion de matrices");
			System.out.println(" presiona otra tecla para salir ");
			System.out.println("");
			
			int opcion=sc.nextInt();
			System.out.println("");
			switch(opcion){

				case 1: //nueva matriz
					System.out.println("de que orden deseas la nueva matriz");
					int nue= sc.nextInt();
					int k;
					Matriz nueva= new Matriz(nue);
					
					for (int i=0; i< nueva.getOrden(); i++){
						for(int j= 0; j<nueva.getOrden(); j++){
							System.out.println("ingresa el elemento "+(i+1)+" "+(j+1));
							k = sc.nextInt();
							nueva.setElemento(i,j, k);
						}
					}
					matrices.add(nueva);
					System.out.println("");
				break;

				case 2: //ver matrices
					int ind=1;
					for (Matriz mat : matrices){ //para todas las matrices del arreglo 
						System.out.println("matriz numero/indice de arreglo "+ind);
						for (int i = 0; i<mat.getOrden(); i++){
							for (int j =0; j<mat.getOrden(); j++){
								System.out.print(mat.getElemento(i,j)+" ");
							}
							System.out.println("");
						}
						System.out.println("");
						ind+=1;
					}
				System.out.println("");
				break;

				case 3: //sumar matrices
					System.out.println("elija dos matrices a sumar");
					for (Matriz mat : matrices){ //para todas las matrices del arreglo 
						for (int i = 0; i<mat.getOrden(); i++){
							for (int j =0; j<mat.getOrden(); j++){
								System.out.print(mat.getElemento(i,j)+" ");
							}
							System.out.println("");
						}
					System.out.println("");
					}
					//imprimirMatrices(matrices);
					System.out.println("elija la matriz 1, con un indice entero partiendo de 1 y n (elementos del arraylist de matrices en pantalla");
					int uno = sc.nextInt();
					uno -=1;
					System.out.println("elija la matriz 2");
					int dos = sc.nextInt();
					dos-=1;

					Matriz mat1 = matrices.get(uno);
					Matriz mat2 = matrices.get(dos);
					Matriz mat3 = mat1.suma(mat2);

					System.out.println("Matriz resultante ");

					for (int i = 0; i<mat1.getOrden(); i++){
							for (int j =0; j<mat1.getOrden(); j++){
								System.out.print(mat3.getElemento(i,j)+" ");
							}
							System.out.println("");
					}

					System.out.println("");
					matrices.add(mat3);

				break;

				case 4: //restar matrices
					System.out.println("elija dos matrices a restar");
					for (Matriz mat : matrices){ //para todas las matrices del arreglo 
						for (int i = 0; i<mat.getOrden(); i++){
							for (int j =0; j<mat.getOrden(); j++){
								System.out.print(mat.getElemento(i,j)+" ");
							}
							System.out.println("");
						}
						System.out.println("");	
					}
					System.out.println("elija la matriz A, con un indice entero partiendo de 1 y n (elementos del arraylist de matrices en pantalla");
					int muno = sc.nextInt();
					muno-=1;
					System.out.println("elija la matriz B - se restara esta matriz a la matriz A");
					int mdos = sc.nextInt();
					mdos-=1;

					Matriz mat11 = matrices.get(muno);
					Matriz mat22 = matrices.get(mdos);
					Matriz mat33 = mat11.resta(mat22);

					System.out.println("Matriz resultante ");

					for (int i = 0; i<mat11.getOrden(); i++){
							for (int j =0; j<mat11.getOrden(); j++){
								System.out.print(mat33.getElemento(i,j)+" ");
							}
							System.out.println("");
					}
					System.out.println(" ");
				System.out.println("");
				matrices.add(mat33);
				break;

				case 5: //transposicion
					System.out.println("elija una matriz para transponerla");
					int tra = sc.nextInt();
					tra-=1;
					Matriz atrans= matrices.get(tra);
					Matriz trans  = atrans.transponer();
					matrices.add(trans);
					System.out.println("Matriz resultante ");

					for (int i = 0; i<trans.getOrden();i++){
						for(int j = 0; j<trans.getOrden();j++){
							System.out.print(trans.getElemento(i,j)+" ");
						}
						System.out.println("");
					}
					System.out.println(" ");
				break;

				case 6: //traza
					System.out.println("selecciona una matriz para obtener su traza");
					int tz = sc.nextInt();
					tz-=1;
					Matriz mtz = matrices.get(tz);
					double traz = mtz.traza();
					System.out.println(" la traza de la matriz seleccionada es "+traz);
				break;

				case 7://multiplicacion por un escalar
					System.out.println("Que matriz deseas multiplicar por un escalar?");
					int mult = sc.nextInt();
					mult-=1;
					Matriz m = matrices.get(mult);
					System.out.println("cual es el escalar que multiplicara a la matriz?");
					double esc = sc.nextDouble();
					m.multiplicacionEscalar(esc);
					for (int i = 0; i<m.getOrden();i++){
						for (int j =0; j<m.getOrden(); j++){
							System.out.print(m.getElemento(i,j)+" ");
						}
						System.out.println("");
					}

				break;

				case 8: //multiplicacion de matrices
					System.out.println("elija dos matrices a multiplicar");
					for (Matriz mat : matrices){ //para todas las matrices del arreglo 
						for (int i = 0; i<mat.getOrden(); i++){
							for (int j =0; j<mat.getOrden(); j++){
								System.out.print(mat.getElemento(i,j)+" ");
							}
							System.out.println("");
						}
					System.out.println("");
					}
					//imprimirMatrices(matrices);
					System.out.println("elija la matriz 1, con un indice entero partiendo de 1 y n (elementos del arraylist de matrices en pantalla");
					int un = sc.nextInt();
					un -=1;
					System.out.println("elija la matriz 2");
					int doss = sc.nextInt();
					doss-=1;

					Matriz ma1 = matrices.get(un);
					Matriz ma2 = matrices.get(doss);
					Matriz ma3 = ma1.multiplicacion(ma2);
					matrices.add(ma3);

					System.out.println("Matriz resultante ");

					for (int i = 0; i<ma1.getOrden(); i++){
							for (int j =0; j<ma1.getOrden(); j++){
								System.out.print(ma3.getElemento(i,j)+" ");
							}
							System.out.println("");
					}

					System.out.println("");
				break;

				default: // salir 
					System.out.println(" fin del programa ");
					continuar = false;
				break;
			}

		}
	}

/*
	static void imprimirMatrices(ArrayList matrices){
		for (Matriz mat : matrices){ //para todas las matrices del arreglo 
			for (int i = 0; i<mat.getOrden(); i++){
				for (int j =0; j<mat.getOrden(); j++){
					System.out.print(mat.getElemento(i,j)+" ");
				}
				System.out.println("");
			}
		}
	}
*/
}
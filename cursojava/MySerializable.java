import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;


class Usuario implements Serializable{
    
    final protected String nombre;
    final protected double edad;
    final protected double altura;
    final protected String user;
    final protected String pass;
    
    Usuario( String nombre, double edad, double altura, String user, String pass){
        this.nombre=nombre;
        this.edad = edad;
        this.altura=altura;
        this.user=user;
        this.pass=pass;
    }

    public String getNombre() {
        return nombre;
    }

    public double getEdad() {
        return edad;
    }

    public double getAltura() {
        return altura;
    }

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }
    
    public String toString(){
    	return String.format("\n "+this.getNombre()+this.getEdad()+this.getAltura()+this.getUser());
    }

    public boolean serial(String ruta){
    	try {
	         FileOutputStream fileOut = new FileOutputStream(ruta);
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(this);
	         out.close();
	         fileOut.close();
	         return true;
      	} catch (IOException i) {
        	 i.printStackTrace();
        	 return false;
      	}
    }

    public static boolean hidratar(Usuario usu, String ruta){
		try {
	         FileInputStream fileIn = new FileInputStream(ruta);
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         usu = (Usuario) in.readObject();
	         in.close();
	         fileIn.close();
	         return  true;
		}catch (IOException i) {
	         i.printStackTrace();
	        System.out.println("algo salio mal");
	        return false;      
		}catch(ClassNotFoundException c){
			c.printStackTrace();
			System.out.println("No se encontro la clase");
			return false;
		}
    }
}


class MySerializable{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in); 	
		boolean salir = false;
		System.out.println("Ingrese la ruta donde estan los archivos");
		String rutaprim= sc.nextLine();
		do{
				try{
				System.out.println("\n Seleccione una opcion : \n1) Ingresar nuevo 2) Iniciar Sesion\n\n");
				switch(sc.nextInt()){
					case 1:
							System.out.println("\nIngresar nuevo\n");
							System.out.println("\nnombre\n");
							String a = sc.nextLine();
							a=sc.nextLine();
							System.out.println("\nedad\n");
							double e= sc.nextDouble();
							System.out.println("\naltura\n");
							double i = sc.nextDouble();
							System.out.println("\nnombreusuario\n");
							String o =sc.nextLine(); 
							o =sc.nextLine(); 
							System.out.println("\npassward\n");
							String u =sc.nextLine();
							Usuario usu = new Usuario(a,e,i,o,u);
							System.out.println(usu);
							String ru = rutaprim+"/"+o;
							boolean done = usu.serial(ru);
							if (done){
								System.out.println("serializado con exito");
							}
						break;
						
					case  2:
						System.out.println("\nIngrese su nombre de usuario\n");
						String nous = sc.nextLine();
						System.out.println("\nIngrese su passward\n");
						String passw = sc.nextLine();
						String rut = rutaprim+"/"+nous;
						Usuario us = null;
						boolean done1= Usuario.hidratar(us, rut);
						if (done1){
							System.out.println("hidratado con exito");
						}
						if (us.getPass().equals(passw)){
							System.out.println(" acceso concedido");
						}else{
							System.out.println("acceso denegado, intente de nuevo");
						}
						break;
					case 3: 
						System.out.println("\nsalir alv");
						salir = true;
						break;
					default:
						System.out.println("\nopcion no valida\n");
						break;
				}	


				}catch(Exception e){}	
		}while(salir == false);
	}
}
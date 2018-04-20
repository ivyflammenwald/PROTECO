import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.io.BufferedReader;
import java.net.ServerSocket;

public class Cliente {
    public static void main(String[] args) throws IOException{
        //Paso 1: Crear un Socket para conectar con el Servidor
        Socket s = new Socket("192.168.1.172", 9999);
        
        String cadena = "";
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        
        //Paso 2:Obtener los flujos de I/O del Socket
        PrintStream ps = new PrintStream(s.getOutputStream());
        
        //Paso 3:Realizar procesamiento
        while(!cadena.equals("quit")){
            cadena = teclado.readLine();
            ps.println(cadena);
            ps.flush();
        }
        
        //Paso 4: Cerrar la conexion
        ps.close();
        teclado.close();
        s.close();
    }
}

import java.util.Scanner;
import java.io.IOException;
import java.io.BufferedReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.io.InputStream;
import java.net.InetAddress;

class User  {
    
    User(){
    }

    Socket recibo = null;
    Socket envio = null;
    BufferedReader brrecibo = null;
    InputStreamReader isrrecibo = null;
    InputStream isrecibo = null;
    PrintStream psenvio = null;

    public Socket getRecibo() {
        return recibo;
    }

    public Socket getEnvio() {
        return envio;
    }

    public BufferedReader getBrrecibo() {
        return brrecibo;
    }

    public InputStreamReader getIsrrecibo() {
        return isrrecibo;
    }

    public InputStream getIsrecibo() {
        return isrecibo;
    }

    public PrintStream getPsenvio() {
        return psenvio;
    }


    public void establecerConexion(Socket sin, Socket sout){ //el socket recibe desde el flujo de salida de otro socket, sin se refiere a la entrada de datos desde la instancia
        try{
            this.recibo = new Socket(sin.getInetAddress(), sin.getPort());
            this.envio = new Socket(sout.getInetAddress(), sout.getPort());
            System.out.println("conectado a la ip "+sin.getInetAddress());
            //ss.bind(ssss.getLocalSocketAddress(), 9999);
            this.isrecibo = recibo.getInputStream();
            isrrecibo = new InputStreamReader(isrecibo);
            brrecibo = new BufferedReader(isrrecibo);
            psenvio = new PrintStream(envio.getOutputStream());
        }catch(Exception e){
        }
       
    }


    public void cerrar(){
        try{
        this.brrecibo.close();
        this.isrecibo.close();
        this.isrrecibo.close();
        this.psenvio.close();
        this.envio.close();
        this.recibo.close();
        }catch(IOException e){}
    }
    
}


class PrebeChat {
    public static void main(String[] args) throws IOException{
        
        Scanner sc= new Scanner(System.in);
        System.out.println("ingresa tu ip");
        String local = sc.nextLine(); //se recibe la ip local
        
        String[] iplocal = local.substring(1, local.length() - 1).split("."); //se convierte la ip a un arreglo de byte
        byte[] bipl = new byte[iplocal.length];

        for (int i=0, len=bipl.length; i<len; i++) {
            bipl[i] = Byte.parseByte(iplocal[i].trim());     //el arr de byte se casteara para pasarlo como direccion ip byteiplocal
        }
  
        System.out.println("Ingresa la ip a la que quieres conectarte"); 
        String conectar = sc.nextLine();    //recibe ip remota

        String[] ipremota = local.substring(1, local.length() - 1).split(".");  //byteipremota
        byte[] bipr = new byte[ipremota.length];

        for (int i=0, len=bipr.length; i<len; i++) {
            bipr[i] = Byte.parseByte(iplocal[i].trim());     
        }
        
        Socket s1in=new Socket(InetAddress.getByAddress (bipl) , 9999); //socket de entrada a local
        Socket s1out=new Socket(InetAddress.getByAddress(bipl), 9998); //socket de salida , local
        
        Socket s2in=new Socket(InetAddress.getByAddress(bipr), 9999);
        Socket s2out=new Socket(InetAddress.getByAddress(bipr), 9998);
        
        
        User s1 = new User(); // el usuario local
        User s2 = new User(); //la conexion remota
        
        s1.establecerConexion(s1in, s1out);
        s2.establecerConexion(s2in, s2out);
        
        System.out.println("Conexion establecida, el chat finaliza cuando uno de los dos escriba - quit -  ");
    

        String menviado = null;
        boolean continuar = true;
        String mrecibido = null;

        do{
            System.out.println("escriba un mensaje para enviar");
            menviado=sc.nextLine();
            s1.getPsenvio().println(menviado);
            s1.getPsenvio().flush();
            if(menviado.equals("quit") || mrecibido.equals("quit")){
                continuar =false;
                System.out.println("alguien ha decidido cerrar el chat");
            }
            mrecibido = s2.getBrrecibo().readLine();
            System.out.println("mensaje recibido "+mrecibido);
        }while(continuar);
        
        s1.cerrar();
        s2.cerrar();
    }
}






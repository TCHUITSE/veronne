package Socket;
import java.io.*;
import java.net.*;
import java.util.*;
public class Clients {
	private static int port=9090;
	private static String ip="localhost";
	
	public static void main(String[] args)throws Exception{
		Socket socket=null;
		BufferedReader in;
		PrintWriter out;
		Scanner keyb;
		String message;
		try{
			System.out.println("----------------------------------------------------------------------------");
			System.out.println("CLIENT: Connecte moi serveur");
			System.out.println("----------------------------------------------------------------------------");
			socket=new Socket(ip,port);
			in =new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String reponse= in.readLine();
			System.out.println(reponse);
			System.out.println("----------------------------------------------------------------------------");
			System.out.println("SERVEUR:Entrer le message dont vous voulez l'analyse");
			System.out.println("----------------------------------------------------------------------------");
			keyb=new Scanner(System.in);
			message=keyb.nextLine();
			out=new PrintWriter(socket.getOutputStream());
			out.println(message);
			out.flush();
			in =new BufferedReader(new InputStreamReader(socket.getInputStream()));
			System.out.println("----------------------------------------------------------------------------");
			System.out.println(in.readLine());
			System.out.println("----------------------------------------------------------------------------");
			
			
		}
		catch(IOException e){
			System.out.println("la connexion a echoué !!!");
			e.printStackTrace();
		}
		socket.close();
	}
}

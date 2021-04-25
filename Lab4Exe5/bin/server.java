import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTranslationApplication {

	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket=null;
		try {
			// Bind Serversocket to a port
			int portNo=4228;
			serverSocket=new ServerSocket(portNo);
			
			//String text1="Good afternoon";
			System.out.println("Waiting for request");
			
			while (true) {
				//Accept client request for connection
				Socket clientSocket=serverSocket.accept();
				
				//Create stream to write data on the network
				InputStreamReader in =new InputStreamReader(clientSocket.getInputStream());
				BufferedReader bf=new BufferedReader(in);
				
				String str=bf.readLine();
				System.out.println("Client: "+str);
				
				PrintWriter pr=new PrintWriter(clientSocket.getOutputStream());
				pr.println("yes");
				pr.flush();
				
				//Close the socket
				clientSocket.close();

			}
			
			//Closing is not necessary because the code is unreachable
		} catch (IOException ioe) {
			if (serverSocket!=null)
				serverSocket.close();
			ioe.printStackTrace();
		}

	}

}

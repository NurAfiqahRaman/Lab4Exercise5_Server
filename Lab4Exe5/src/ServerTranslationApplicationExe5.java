import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTranslationApplicationExe5 {

	public static void main(String[] args) throws IOException {
		ServerSocket ss=new ServerSocket(1223);
		try {
			
			
			while (true) {
				//Accept client request for connection
				Socket clientSocket=ss.accept();
				System.out.println("client connected");
				
				//Create stream to write data on the network
				BufferedReader bufferedReader=new BufferedReader(
						new InputStreamReader(clientSocket.getInputStream()));
				
				//Read from the network and display the current date
				String text =bufferedReader.readLine();
				System.out.println("client : "+text);
				
				//Send current data back to the client

				PrintWriter pr=new PrintWriter(clientSocket.getOutputStream());
				pr.println("selamat pagi");
				pr.flush();
				
				
				//Close the socket
				clientSocket.close();

			}
			
			//Closing is not necessary because the code is unreachable
		} catch (IOException ioe) {
			if (ss!=null)
				ss.close();
			ioe.printStackTrace();
		}

	}

}

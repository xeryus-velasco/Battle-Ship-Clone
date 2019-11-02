import java.net.*;
import java.io.*;

public class Server implements Runnable
{
	//Input stream
	private DataInputStream in = null;
	private DataOutputStream out = null;

	//Initializes 2 server sockets
	private static ServerSocket serverSocket = null;

	public static void main(String[] args) throws IOException
	{
		//Initializes 2 server sockets
		serverSocket = new ServerSocket(5000);

		try
		{
			Socket s1 = serverSocket.accept();
			Socket s2 = serverSocket.accept();

			Runnable run = new Server();
			Thread game = new Thread(run);

			game.start();
		}
		catch(IOException e)
		{
			System.out.println("Connection Error\n" + e);
		}


	}

	@Override
	public void run()
	{
		System.out.println(Message.MSG_REQUEST_INIT);


	}
}

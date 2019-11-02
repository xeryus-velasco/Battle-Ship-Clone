import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client
{
	private static Socket socket = null;
	private BufferedReader input = null;


	public static void main(String[] args) throws IOException
	{
		try
		{
			socket = new Socket("127.0.0.1", 5000);
			System.out.println("Connection Established");
		}
		catch(IOException e)
		{
			System.out.println("Failed Connection\n" + e);
		}

	}


}

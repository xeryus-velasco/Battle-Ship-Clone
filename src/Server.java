import java.net.*;
import java.io.*;

public class Server implements Runnable
{
	//Input stream
	private Socket socket1 = null;
	private Socket socket2 = null;
	private DataInputStream in = null;
	private DataOutputStream out = null;

	//Initializes one server sockets
	private static ServerSocket serverSocket = null;

	public static void main(String[] args) throws IOException
	{
		//Initializes 2 server sockets
		serverSocket = new ServerSocket(5000);

		try
		{
			//get two players to connect
			Socket player1 = serverSocket.accept();
			Socket player2 = serverSocket.accept();

			//make server objects and redefine them
			Server server = new Server();
			server.socket1 = player1;
			server.socket2 = player2;

			//create game thread
			Thread game = new Thread(server);

			//start game thread
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

		try {
			ObjectInputStream in1 = new ObjectInputStream(socket1.getInputStream());
			ObjectOutputStream out1 = new ObjectOutputStream(socket1.getOutputStream());

			Message message = new Message();
			message.setMsgType(1);
			out1.writeObject(message);
			out1.flush();

			message.Ftable = new BattleShipTable();
			out1.writeObject(message.Ftable);
			out1.reset();

			Object airCarrier1 = in1.readObject();
			Object airCarrier2 = in1.readObject();
			message.Ftable.insertAirCarrier(airCarrier1.toString(),airCarrier2.toString());
			out1.writeObject(message.Ftable);
			out1.reset();

			Object airCarrier3 = in1.readObject();
			Object airCarrier4 = in1.readObject();
			message.Ftable.insertAirCarrier(airCarrier3.toString(),airCarrier4.toString());
			out1.writeObject(message.Ftable);
			out1.reset();

			Object destroyer1 = in1.readObject();
			Object destroyer2 = in1.readObject();
			message.Ftable.insertDestroyer(destroyer1.toString(),destroyer2.toString());
			out1.writeObject(message.Ftable);
			out1.reset();

			Object destroyer3 = in1.readObject();
			Object destroyer4 = in1.readObject();
			message.Ftable.insertDestroyer(destroyer3.toString(),destroyer4.toString());
			out1.writeObject(message.Ftable);
			out1.reset();

			Object submarine1 = in1.readObject();
			message.Ftable.insertSubmarine(submarine1.toString());
			out1.writeObject(message.Ftable);
			out1.reset();

			Object submarine2 = in1.readObject();
			message.Ftable.insertSubmarine(submarine2.toString());
			out1.writeObject(message.Ftable);
			out1.reset();

			Message message2 = (Message)in1.readObject();


			//player two
			ObjectInputStream in2 = new ObjectInputStream(socket2.getInputStream());
			ObjectOutputStream out2 = new ObjectOutputStream(socket2.getOutputStream());

			message.setMsgType(1);
			out2.writeObject(message);
			out2.flush();

			message.Ftable = new BattleShipTable();
			out2.writeObject(message.Ftable);
			out2.reset();

			Object airCarrier5 = in2.readObject();
			Object airCarrier6 = in2.readObject();
			message.Ftable.insertAirCarrier(airCarrier5.toString(),airCarrier6.toString());
			out2.writeObject(message.Ftable);
			out2.reset();

			Object airCarrier7 = in2.readObject();
			Object airCarrier8 = in2.readObject();
			message.Ftable.insertAirCarrier(airCarrier7.toString(),airCarrier8.toString());
			out2.writeObject(message.Ftable);
			out2.reset();

			Object destroyer5 = in2.readObject();
			Object destroyer6 = in2.readObject();
			message.Ftable.insertDestroyer(destroyer5.toString(),destroyer6.toString());
			out2.writeObject(message.Ftable);
			out2.reset();

			Object destroyer7 = in2.readObject();
			Object destroyer8 = in2.readObject();
			message.Ftable.insertDestroyer(destroyer7.toString(),destroyer8.toString());
			out2.writeObject(message.Ftable);
			out2.reset();

			Object submarine3 = in2.readObject();
			message.Ftable.insertSubmarine(submarine3.toString());
			out2.writeObject(message.Ftable);
			out2.reset();

			Object submarine4 = in2.readObject();
			message.Ftable.insertSubmarine(submarine4.toString());
			out2.writeObject(message.Ftable);
			out2.reset();

			Message message4 = (Message)in2.readObject();

			message.setMsgType(3);
			out1.writeObject(message);
			out1.flush();

			message.Ptable = new BattleShipTable();
			out1.writeObject(message.Ptable);
			out1.reset();

			message.Ftable = new BattleShipTable();
			out1.writeObject(message.Ftable);

			out1.reset();

			message.setMsgType(3);
			out2.writeObject(message);
			out2.flush();

			message.Ptable = new BattleShipTable();
			out2.writeObject(message.Ptable);
			out2.reset();

			message.Ftable = new BattleShipTable();
			out2.writeObject(message.Ftable);

			out2.reset();

			Message message6 = (Message)in1.readObject();
			Message message7 = (Message)in2.readObject();

		} catch (IOException | ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
}

import java.util.*;
import java.net.*;
import java.io.*;

public class Client
{
	public static void main(String args[]) throws IOException, ClassNotFoundException
	{
		Scanner keyboard = new Scanner(System.in);

		Socket socket = new Socket("127.0.0.1", 5000);

		ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
		ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

		Message message = (Message) in.readObject();

		Object fTable1 = in.readObject();
		System.out.println("Printing the F-board");
		System.out.println(fTable1.toString());
		System.out.println();

		if (message.getMsgType() == 1)
		{
			//Inputting pieces to board
			System.out.println("Provide fleet information: ");
			System.out.println();
			
			//Air Carrier 1
			System.out.print("Insert the first coordinate for air carrier 1: ");
			String input1 = keyboard.nextLine();
			out.writeObject(input1);
			System.out.print("Insert the second coordinate for air carrier 1: ");
			String input2 = keyboard.nextLine();
			out.writeObject(input2);

			//Place Air Carrier 1
			Object fTable2 = in.readObject();
			System.out.println("Placing your first air carrier, here is your board: ");
			System.out.println(fTable2.toString());

			
			//Air Carrier 2
			System.out.println();
			System.out.print("Insert the first coordinate for air carrier 2: ");
			String input3 = keyboard.nextLine();
			out.writeObject(input3);
			System.out.print("Insert the second coordinate for air carrier 2: ");
			String input4 = keyboard.nextLine();
			out.writeObject(input4);
			
			//Place Air Carrier 1
			System.out.println("Placing your second air carrier, here is your board: ");
			Object fTable3 = in.readObject();
			System.out.println(fTable3.toString());
			
			
			//Destroyer 1
			System.out.println();
			System.out.print("Insert the first coordinate for destroyer 1: ");
			String input5 = keyboard.nextLine();
			out.writeObject(input5);
			System.out.print("Insert the second coordinate for destroyer 1: ");
			String input6 = keyboard.nextLine();
			out.writeObject(input6);

			//Place Destroyer 1
			System.out.println("Placing your first destroyer, here is your board: ");
			Object fTable4 = in.readObject();
			System.out.println(fTable4.toString());

			
			//Destroyer 2
			System.out.println();
			System.out.print("Insert the first coordinate for destroyer 2: ");
			String input7 = keyboard.nextLine();
			out.writeObject(input7);
			System.out.print("Insert the second coordinate for destroyer 2: ");
			String input8 = keyboard.nextLine();
			out.writeObject(input8);

			//Place Destroyer 2
			System.out.println("Placing your second destroyer, here is your board: ");
			Object fTable5 = in.readObject();
			System.out.println(fTable5.toString());

			
			//Submarine 1
			System.out.println();
			System.out.print("Insert the coordinate for submarine 1: ");
			String input9 = keyboard.nextLine();
			out.writeObject(input9);
			System.out.println();

			//Place Submarine 1
			Object fTable6 = in.readObject();
			System.out.println("Placing your first submarine, here is your board: ");
			System.out.println(fTable6.toString());

			
			//Submarine 2
			System.out.println();
			System.out.print("Insert the coordinate for submarine 2: ");
			String input11 = keyboard.nextLine();
			out.writeObject(input11);
			System.out.println();

			//Place Submarine 2
			Object fTable7 = in.readObject();
			System.out.println("Placing your second submarine, here is your final board: ");
			System.out.println(fTable7.toString());

			//Creates the message class to send message (2 -- MSG_RESPONSE_INIT) to the Server (player 1 and player 2)
			Message message2 = new Message();
			message2.setMsgType(2);
			out.writeObject(message2);
			
			//Reading in message (3) from the Server for (player 1 and player 2)
			Message message3 = (Message)in.readObject();

			// Preparing to print the F-board and P-board for (player 1 and player 2)
			if(message3.getMsgType() == 3)
			{
				Object pTable1 = in.readObject();

				System.out.println("Here is your F-board: ");
				System.out.println(fTable7.toString());

				System.out.println("Here is your P-board: ");
				System.out.println(pTable1.toString());

				System.out.print("Select a coordinate to attack, for the P-board (Opponent's board): ");
				String input12 = keyboard.nextLine();

				Message message4 = new Message();
				message4.setMsgType(4);
				out.writeObject(message4);

				System.out.println();

				if(message4.getMsgType() == 4)
				{
					Object pTable2 = in.readObject();
					System.out.println("Here is the updated P-board (Opponent's board): ");
					System.out.println(pTable2.toString());
				}
			}
		}
	}
}



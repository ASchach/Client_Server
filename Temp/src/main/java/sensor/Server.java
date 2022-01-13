package sensor;

import java.net.*;
import java.io.*;

public class Server
{
    //initialize socket and input stream
    private Socket          socket   = null;
    private ServerSocket    server   = null;
    private DataInputStream in       = null;
    private DataOutputStream out     = null;
    private static TemperatureSensor tempSensor = new TemperatureSensor();

    // constructor with port
    public Server(int port)
    {
        // starts server and waits for a connection
        try
        {
            server = new ServerSocket(port);
            System.out.println("Server started");

            System.out.println("Waiting for a client ...");

            socket = server.accept();
            System.out.println("Client accepted");

            // takes input from the client socket
            in = new DataInputStream(
                    new BufferedInputStream(socket.getInputStream()));

            out    = new DataOutputStream(socket.getOutputStream());

            String line = "";

            // reads message from client until "Over" is sent
            while (!line.equals("Over"))
            {
                try
                {
                    line = in.readUTF();
                    System.out.println(line);
                    out.writeUTF("" + tempSensor.value());
                    line = in.readUTF();
                    System.out.println(line);

                }
                catch(EOFException i)
                {
                    System.out.println(i);
                }

            }
            System.out.println("Closing connection");

            // close connection
            socket.close();
            in.close();
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
    }

    public static void main(String args[])
    {
        tempSensor.start();
        Server server = new Server(4000);
        tempSensor.stop();
    }
}

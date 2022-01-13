package domain;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientCo2 implements ISensor {


        // initialize socket and input output streams
        private Socket socket            = null;
        private DataInputStream in = null;
        private DataOutputStream out     = null;
        private String line = "line";
        private String co2Id = "";
        private String[] co2Array;


        // constructor to put ip address and port
        public ClientCo2(String address, int port)
        {
            // establish a connection
            try
            {
                socket = new Socket(address, port);
                System.out.println("Connected");

                // takes input from terminal
                in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));

                // sends output to the socket
                out    = new DataOutputStream(socket.getOutputStream());
            }
            catch(UnknownHostException u)
            {
                System.out.println(u);
            }
            catch(IOException i)
            {
                System.out.println(i);
            }



            // keep reading until "Over" is input
            while (!line.equals("Over"))
            {
                try
                {
                    out.writeUTF("");
                    line = in.readUTF();
                    co2Id = line;
                    co2Array = co2Id.split(" ");
                    out.writeUTF("Over");
                }
                catch(Exception i)
                {
                    System.out.println(i);
                }
                break;
            }

            // close the connection
            try
            {
                in.close();
                out.close();
                socket.close();
            }
            catch(IOException i)
            {
                System.out.println(i);
            }


        }
    @Override
    public String getName() {
        return co2Array[0];
    }

    @Override
    public Double getValue() {
        return Double.valueOf(co2Array[1]);
    }
}

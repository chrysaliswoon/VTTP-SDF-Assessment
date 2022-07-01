package assessment.core;

import java.io.IOException;

public class Main 
{
    public static void main( String[] args ) throws IOException
    {
        String IP;
        Integer PORT;
        Client client;

        if (args.length > 0) {
            IP = args[0];
            PORT = Integer.parseInt(args[1]);

            //? Sends the txtfile over to the csvreader
            client = new Client(IP, PORT);
            client.start(); 
        }
    }
}

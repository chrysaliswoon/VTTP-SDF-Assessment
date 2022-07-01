package assessment.core;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Client {
    private String IP;
    private Integer PORT;
    private Socket clientSocket;
    private DataOutputStream out;
    private DataInputStream in;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;
    private String name = "Chrysalis Woon Yong Xin";
    String email = "chrysaliswoon@gmail.com";

    public Client(String IP, Integer PORT) throws IOException {
        this.IP = IP;
        this.PORT = PORT;
    }

    public void start() throws IOException {
        try {
            clientSocket = new Socket(IP, PORT);
            System.out.println("Connected to " + IP + " on Port: " + PORT);

            out = new DataOutputStream(clientSocket.getOutputStream());
            in = new DataInputStream(clientSocket.getInputStream());
            oos = new ObjectOutputStream(out);
            ois = new ObjectInputStream(in);

            // ? Reads the response from the server
            String response = ois.readUTF();

            // ? Splits the response into Request ID and List of Integers
            String segments[] = response.split(" ");
            String reqID = segments[0];
            String integerList = segments[segments.length - 1];
            String[] numbers = integerList.split(",");

            // ? Calculate the average of the scores
            Stream<String> stringStream = Arrays.stream(numbers);
            IntStream intStream = stringStream.mapToInt(value -> Integer.parseInt(value));
            double score = intStream.average().getAsDouble();
            float averageScore = (float) score;

            System.out.println("Request ID: " + reqID);
            System.out.println("Average: " + averageScore);

            // ? Write answer back to server
            writeUTF(reqID);
            writeUTF(name);
            writeUTF(email);
            writeFloat(averageScore);

            oos.flush();

            Boolean readBoolean = ois.readBoolean();
            if (readBoolean == false) {
                System.out.println("FAILED");
                stopConnection();
            } else {
                System.out.println("SUCCESS");
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public void writeUTF(String str) throws IOException {
        oos.writeUTF(str);
    }

    public void writeFloat(Float num) throws IOException {
        oos.writeFloat(num);
    }

    public void stopConnection() throws IOException {
        out.close();
        in.close();
        clientSocket.close();
    }
}

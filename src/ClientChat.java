import java.io.*;
import java.net.Socket;

public class ClientChat {
    public static void main(String[] args) throws IOException {

        String hostName = "192.168.11.143";
        int serverPortNumber = 9091; //é sempre o port do servidor

        Socket clientSocket = null;
        BufferedReader in = null;

        try {
            clientSocket = new Socket(hostName, serverPortNumber);

            Reader input = new InputStreamReader(System.in);
            in = new BufferedReader(input);


            PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);


            String message = "";

            while (!message.equals("bye")) {
                message = in.readLine();

                output.println(message);
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
        in.close();
        clientSocket.close();
        }



    }
}

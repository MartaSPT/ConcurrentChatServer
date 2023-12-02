import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerChat {
    public static void main(String[] args) throws IOException {
        String serverPortNumber = "localhost";
        int portNumber = 9091;

        ServerSocket serverSocket = null;
        BufferedReader in = null;


        try {
            serverSocket = new ServerSocket(portNumber);
            System.out.println("BEFORE");
            Socket clientSocket = serverSocket.accept(); //tree hand shake
            System.out.println("AFTER");
            Reader input = new InputStreamReader(clientSocket.getInputStream());

                                                    //Input Stream Reader
            in = new BufferedReader(input);

            String message = "";
            while (!message.equals("bye")) {
                message = in.readLine();
                System.out.println(message);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if(in != null) {
                in.close();
            }
            if(serverSocket != null) {
                serverSocket.close();
            } // :)
        }
    }
}

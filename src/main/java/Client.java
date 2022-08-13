import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 8080;
        try (Socket clientSocket1 = new Socket(host, port);
             PrintWriter out1 = new PrintWriter(clientSocket1.getOutputStream(), true);
             BufferedReader in1 = new BufferedReader(new InputStreamReader(clientSocket1.getInputStream()))) {
            out1.println("GET / HTTP/1.1\n" + "Host: localhost\n\n\n");
            String resp = in1.readLine();
            System.out.println(resp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

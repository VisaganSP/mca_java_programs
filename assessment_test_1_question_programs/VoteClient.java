
// CLIENT SIDE PROGRAM
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class VoteClient {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8080);
            System.out.println("Connected to server.");

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            // Get age input from the user
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your age: ");
            int age = scanner.nextInt();

            // Send age to the server
            dos.writeInt(age);

            // Receive and display the server's response
            String response = dis.readUTF();
            System.out.println("Server says: " + response);

            // Close the connection
            socket.close();
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
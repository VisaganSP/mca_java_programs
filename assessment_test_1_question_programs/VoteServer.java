
// java program 9.a
// SERVER SIDE PROGRAM
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class VoteServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);

        try {
            System.out.println("Server waiting for client on port 8080...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket);

                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

                // Receive age from client
                int age = dis.readInt();

                // Check eligibility to vote
                String message = (age >= 18) ? "You are eligible to vote." : "You are not eligible to vote.";

                // Send response back to client
                dos.writeUTF(message);

                // Close the connection
                socket.close();
                System.out.println("Client disconnected.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            serverSocket.close();
        }
    }
}

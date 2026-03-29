// Jasmine Sanders
import java.net.*;
import java.util.Scanner;

public class EchoServer {
    public static void main(String[] args) throws Exception {
        // Step A: Create a socket to listen on port 5000
        DatagramSocket socket = new DatagramSocket(5000);
        byte[] buffer = new byte[1024];

        System.out.println("Server is listening on port 5000...");

        while (true) {
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            
            // TODO: Use the socket to 'receive' the packet here
            socket.receive(packet);
            
            String received = new String(packet.getData(), 0, packet.getLength());
            System.out.println("Echo Server intercepted:  " + received.trim() );

            // Step 1: Fetch a random technology quote from the web
            Scanner s = new Scanner(URI.create("http://api.quotable.io/random?tags=technology").toURL().openStream());
            String webData = s.useDelimiter("\\A").next();
            s.close();

             System.out.println("Quote fetched: " + webData);
             
            // Step 2: Send the fetched quote back to the client
            InetAddress clientAddress = packet.getAddress();
            int clientPort = packet.getPort();
            byte[] responseBytes = webData.getBytes();
            DatagramPacket response = new DatagramPacket(
                responseBytes, responseBytes.length, clientAddress, clientPort
            );
            socket.send(response);

        }
    }
}


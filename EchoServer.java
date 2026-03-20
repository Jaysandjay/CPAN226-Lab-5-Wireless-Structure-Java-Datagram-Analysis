import java.net.*;

public class EchoServer {
    public static void main(String[] args) throws Exception {
        // Step A: Create a socket to listen on port 5000
        DatagramSocket socket = new DatagramSocket(5000);
        byte[] buffer = new byte[1024];

        System.out.println("Server is listening on port 5000...");

        while (true) {
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            
            // TODO: Use the socket to 'receive' the packet here
            
            String received = new String(packet.getData(), 0, packet.getLength());
            System.out.println("Received: " + received);

            // TODO: Use the socket to 'send' the packet back to the client
        }
    }
}


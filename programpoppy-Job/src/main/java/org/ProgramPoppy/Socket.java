package org.ProgramPoppy;

import org.apache.logging.log4j.message.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class HelloServer {
    private static final Logger logger = LoggerFactory.getLogger(HelloServer.class);

    public void start(int port) {
        // 1. Create a ServerSocket object and bind it to a port
        try (ServerSocket server = new ServerSocket(port)) {
            Socket socket;
            // 2. Listen for client requests with accept() method
            while ((socket = server.accept()) != null) {
                logger.info("Client connected");
                try (ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                     ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream())) {
                    // 3. Read the client's request information through the input stream
                    Message message = (Message) objectInputStream.readObject();
                    //logger.info("Server received message: " + message.getContent());
                    //message.setContent("New content");
                    // 4. Send a response to the client through the output stream
                    objectOutputStream.writeObject(message);
                    objectOutputStream.flush();
                } catch (IOException | ClassNotFoundException e) {
                    logger.error("Occur exception:", e);
                }
            }
        } catch (IOException e) {
            logger.error("Occur IOException:", e);
        }
    }

    public static void main(String[] args) {
        HelloServer helloServer = new HelloServer();
        helloServer.start(6666);
    }
}

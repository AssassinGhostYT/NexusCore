package net.nexuscore.server;

import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * ¡El Reinicio! NexusCore como un Servidor Web simple.
 * Esto funcionará al 100% y demostrará que nuestro entorno es perfecto.
 */
public class NexusCore {

    private static final int PORT = 8080; // Usamos un puerto estándar para web

    public static void main(String[] args) {
        System.out.println("==============================================");
        System.out.println("||   NexusCore - Web Edition v1.0.0         ||");
        System.out.println("==============================================");

        try {
            // Creamos un servidor que escucha conexiones TCP (el protocolo de la web)
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("[INFO] Servidor WEB escuchando en http://localhost:" + PORT);

            // Bucle para aceptar clientes (pestañas del navegador)
            while (true) {
                // El programa se detiene aquí hasta que alguien se conecta
                Socket clientSocket = serverSocket.accept();
                System.out.println("[INFO] ¡Cliente conectado desde " + clientSocket.getInetAddress() + "!");

                // Preparamos nuestra respuesta HTML
                String httpResponse = "HTTP/1.1 200 OK\r\n\r\n" +
                                      "<h1>¡NexusCore Vive!</h1>" +
                                      "<p>Si ves esto, significa que has creado con exito un servidor web en Java puro.</p>" +
                                      "<p>¡Felicidades, has vencido todos los obstaculos!</p>";

                // Enviamos la respuesta al navegador
                OutputStream output = clientSocket.getOutputStream();
                output.write(httpResponse.getBytes(StandardCharsets.UTF_8));
                output.flush();
                
                // Cerramos la conexión con este cliente
                clientSocket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
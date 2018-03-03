package sockets;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Rodrigo Lopes Napolitano
 */
public class MainServidor {

    public static void main(String[] args) {

        ServerSocket server;

        Socket cliente;

        Scanner in;

        PrintStream saida;
        
        Boolean start = true;

        //Servidor
        //Criação do socket Servidor e bind
        try {

            server = new ServerSocket(9876);

        } catch (Exception e) {
            System.out.println("Erro ao criar servidor na porta 9876 \n"
                    + "Log: " + e.getMessage());
            return;
        }
        while (start) {
            //Espera pelo pedido do cliente: accept
            try {

                System.out.println("Aguardando conexão...");

                cliente = server.accept();

                System.out.println("Conexão estabelecida \n"
                        + cliente.getInetAddress().getHostAddress());

            } catch (Exception e) {
                System.out.println("Erro ao conectar com cliente :C  \n"
                        + "Log: " + e.getMessage());
                return;
            }

            //Etapa de comunicação
            try {

                in = new Scanner(cliente.getInputStream());

                String entrada;

                entrada = in.nextLine();

                System.out.println("Recebido: " + entrada);

                saida = new PrintStream(cliente.getOutputStream());

                saida.println("Opa, tudo bom?");

            } catch (Exception e) {
                System.out.println("Erro de comunicação :C \n"
                        + "Log: " + e.getMessage());
                return;
            }

            //Encerramento da conexão
            try {

                cliente.close();
                
                if (cliente.getInetAddress().getHostAddress().equalsIgnoreCase("192.168.36.158")) {
                    System.out.println("Eduardo se conectou :P");
                    server.close();
                    cliente.close();
                    start = false;
                }

            } catch (Exception e) {
                System.out.println("Erro ao encerrar conexão :C \n"
                        + "Log: " + e.getMessage());
            }

        }
    }
}

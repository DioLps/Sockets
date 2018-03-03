package sockets;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author diolps
 */
public class MainServidor {

    public static void main(String[] args) {

        //Declaração de escopo
        ServerSocket server;
        
        Socket cliente;
        
        Scanner in;
        
        //Criação do socket Servidor e bind
        try {
            server = new ServerSocket(9876);
        } catch (Exception e) {
            System.out.println("Erro ao criar socket na porta 9876");
            System.out.println("Erro: " + e.getMessage());
            return;
        }

        //Espera pelo pedido do cliente: accept
        try {
            System.out.println("Aguardando conexão..");
            cliente = server.accept();
            System.out.println("Conectado a: " + cliente.getInetAddress().getHostAddress());
        } catch (Exception e) {
            System.out.println("Erro ao conectar com cliente");
            System.out.println("Erro: " + e.getMessage());
            return;
        }

        //Etapa de comunicação
        try {
            in = new Scanner(cliente.getInputStream());
            
            String entrada =  in.nextLine();
            
            System.out.println("Recebido: " + entrada);
            
        } catch (Exception e) {
            System.out.println("Erro de comunição");
            System.out.println("Erro: " + e.getMessage());
            return;
        }
        //Encerramento da conexão
        try {
            
            server.close();
            
            cliente.close();
            System.out.println("Saindo..");
        } catch (Exception e) {
            System.out.println("Erro ao encerrar conexão");
            System.out.println("Erro: " + e.getMessage());
        }
    }
}

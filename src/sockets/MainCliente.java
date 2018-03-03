package sockets;

import java.io.PrintStream;
import java.net.Socket;

/**
 *
 * @author Rodrigo Lopes Napolitano
 */
public class MainCliente {

    public static void main(String[] args) {

        Socket socket;

        PrintStream saida;

        //Cliente
        //Etapa pedido de conexão
        try {

            socket = new Socket("localhost", 9876);

        } catch (Exception e) {
            System.out.println("Erro ao conectar com o servidor :C \n"
                    + "Log: " + e.getMessage());
            return;
        }

        //Etapa de conexão
        try {

            saida = new PrintStream(socket.getOutputStream());

            saida.println("Oi, tudo bem?");

        } catch (Exception e) {
            System.out.println("Erro ao enviar dados :C  \n"
                    + "Log: " + e.getMessage());
            return;
        }

        //Encerramento da conexão
        try {

            socket.close();

        } catch (Exception e) {
            System.out.println("Erro ao encerrar conexão :C \n"
                    + "Log: " + e.getMessage());
        }

    }

}

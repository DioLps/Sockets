package sockets;

import java.io.PrintStream;
import java.net.Socket;

/**
 *
 * @author diolps
 */
public class MainCliente {

    public static void main(String[] args) {

        //Declaração de escopo
        Socket socket;

        PrintStream saida;

        //Etapa pedido de conexão - Utilizar porta 9876 e ip da máquina onde o servidor está rodando.
        try {
            socket = new Socket("localhost", 9876);
        } catch (Exception e) {
            System.out.println("Erro ao Solicitar conexão");
            System.out.println("Erro: " + e.getMessage());
            return;
        }

        //Etapa de comunicacao - Onde será enviada a mensagem ao servidor.
        try {
            saida = new PrintStream(socket.getOutputStream());

            saida.println("Se inscreve no canal!");

        } catch (Exception e) {
            System.out.println("Erro ao enviar dados");
            System.out.println("Erro: " + e.getMessage());
            return;
        }
        //Encerramento da conexão
        try {
            System.out.println("Saindo..");
            socket.close();
        } catch (Exception e) {
            System.out.println("Erro ao encerrar conexão");
            System.out.println("Erro: " + e.getMessage());
        }

    }

}

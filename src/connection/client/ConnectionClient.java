/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection.client;
import java.net.*;
import java.io.*;
/**
 *
 * @author elkha
 */
public class ConnectionClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int porta = 3500;
        String ns = "localhost";
        BufferedReader in;
        DataOutputStream out;
        BufferedReader tastiera;
        String stringaUtente;
        String stringaRicevutaServer;
        
        try{
            Socket connection;
            connection = new Socket(ns, porta);
            out = new DataOutputStream(connection.getOutputStream());
            in = new BufferedReader(new InputStreamReader(System.in));
            tastiera = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Inserisci la stringa da trasmettere al server: \n");
            stringaUtente = tastiera.readLine();
            System.out.println("Invio stringa  e attendo risposta del server.. \n");
            out.writeBytes(stringaUtente);
            stringaRicevutaServer = in.readLine();
            System.out.println("Risposta : " + stringaRicevutaServer);
            System.out.println("\nTERMINE\n");
            connection.close();
        } 
        catch(IOException ex){
            System.err.println("Errore: " + ex);
            System.exit(0);
        }
        ;
        
    }
    
}

import java.net.*;
import java.io.*;
import java.lang.*;

class Server
{
    public static void main(String args[]) throws IOException
    {
        ServerSocket ss = null;
        Socket clientSocket = null;
        try
        {
            ss = new ServerSocket(Integer.parseInt(args[0]));
            System.out.println("Waiting for Client");
            clientSocket = ss.accept();
            System.out.println("Connected to Client IP: " + clientSocket.getInetAddress() + " :: Port: "+ + clientSocket.getPort());
            
            //thread for Receive Message
            ReceiveMessage rfc = new ReceiveMessage(clientSocket);
            Thread t1 = new Thread(rfc);
            t1.start();
            
            //thread to send message
            SendMessage stc = new SendMessage(clientSocket);
            Thread t2 = new Thread(stc);
            t2.start();
            
        }catch(Exception e){
            System.out.println("Unable to Connect to any Client");
        }
        finally
        {
            try{
                ss.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
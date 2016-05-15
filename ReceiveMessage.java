import java.io.*;
import java.net.*;
import java.lang.*;

class ReceiveMessage implements Runnable
{
    Socket rcvSocket = null;
    DataInputStream din = null;

    public ReceiveMessage(Socket rcvSocket)
    {
        this.rcvSocket = rcvSocket;
    }
    public void run()
    {
        try{
            String receive = "";
            din = new DataInputStream(rcvSocket.getInputStream());
            while(true)
            {
                receive = (String)din.readUTF();
                System.out.println("Received: " + receive);
            }
        }catch(Exception e){
            System.out.println("Problem in Receiving From Client");
        }
        finally
        {
            try{
                rcvSocket.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }

    }
}

import java.io.*;
import java.net.*;
import java.lang.*;

class SendMessage implements Runnable
{
    Socket sendSocket = null;
    DataOutputStream dout = null;
    BufferedReader br = null;
    public SendMessage(Socket sendSocket){
        this.sendSocket = sendSocket;
    }
    public void run()
    {
        try{
            br = new BufferedReader(new InputStreamReader(System.in));
            dout = new DataOutputStream(sendSocket.getOutputStream());
            String send = "";
            while(true){
                send = br.readLine();
                dout.writeUTF(send);
                dout.flush();
            }
        }catch(Exception e){
            System.out.println("Problem in Sending to Client");
        }
        finally
        {
            try{
                sendSocket.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
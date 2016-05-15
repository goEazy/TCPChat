import java.io.*;
import java.net.*;
import java.lang.*;

class Client    
{
	public static void main(String args[]) throws IOException
    {
        Socket sSocket = null;
        DataOutputStream dout = null;
        try
        {
            sSocket = new Socket(args[0], Integer.parseInt(args[1]));
            System.out.println("Connected to Server");
            //thread for Receive Message
            ReceiveMessage rfs = new ReceiveMessage(sSocket);
            Thread t1 = new Thread(rfs);
            t1.start();
            
            //thread for Send Message
            SendMessage sts = new SendMessage(sSocket);
            Thread t2 = new Thread(sts);
            t2.start();   
        }catch(Exception e){
            System.out.println("Unable to Reach Server....");
        }
    }   
}   
import java.io.*;
import java.net.*;
import java.util.*;
public class serverContact extends Thread
{
   private Socket clientSocket;
   private BufferedReader inFromServer;
   private boolean running = true;
   private String sentence = "";
   serverContact(Socket c)
   {
      clientSocket = c;
   }
   
   public void run()
   {
      
      try{
         inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
      }
      catch (Exception e){
         System.out.println(e);
      }
      
      do
      {
         try{
            sentence = inFromServer.readLine();
            System.out.println(sentence);
         }
         catch (Exception e){
            System.out.println(e);
         }
         
      }while(running);
      
      try{
         clientSocket.close();
         inFromServer.close();
      }
      catch (Exception e){
         System.out.println(e);
      }
   }
   
   public void quit()
   {
      running = false;
   }
}
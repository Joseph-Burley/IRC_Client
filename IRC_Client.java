//creates a client
import java.io.*;
import java.net.*;

class IRC_Client
{
   public static void main(String args[]) throws Exception
   {
      String ipaddress = "localhost";
      String port = "6789";
      String sentence = "";
      String userQuit = "/quit";
      
      if(args.length > 1)
      {
         ipaddress = args[0];
         port = args[1];
      }
      
      BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
      Socket clientSocket = new Socket(ipaddress, Integer.parseInt(port));
      while(!clientSocket.isConnected())
      {
      }
      System.out.println("Client is connected");
      DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
      BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
      
      System.out.println("Enter a line or \"/quit\"");
      do
      {
         if(inFromUser.ready())
         {
            sentence = inFromUser.readLine();
            outToServer.writeBytes(sentence + '\n');
         }
         if(inFromServer.ready())
         {
            System.out.println(inFromServer.readLine());
         }
         /*
         if(!sentence.equals(userQuit))
         {
            modifiedSentence = inFromServer.readLine();
            System.out.println("From Server: " + modifiedSentence);
         }
         */
      }while(!sentence.equals(userQuit));
      
      clientSocket.close();
   }
}
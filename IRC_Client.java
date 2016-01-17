//creates a client
import java.io.*;
import java.net.*;

class IRC_Client
{
   public static void main(String args[]) throws Exception
   {
      String sentence;
      String modifiedSentence;
      String userQuit = "/quit";
      
      BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
      Socket clientSocket = new Socket("localhost", 6789);
      while(!clientSocket.isConnected())
      {
      }
      System.out.println("Client is connected");
      DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
      BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
      
      do
      {
         System.out.println("Enter a line or \"/quit\"");
         sentence = inFromUser.readLine();
         outToServer.writeBytes(sentence + '\n');
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
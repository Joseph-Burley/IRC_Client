//creates a client
import java.io.*;
import java.net.*;
import java.util.Scanner;

class IRC_Client
{
   public static void main(String args[]) throws Exception
   {
      String ipaddress = "localhost";
      String port = "6789";
      String sentence = "";
      String userQuit = "/quit";
      serverContact sc;
      
      if(args.length > 1)
      {
         ipaddress = args[0];
         port = args[1];
      }
      
      //create io things
      Scanner inFromUser = new Scanner(System.in);
      Socket clientSocket = new Socket(ipaddress, Integer.parseInt(port));
      while(!clientSocket.isConnected())
      {
      }
      BufferedWriter outToServer = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
      //start socket thread
      sc = new serverContact(clientSocket);
      sc.start();
      System.out.println("Client is connected");
      
      
      
      System.out.println("Enter a line or \"/quit\"");
      do
      {
         
            sentence = inFromUser.nextLine();
            outToServer.write(sentence, 0, sentence.length());//try using outToServer.newLine() instead?
            outToServer.newLine();
            outToServer.flush();
        
         
      }while(!sentence.equals(userQuit));
      
      sc.quit();
      clientSocket.close();
   }
}
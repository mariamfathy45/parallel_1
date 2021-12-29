package parallel;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class client2 {
    
    public static void main(String[] args)throws IOException//throwing an exception is essiential for handling possible errors
    
    {
        //create a socket object that holds network, &amp; port numbrt, network in this case is localhost as it&#039;s running on your local device
        Socket s = new Socket("localhost", 9999); //192.168.1.5
        //create DataOutputStream object to change the output data to form of streams with passing the socket object to
        DataOutputStream outToServer = new DataOutputStream(s.getOutputStream());
        
        DataInputStream in = new DataInputStream(s.getInputStream()); 
        
        System.out.println("please enter username and password");
  
        //buffer object is used to hold the data output from the client side 
        BufferedReader username = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedReader password = new BufferedReader(new InputStreamReader(System.in)); 

        while(true)
        {
                 
         //then a string is used to hold the data entered from the uesr to read it as a line
          String sentencetoclient = username.readLine(); 
          String sentencetoclient2 = password.readLine(); 

          outToServer.writeUTF(sentencetoclient);
          outToServer.writeUTF(sentencetoclient2);
          //
          String sentencefromserver = in.readUTF(); 
          System.out.println("Server:" + sentencefromserver);
          //
          if(sentencetoclient.equalsIgnoreCase("exist"))
          {
              break;
          }
        }
        s.close();
    
    }
    
}
    


package parallel;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
public class server {
    
    public static void main(String[] args)throws IOException //throwing an exception is essiential for handling possible errors
    {
        String clientSentence; 
        String capitalizedSentence; 

              //create a serverSocket object that handles the port number for the application InputStreamReader
              //any port number would do fine as long as it&#039;s used same port number at the clientServer side 
              ServerSocket s = new ServerSocket(9999); 
              Socket ss = s.accept(); //to accept the connection between server &amp; client
              System.out.println("Connected: "+ ss);
//              ServerSocket s2 = new ServerSocket(9992); 
//              Socket ss2 = s2.accept();
//              System.out.println("Connected client2");
//              ServerSocket s3 = new ServerSocket(9993); 
//              Socket ss3 = s3.accept();
//              System.out.println("Connected client3");
              //while loop is being used to keep connection alive between server &amp; client //TCP connection orianted
              DataInputStream in = new DataInputStream(ss.getInputStream()); 
//              DataInputStream in2 = new DataInputStream(ss2.getInputStream()); 
//              DataInputStream in3 = new DataInputStream(ss3.getInputStream()); 
              DataOutputStream outToServer = new DataOutputStream(ss.getOutputStream());
//              DataOutputStream outToServer2 = new DataOutputStream(ss2.getOutputStream());
//              DataOutputStream outToServer3 = new DataOutputStream(ss3.getOutputStream());
              //buffer object is used to hold the data output from the client side 
              BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
              
              while(true) { 
                  String username = in.readUTF(); 
                  String password = in.readUTF();    
                  System.out.println("client:" + username);
                  System.out.println("client:" + password);
                  //
                  if ("karim".equals(username) && "2018".equals(password) )
                  {
                    outToServer.writeUTF("Login client1");
                  }
                  
                  //
                 
                  else if ("joya".equals(username) && "2019".equals(password) )
                  {
                    outToServer.writeUTF("Login client2");
                  }
                 
                  //
                  
                 else if ("remo".equals(username) && "2020".equals(password) )
                  {
                    outToServer.writeUTF("Login client3");
                  }
                  else
                  {
                      outToServer.writeUTF("Login failed");
                  }
                  //
                  if (username.equalsIgnoreCase("exist"))
                  {
                      break;
                  }
              } 
              ss.close();
//            ss2.close();
//            ss3.close();
    }
    
}

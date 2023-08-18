package pack2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.Socket;
import java.util.Scanner;



public class Client {
    private static DataOutputStream dataOutputStream = null;
    private static DataInputStream dataInputStream = null;
    String ipaddress;
    String display;

    public void getip(){
        Scanner s= new Scanner(System.in);
        System.out.println("Enter ip of server");
        ipaddress=s.nextLine();

    }

    public void runclient(String Display)
    {

        // Create Client Socket connect to port 900
        getip();

        //clobj.getInputPath("C:\\");



        try (Socket socket = new Socket(ipaddress, 900)) {

            dataInputStream = new DataInputStream(
                    socket.getInputStream());
            dataOutputStream = new DataOutputStream(
                    socket.getOutputStream());
            System.out.println(
                    "Sending the File to the Server");


            // Call SendFile Method

           // pack3.desktop clobj=new pack3.desktop();
            //String Display=obj5.disp;
            //System.out.println(Display);

            sendFile(Display);
            System.out.println("File sent");

            dataInputStream.close();
            dataInputStream.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    // sendFile function define here
    private static void sendFile(String path)
            throws Exception
    {
        int bytes = 0;
        // Open the File where he located in your pc
        File file = new File(path);
        FileInputStream fileInputStream
                = new FileInputStream(file);

        // Here we send the File to Server
        dataOutputStream.writeLong(file.length());
        // Here we break file into chunks
        byte[] buffer = new byte[4 * 1024];
        while ((bytes = fileInputStream.read(buffer))
                != -1) {
            // Send the file to Server Socket
            dataOutputStream.write(buffer, 0, bytes);
            dataOutputStream.flush();
        }
        // close the file here
        fileInputStream.close();
    }
}


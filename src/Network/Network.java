package Network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.Socket;

public class Network {

    private static Network network;

    public static Network getInstance() {
        if (network == null) {
            network = new Network();
            return network;
        } else {
            return network;
        }
    }

    private String ip;
    private int port;
    private boolean logedin;
    private Socket socket;
    private DataOutputStream os;
    private DataInputStream is;


    private Network(){
        logedin = false;
        try {
            socket = new Socket(ip,port);
            os = new DataOutputStream(socket.getOutputStream());
            is = new DataInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public boolean login(String id, String pw){
        try {
            os.writeUTF(id);
            os.writeInt(pw.hashCode());

            int result = is.readInt();

            if(result == 0)
                return false;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return logedin = true;
    }

    public void logout(){
        try {
            socket.close();
            logedin = false;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void send(File f){
        try {
            String fName = f.getName();
            os.writeUTF(fName);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

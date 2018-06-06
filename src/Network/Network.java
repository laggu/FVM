package Network;

import Main.Status;

import java.io.*;
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
    private ObjectOutputStream objectOutputStream;
    private ObjectInputStream objectInputStream;

    private Network(){
        logedin = false;
        try {
            socket = new Socket(ip,port);
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectInputStream = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public boolean login(String id, String pw){
        try {
            objectOutputStream.writeUTF(id);
            objectOutputStream.writeInt(pw.hashCode());

            int result = objectInputStream.readInt();

            if(result == 1){
                Status status = Status.getInstance();
                ClientStatus clientStatus = new ClientStatus(id,status.getProjectName(),status.getBranch(),status.getVersion());
                objectOutputStream.writeObject(clientStatus);
            }
            else
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

    private void sendFile(File f){
        byte[] buffer = new byte[10000];
        int readBytes;

        try {
            String fName = f.getName();
            objectOutputStream.writeUTF(fName);

            FileInputStream fis = new FileInputStream(f);

            while ((readBytes = fis.read(buffer)) > 0) {
                objectOutputStream.write(buffer, 0, readBytes);
                objectOutputStream.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendDir(File dir){

    }

    private void receiveFile(){
        byte[] buffer = new byte[10000];
        int n;

        try{
            String fileName = objectInputStream.readUTF();


            // 경로 변경 필요함    !!!!!!!!!!!!
            File f = new File(fileName);
            FileOutputStream fos = new FileOutputStream(f);

            while((n = objectInputStream.read(buffer)) != -1){
                fos.write(buffer,0,n);
                fos.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void receiveDir(){

    }
}
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
        int result = 0;

        try {
            objectOutputStream.writeInt(0);
            String fName = f.getName();
            objectOutputStream.writeUTF(fName);

            FileInputStream fis = new FileInputStream(f);

            while ((readBytes = fis.read(buffer)) > 0) {
                objectOutputStream.write(buffer, 0, readBytes);
                objectOutputStream.flush();
            }

            result = objectInputStream.readInt();
            if(result == 1)
                System.out.println("전송 성공 : " + f.getName());
            else
                System.out.println("전송 실패 : " + f.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendDir(File dir){
        int result = 0;
        try {
            objectOutputStream.writeInt(1);
            String dirName = dir.getName();
            objectOutputStream.writeUTF(dirName);

            File[] list = dir.listFiles();

            for (int i = 0; i < list.length; ++i) {
                if(list[i].isDirectory())
                    sendDir(list[i]);
                else if (list[i].isFile())
                    sendFile(list[i]);
            }

            result = objectInputStream.readInt();
            if(result == 1)
                System.out.println("전송 성공 : " + dir.getName());
            else
                System.out.println("전송 실패 : " + dir.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void receiveFile(String rootPath){
        byte[] buffer = new byte[10000];
        int n;

        try{
            String fileName = objectInputStream.readUTF();

            // 경로 변경 필요함    !!!!!!!!!!!!
            File f = new File(rootPath+fileName);
            FileOutputStream fos = new FileOutputStream(f);

            while((n = objectInputStream.read(buffer)) != -1){
                fos.write(buffer,0,n);
                fos.flush();
            }

            objectOutputStream.writeInt(1);
        } catch (IOException e) {
            e.printStackTrace();
            try {
                objectOutputStream.writeInt(0);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    public void receiveDir(String rootPath){
        try {
            String dirName = objectInputStream.readUTF();

            File dir = new File(rootPath+dirName);
            dir.mkdirs();

            objectOutputStream.writeInt(1);
        } catch (IOException e) {
            e.printStackTrace();
            try {
                objectOutputStream.writeInt(0);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    public void receive(){
        String rootPath = null;

        try {
            rootPath = objectInputStream.readUTF();

            while (true) {
                int receiveCode = objectInputStream.readInt();
                if (receiveCode == 1) {
                    receiveDir(rootPath);
                } else if (receiveCode == 2) {
                    receiveFile(rootPath);
                } else if (receiveCode == 3) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
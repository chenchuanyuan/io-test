package com.ccy;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author CCY
 */
public class Bio {
    public static void main(String[] args) throws IOException {
        try {
            ServerSocket ss = new ServerSocket(8888);
            System.out.println("启动服务器....");
            // accept 获取一个跟客户端 new 的 socket 对接的对象
            Socket s = ss.accept();
            System.out.println("客户端:"+s.getInetAddress().getLocalHost()+"已连接到服务器");

            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            //读取客户端发送来的消息
            String mess = br.readLine();
            System.out.println("客户端："+mess);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
            bw.write(mess+"\n");
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

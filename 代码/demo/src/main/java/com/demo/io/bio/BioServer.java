package com.demo.io.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BioServer {

    public static void main(String[] args) throws IOException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        ServerSocket serverSocket = new ServerSocket(6666);
        while (true) {

            final Socket accept = serverSocket.accept();
            System.out.println("客户端连接成功!" + accept.getLocalAddress().toString());
            executorService.execute(() -> run(accept));
        }
    }

    private static void run(Socket accept) {
        try{

            byte[] bytes = new byte[1024];
            InputStream inputStream = accept.getInputStream();
            while(true) {
                int read = inputStream.read(bytes);
                if (read != -1) {
                    System.out.println(Thread.currentThread() + ":" +new String(bytes, 0, read));
                } else {
                    break;
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                accept.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

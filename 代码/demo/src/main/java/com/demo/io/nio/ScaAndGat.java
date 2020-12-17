package com.demo.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

public class ScaAndGat {

    /**
     *  将数据写入到buffer
     *
     *  将buffer写入到数据
     * @param args
     */

    public static void main(String[] args) throws IOException {
        ServerSocketChannel open = ServerSocketChannel.open();
        InetSocketAddress inetSocketAddress = new InetSocketAddress(7777);
        open.socket().bind(inetSocketAddress);

        ByteBuffer[] byteBuffers = new ByteBuffer[2];
        byteBuffers[0] = ByteBuffer.allocate(5);
        byteBuffers[1] = ByteBuffer.allocate(3);

        SocketChannel accept = open.accept();
        int mesLength = 8;

        while(true){
            int byteRead = 0;
//            while (byteRead < mesLength) {
            long read = accept.read(byteBuffers);
            byteRead += read;
            Arrays.asList(byteBuffers).stream()
                    .map(byteBuffer -> "position:" + byteBuffer.position() + ", limit:" + byteBuffer.limit())
                    .forEach(System.out::println);
//            }

            System.out.println("byteRead:" + byteRead);
            Arrays.asList(byteBuffers).stream()
                    .map(byteBuffer -> "" + new String(byteBuffer.array()))
                    .forEach(System.out::println);
            //反转
            Arrays.asList(byteBuffers).forEach(ByteBuffer::flip);
            //打印
            int byteWrite = 0;
//            accept.write(byteBuffers);
            System.out.println("byteWrite:" + byteWrite);
            //复位
            Arrays.asList(byteBuffers).forEach(ByteBuffer::clear);
            System.out.println();
        }
    }
}

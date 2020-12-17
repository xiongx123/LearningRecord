package com.demo.io.nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Demo1 {

    public static void main(String[] args) {
        String fileName = "d://test.txt";
        try {
            write(fileName);
            read(fileName);
            readOnWrite(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readOnWrite(String fileName) throws IOException {
        File file = new File(fileName);
        FileInputStream fileInputStream = new FileInputStream(file);
        FileChannel channel = fileInputStream.getChannel();

        FileOutputStream fileOutputStream = new FileOutputStream("d://test_write.txt");
        FileChannel channel_write = fileOutputStream.getChannel();

//        ByteBuffer byteBuffer = ByteBuffer.allocate((int)file.length());
//        channel.read(byteBuffer);
//        byteBuffer.flip();
//        channel_write.write(byteBuffer);
        channel.transferTo( 0, file.length(), channel_write);
//        channel_write.transferFrom(channel, 0, file.length());


        fileInputStream.close();
        fileOutputStream.close();
        channel.close();
        channel_write.close();

    }


    private static void write(String fileName) throws IOException{
        FileOutputStream  fileOutputStream = new FileOutputStream(fileName);

        FileChannel  fileChannel = fileOutputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("AAAA").append("\n")
                .append("dddd").append("\n")
                .append("cccc").append("\n")
                .append("cccc");

        byteBuffer.put(stringBuffer.toString().getBytes());

        byteBuffer.flip();

        fileChannel.write(byteBuffer);

        byteBuffer.clear();
        fileOutputStream.close();
        fileChannel.close();
    }

    private static void read(String fileName) throws IOException {
        File file = new File(fileName);
        FileInputStream fileInputStream = new FileInputStream(file);
        FileChannel channel = fileInputStream.getChannel();
        ByteBuffer allocate = ByteBuffer.allocate(1024);
        channel.read(allocate);
        allocate.flip();
        System.out.println(new String(allocate.array()));
        fileInputStream.close();
        channel.close();
    }

}

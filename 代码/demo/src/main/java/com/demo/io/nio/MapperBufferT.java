package com.demo.io.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class MapperBufferT {

    public static void main(String[] args) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("" , "rw");
        FileChannel channel = randomAccessFile.getChannel();
        //直接修改堆外内存
        MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_WRITE, 0, 5);
        map.put(2, (byte)'1');
        randomAccessFile.close();
    }
}

package com.demo.io.nio;

import java.nio.ByteBuffer;

public class BufferDemo {

    public static void main(String[] args) {
        ByteBuffer allocate = ByteBuffer.allocate(10);
        allocate.putDouble(1.);
        allocate.putFloat(1f);
        allocate.putChar('熊');

    }
}

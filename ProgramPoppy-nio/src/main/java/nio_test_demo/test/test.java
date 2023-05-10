package nio_test_demo.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class test {
    public static void main(String[] args) {
        test2();
    }

    public static void test1() {
        String str = "testString";

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        /*
        * 容量（capacity）表示该缓冲区最多可以存储多少字节数据；
        * 限制（limit）表示该缓冲区中实际存储的数据大小；
        * 位置（position）表示下一个要读取或写入的元素的位置，默认为 0。
        * */
        //分配一个指定大小的缓冲区
        System.out.println("---------------------------allocate---------------------------");
        System.out.println(byteBuffer.capacity());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.position());

        //利用 put() 存入数据到缓冲区中
        byteBuffer.put(str.getBytes());
        System.out.println("---------------------------put---------------------------");
        System.out.println(byteBuffer.capacity());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.position());

        //切换到读数据模式
        byteBuffer.flip();
        System.out.println("---------------------------flip---------------------------");
        System.out.println(byteBuffer.capacity());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.position());

        //利用 get() 读取缓冲区中的数据
        byte[] dst = new byte[byteBuffer.limit()];
        byteBuffer.get(dst);
        System.out.println(new String(dst,0,dst.length));
        System.out.println("---------------------------get---------------------------");
        System.out.println(byteBuffer.capacity());   //1024
        System.out.println(byteBuffer.limit());      //10,可以读取数据的大小依然是 10 个
        System.out.println(byteBuffer.position());   //10,读完之后位置变到了第 10 个

        //rewind() 可重复读
        byteBuffer.rewind();         //这个方法调用完后,又变成了读模式
        System.out.println("---------------------------rewind---------------------------");
        System.out.println(byteBuffer.capacity());   //1024
        System.out.println(byteBuffer.limit());      //10
        System.out.println(byteBuffer.position());  //0

        //clear() 清空缓冲区,虽然缓冲区被清空了，但是缓冲区中的数据依然存在，只是出于"被遗忘"状态。意思其实是，缓冲区中的界限、位置等信息都被置为最初的状态了，所以你无法再根据这些信息找到原来的数据了，原来数据就出于"被遗忘"状态
        byteBuffer.clear();
        System.out.println("---------------------------clear---------------------------");
        System.out.println(byteBuffer.capacity());   //1024
        System.out.println(byteBuffer.limit());      //1024
        System.out.println(byteBuffer.position());  //0
    }

    public static void test2() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        System.out.println(byteBuffer.isDirect());
    }

    public static void test3() throws Exception {
        /*
        * 推荐使用try方法
        * */
        FileInputStream fis = new FileInputStream("a.txt");
        FileOutputStream fos = new FileOutputStream("b.txt");
        FileChannel fisChannel = fis.getChannel();
        FileChannel fosChannel = fos.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        while (fisChannel.read(byteBuffer) != -1) {
            byteBuffer.flip();
            fosChannel.write(byteBuffer);
            byteBuffer.clear();
        }
        fosChannel.close();
        fisChannel.close();
        fos.close();
        fis.close();

    }
}

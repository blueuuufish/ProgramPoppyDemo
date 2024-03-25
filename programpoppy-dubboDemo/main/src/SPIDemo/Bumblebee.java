package src.SPIDemo;

import org.junit.Test;

import java.util.ServiceLoader;

public class Bumblebee implements Robot{
    @Override
    public void sayHello() {
        System.out.println("Hello, I am Bumblebee");
    }
}


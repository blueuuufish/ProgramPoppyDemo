package com.ProgramPoppy.jvmti;

import java.lang.instrument.Instrumentation;

public class MyFirstAgent {
    /*
    * 需求：初步创建一个Agent，来实现监视的功能
    * */
    public static void main(String[] args, Instrumentation instrumentation) {
        System.out.println("MyAgent is running");
        instrumentation.addTransformer(new MyTransformer());
    }
    
}

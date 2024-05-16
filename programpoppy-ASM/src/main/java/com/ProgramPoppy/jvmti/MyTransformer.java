package com.ProgramPoppy.jvmti;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

public class MyTransformer implements ClassFileTransformer {
    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        if("com/ProgramPoppy/jvmti/MyFirstAgent".equals(className)) {
            System.out.println("Transforming " + className);
        }
        return classfileBuffer;
    }
}

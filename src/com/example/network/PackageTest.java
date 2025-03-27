package com.example.network;

public class PackageTest {
    void ploof(){
        PackageTestPkg packageTest = new PackageTestPkg() {
            @Override
            void doSomething() {
                System.out.println("override");
            }
        };
    }
}

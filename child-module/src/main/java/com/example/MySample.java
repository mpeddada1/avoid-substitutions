package com.example;

import com.example.MyAbstractGoogleClientRequest.ApiClientVersion;

public class MySample {

    public static void main(String... args) {
        System.out.println("HELLLOOO");
        // This will be true when we run this application as a native image.
        System.out.println(NativeImageDetector.inNativeImage());
        System.out.println(GaxProperties.getJavaVersion());
        System.out.println(ApiClientVersion.DEFAULT_VERSION);
    }
}
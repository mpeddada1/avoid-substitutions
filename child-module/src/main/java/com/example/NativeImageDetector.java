package com.example;

public class NativeImageDetector {

    private static final String imageCode = System.getProperty("org.graalvm.nativeimage.imagecode");

    /**
     * Returns {@code true} if invoked in the context of image building or during image runtime, else {@code false}.
     */
    public static boolean inNativeImage() {
        if (imageCode != null) {
            return imageCode.equals("runtime");
        }
        return false;
    }
}

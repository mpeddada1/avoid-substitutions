
package com.example;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/** Provides properties of the GAX library. */
public class GaxProperties {

    private static final String DEFAULT_VERSION = "";
    private static final String GAX_VERSION = getLibraryVersion(GaxProperties.class, "version.gax");
    private static final String JAVA_VERSION = getRuntimeVersion();

    private GaxProperties() {}

    /** Returns the version of the library that the {@code libraryClass} belongs to */
    public static String getLibraryVersion(Class<?> libraryClass) {
        String version = libraryClass.getPackage().getImplementationVersion();
        return version != null ? version : DEFAULT_VERSION;
    }

    /**
     * Returns the version of the library that the {@code libraryClass} belongs to, or a property
     * value in dependencies.properties resource file instead, if the version was not found. The
     * method is doing I/O operations and is potentially inefficient, the values returned by this
     * method are expected to be cached.
     */
    public static String getLibraryVersion(Class<?> libraryClass, String propertyName) {
        String version = null;
        // Always read GaxProperties' version from the properties file.
        if (!libraryClass.equals(GaxProperties.class)) {
            version = getLibraryVersion(libraryClass);
            if (!DEFAULT_VERSION.equals(version)) {
                return version;
            }
        }

        try (InputStream in = libraryClass.getResourceAsStream("/dependencies.properties")) {
            if (in != null) {
                Properties props = new Properties();
                props.load(in);
                version = props.getProperty(propertyName);
            }
        } catch (IOException e) {
            // ignore
        }

        return version != null ? version : DEFAULT_VERSION;
    }

    /** Returns the version of the running JVM */
    public static String getJavaVersion() {
        if (NativeImageDetector.inNativeImage()) {
            String graalVersion = System.getProperty("java.version") + "-graalvm";
            return graalVersion;
        }
        return JAVA_VERSION;
    }

    /** Returns the current version of GAX. */
    public static String getGaxVersion() {
        return GAX_VERSION;
    }

    /** Returns the current runtime version */
    private static String getRuntimeVersion() {
        return System.getProperty("java.version");
    }
}
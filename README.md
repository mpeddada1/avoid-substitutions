https://www.graalvm.org/sdk/javadoc/index.html?constant-values.html

Reference: https://github.com/spring-projects/spring-framework/blob/e681e713d4aa75be988d77f0108f80ecf15e21e9/spring-core/src/main/java/org/springframework/core/NativeDetector.java#L25 

## Run in standard java
1) mvn package
2) java -jar target/child-project-1.0-SNAPSHOT.jar. The result will be: 

```
11.0.15
gl-java/11.0.15 gdcl/1.33.0 linux/5.16.18
```

## Run with GraalVM
1) mvn package -Pnative
2) ./target/child-project. The result will be:

```
11.0.15-graalvm
gl-java/11.0.15-graalvm gdcl/1.33.0 linux/5.16.18
```

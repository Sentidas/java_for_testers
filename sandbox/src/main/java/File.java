public class File {

    public static void main(String[] args) {
        System.out.println("Hello world!");

        var configFile = new java.io.File("sandbox/build.gradle");
        System.out.println(configFile.getAbsoluteFile());
        System.out.println(configFile.exists());
    }
}

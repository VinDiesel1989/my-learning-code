package org.example;

public class ClassLoaderView {

    public static void main(String[] args) throws ClassNotFoundException {
        //加载核心类哭的 Bootstrap ClassLoader
        System.out.println("核心类库加载器：" + ClassLoaderView.class.getClassLoader().loadClass("java.lang.String").getClassLoader());
        //扩展类库加载器 Extension Classloader
        System.out.println("扩展类库加载器：" + ClassLoaderView.class.getClassLoader().loadClass("com.sun.nio.zipfs.ZipCoder").getClassLoader());
        //应用程序的类库加载器
        System.out.println("应用程序类库加载器：" + ClassLoaderView.class.getClassLoader());

        System.out.println(
                "应用程序库加载器的父类的父类：" + ClassLoaderView.class.getClassLoader().getParent().getParent());

        //        C:\Program Files\Java\jdk1.8.0_301\jre\lib\charsets.jar
        //        C:\Program Files\Java\jdk1.8.0_301\jre\lib\deploy.jar
        //        C:\Program Files\Java\jdk1.8.0_301\jre\lib\ext\access-bridge-64.jar
        //        C:\Program Files\Java\jdk1.8.0_301\jre\lib\ext\cldrdata.jar
        //        C:\Program Files\Java\jdk1.8.0_301\jre\lib\ext\dnsns.jar
        //        C:\Program Files\Java\jdk1.8.0_301\jre\lib\ext\jaccess.jar
        //        C:\Program Files\Java\jdk1.8.0_301\jre\lib\ext\jfxrt.jar
        //        C:\Program Files\Java\jdk1.8.0_301\jre\lib\ext\localedata.jar
        //        C:\Program Files\Java\jdk1.8.0_301\jre\lib\ext\nashorn.jar
        //        C:\Program Files\Java\jdk1.8.0_301\jre\lib\ext\sunec.jar
        //        C:\Program Files\Java\jdk1.8.0_301\jre\lib\ext\sunjce_provider.jar
        //        C:\Program Files\Java\jdk1.8.0_301\jre\lib\ext\sunmscapi.jar
        //        C:\Program Files\Java\jdk1.8.0_301\jre\lib\ext\sunpkcs11.jar
        //        C:\Program Files\Java\jdk1.8.0_301\jre\lib\ext\zipfs.jar
        //        C:\Program Files\Java\jdk1.8.0_301\jre\lib\javaws.jar
        //        C:\Program Files\Java\jdk1.8.0_301\jre\lib\jce.jar
        //        C:\Program Files\Java\jdk1.8.0_301\jre\lib\jfr.jar
        //        C:\Program Files\Java\jdk1.8.0_301\jre\lib\jfxswt.jar
        //        C:\Program Files\Java\jdk1.8.0_301\jre\lib\jsse.jar
        //        C:\Program Files\Java\jdk1.8.0_301\jre\lib\management-agent.jar
        //        C:\Program Files\Java\jdk1.8.0_301\jre\lib\plugin.jar
        //        C:\Program Files\Java\jdk1.8.0_301\jre\lib\resources.jar
        //        C:\Program Files\Java\jdk1.8.0_301\jre\lib\rt.jar
        //        F:\IdeaProjects\test\target\classes
        //        H:\JetBrains\IntelliJ IDEA Community Edition 2021.2\lib\idea_rt.jar
        System.out.println(System.getProperty("java.class.path"));


    }
}

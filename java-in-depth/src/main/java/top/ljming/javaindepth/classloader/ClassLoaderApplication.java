package top.ljming.javaindepth.classloader;

import java.io.IOException;
import java.io.InputStream;

/**
 * 类加载器.
 *
 * @author lijm
 */
public class ClassLoaderApplication {
    // 判断两个类是否"相等"

    public static void main(String[] args) throws Exception {
        ClassLoader myClassLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if (is == null) {
                        return super.loadClass(name);
                    }
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException(name);
                }

            }
        };
        Object obj = myClassLoader.loadClass("top.ljming.javaindepth.classloader.ClassLoaderApplication").newInstance();
        System.out.println(obj.getClass().getClassLoader());
        System.out.println(ClassLoaderApplication.class.getClassLoader());
        System.out.println(obj.getClass());
        System.out.println(obj instanceof ClassLoaderApplication);

    }
}

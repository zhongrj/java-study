package zrj.study.test.classloader;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/8/17
 */
public class ClassLoaderTest1 {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoader loader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String filename = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    System.out.println(getClass());
                    InputStream is = getClass().getResourceAsStream(filename);
                    if (is == null) {
                        return super.loadClass(name);
                    }
                    byte[] bytes = new byte[is.available()];
                    is.read(bytes);
                    return defineClass(name, bytes, 0, bytes.length);
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new ClassNotFoundException(name);
                }
            }
        };

        Class<?> clazz = loader.loadClass("zrj.study.test.classloader.Person");
        Object o = clazz.newInstance();
        System.out.println(o.getClass());
        System.out.println(o instanceof Person);
        System.out.println(o.getClass().equals(Person.class));

//        Person p = (Person) o;
    }

}

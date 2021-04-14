import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

public class HandlerTest {
    public static void start(Class<?> testClass) throws InvocationTargetException, IllegalAccessException {
        Method[] methods = testClass.getDeclaredMethods();// array of all methods
        runMethods(methods);
    }

    public static void runMethods(Method[] methods)
            throws InvocationTargetException, IllegalAccessException {
        Class bS = BeforeSuite.class;
        Class aS = AfterSuite.class;
        //Before
        boolean flag = true;

        for (Method m : methods) {
            if (m.getAnnotation(bS) != null) {
                if (flag == true) {
                    invokeMethod(m); //m.invoke(null);
                    flag = false;
                } else throw new RuntimeException("More then 1 annotation " + bS.getName());
            }
        }
        // Test
        Arrays.stream(methods)
                .filter(method -> method.isAnnotationPresent(Test.class))
                .sorted(Comparator.comparingInt(method-> method.getAnnotation(Test.class).priority()))
                .forEach(method1 -> invokeMethod(method1));
        // After
        flag = true;
        for (Method m : methods) {
            if (m.getAnnotation(aS) != null) {
                if (flag == true) {
                    invokeMethod(m);//m.invoke(null);
                    flag = false;
                } else throw new RuntimeException("More then 1 annotation " + aS.getName());
            }
        }


    }

    private static void invokeMethod(Method method1) {
        try{
            method1.invoke(null);

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
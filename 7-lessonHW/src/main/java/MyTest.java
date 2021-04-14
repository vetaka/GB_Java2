public class MyTest {
    @BeforeSuite
    public static void beforeTest() {
        System.out.println(" I do @BeforeSuit.");
    }
    @AfterSuite
    public static void afterTest() {
        System.out.println(" I do @afterSuit.");
    }
    @Test(priority = 3)
    public static void test1(){
        System.out.println(" I do test1. My priority is 3.");
    }
    @Test(priority = 10)
    public static void test2(){
        System.out.println(" I do test2.My priority is 10.");
    }
    @Test(priority = 1)
    public static void test3(){
        System.out.println(" I do test3.My priority is 1.");
    }
    @Test(priority = 4)
    public static void test4(){
        System.out.println(" I do test4.My priority is 4.");
    }
}

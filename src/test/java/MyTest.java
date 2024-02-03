

public class MyTest {

    static void beforeAll() {
        System.out.println("beforeAll");

    }




    void tearDown() {
        System.out.println("tearDown");
        System.out.println("tearDfgjjgown");

    }

    static void afterAll() {
        System.out.println("tafterAll");

    }


    public void test3(){
        System.out.println("test3");
    }


    public void test1(){
        System.out.println("test1");
    }


    public void test2(){
        System.out.println("test2");
    }
}

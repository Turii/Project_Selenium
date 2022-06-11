import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class MyTest {
    @BeforeAll
    static void beforeAll() {
        System.out.println("beforeAll");

    }



    @AfterEach
    void tearDown() {
        System.out.println("tearDown");

    }
    @AfterAll
    static void afterAll() {
        System.out.println("tafterAll");

    }

    @Test
    public void test3(){
        System.out.println("test3");
    }

    @Test
    public void test1(){
        System.out.println("test1");
    }

    @Test
    public void test2(){
        System.out.println("test2");
    }
}

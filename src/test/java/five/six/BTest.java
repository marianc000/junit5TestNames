package five.six;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.MethodName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodName.class)
public class BTest {

    @BeforeAll
    public static void beforeAll() {
        System.out.println("beforeAll");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("afterAll");
    }

    @BeforeEach
    public void beforeEach() {
        System.out.println("beforeEach");
    }

    @AfterEach
    public void afterEach() {
        System.out.println("afterEach");
    }

    @Test
    public void test1() {
        System.out.println("test1");
    }

    @Test
    public void test2() {
        System.out.println("test2");
    }

    @Test
    @DisplayName("display name for test3")
    public void test3() {
        System.out.println("test3");
    }

    @Test
    @DisplayName("display name for test4")
    public void test4() {
        System.out.println("test4");
    }

    @Test
    @Disabled("test5 disabled for demo")
    public void test5() {
        System.out.println("test5");
    }

    @Test
    @Disabled("test6 disabled for demo")
    @DisplayName("display name for test6")
    public void test6() {
        System.out.println("test6");
    }

}

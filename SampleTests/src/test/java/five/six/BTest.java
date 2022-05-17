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
@DisplayName("display name for the first class")
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
        System.out.println("huge output of test1");
        throw new NullPointerException("TEST");
    }

    @Test
    @DisplayName("display name for test2")
    public void test2() {
        System.out.println("huge output of test2");
    }

    @Test
    @Disabled("test3 disabled for demo")
    public void test3() {
        System.out.println("huge output of test3");
    }
}

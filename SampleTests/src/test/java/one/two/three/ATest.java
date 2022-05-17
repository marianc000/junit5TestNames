package one.two.three;

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
  @DisplayName("display name for the last class")
public class ATest {

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
    public void testA() {
        System.out.println("huge output of testA");
    }

    @Test
    @DisplayName("display name for testB")
    public void testB() {
        System.out.println("huge output of testB");
    }

    @Test
    @Disabled("testC disabled for demo")
    @DisplayName("display name for testC")
    public void testC() {
        System.out.println("huge output of testC");
    }
}

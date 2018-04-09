package sikulix.com.sikulix1test;

import org.junit.*;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestAll {

  private static void log(String message, Object... args) {
    System.out.println(String.format("[TestAll] " + message, args));
  }

  @BeforeClass
  public static void setUpClass() {
  }

  @AfterClass
  public static void tearDownClass() {
  }

  @Before
  public void setUp() {
    currentTest = "currentTest";
    result = "nothing to do";
  }

  @After
  public void tearDown() {
    log("%s: %s", currentTest, result);
  }

  private String currentTest = "";
  private String result = "";

  @Test
  public void test_000_play() {
    currentTest = "test_000_play";
    result = "should not fail ;-)";
    assert true;
  }

}

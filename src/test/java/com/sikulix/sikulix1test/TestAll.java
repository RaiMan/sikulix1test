package com.sikulix.sikulix1test;

import org.junit.*;
import org.junit.runners.MethodSorters;
import org.sikuli.script.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestAll {

  private static String message(String message, Object... args) {
    return(String.format(message, args));
  }

  private static void log(String message, Object... args) {
    System.out.println(message("[TestAll] " + message, args));
  }

  private static void logError(String message, Object... args) {
    log("[ERROR] " + message, args);
  }

  static Screen scr = new Screen();
  static final String baseURL = "http://test.sikulix.com/";
  Region browserWindow = null;

  @BeforeClass
  public static void setUpClass() {
    ImagePath.add("com.sikulix.sikulix1test.Sikulix1Test/images.sikuli");
  }

  @AfterClass
  public static void tearDownClass() {
  }

  @Before
  public void setUp() {
    currentTest = "currentTest";
    result = "";
    if (App.openLink(baseURL)) {
      browserWindow = App.focusedWindow();
    } else {
      logError("could not open browser for: %s", baseURL);
      System.exit(1);
    }
  }

  @After
  public void tearDown() {
    scr.type("w", Key.META);
    if (!result.isEmpty()) {
      log("%s: %s", currentTest, result);
    }
    scr.wait(2f);
  }

  private String currentTest = "";
  private String result = "";

  @Test
  public void test_000_play() {
    currentTest = "test_000_play";
    log("Screen: %s", scr);
    result = "should not fail ;-)";
    scr.wait(3f);
    assert true;
  }

  @Test
  public void test_001_waitForImage() {
    currentTest = "test_001_waitForImage";
    String image = "godsEye";
    try {
      Match found = scr.wait(image);
      result = message("Image: %s as Match: %s", image, found);
      assert true;
    } catch (FindFailed findFailed) {
      assert false : message("Image not found: %s", image);
    }
  }

  @Test
  public void test_002_hoverOnImage() {
    currentTest = "test_002_hoverOnImage";
    String image = "clickMe";
    try {
      Match found = scr.wait(image);
      Location foundCenter = found.getCenter();
      found.hover();
      Location mouseAt = Mouse.at();
      if (foundCenter.equals(mouseAt)) {
        result = message("Mouse at: %s", foundCenter);
        assert true;
      } else {
        assert false :
        message("Mouse at: %s should be at: %s", mouseAt, foundCenter);
      }
    } catch (FindFailed findFailed) {
      assert false : message("Image not found: %s", image);
    }
  }
}

package com.sikulix.sikulix1test;

import org.sikuli.basics.Debug;
import org.sikuli.basics.Settings;
import org.sikuli.script.Screen;

public class Sikulix1Test {
  public static void main(String[] args) {
    boolean shouldEval = false;
    if (args.length > 0) {
      for (String arg : args) {
        if ("eval".equals(arg)) {
          shouldEval = true;
          break;
        }
      }
      if (shouldEval) {
        Debug.logp("SikulixAPI: running eval");
        //Settings.DebugLogs = true;
        Settings.LogTime = true;
        Debug.on(3);
        Debug.log(3, "Debug *****");
        Debug.user("userlog *****");
        new Screen().click();
        Debug.logp("SikulixAPI: ending eval");
        //Debug.off();
      }
      //Sikulix.terminate();
    }
    if (!shouldEval) {
      System.out.println("Sikulix1Test: nothing to do here");
    }
  }
}

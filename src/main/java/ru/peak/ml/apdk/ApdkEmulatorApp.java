package ru.peak.ml.apdk;

import com.alee.laf.WebLookAndFeel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import ru.peak.ml.apdk.ui.MainFrm;

/**
 *
 */
@Slf4j
public class ApdkEmulatorApp implements Runnable {

  @Autowired
  MainFrm frmMain;

  public void run() {
    frmMain.setLocationRelativeTo(null);
    frmMain.setVisible(true);
  }

  public static void main(String[] args) {
    initLookAndFeel();
    loadContext();
    Runnable application = ContextLoader.getInstance().getContext().getBean(ApdkEmulatorApp.class);
    application.run();
  }

  private static void loadContext() {
    ContextLoader.getInstance().load();
  }

  private static void initLookAndFeel() {
      WebLookAndFeel.install();
  }

  public void close() {
    System.exit(0);
  }
}

package ru.peak.ml.apdk.ui.menu;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;

/**
 *
 */
@Component
@Slf4j
public class MainMenu extends JMenuBar {

  private JMenu jmAbout;
  private JMenu jmFile;

  @SuppressWarnings("unchecked")
  @PostConstruct
  private void initComponents(){
    jmFile = new JMenu("Файл");
    jmAbout = new JMenu("О'б");

    add(jmFile);
    add(jmAbout);
  }

}

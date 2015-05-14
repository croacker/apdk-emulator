package ru.peak.ml.apdk.ui.menu;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 */
@Component
@Slf4j
public class MainMenu extends JMenuBar {

  private JMenu jmFile;
  private JMenu jmSettings;
  private JMenu jmAbout;

  private JMenuItem jmiExit;

  private JMenuItem jmiSettings;

  @SuppressWarnings("unchecked")
  @PostConstruct
  private void initComponents(){
    jmFile = new JMenu("Файл");
    jmSettings = new JMenu("Сервис");
    jmAbout = new JMenu("О'б");

    add(jmFile);
    add(jmSettings);
    add(jmAbout);

    jmiExit = new JMenuItem("Выход");
    jmFile.add(jmiExit);

    jmiSettings = new JMenuItem("Параметры");
    jmSettings.add(jmiSettings);
  }

  public void addSettingsActionListener(ActionListener actionListener){
    jmiSettings.addActionListener(actionListener);
  }





}

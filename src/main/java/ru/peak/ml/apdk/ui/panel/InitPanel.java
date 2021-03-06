package ru.peak.ml.apdk.ui.panel;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.event.ActionListener;

/**
 *
 */
@Component
@Slf4j
public class InitPanel extends JPanel {

  private JButton jbInit;

  @SuppressWarnings("unchecked")
  @PostConstruct
  private void initComponents() {
    jbInit = new JButton("Инициализация");

    GroupLayout jpInitLayout = new GroupLayout(this);
    setLayout(jpInitLayout);
    jpInitLayout.setHorizontalGroup(
        jpInitLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 410, Short.MAX_VALUE).addComponent(jbInit)
    );
    jpInitLayout.setVerticalGroup(
        jpInitLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 248, Short.MAX_VALUE).addComponent(jbInit)
    );

      setDefaultValues();
  }

    private void setDefaultValues(){

    }

    public void addRunOperationClickListener(ActionListener actionListener) {
      jbInit.addActionListener(actionListener);
    }

}

package ru.peak.ml.apdk.ui.panel;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.event.ActionListener;

/**
 *
 */
@Component
@Slf4j
public class RawDataPanel extends JPanel {

  private JLabel jLabel1;

  private JTextField jtfRawData;

  private JButton jbSendRawData;

  public byte[] getData(){
    String[] dataString = jtfRawData.getText().trim().split(", ");
    byte[] data = ArrayUtils.EMPTY_BYTE_ARRAY;
    for(String str: dataString){
      data = ArrayUtils.add(data, Byte.parseByte(str));
    }
    return data;
  }

  @SuppressWarnings("unchecked")
  @PostConstruct
  private void initComponents() {
    jLabel1 = new JLabel("Данные:");

    jtfRawData = new JTextField();

    jbSendRawData = new JButton("Отправить");
  }

  public void addRunOperationClickListener(ActionListener actionListener) {
    jbSendRawData.addActionListener(actionListener);
  }

}

package ru.peak.ml.apdk.ui;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.peak.ml.apdk.service.ApdkService;
import ru.peak.ml.apdk.service.apdk.ApdkMessage;
import ru.peak.ml.apdk.service.apdk.Init;
import ru.peak.ml.apdk.service.apdk.Sale;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 *
 */
@Component
@Slf4j
public class MainFrm extends JFrame {

  public static final String DEFAULT_SERVER_ADDRESS = "127.0.0.1";
  public static final String DEFAULT_SERVER_PORT = "7000";
  public static final String DEFAULT_SUM = "1200";

  @Autowired
  private ApdkService apdkService;

  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JMenu jMenu1;
  private javax.swing.JMenu jMenu2;
  private javax.swing.JMenuBar jMenuBar1;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JPanel jPanel3;
  private javax.swing.JButton jbClientAccount;
  private javax.swing.JButton jbInit;
  private javax.swing.JButton jbReconciliation;
  private javax.swing.JButton jbSale;
  private javax.swing.JTextField jtfServerAddress;
  private javax.swing.JTextField jtfServerPort;
  private javax.swing.JTextField jtfSum;

  @SuppressWarnings("unchecked")
  @PostConstruct
  private void initComponents() {
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    jPanel1 = new javax.swing.JPanel();
    jPanel2 = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();
    jtfServerAddress = new javax.swing.JTextField();
    jLabel2 = new javax.swing.JLabel();
    jtfServerPort = new javax.swing.JTextField();
    jPanel3 = new javax.swing.JPanel();
    jLabel3 = new javax.swing.JLabel();
    jtfSum = new javax.swing.JTextField();
    jbSale = new javax.swing.JButton();
    jbInit = new javax.swing.JButton();
    jbClientAccount = new javax.swing.JButton();
    jbReconciliation = new javax.swing.JButton();
    jMenuBar1 = new javax.swing.JMenuBar();
    jMenu1 = new javax.swing.JMenu();
    jMenu2 = new javax.swing.JMenu();

    jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

    jLabel1.setText("IP-адрес сервера:");
    jtfServerAddress.setText(DEFAULT_SERVER_ADDRESS);

    jLabel2.setText("Порт:");
    jtfServerPort.setText(DEFAULT_SERVER_PORT);

    jLabel3.setText("Сумма продажи:");
    jtfSum.setText(DEFAULT_SUM);

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfServerAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfServerPort, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
    );
    jPanel2Layout.setVerticalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtfServerAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jtfServerPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

    jbSale.setText("Продажа");
    jbSale.addActionListener(getSaleListener());

    jbInit.setText("Инициализация");
    jbInit.addActionListener(getInitListener());

    jbClientAccount.setText("Состояние счета");
    jbClientAccount.addActionListener(getClientAccountListener());

    jbReconciliation.setText("Сверка итогов");
    jbReconciliation.addActionListener(getReconciliationListener());

    javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
    jPanel3.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(
        jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfSum)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbSale))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jbInit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbClientAccount)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbReconciliation)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    jPanel3Layout.setVerticalGroup(
        jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtfSum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbSale))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbInit)
                    .addComponent(jbClientAccount)
                    .addComponent(jbReconciliation))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
    );
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
    );

    jMenu1.setText("Файл");
    jMenuBar1.add(jMenu1);

    jMenu2.setText("О'б");
    jMenuBar1.add(jMenu2);

    setJMenuBar(jMenuBar1);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
    );

    pack();
  }

  private ActionListener getSaleListener() {
    return new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        sale();
      }
    };
  }

  private ActionListener getInitListener() {
    return new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        init();
      }
    };
  }

  private ActionListener getClientAccountListener() {
    return new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        clientAccount();
      }
    };
  }

  private ActionListener getReconciliationListener() {
    return new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        reconciliation();
      }
    };
  }

  /**
   * Операция Продажа
   */
  private void sale() {
    String serverAddress = jtfServerAddress.getText();
    if (StringUtils.isEmpty(serverAddress)) {
      showError("Не указан адрес сервера!");
      return;
    }

    int serverPort;
    try {
      serverPort = Integer.parseInt(jtfServerPort.getText());
    } catch (Exception e) {
      showError("Неверно указан порт сервера!");
      return;
    }

    String sum;
    try {
      Long sumLong = Long.parseLong(jtfSum.getText());
      sum = sumLong.toString();
    } catch (Exception e) {
      showError("Неверно указана сумма!");
      return;
    }

    ApdkMessage message = new Sale(serverAddress, serverPort, sum);


    try {
      String result = apdkService.sendMessage(message);
      showInfo(result);
    } catch (IOException|IllegalArgumentException e) {
      showError(e.toString());
    }
  }

  /**
   * Операция Инициализация
   */
  private void init() {
    String serverAddress = jtfServerAddress.getText();
    if (StringUtils.isEmpty(serverAddress)) {
      showError("Не указан адрес сервера!");
      return;
    }

    int serverPort;
    try {
      serverPort = Integer.parseInt(jtfServerPort.getText());
    } catch (Exception e) {
      showError("Неверно указан порт сервера!");
      return;
    }
    ApdkMessage message = new Init(serverAddress, serverPort);

    try {
      String result = apdkService.sendMessage(message);
      showInfo(result);
    } catch (IOException|IllegalArgumentException e) {
      showError(e.toString());
    }
  }

  private void clientAccount() {
    showNotImplementPopup();
  }

  private void reconciliation() {
    showNotImplementPopup();
  }

  private void showNotImplementPopup() {
    JOptionPane.showMessageDialog(this, "Операция не реализована!");
  }

  private void showError(String error) {
    JOptionPane.showMessageDialog(this, error, "Ошибка!", JOptionPane.ERROR_MESSAGE);
  }

  private void showInfo(String error) {
    JOptionPane.showMessageDialog(this, error, "Результат", JOptionPane.INFORMATION_MESSAGE);
  }
}

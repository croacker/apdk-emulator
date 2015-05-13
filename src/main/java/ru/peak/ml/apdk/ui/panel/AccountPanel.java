package ru.peak.ml.apdk.ui.panel;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;

/**
 *
 */
@Component
@Slf4j
public class AccountPanel extends JPanel {

  private JLabel jLabel14;
  private JLabel jLabel15;

  private JTextField jtfCardnumberAccount;
  private JTextField jtfExpirationAccount;

  private JTextField jtfHashAccount;

  private JButton jbHashAccount;
  private JButton jbAccount;

  @SuppressWarnings("unchecked")
  @PostConstruct
  private void initComponents() {
    jLabel14 = new JLabel("Номер карты:");
    jLabel15 = new JLabel("Срок действия:");

    jtfCardnumberAccount = new JTextField();
    jtfExpirationAccount = new JTextField();

    jtfHashAccount = new JTextField();
    jtfHashAccount.setEditable(false);

    jbHashAccount = new JButton("HASH");

    jbAccount = new JButton("Состояние счета");

    GroupLayout jpAccountLayout = new GroupLayout(this);
    setLayout(jpAccountLayout);
    jpAccountLayout.setHorizontalGroup(
        jpAccountLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jpAccountLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpAccountLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, jpAccountLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbAccount))
                    .addGroup(jpAccountLayout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfCardnumberAccount, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfExpirationAccount, GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE))
                    .addGroup(jpAccountLayout.createSequentialGroup()
                        .addComponent(jbHashAccount)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtfHashAccount)))
                .addContainerGap())
    );
    jpAccountLayout.setVerticalGroup(
        jpAccountLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jpAccountLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpAccountLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jtfCardnumberAccount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(jtfExpirationAccount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpAccountLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jbHashAccount)
                    .addComponent(jtfHashAccount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 149, Short.MAX_VALUE)
                .addComponent(jbAccount)
                .addContainerGap())
    );
  }

}

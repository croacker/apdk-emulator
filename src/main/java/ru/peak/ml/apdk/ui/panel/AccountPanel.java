package ru.peak.ml.apdk.ui.panel;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.peak.ml.loyalty.core.service.CardService;
import ru.peak.ml.loyalty.util.StringUtil;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 */
@Component
@Slf4j
public class AccountPanel extends JPanel {

    private static ThreadLocal<DateFormat> expireDateInputFormat = new ThreadLocal<DateFormat>() {
        protected DateFormat initialValue() {
            return new SimpleDateFormat("MM/yy");
        }
    };

  private JLabel jLabel14;
  private JLabel jLabel15;

  private JTextField jtfCardnumberAccount;
  private JTextField jtfExpirationAccount;

  private JTextField jtfHashAccount;

  private JButton jbHashAccount;
  private JButton jbAccount;

    private CardService cardService;

    private CardService getCardService(){
        if (cardService == null){
            cardService = new CardService();
        }
        return cardService;
    }

    public String getCardHash(){
        calcCardHash();
        return jtfHashAccount.getText();
    }

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
      jbHashAccount.addActionListener(getCalcHashActionListener());

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

      setDefaultValues();
  }

    private void setDefaultValues(){
        jtfCardnumberAccount.setText("1234 5678 9012 3452");
        jtfExpirationAccount.setText("04/17");
    }

    private ActionListener getCalcHashActionListener(){
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcCardHash();
            }
        };
    }

    public void addRunOperationClickListener(ActionListener actionListener) {
        jbAccount.addActionListener(actionListener);
    }


    /**
     * Расчитать хеш карты
     */
    private void calcCardHash() {
        jtfHashAccount.setText(StringUtil.EMPTY);
        String cardNumber = jtfCardnumberAccount.getText();
        String expireMonth = expireDateInputFormat.get().format(new Date());

        String cardHash = getCardService().calcHash(cardNumber, expireMonth);
        jtfHashAccount.setText(cardHash);
    }

}

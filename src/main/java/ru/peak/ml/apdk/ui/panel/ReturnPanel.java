package ru.peak.ml.apdk.ui.panel;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.peak.ml.apdk.ui.list.PaymentMethodCombobox;

import javax.annotation.PostConstruct;
import javax.swing.*;

/**
 *
 */
@Component
@Slf4j
public class ReturnPanel extends JPanel{

  private JLabel jLabel9;
  private JLabel jLabel10;
  private JLabel jLabel11;
  private JLabel jLabel12;
  private JLabel jLabel13;

  private JTextField jtfDateReturn;
  private JTextField jtfSumReturn;
  private JTextField jtfLoyaltySumReturn;
  private JTextField jtfReferenceNumberReturn;

  @Autowired
  private PaymentMethodCombobox jcbPaymentMethodReturn;

  private JButton jbReturn;

    @SuppressWarnings("unchecked")
    @PostConstruct
    private void initComponents() {

      jLabel9 = new JLabel("Дата:");
      jLabel10 = new JLabel("Номер ссылки:");
      jLabel11 = new JLabel("Сумма:");
      jLabel12 = new JLabel("Вознаграждение:");
      jLabel13 = new JLabel("Способ платежа:");

      jtfDateReturn = new JTextField();
      jtfSumReturn = new JTextField();
      jtfLoyaltySumReturn = new JTextField();
      jtfReferenceNumberReturn = new JTextField();

      jbReturn = new JButton("Возврат");

      GroupLayout jpReturnLayout = new GroupLayout(this);
      setLayout(jpReturnLayout);
      jpReturnLayout.setHorizontalGroup(
          jpReturnLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
              .addGroup(jpReturnLayout.createSequentialGroup()
                  .addContainerGap()
                  .addGroup(jpReturnLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                      .addGroup(jpReturnLayout.createSequentialGroup()
                          .addGroup(jpReturnLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                              .addGroup(jpReturnLayout.createSequentialGroup()
                                  .addComponent(jLabel9)
                                  .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                  .addComponent(jtfDateReturn, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
                                  .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                  .addComponent(jLabel10))
                              .addGroup(jpReturnLayout.createSequentialGroup()
                                  .addComponent(jLabel11)
                                  .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                  .addComponent(jtfSumReturn, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
                                  .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                  .addGroup(jpReturnLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                      .addComponent(jLabel13)
                                      .addComponent(jLabel12))))
                          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                          .addGroup(jpReturnLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                              .addComponent(jtfReferenceNumberReturn)
                              .addComponent(jtfLoyaltySumReturn)
                              .addComponent(jcbPaymentMethodReturn, 0, 133, Short.MAX_VALUE)))
                      .addGroup(GroupLayout.Alignment.TRAILING, jpReturnLayout.createSequentialGroup()
                          .addGap(0, 0, Short.MAX_VALUE)
                          .addComponent(jbReturn)))
                  .addContainerGap())
      );
      jpReturnLayout.setVerticalGroup(
          jpReturnLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
              .addGroup(jpReturnLayout.createSequentialGroup()
                  .addContainerGap()
                  .addGroup(jpReturnLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                      .addComponent(jLabel9)
                      .addComponent(jtfDateReturn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                      .addComponent(jLabel10)
                      .addComponent(jtfReferenceNumberReturn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                  .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                  .addGroup(jpReturnLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                      .addComponent(jLabel11)
                      .addComponent(jtfSumReturn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                      .addComponent(jLabel12)
                      .addComponent(jtfLoyaltySumReturn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                  .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                  .addGroup(jpReturnLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                      .addComponent(jLabel13)
                      .addComponent(jcbPaymentMethodReturn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                  .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                  .addComponent(jbReturn)
                  .addContainerGap())
      );
    }

}

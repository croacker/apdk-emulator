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
public class SalePanel extends JPanel{

  private JLabel jLabel1;
  private JLabel jLabel2;
  private JLabel jLabel3;
  private JLabel jLabel4;
  private JLabel jLabel5;
  private JLabel jLabel6;
  private JLabel jLabel7;
  private JLabel jLabel8;

  private JTextField jtfCardnumberSale;
  private JTextField jtfExpirationSale;
  private JTextField jtfHashSale;
  private JTextField jtfDateSale;
  private JTextField jtfReferenceNumberSale;
  private JTextField jtfSumSale;
  private JTextField jtfLoyaltysumSale;
  private JTextField jtfBatchNumberSale;

  @Autowired
  private PaymentMethodCombobox jcbPaymentMethodSale;

  private JButton jbHashSale;

  private JButton jbSale;

  @SuppressWarnings("unchecked")
  @PostConstruct
  private void initComponents(){
    jLabel1 = new JLabel("Номер карты:");
    jLabel2 = new JLabel("Срок действия:");
    jLabel3 = new JLabel("Дата:");
    jLabel4 = new JLabel("Номер ссылки:");
    jLabel5 = new JLabel("Номер батча:");
    jLabel6 = new JLabel("Способ платежа:");
    jLabel7 = new JLabel("Сумма:");
    jLabel8 = new JLabel("Вознаграждение:");

    jtfHashSale = new JTextField();
    jtfHashSale.setEditable(false);

    jtfCardnumberSale = new JTextField();
    jtfExpirationSale = new JTextField();
    jtfHashSale = new JTextField();
    jtfHashSale.setEditable(false);
    jtfDateSale = new JTextField();
    jtfReferenceNumberSale = new JTextField();
    jtfSumSale = new JTextField();
    jtfLoyaltysumSale = new JTextField();
    jtfBatchNumberSale = new JTextField();

    jbHashSale = new JButton("HASH");

    jbSale = new JButton("Продажа");

    GroupLayout jpSaleLayout = new GroupLayout(this);
    setLayout(jpSaleLayout);
    jpSaleLayout.setHorizontalGroup(
        jpSaleLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jpSaleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpSaleLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jpSaleLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(45, 45, 45)
                        .addGroup(jpSaleLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(jpSaleLayout.createSequentialGroup()
                                .addComponent(jtfSumSale, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfLoyaltysumSale, GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE))
                            .addGroup(jpSaleLayout.createSequentialGroup()
                                .addGroup(jpSaleLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtfReferenceNumberSale, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                                    .addComponent(jtfDateSale))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jpSaleLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jpSaleLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfBatchNumberSale)
                                    .addComponent(jcbPaymentMethodSale, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(jpSaleLayout.createSequentialGroup()
                        .addGroup(jpSaleLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, GroupLayout.Alignment.LEADING))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(GroupLayout.Alignment.TRAILING, jpSaleLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbSale))
                    .addGroup(jpSaleLayout.createSequentialGroup()
                        .addGroup(jpSaleLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jbHashSale, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpSaleLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(jpSaleLayout.createSequentialGroup()
                                .addComponent(jtfCardnumberSale)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfExpirationSale, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
                            .addComponent(jtfHashSale))))
                .addContainerGap())
    );
    jpSaleLayout.setVerticalGroup(
        jpSaleLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jpSaleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpSaleLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtfCardnumberSale, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jtfExpirationSale, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpSaleLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfHashSale, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbHashSale))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpSaleLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtfDateSale, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jcbPaymentMethodSale, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpSaleLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtfReferenceNumberSale, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jtfBatchNumberSale, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpSaleLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jtfSumSale, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jtfLoyaltysumSale, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addComponent(jbSale)
                .addContainerGap())
    );
  }

}

package ru.peak.ml.apdk.ui.panel;

import com.alee.laf.spinner.WebSpinner;
import com.alee.laf.text.WebFormattedTextField;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.peak.ml.apdk.ui.edit.DateWebSpinner;
import ru.peak.ml.apdk.ui.list.PaymentMethodCombobox;
import ru.peak.ml.loyalty.core.data.mlenum.CardOperationPaymentMethod;
import ru.peak.ml.loyalty.core.service.CardService;
import ru.peak.ml.loyalty.util.StringUtil;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 */
@Component
@Slf4j
public class SalePanel extends JPanel {

    protected static DateFormat dateFormat =  new SimpleDateFormat("yyyyMMddHHmmss");

    private static ThreadLocal<DateFormat> expireDateInputFormat = new ThreadLocal<DateFormat>() {
        protected DateFormat initialValue() {
            return new SimpleDateFormat("MM/yy");
        }
    };

    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;

    private JTextField jtfCardnumberSale;
    private WebFormattedTextField jtfExpirationSale;
    private JTextField jtfHashSale;

    @Autowired
    private DateWebSpinner jtfDateSale;
    private JTextField jtfReferenceNumberSale;
    private JTextField jtfSumSale;
    private JTextField jtfLoyaltySumSale;
    private JTextField jtfOperationNumberSale;

    @Autowired
    private PaymentMethodCombobox jcbPaymentMethodSale;

    private JButton jbHashSale;

    private JButton jbSale;

    private CardService cardService;

    private CardService getCardService(){
        if (cardService == null){
            cardService = new CardService();
        }
        return cardService;
    }

    public String getCardHash(){
        calcCardHash();
        return jtfHashSale.getText();
    }

    public String getDate(){
        return dateFormat.format(jtfDateSale.getValue());
    }

    public String getReferenceNumber(){
        return jtfReferenceNumberSale.getText();
    }

    public String getOperationNumber(){
        return jtfOperationNumberSale.getText();
    }

    public String getSum(){
        return jtfSumSale.getText();
    }

    public String getLoyaltySum(){
        return jtfLoyaltySumSale.getText();
    }

    public String getPaymentMethod(){
        return ((CardOperationPaymentMethod)jcbPaymentMethodSale.getSelectedItem()).getIdCode();
    }

    @SuppressWarnings("unchecked")
    @PostConstruct
    private void initComponents() {
        jLabel1 = new JLabel("Номер карты:");
        jLabel2 = new JLabel("Срок действия:");
        jLabel3 = new JLabel("Дата:");
        jLabel4 = new JLabel("Номер ссылки:");
        jLabel5 = new JLabel("Номер операции:");
        jLabel6 = new JLabel("Способ платежа:");
        jLabel7 = new JLabel("Сумма:");
        jLabel8 = new JLabel("Вознаграждение:");

        jtfHashSale = new JTextField();
        jtfHashSale.setEditable(false);

        jtfCardnumberSale = new JTextField();
        jtfExpirationSale = new WebFormattedTextField();
        jtfHashSale = new JTextField();
        jtfHashSale.setEditable(false);
        jtfReferenceNumberSale = new JTextField();
        jtfSumSale = new JTextField();
        jtfLoyaltySumSale = new JTextField();
        jtfOperationNumberSale = new JTextField();

        jbHashSale = new JButton("HASH");
        jbHashSale.addActionListener(getCalcHashActionListener());

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
                                                                .addComponent(jtfLoyaltySumSale, GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE))
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
                                                                        .addComponent(jtfOperationNumberSale)
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
                                        .addComponent(jtfOperationNumberSale, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jpSaleLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7)
                                        .addComponent(jtfSumSale, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel8)
                                        .addComponent(jtfLoyaltySumSale, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                                .addComponent(jbSale)
                                .addContainerGap())
        );

        setDefaultValues();
    }

    private void setDefaultValues(){
        jtfCardnumberSale.setText("1234 5678 9012 3452");
        jtfExpirationSale.setText("04/17");
        jtfDateSale.setValue(new Date());
        jtfReferenceNumberSale.setText("1000000001");
        jtfOperationNumberSale.setText("100001");
        jtfSumSale.setText("1200");
        jtfLoyaltySumSale.setText("120");

        jcbPaymentMethodSale.setSelectedIndex(1);
    }

    public void addRunOperationClickListener(ActionListener actionListener) {
        jbSale.addActionListener(actionListener);
    }

    private ActionListener getCalcHashActionListener(){
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcCardHash();
            }
        };
    }

    /**
     * Расчитать хеш карты
     */
    private void calcCardHash() {
        jtfHashSale.setText(StringUtil.EMPTY);
        String cardNumber = jtfCardnumberSale.getText();
        String expireMonth = jtfExpirationSale.getText();

        String cardHash = getCardService().calcHash(cardNumber, expireMonth);
        jtfHashSale.setText(cardHash);
    }


}

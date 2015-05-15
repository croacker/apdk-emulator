package ru.peak.ml.apdk.ui.panel;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.peak.ml.apdk.ui.edit.DateWebSpinner;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 */
@Component
@Slf4j
public class CancelPanel extends JPanel {

    protected static ThreadLocal<DateFormat> dateFormat = new ThreadLocal<DateFormat>() {
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyyMMddHHmmFF");
        }
    };

    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;

    @Autowired
    private DateWebSpinner jtfDateCancel;
    private JTextField jtfOperationNumberCancel;
    private JTextField jtfLoyaltySumCancel;

    private JButton jbCancel;

    public String getDate(){
        return dateFormat.get().format(jtfDateCancel.getValue());
    }

    @SuppressWarnings("unchecked")
    @PostConstruct
    private void initComponents() {
        jLabel1 = new JLabel("Дата:");
        jLabel2 = new JLabel("Номер операции:");
        jLabel3 = new JLabel("Вознаграждение:");

        jtfOperationNumberCancel = new JTextField();
        jtfLoyaltySumCancel = new JTextField();

        jbCancel = new JButton("Отмена");

        javax.swing.GroupLayout jpCancelLayout = new javax.swing.GroupLayout(this);
        setLayout(jpCancelLayout);
        jpCancelLayout.setHorizontalGroup(
                jpCancelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jpCancelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jpCancelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jpCancelLayout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jtfDateCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jtfLoyaltySumCancel, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE))
                                        .addGroup(jpCancelLayout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jtfOperationNumberCancel))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpCancelLayout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(jbCancel)))
                                .addContainerGap())
        );
        jpCancelLayout.setVerticalGroup(
                jpCancelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jpCancelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jpCancelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jtfDateCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jtfLoyaltySumCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jpCancelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(jtfOperationNumberCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
                                .addComponent(jbCancel)
                                .addContainerGap())
        );

        setDefaultValues();
    }

    private void setDefaultValues(){
        jtfDateCancel.setValue(new Date());
        jtfOperationNumberCancel.setText("100001");
        jtfLoyaltySumCancel.setText("120");
    }

    public void addRunOperationClickListener(ActionListener actionListener) {
        jbCancel.addActionListener(actionListener);
    }

}

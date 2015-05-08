package ru.peak.ml.apdk.ui;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.peak.ml.apdk.service.ApdkService;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 */
@Component
@Slf4j
public class MainFrm extends JFrame {

    @Autowired
    private ApdkService apdkService;

    private javax.swing.JButton jbSale;
    private javax.swing.JButton jbInit;
    private javax.swing.JButton jbClientAccount;
    private javax.swing.JButton jbReconciliation;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JSpinner jsSum;

    @SuppressWarnings("unchecked")
    @PostConstruct
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jsSum = new javax.swing.JSpinner();
        jbSale = new javax.swing.JButton();
        jbInit = new javax.swing.JButton();
        jbClientAccount = new javax.swing.JButton();
        jbReconciliation = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToolBar1.setRollover(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Сумма:");
        jbSale.setText("Оплата");
        jbSale.addActionListener(getSaleListener());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jsSum)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbSale)
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jsSum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jbSale))
                                .addContainerGap(12, Short.MAX_VALUE))
        );

        jbInit.setText("Инициализация");

        jbClientAccount.setText("Запрос баланса");

        jbReconciliation.setText("Сверка итогов");

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jbInit)
                                .addGap(18, 18, 18)
                                .addComponent(jbClientAccount)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                                .addComponent(jbReconciliation)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jbInit)
                                        .addComponent(jbClientAccount)
                                        .addComponent(jbReconciliation))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

    private ActionListener getSaleListener(){
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sale();
            }
        };
    }

    private ActionListener getInitListener(){
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                init();
            }
        };
    }

    private ActionListener getClientAccountListener(){
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clientAccount();
            }
        };
    }

    private ActionListener getReconciliationListener(){
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reconciliation();
            }
        };
    }

    private void sale() {
        showNotImplementPopup();
    }

    private void init() {
        showNotImplementPopup();
    }

    private void clientAccount() {
        showNotImplementPopup();
    }

    private void reconciliation() {
        showNotImplementPopup();
    }

    private void showNotImplementPopup(){
        JOptionPane.showMessageDialog(this, "Операция не реализована!");
    }
}

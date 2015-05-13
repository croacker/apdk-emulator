package ru.peak.ml.apdk.ui;

import javax.swing.*;

/**
 *
 */
public class MainFrmPaged extends JFrame {

    /**
     * Creates new form NewJFrame1
     */
    public MainFrmPaged() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jtpMain = new JTabbedPane();
        jpSale = new JPanel();
        jLabel1 = new JLabel();
        jtfCardnumberSale = new JTextField();
        jLabel2 = new JLabel();
        jtfExpirationSale = new JTextField();
        jtfHashSale = new JTextField();
        jLabel3 = new JLabel();
        jtfDateSale = new JTextField();
        jLabel4 = new JLabel();
        jtfReferenceNumberSale = new JTextField();
        jLabel5 = new JLabel();
        jtfBatchNumberSale = new JTextField();
        jLabel6 = new JLabel();
        jcbPaymentMethodSale = new JComboBox();
        jLabel7 = new JLabel();
        jtfSumSale = new JTextField();
        jLabel8 = new JLabel();
        jtLoyaltysumSale = new JTextField();
        jbSale = new JButton();
        jbHashSale = new JButton();
        jpReturn = new JPanel();
        jLabel9 = new JLabel();
        jtfDateReturn = new JTextField();
        jLabel10 = new JLabel();
        jtfReferenceNumberReturn = new JTextField();
        jLabel11 = new JLabel();
        jtfSumReturn = new JTextField();
        jLabel12 = new JLabel();
        jtfLoyaltySumReturn = new JTextField();
        jLabel13 = new JLabel();
        jcbPaymentMethodReturn = new JComboBox();
        jbReturn = new JButton();
        jpAccount = new JPanel();
        jLabel14 = new JLabel();
        jtfCardnumberAccount = new JTextField();
        jLabel15 = new JLabel();
        jtfExpirationAccount = new JTextField();
        jbHashAccount = new JButton();
        jtfHashAccount = new JTextField();
        jbAccount = new JButton();
        jpInit = new JPanel();
        jpReconcilation = new JPanel();
        jPanel1 = new JPanel();
        jScrollPane1 = new JScrollPane();
        jtaLog = new JTextArea();
        jmbMain = new JMenuBar();
        jmFile = new JMenu();
        jmAbout = new JMenu();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Номер карты:");

        jtfCardnumberSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfCardnumberSaleActionPerformed(evt);
            }
        });

        jLabel2.setText("Срок действия:");

        jtfHashSale.setEditable(false);

        jLabel3.setText("Дата:");

        jLabel4.setText("Номер ссылки:");

        jLabel5.setText("Номер батча:");

        jLabel6.setText("Способ платежа:");

        jLabel7.setText("Сумма:");

        jLabel8.setText("Вознаграждение:");

        jbSale.setText("Продажа");

        jbHashSale.setText("HASH");

        GroupLayout jpSaleLayout = new GroupLayout(jpSale);
        jpSale.setLayout(jpSaleLayout);
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
                                                                .addComponent(jtLoyaltysumSale, GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE))
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
                                        .addComponent(jtLoyaltysumSale, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                                .addComponent(jbSale)
                                .addContainerGap())
        );

        jtpMain.addTab("Продажа", jpSale);

        jLabel9.setText("Дата:");

        jLabel10.setText("Номер ссылки:");

        jLabel11.setText("Сумма:");

        jLabel12.setText("Вознаграждение:");

        jLabel13.setText("Способ платежа:");

        jbReturn.setText("Возврат");

        GroupLayout jpReturnLayout = new GroupLayout(jpReturn);
        jpReturn.setLayout(jpReturnLayout);
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

        jtpMain.addTab("Возврат", jpReturn);

        jLabel14.setText("Номер карты:");

        jLabel15.setText("Срок действия:");

        jbHashAccount.setText("HASH");

        jtfHashAccount.setEditable(false);

        jbAccount.setText("Состояние счета");

        GroupLayout jpAccountLayout = new GroupLayout(jpAccount);
        jpAccount.setLayout(jpAccountLayout);
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

        jtpMain.addTab("Состояние счета", jpAccount);

        GroupLayout jpInitLayout = new GroupLayout(jpInit);
        jpInit.setLayout(jpInitLayout);
        jpInitLayout.setHorizontalGroup(
                jpInitLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 410, Short.MAX_VALUE)
        );
        jpInitLayout.setVerticalGroup(
                jpInitLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 248, Short.MAX_VALUE)
        );

        jtpMain.addTab("Инициализация", jpInit);

        GroupLayout jpReconcilationLayout = new GroupLayout(jpReconcilation);
        jpReconcilation.setLayout(jpReconcilationLayout);
        jpReconcilationLayout.setHorizontalGroup(
                jpReconcilationLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 410, Short.MAX_VALUE)
        );
        jpReconcilationLayout.setVerticalGroup(
                jpReconcilationLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 248, Short.MAX_VALUE)
        );

        jtpMain.addTab("Сверка итогов", jpReconcilation);

        jtaLog.setColumns(20);
        jtaLog.setRows(5);
        jScrollPane1.setViewportView(jtaLog);

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
        );

        jmFile.setText("Файл");
        jmbMain.add(jmFile);

        jmAbout.setText("О'б");
        jmbMain.add(jmAbout);

        setJMenuBar(jmbMain);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jtpMain)
                        .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jtpMain, GroupLayout.PREFERRED_SIZE, 273, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    private void jtfCardnumberSaleActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(NewJFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(NewJFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(NewJFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(NewJFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


    }

    // Variables declaration - do not modify
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel12;
    private JLabel jLabel13;
    private JLabel jLabel14;
    private JLabel jLabel15;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JButton jbAccount;
    private JButton jbHashAccount;
    private JButton jbHashSale;
    private JButton jbReturn;
    private JButton jbSale;
    private JComboBox jcbPaymentMethodReturn;
    private JComboBox jcbPaymentMethodSale;
    private JMenu jmAbout;
    private JMenu jmFile;
    private JMenuBar jmbMain;
    private JPanel jpAccount;
    private JPanel jpInit;
    private JPanel jpReconcilation;
    private JPanel jpReturn;
    private JPanel jpSale;
    private JTextField jtLoyaltysumSale;
    private JTextArea jtaLog;
    private JTextField jtfBatchNumberSale;
    private JTextField jtfCardnumberAccount;
    private JTextField jtfCardnumberSale;
    private JTextField jtfDateReturn;
    private JTextField jtfDateSale;
    private JTextField jtfExpirationAccount;
    private JTextField jtfExpirationSale;
    private JTextField jtfHashAccount;
    private JTextField jtfHashSale;
    private JTextField jtfLoyaltySumReturn;
    private JTextField jtfReferenceNumberReturn;
    private JTextField jtfReferenceNumberSale;
    private JTextField jtfSumReturn;
    private JTextField jtfSumSale;
    private JTabbedPane jtpMain;
    // End of variables declaration
}

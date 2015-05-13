package ru.peak.ml.apdk.ui;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.peak.ml.apdk.ui.panel.*;

import javax.annotation.PostConstruct;
import javax.swing.*;

/**
 *
 */
@Component
@Slf4j
public class MainFrmPaged extends JFrame {

  private JPanel jPanel1;
  private JScrollPane jScrollPane1;

  @Autowired
  private JMenuBar jmbMain;

  private JTabbedPane jtpMain;
  @Autowired
  private SalePanel jpSale;
  @Autowired
  private ReturnPanel jpReturn;
  @Autowired
  private AccountPanel jpAccount;
  @Autowired
  private InitPanel jpInit;
  @Autowired
  private ReconcilationPanel jpReconcilation;

  private JTextArea jtaLog;

  @SuppressWarnings("unchecked")
  @PostConstruct
  private void initComponents() {
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    jtpMain = new JTabbedPane();
    jPanel1 = new JPanel();
    jScrollPane1 = new JScrollPane();
    jtaLog = new JTextArea();

    jtpMain.addTab("Продажа", jpSale);
    jtpMain.addTab("Возврат", jpReturn);
    jtpMain.addTab("Состояние счета", jpAccount);
    jtpMain.addTab("Инициализация", jpInit);
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
  }

}

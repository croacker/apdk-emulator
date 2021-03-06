package ru.peak.ml.apdk.ui;

import com.alee.laf.WebLookAndFeel;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.peak.ml.apdk.service.ApdkService;
import ru.peak.ml.apdk.service.apdk.*;
import ru.peak.ml.apdk.ui.dialog.SettingsDialog;
import ru.peak.ml.apdk.ui.menu.MainMenu;
import ru.peak.ml.apdk.ui.panel.*;

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
public class MainFrmPaged extends JFrame {

    @Getter
    @Setter
    private String serverAddress = "127.0.0.1";
    @Getter
    @Setter
    private String serverPort = "7000";
    @Getter
    @Setter
    private String shopNumber = "30101010";
    @Getter
    @Setter
    private String terminalId = "10000018";
    @Getter
    @Setter
    private String batchNumber = "100001";

    private JPanel jPanel1;
    private JScrollPane jScrollPane1;

    @Autowired
    private ApdkService apdkService;

    @Autowired
    private MainMenu jmbMain;

    private JTabbedPane jtpMain;
    @Autowired
    private SalePanel jpSale;
    @Autowired
    private ReturnSalePanel jpReturn;
    @Autowired
    private AccountPanel jpAccount;
    @Autowired
    private CancelPanel jpCancel;
    @Autowired
    private InitPanel jpInit;
    @Autowired
    private ReconciliationPanel jpReconciliation;
    @Autowired
    private RawDataPanel jpRawData;

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
        jtpMain.addTab("Отмена", jpCancel);
        jtpMain.addTab("Состояние счета", jpAccount);
        jtpMain.addTab("Инициализация", jpInit);
        jtpMain.addTab("Сверка итогов", jpReconciliation);
        jtpMain.addTab("Данные", jpRawData);

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

        jpAccount.addRunOperationClickListener(getAccountActionListener());
        jpCancel.addRunOperationClickListener(getCancelActionListener());
        jpInit.addRunOperationClickListener(getInitActionListener());
        jpReconciliation.addRunOperationClickListener(getReconciliationActionListener());
        jpReturn.addRunOperationClickListener(getReturnSaleActionListener());
        jpSale.addRunOperationClickListener(getSaleActionListener());
        jpRawData.addRunOperationClickListener(getRawDataListener());

        jmbMain.addSettingsActionListener(getShowSettingsActionListener());
    }

    private void showError(String error) {
        JOptionPane.showMessageDialog(this, error, "Ошибка!", JOptionPane.ERROR_MESSAGE);
    }

    private void showInfo(String error) {
        JOptionPane.showMessageDialog(this, error, "Результат", JOptionPane.INFORMATION_MESSAGE);
    }

    private ActionListener getAccountActionListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                account();
            }
        };
    }

    private ActionListener getCancelActionListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancel();
            }
        };
    }

    private ActionListener getInitActionListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                init();
            }
        };
    }

    private ActionListener getReconciliationActionListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reconciliation();
            }
        };
    }

    private ActionListener getReturnSaleActionListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                returnSale();
            }
        };
    }

    private ActionListener getSaleActionListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sale();
            }
        };
    }

    private ActionListener getRawDataListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendRawData();
            }
        };
    }

    private ActionListener getShowSettingsActionListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showSettingsForm();
            }
        };
    }

    private void account() {
        jtaLog.append("...\r\n");
        jtaLog.append("Запрос: ЗАПРОС БАЛАНСА\r\n");

        Account account = new Account(getServerAddress(), Integer.valueOf(getServerPort()));
        account.setShopNumber(getShopNumber());
        account.setTerminalId(getTerminalId());
        account.setBatchNumber(getBatchNumber());
        account.setCardHash(jpAccount.getCardHash());

        try {
            jtaLog.append(apdkService.sendMessage(account));
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            jtaLog.append(e.toString());
        }
    }

    private void cancel() {
        jtaLog.append("...\r\n");
        jtaLog.append("Запрос: ОТМЕНА\r\n");

        Cancel cancel = new Cancel(getServerAddress(), Integer.valueOf(getServerPort()));
        cancel.setShopNumber(getShopNumber());
        cancel.setTerminalId(getTerminalId());
        cancel.setBatchNumber(getBatchNumber());
        cancel.setDate(jpCancel.getDate());
        cancel.setOperationNumber(jpCancel.getOperationNumber());
        cancel.setLoyaltySum(jpCancel.getLoyaltySum());

        try {
            jtaLog.append(apdkService.sendMessage(cancel));
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            jtaLog.append(e.toString());
        }
    }

    private void init() {
        jtaLog.append("...\r\n");
        jtaLog.append("Запрос: ИНИЦИАЛИЗАЦИЯ\r\n");

        Init init = new Init(getServerAddress(), Integer.valueOf(getServerPort()));
        init.setShopNumber(getShopNumber());
        init.setTerminalId(getTerminalId());
        init.setBatchNumber(getBatchNumber());
        try {
            jtaLog.append(apdkService.sendMessage(init));
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            jtaLog.append(e.toString());
        }
    }

    private void reconciliation() {
        jtaLog.append("...\r\n");
        jtaLog.append("Запрос: СВЕРКА ИТОГОВ\r\n");

        Reconciliation reconciliation = new Reconciliation(getServerAddress(), Integer.valueOf(getServerPort()));
        reconciliation.setShopNumber(getShopNumber());
        reconciliation.setTerminalId(getTerminalId());
        reconciliation.setBatchNumber(getBatchNumber());
        try {
            jtaLog.append(apdkService.sendMessage(reconciliation));
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            jtaLog.append(e.toString());
        }
    }

    private void returnSale() {
        jtaLog.append("...\r\n");
        jtaLog.append("Запрос: ВОЗВРАТ\r\n");
        ReturnSale returnSale = new ReturnSale(getServerAddress(), Integer.valueOf(getServerPort()));
        returnSale.setShopNumber(getShopNumber());
        returnSale.setTerminalId(getTerminalId());
        returnSale.setBatchNumber(getBatchNumber());
        returnSale.setDate(jpReturn.getDate());
        returnSale.setPaymentMethod(jpReturn.getPaymentMethod());
        returnSale.setReferenceNumber(jpReturn.getReferenceNumber());
        returnSale.setSum(jpReturn.getSum());
        returnSale.setLoyaltySum(jpReturn.getLoyaltySum());

        try {
            jtaLog.append(apdkService.sendMessage(returnSale));
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            jtaLog.append(e.toString());
        }
    }

    private void sale() {
        jtaLog.append("...\r\n");
        jtaLog.append("Запрос: ПРОДАЖА\r\n");

        Sale sale = new Sale(getServerAddress(), Integer.valueOf(getServerPort()));
        sale.setShopNumber(getShopNumber());
        sale.setTerminalId(getTerminalId());
        sale.setBatchNumber(getBatchNumber());
        sale.setCardHash(jpSale.getCardHash());
        sale.setDate(jpSale.getDate());
        sale.setPaymentMethod(jpSale.getPaymentMethod());
        sale.setReferenceNumber(jpSale.getReferenceNumber());
        sale.setOperationNumber(jpSale.getOperationNumber());
        sale.setSum(jpSale.getSum());
        sale.setLoyaltySum(jpSale.getLoyaltySum());

        try {
            jtaLog.append(apdkService.sendMessage(sale));
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            jtaLog.append(e.toString());
        }
    }

    private void sendRawData() {
        jtaLog.append("...\r\n");
        jtaLog.append("Запрос: ДАННЫЕ\r\n");

        RawData rawData = new RawData(getServerAddress(), Integer.valueOf(getServerPort()));
        rawData.setData(jpRawData.getData());

        try {
            jtaLog.append(apdkService.sendMessage(rawData));
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            jtaLog.append(e.toString());
        }
    }

    private void showSettingsForm() {
        boolean decorateFrames = WebLookAndFeel.isDecorateDialogs();
        WebLookAndFeel.setDecorateDialogs(true);

        final SettingsDialog settingsDialog = new SettingsDialog(this);

        settingsDialog.setServerAddress(getServerAddress());
        settingsDialog.setServerPor(getServerPort());
        settingsDialog.setShopNumber(getShopNumber());
        settingsDialog.setTerminalId(getTerminalId());
        settingsDialog.setBatchNumber(getBatchNumber());

        settingsDialog.pack();
        settingsDialog.setLocationRelativeTo(this);
        settingsDialog.setVisible(true);

        if (settingsDialog.isDialogResult()) {
            setServerAddress(settingsDialog.getServerAddress());
            setServerPort(settingsDialog.getServerPort());
            setShopNumber(settingsDialog.getShopNumber());
            setTerminalId(settingsDialog.getTerminalId());
            setBatchNumber(settingsDialog.getBatchNumber());
        }

        WebLookAndFeel.setDecorateDialogs(decorateFrames);
    }
}

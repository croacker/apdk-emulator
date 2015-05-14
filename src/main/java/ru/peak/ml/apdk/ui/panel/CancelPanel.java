package ru.peak.ml.apdk.ui.panel;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.event.ActionListener;

/**
 *
 */
@Component
@Slf4j
public class CancelPanel extends JPanel {

    @SuppressWarnings("unchecked")
    @PostConstruct
    private void initComponents() {
        GroupLayout jpReconcilationLayout = new GroupLayout(this);
        setLayout(jpReconcilationLayout);
        jpReconcilationLayout.setHorizontalGroup(
                jpReconcilationLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 410, Short.MAX_VALUE)
        );
        jpReconcilationLayout.setVerticalGroup(
                jpReconcilationLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 248, Short.MAX_VALUE)
        );

        setDefaultValues();
    }

    private void setDefaultValues(){

    }

    public void addRunOperationClickListener(ActionListener actionListener) {

    }

}
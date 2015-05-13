package ru.peak.ml.apdk.ui.list;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;

/**
 *
 */
@Component
@Slf4j
@Scope("prototype")
public class PaymentMethodCombobox extends JComboBox {

  @SuppressWarnings("unchecked")
  @PostConstruct
  private void initComponents() {

  }

}

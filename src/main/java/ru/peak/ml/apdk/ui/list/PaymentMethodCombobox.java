package ru.peak.ml.apdk.ui.list;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.peak.ml.apdk.ui.list.payment.PaymentMethodModel;
import ru.peak.ml.loyalty.core.data.mlenum.PaymentMethod;

import javax.annotation.PostConstruct;
import javax.swing.*;

/**
 *
 */
@Component
@Slf4j
@Scope("prototype")
public class PaymentMethodCombobox extends JComboBox<PaymentMethod> {


  @SuppressWarnings("unchecked")
  @PostConstruct
  private void initComponents() {
    setModel(new PaymentMethodModel());
  }

}

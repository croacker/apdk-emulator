package ru.peak.ml.apdk.ui.list.payment;

import ru.peak.ml.loyalty.core.data.mlenum.PaymentMethod;

import javax.swing.*;

/**
 *
 */
public class PaymentMethodModel extends DefaultComboBoxModel<PaymentMethod> {

    private PaymentMethod[] paymentMethods = PaymentMethod.values();

    private PaymentMethod selectedItem;

    @Override
    public void setSelectedItem(Object anItem) {
        selectedItem = (PaymentMethod) anItem;
    }

    @Override
    public PaymentMethod getSelectedItem() {
        return selectedItem;
    }

    @Override
    public int getSize() {
        return paymentMethods.length;
    }

    @Override
    public PaymentMethod getElementAt(int index) {
        return paymentMethods[index];
    }

}

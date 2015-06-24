package ru.peak.ml.apdk.ui.list.payment;

import ru.peak.ml.loyalty.core.data.mlenum.CardOperationPaymentMethod;

import javax.swing.*;

/**
 *
 */
public class PaymentMethodModel extends DefaultComboBoxModel<CardOperationPaymentMethod> {

    private CardOperationPaymentMethod[] paymentMethods = CardOperationPaymentMethod.values();

    private CardOperationPaymentMethod selectedItem;

    @Override
    public void setSelectedItem(Object anItem) {
        selectedItem = (CardOperationPaymentMethod) anItem;
    }

    @Override
    public CardOperationPaymentMethod getSelectedItem() {
        return selectedItem;
    }

    @Override
    public int getSize() {
        return paymentMethods.length;
    }

    @Override
    public CardOperationPaymentMethod getElementAt(int index) {
        return paymentMethods[index];
    }

}

package ru.peak.ml.apdk.service.formatter;

import ru.peak.ml.loyalty.message.Message;

/**
 *
 */
public class AccountFormatter implements MessageFormatter{
    @Override
    public String toMessageString(Message message) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Статус транзакции:[");
        stringBuffer.append(message.getTransactionStatus());
        stringBuffer.append("]");
        stringBuffer.append("\r\n");
        stringBuffer.append("Баланс счета:[");
        stringBuffer.append(message.getBalanceOfBonusAccount());
        stringBuffer.append("]");
        stringBuffer.append("\r\n");
        return stringBuffer.toString();
    }
}

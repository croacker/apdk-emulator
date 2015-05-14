package ru.peak.ml.apdk.service.formatter;

import ru.peak.ml.loyalty.message.Message;

/**
 *
 */
public class CancelFormatter implements MessageFormatter{
    @Override
    public String toMessageString(Message message) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Статус транзакции:[");
        stringBuffer.append(message.getTransactionStatus());
        stringBuffer.append("]");
        stringBuffer.append("\r\n");
        return stringBuffer.toString();
    }
}

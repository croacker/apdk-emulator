package ru.peak.ml.apdk.service.formatter;

import ru.peak.ml.loyalty.message.Message;

/**
 *
 */
public class InitFormatter implements MessageFormatter{
    @Override
    public String toMessageString(Message message) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Статус транзакции:[");
        stringBuffer.append(message.getTransactionStatus());
        stringBuffer.append("]");
        stringBuffer.append("\r\n");
        stringBuffer.append("Номер батча:[");
        stringBuffer.append(message.getBatchNumber());
        stringBuffer.append("]");
        stringBuffer.append("\r\n");
        stringBuffer.append("Номер операции:[");
        stringBuffer.append(message.getOperationNumber());
        stringBuffer.append("]");
        stringBuffer.append("\r\n");
        return stringBuffer.toString();
    }
}

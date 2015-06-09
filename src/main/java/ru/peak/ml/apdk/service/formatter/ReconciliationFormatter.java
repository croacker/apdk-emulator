package ru.peak.ml.apdk.service.formatter;

import ru.peak.ml.loyalty.message.Message;

/**
 *
 */
public class ReconciliationFormatter implements MessageFormatter {
    @Override
    public String toMessageString(Message message) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Статус транзакции:[");
        stringBuffer.append(message.getTransactionStatus());
        stringBuffer.append("]");
        stringBuffer.append("\r\n");
        stringBuffer.append("Начисления количество:[");
        stringBuffer.append(message.getOperationsCount());
        stringBuffer.append("]");
        stringBuffer.append("\r\n");
        stringBuffer.append("Начисления сумма:[");
        stringBuffer.append(message.getSumOfBonuses());
        stringBuffer.append("]");
        stringBuffer.append("\r\n");
        stringBuffer.append("Оплата бонусами количество:[");
        stringBuffer.append(message.getCountLoyaltyWriteOff());
        stringBuffer.append("]");
        stringBuffer.append("\r\n");
        stringBuffer.append("Оплата бонусами сумма:[");
        stringBuffer.append(message.getSumLoyaltyWriteOff());
        stringBuffer.append("]");
        stringBuffer.append("\r\n");
        stringBuffer.append("Возврат и Отмена количество:[");
        stringBuffer.append(message.getCountReturnOperations());
        stringBuffer.append("]");
        stringBuffer.append("\r\n");
        stringBuffer.append("Возврат и Отмена сумма списанных бонусов:[");
        stringBuffer.append(message.getWriteOffReturnOperations());
        stringBuffer.append("]");
        stringBuffer.append("\r\n");
        return stringBuffer.toString();
    }
}

package ru.peak.ml.apdk.service.formatter;

import ru.peak.ml.loyalty.message.Message;
import ru.peak.ml.loyalty.util.StringUtil;

/**
 *
 */
public class ReconciliationFormatter implements MessageFormatter{
    @Override
    public String toMessageString(Message message) {
        StringBuffer stringBuffer = new StringBuffer();
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
        stringBuffer.append("Возвраты количество:[");
        stringBuffer.append(message.getCountReturnOperations());
        stringBuffer.append("]");
        stringBuffer.append("\r\n");
        stringBuffer.append("Возвраты сумма списанных бонусов:[");
        stringBuffer.append(message.getWriteOffReturnOperations());
        stringBuffer.append("]");
        stringBuffer.append("\r\n");
        stringBuffer.append("Возвраты сумма начисленных бонусов:[");
        stringBuffer.append(message.getAccuralReturnOperations());
        stringBuffer.append("]");
        stringBuffer.append("\r\n");
        return stringBuffer.toString();
    }
}

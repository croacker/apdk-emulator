package ru.peak.ml.apdk.service.apdk;

import lombok.Getter;
import lombok.Setter;
import ru.peak.ml.apdk.service.formatter.MessageFormatter;
import ru.peak.ml.apdk.service.formatter.ReturnFormatter;
import ru.peak.ml.loyalty.message.ResponseMessage;

/**
 *
 */
public class ReturnSale extends CommonApdkMessage {

    public static final String OPERATION_TYPE = new String(new byte[]{50, 57});

    MessageFormatter formatter = new ReturnFormatter();

    @Getter @Setter
    private String date;

    @Getter @Setter
    private String paymentMethod;

    @Getter @Setter
    private String referenceNumber;

    @Getter @Setter
    private String sum;

    @Getter @Setter
    private String loyaltySum;

    public ReturnSale(String serverAddress, int serverPort) {
        super(serverAddress, serverPort);
    }

    @Override
    public byte[] getData() {
        return new byte[0];
    }

    @Override
    public ResponseMessage getNewApdkMessage() {
        ResponseMessage message = super.getNewApdkMessage();
        message.setOperationTimestamp(getDate());
        message.setReferenceNumber(getReferenceNumber());
        message.setPaymentMethod(getPaymentMethod());
        message.setBatchNumber("100001");
        message.setSum(getSum());
        message.setSumLoyalty(Long.valueOf(getLoyaltySum()));
        message.setRewardSum(getLoyaltySum());

        message.setOperationType(OPERATION_TYPE);
        return message;
    }

    @Override
    public MessageFormatter getFormatter() {
        return formatter;
    }
}

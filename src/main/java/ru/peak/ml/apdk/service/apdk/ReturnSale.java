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

    public static byte[] ORIGINAL_DATA = {2, 114, 0, 0, 1, 0, 7, 1, 8, 0, 49, 48, 48, 48, 48, 48, 49, 56, 2, 4, 0, 49, 50, 51, 52, 4, 3, 0, 54, 52, 51, 5, 14, 0, 50, 48, 49, 53, 48, 53, 50, 54, 49, 54, 51, 48, 48, 52, 6, 8, 0, 51, 48, 49, 48, 49, 48, 49, 48, 7, 12, 0, 49, 48, 48, 48, 48, 48, 48, 49, 48, 48, 48, 51, 16, 1, 0, 48, 17, 6, 0, 49, 49, 54, 48, 48, 49, 18, 3, 0, 50, 48, 81, 19, 3, 0, 0, 0, 71, 23, 4, 0, 49, 50, 48, 48, 25, 2, 0, 50, 57, 100, 3, 0, 48, 48, 48, -105, -24};

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
        return getNewApdkMessage().toArray();
    }

    @Override
    public ResponseMessage getNewApdkMessage() {
        ResponseMessage message = super.getNewApdkMessage();
        message.setOperationTimestamp(getDate());
        message.setReferenceNumber(getReferenceNumber());
        message.setPaymentMethod(getPaymentMethod());

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

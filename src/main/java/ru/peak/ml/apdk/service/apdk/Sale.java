package ru.peak.ml.apdk.service.apdk;

import lombok.Getter;
import lombok.Setter;
import ru.peak.ml.apdk.service.formatter.MessageFormatter;
import ru.peak.ml.apdk.service.formatter.SaleFormatter;
import ru.peak.ml.loyalty.message.ResponseMessage;

import javax.xml.bind.DatatypeConverter;

/**
 *
 */
public class Sale extends CommonApdkMessage {

    public static byte[] ORIGINAL_DATA = {2, -117, 0, 0, 1, 0, 7, 1, 8, 0, 57, 57, 55, 55, 53, 53, 51, 51, 2, 4, 0, 50, 50, 52, 52, 3, 27, 0, 4, 69, -54, -126, -107, -13, -118, 42, -108, -4, 4, -76, -96, 110, -42, -104, 25, 106, -53, 112, -31, 51, 0, 92, 57, 60, -44, 4, 3, 0, 54, 52, 51, 5, 14, 0, 50, 48, 49, 53, 48, 52, 50, 49, 49, 55, 49, 49, 50, 50, 6, 6, 0, 49, 49, 54, 48, 49, 52, 7, 10, 0, 49, 48, 48, 48, 48, 48, 48, 48, 48, 49, 16, 1, 0, 49, 17, 6, 0, 49, 49, 54, 48, 48, 49, 18, 3, 0, 16, 0, 1, 19, 3, 0, 16, 0, 1, 23, 4, 0, 49, 50, 48, 48, 25, 1, 0, 49, 100, 3, 0, 48, 48, 48, -48, -27};
    public static byte[] ORIGINAL_DATA_1 = {2, -107, 0, 0, 1, 0, 7, 1, 8, 0, 49, 48, 48, 48, 48, 48, 49, 56, 2, 4, 0, 49, 50, 51, 52, 3, 27, 0, 4, 69, -54, -126, -107, -13, -118, 42, -108, -4, 4, -76, -96, 110, -42, -104, 25, 106, -53, 112, -31, 51, 0, 92, 57, 60, -44, 4, 3, 0, 54, 52, 51, 5, 14, 0, 50, 48, 49, 53, 48, 52, 50, 49, 49, 55, 49, 49, 50, 50, 6, 8, 0, 51, 48, 49, 48, 49, 48, 49, 48, 7, 12, 0, 49, 48, 48, 48, 48, 48, 48, 48, 57, 56, 51, 55, 16, 1, 0, 48, 17, 6, 0, 49, 49, 54, 48, 48, 49, 18, 3, 0, 50, 48, 81, 19, 3, 0, 0, 0, 24, 23, 4, 0, 49, 50, 48, 48, 45, 3, 0, 49, 50, 48, 25, 1, 0, 49, 100, 3, 0, 48, 48, 48, 93, -82};
    public static byte[] ORIGINAL_DATA_2 = {2, -107, 0, 0, 1, 0, 7, 1, 8, 0, 49, 48, 48, 48, 48, 48, 49, 56, 2, 4, 0, 49, 50, 51, 52, 3, 27, 0, 4, 69, -54, -126, -107, -13, -118, 42, -108, -4, 4, -76, -96, 110, -42, -104, 25, 106, -53, 112, -31, 51, 0, 92, 57, 60, -44, 4, 3, 0, 54, 52, 51, 5, 14, 0, 50, 48, 49, 53, 48, 52, 50, 49, 49, 55, 49, 49, 50, 50, 6, 8, 0, 51, 48, 49, 48, 49, 48, 49, 48, 7, 12, 0, 49, 48, 48, 48, 48, 48, 48, 48, 57, 56, 51, 56, 16, 1, 0, 48, 17, 6, 0, 49, 49, 54, 48, 48, 49, 18, 3, 0, 50, 48, 81, 19, 3, 0, 0, 0, 25, 23, 4, 0, 49, 50, 48, 48, 45, 3, 0, 49, 50, 48, 25, 1, 0, 49, 100, 3, 0, 48, 48, 48, 82, -114};


    public static final String OPERATION_TYPE = new String(new byte[]{49});

    MessageFormatter formatter = new SaleFormatter();

    @Getter
    @Setter
    private String cardHash;

    @Getter
    @Setter
    private String date;

    @Getter
    @Setter
    private String paymentMethod;

    @Getter
    @Setter
    private String referenceNumber;

    @Getter
    @Setter
    private String operationNumber;

    @Getter
    @Setter
    private String sum;

    @Getter
    @Setter
    private String loyaltySum;

    public Sale(String serverAddress, int serverPort) {
        super(serverAddress, serverPort);
    }

    public byte[] getData() {
        return getNewApdkMessage().toArray();
//        return ORIGINAL_DATA_2;
    }

    public ResponseMessage getNewApdkMessage() {
        ResponseMessage message = super.getNewApdkMessage();
        message.setCardIdentifier(DatatypeConverter.parseHexBinary(getCardHash()));
        message.setOperationTimestamp(getDate());
        message.setReferenceNumber(getReferenceNumber());
        message.setPaymentMethod(getPaymentMethod());
        message.setOperationNumber(getOperationNumber());
        message.setSum(getSum());
        message.setRewardSum(getLoyaltySum());
        message.setOperationType(OPERATION_TYPE);

        return message;
    }

    @Override
    public MessageFormatter getFormatter() {
        return formatter;
    }

}

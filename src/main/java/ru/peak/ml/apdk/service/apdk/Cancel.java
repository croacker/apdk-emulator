package ru.peak.ml.apdk.service.apdk;

import lombok.Getter;
import lombok.Setter;
import ru.peak.ml.apdk.service.formatter.CancelFormatter;
import ru.peak.ml.apdk.service.formatter.MessageFormatter;
import ru.peak.ml.loyalty.message.ResponseMessage;

/**
 *
 */
public class Cancel extends CommonApdkMessage {

    public static byte[] ORIGINAL_DATA = {2, 81, 0, 0, 1, 0, 7, 1, 8, 0, 49, 48, 48, 48, 48, 48, 49, 56, 2, 4, 0, 49, 50, 51, 52, 5, 14, 0, 50, 48, 49, 53, 48, 53, 50, 48, 49, 52, 48, 56, 48, 51, 6, 8, 0, 51, 48, 49, 48, 49, 48, 49, 48, 17, 6, 0, 49, 49, 54, 48, 48, 49, 18, 3, 0, 50, 48, 81, 19, 3, 0, 0, 0, 38, 25, 1, 0, 52, 100, 3, 0, 48, 48, 48, 38, -80};
    public static byte[] ORIGINAL_DATA_1 = {2, 81, 0, 0, 1, 0, 7, 1, 8, 0, 49, 48, 48, 48, 48, 48, 49, 56, 2, 4, 0, 49, 50, 51, 52, 5, 14, 0, 50, 48, 49, 53, 48, 52, 50, 49, 49, 55, 49, 49, 50, 50, 6, 8, 0, 51, 48, 49, 48, 49, 48, 49, 48, 17, 6, 0, 49, 49, 54, 48, 48, 49, 18, 3, 0, 50, 48, 81, 19, 3, 0, 0, 0, 63, 25, 1, 0, 52, 100, 3, 0, 48, 48, 48, 36, 71};

    public static final String OPERATION_TYPE = new String(new byte[]{52});

    @Getter
    @Setter
    private String date;

    @Getter
    @Setter
    private String operationNumber;

    @Getter
    @Setter
    private String loyaltySum;

    public Cancel(String serverAddress, int serverPort) {
        super(serverAddress, serverPort);
    }

    MessageFormatter formatter = new CancelFormatter();

    @Override
    public byte[] getData() {
        return getNewApdkMessage().toArray();
    }

    @Override
    public ResponseMessage getNewApdkMessage() {
        ResponseMessage message = super.getNewApdkMessage();
        message.setOperationTimestamp(getDate());
        message.setOperationNumber(getOperationNumber());
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

package ru.peak.ml.apdk.service.apdk;

import lombok.Getter;
import lombok.Setter;
import ru.peak.ml.apdk.service.formatter.CancelFormatter;
import ru.peak.ml.apdk.service.formatter.MessageFormatter;
import ru.peak.ml.loyalty.message.Message;
import ru.peak.ml.loyalty.message.ResponseMessage;

/**
 *
 */
public class Cancel extends CommonApdkMessage {

    public static final String OPERATION_TYPE = new String(new byte[]{52});

    @Getter
    @Setter
    private String date;

    @Getter @Setter
    private String loyaltySum;

    public Cancel(String serverAddress, int serverPort) {
        super(serverAddress, serverPort);
    }

    MessageFormatter formatter = new CancelFormatter();

    @Override
    public byte[] getData() {
        return new byte[0];
    }

    @Override
    public ResponseMessage getNewApdkMessage() {
        ResponseMessage message = super.getNewApdkMessage();
        message.setOperationTimestamp(getDate());
        message.setSumLoyalty(Long.valueOf(getLoyaltySum()));
        message.setRewardSum(getLoyaltySum());
        message.setBatchNumber("100001");

        message.setOperationType(OPERATION_TYPE);
        return message;
    }

    @Override
    public MessageFormatter getFormatter() {
        return formatter;
    }
}
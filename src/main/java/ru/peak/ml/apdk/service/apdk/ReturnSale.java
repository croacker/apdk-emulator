package ru.peak.ml.apdk.service.apdk;

import lombok.Getter;
import lombok.Setter;
import ru.peak.ml.apdk.service.formatter.MessageFormatter;
import ru.peak.ml.apdk.service.formatter.ReturnFormatter;
import ru.peak.ml.loyalty.message.Message;
import ru.peak.ml.loyalty.message.ResponseMessage;

/**
 *
 */
public class ReturnSale extends CommonApdkMessage {

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
    public Message getNewApdkMessage() {
        ResponseMessage message = new ResponseMessage();

        message.setErrorDescription("EMULATION");
        return message;
    }

    @Override
    public MessageFormatter getFormatter() {
        return formatter;
    }
}

package ru.peak.ml.apdk.service.apdk;

import ru.peak.ml.apdk.service.formatter.MessageFormatter;
import ru.peak.ml.apdk.service.formatter.ReconcilationFormatter;
import ru.peak.ml.loyalty.message.ResponseMessage;

/**
 *
 */
public class Reconcilation extends CommonApdkMessage {

  public static final String OPERATION_TYPE = new String(new byte[]{53, 57});

  MessageFormatter formatter = new ReconcilationFormatter();

  public Reconcilation(String serverAddress, int serverPort) {
    super(serverAddress, serverPort);
  }

  @Override
  public byte[] getData() {
    return getNewApdkMessage().toArray();
  }

  @Override
  public ResponseMessage getNewApdkMessage() {
    ResponseMessage message = super.getNewApdkMessage();

    message.setOperationType(OPERATION_TYPE);
    return message;
  }

  @Override
  public MessageFormatter getFormatter() {
    return formatter;
  }
}

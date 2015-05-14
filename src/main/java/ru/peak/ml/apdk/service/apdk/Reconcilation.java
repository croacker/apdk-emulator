package ru.peak.ml.apdk.service.apdk;

import ru.peak.ml.apdk.service.formatter.MessageFormatter;
import ru.peak.ml.apdk.service.formatter.ReconcilationFormatter;
import ru.peak.ml.loyalty.message.Message;
import ru.peak.ml.loyalty.message.ResponseMessage;

/**
 *
 */
public class Reconcilation extends CommonApdkMessage {

  MessageFormatter formatter = new ReconcilationFormatter();

  public Reconcilation(String serverAddress, int serverPort) {
    super(serverAddress, serverPort);
  }

  @Override
  public byte[] getData() {
    return getNewApdkMessage().toArray();
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

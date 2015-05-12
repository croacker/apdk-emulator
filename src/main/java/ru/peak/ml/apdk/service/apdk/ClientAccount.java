package ru.peak.ml.apdk.service.apdk;

import ru.peak.ml.loyalty.message.Message;

/**
 *
 */
public class ClientAccount extends CommonApdkMessage {

  public ClientAccount(String serverAddress, int serverPort) {
    super(serverAddress, serverPort);
  }

  @Override
  public byte[] getData() {
    return new byte[0];
  }

  @Override
  public Message getNewApdkMessage() {
    return null;
  }
}

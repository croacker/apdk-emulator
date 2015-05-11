package ru.peak.ml.apdk.service.apdk;

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
}

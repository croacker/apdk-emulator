package ru.peak.ml.apdk.service.apdk;

/**
 *
 */
public class Reconcilation extends CommonApdkMessage {

  public Reconcilation(String serverAddress, int serverPort) {
    super(serverAddress, serverPort);
  }

  @Override
  public byte[] getData() {
    return new byte[0];
  }
}

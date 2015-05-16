package ru.peak.ml.apdk.service.apdk;

import lombok.Setter;
import ru.peak.ml.apdk.service.formatter.MessageFormatter;

/**
 *
 */
public class RawData  extends CommonApdkMessage {

  @Setter
  private byte[] data;

  public RawData(String serverAddress, int serverPort) {
    super(serverAddress, serverPort);
  }

  @Override
  public byte[] getData() {
    return data;
  }

  @Override
  public MessageFormatter getFormatter() {
    return null;
  }
}

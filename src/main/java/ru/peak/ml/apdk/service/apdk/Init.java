package ru.peak.ml.apdk.service.apdk;

/**
 *
 */
public class Init extends CommonApdkMessage {

    public static byte[] ORIGINAL_DATA = {2, 59, 0, 0, 1, 0, 7, 1, 8, 0, 49, 48, 48, 48, 48, 54, 57, 56, 2, 3, 0, 50, 48, 53, 6, 4, 0, 49, 48, 49, 48, 17, 6, 0, 49, 49, 54, 48, 48, 49, 18, 3, 0, 16, 0, 1, 19, 3, 0, 16, 0, 1, 25, 1, 0, 48, 100, 3, 0, 48, 48, 48, 93, -118};

  public Init(String serverAddress, int serverPort) {
    super(serverAddress, serverPort);
  }

  @Override
  public byte[] getData() {
    return ORIGINAL_DATA;
  }
}

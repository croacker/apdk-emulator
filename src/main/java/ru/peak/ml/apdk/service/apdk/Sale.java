package ru.peak.ml.apdk.service.apdk;

import lombok.Getter;
import org.apache.commons.lang.ArrayUtils;

/**
 *
 */
public class Sale extends CommonApdkMessage {

  public static byte[] ORIGINAL_DATA = {2, -117, 0, 0, 1, 0, 7, 1, 8, 0, 57, 57, 55, 55, 53, 53, 51, 51, 2, 4, 0, 50, 50, 52, 52, 3, 27, 0, 4, 69, -54, -126, -107, -13, -118, 42, -108, -4, 4, -76, -96, 110, -42, -104, 25, 106, -53, 112, -31, 51, 0, 92, 57, 60, -44, 4, 3, 0, 54, 52, 51, 5, 14, 0, 50, 48, 49, 53, 48, 52, 50, 49, 49, 55, 49, 49, 50, 50, 6, 6, 0, 49, 49, 54, 48, 49, 52, 7, 10, 0, 49, 48, 48, 48, 48, 48, 48, 48, 48, 49, 16, 1, 0, 49, 17, 6, 0, 49, 49, 54, 48, 48, 49, 18, 3, 0, 16, 0, 1, 19, 3, 0, 16, 0, 1, 23, 4, 0, 49, 50, 48, 48, 25, 1, 0, 49, 100, 3, 0, 48, 48, 48, -48, -27};

  public static byte[] FIRST_PART = {2, -117, 0, 0, 1, 0, 7, 1, 8, 0, 57, 57, 55, 55, 53, 53, 51, 51, 2, 4, 0, 50, 50, 52, 52, 3, 27, 0, 4, 69, -54, -126, -107, -13, -118, 42, -108, -4, 4, -76, -96, 110, -42, -104, 25, 106, -53, 112, -31, 51, 0, 92, 57, 60, -44, 4, 3, 0, 54, 52, 51, 5, 14, 0, 50, 48, 49, 53, 48, 52, 50, 49, 49, 55, 49, 49, 50, 50, 6, 6, 0, 49, 49, 54, 48, 49, 52, 7, 10, 0, 49, 48, 48, 48, 48, 48, 48, 48, 48, 49, 16, 1, 0, 49, 17, 6, 0, 49, 49, 54, 48, 48, 49, 18, 3, 0, 16, 0, 1, 19, 3, 0, 16, 0, 1};
  public static byte[] SECOND_PART = {25, 1, 0, 49, 100, 3, 0, 48, 48, 48};

  @Getter
  private String sum;

  public Sale(String serverAddress, int serverPort, String sum) {
    super(serverAddress, serverPort);
    this.sum = sum;
  }

  public byte[] getData() {
    byte[] result = FIRST_PART;

    byte[] sumArray = getSumAsBytes();
    result = ArrayUtils.add(result, (byte) 23);
    result = ArrayUtils.add(result, (byte) sumArray.length);
    result = ArrayUtils.add(result, (byte) 0);
    result = ArrayUtils.addAll(result, sumArray);

    result = ArrayUtils.addAll(result, SECOND_PART);

    byte[] crc = calcCrc(result);

    result = ArrayUtils.addAll(result, crc);

    return result;
  }

  private byte[] getSumAsBytes() {
//    byte[] result = new byte[]{0,0,0,0};

    return getSum().getBytes();
  }

}

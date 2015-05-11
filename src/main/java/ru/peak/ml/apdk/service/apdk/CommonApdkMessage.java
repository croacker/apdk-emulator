package ru.peak.ml.apdk.service.apdk;

import lombok.Getter;
import ru.peak.ml.loyalty.Crc16;

/**
 * Created by user on 11.05.2015.
 */
public abstract class CommonApdkMessage implements ApdkMessage {

  @Getter
  private String serverAddress;
  @Getter
  private int serverPort;

  public CommonApdkMessage(String serverAddress, int serverPort){
    this.serverAddress = serverAddress;
    this.serverPort = serverPort;
  }

  protected byte[] calcCrc(byte[] sourceData){
    return new Crc16().calcCrc(sourceData);
  }
}

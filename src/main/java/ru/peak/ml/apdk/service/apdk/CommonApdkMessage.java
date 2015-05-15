package ru.peak.ml.apdk.service.apdk;

import lombok.Getter;
import ru.peak.ml.loyalty.Crc16;
import ru.peak.ml.loyalty.message.Message;
import ru.peak.ml.loyalty.message.ResponseMessage;

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

  @Override
  public ResponseMessage getNewApdkMessage() {
    ResponseMessage message = new ResponseMessage();
    message.setProtocolVersion(new String(new byte[]{7}));
    message.setTerminalNumber(new String(new byte[]{57, 57, 55, 55, 53, 53, 51, 51}));
    message.setCashId(new String(new byte[]{50, 50, 52, 52}));
    message.setCurrencyCode(new String(new byte[]{54, 52, 51}));
    message.setShopId(new String(new byte[]{49, 49, 54, 48, 49, 52}));
    message.setOperationNumber(new byte[]{16, 0, 1});
    message.setProtocolIdentifier(new String(new byte[]{48, 48, 48}));
    message.setAcquirerId(new String(new byte[]{49, 49, 54, 48, 48, 49}));
    message.setBatchNumber("100001");
    message.setErrorDescription("EMULATION");
    return message;
  }
}

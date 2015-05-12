package ru.peak.ml.apdk.service.apdk;

import ru.peak.ml.loyalty.message.Message;

/**
 *
 */
public interface ApdkMessage {

  String getServerAddress();

  int getServerPort();

  byte[] getData();

  Message getNewApdkMessage();

}

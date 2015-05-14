package ru.peak.ml.apdk.service.apdk;

import ru.peak.ml.apdk.service.formatter.MessageFormatter;
import ru.peak.ml.loyalty.message.Message;
import ru.peak.ml.loyalty.message.ResponseMessage;

/**
 *
 */
public interface ApdkMessage {

  String getServerAddress();

  int getServerPort();

  byte[] getData();

  ResponseMessage getNewApdkMessage();

  MessageFormatter getFormatter();
}

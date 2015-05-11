package ru.peak.ml.apdk.service.apdk;

/**
 *
 */
public interface ApdkMessage {

  String getServerAddress();

  int getServerPort();

  byte[] getData();

}

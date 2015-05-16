package ru.peak.ml.apdk.service.formatter;

import ru.peak.ml.loyalty.message.Message;
import ru.peak.ml.loyalty.util.StringUtil;

/**
 *
 */
public class RawDataFormatter implements MessageFormatter{
  @Override
  public String toMessageString(Message message) {
    return StringUtil.EMPTY;
  }
}

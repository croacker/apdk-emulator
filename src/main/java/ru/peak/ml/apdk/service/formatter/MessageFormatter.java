package ru.peak.ml.apdk.service.formatter;

import ru.peak.ml.loyalty.message.Message;

/**
 *
 */
public interface MessageFormatter {

    String toMessageString(Message message);

}

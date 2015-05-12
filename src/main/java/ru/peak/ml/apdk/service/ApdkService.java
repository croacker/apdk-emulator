package ru.peak.ml.apdk.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.ArrayUtils;
import org.springframework.stereotype.Service;
import ru.peak.ml.apdk.service.apdk.ApdkMessage;
import ru.peak.ml.loyalty.message.Message;
import ru.peak.ml.loyalty.message.RequestMessage;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 *
 */
@Service
@Slf4j
public class ApdkService {

    public String sendMessage(ApdkMessage message) throws IOException {
        String result;
        try {
            Socket socket = getSocket(message);

            // Берем входной и выходной потоки сокета, теперь можем получать и отсылать данные клиентом.
            InputStream sin = socket.getInputStream();
            OutputStream sout = socket.getOutputStream();

            // Конвертируем потоки в другой тип, чтоб легче обрабатывать текстовые сообщения.
            DataInputStream in = new DataInputStream(sin);
            DataOutputStream out = new DataOutputStream(sout);

            byte[] data = message.getNewApdkMessage().toArray();

            out.write(data); // отсылаем введенную строку текста серверу.
            out.flush(); // заставляем поток закончить передачу данных.

            byte[] responseMessage = IOUtils.toByteArray(in);
            log.info("The server was very polite. It sent me this : " + ArrayUtils.toString(responseMessage));

            RequestMessage request = new RequestMessage(data);

            result = request.toHumanizedString();

            log.info(result);
        } catch (Exception x) {
            log.error(x.getMessage(), x);
            throw x;
        }
        return result;
    }

  private Socket getSocket(ApdkMessage message) throws IOException {
    InetAddress ipAddress = InetAddress.getByName(message.getServerAddress());
    return new Socket(ipAddress, message.getServerPort());
  }

}

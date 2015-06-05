package ru.peak.ml.apdk.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.ArrayUtils;
import org.springframework.stereotype.Service;
import ru.peak.ml.apdk.service.apdk.ApdkMessage;
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

    public String sendMessage(ApdkMessage apdkMessage) throws IOException {
        String result;
        try {
            Socket socket = getSocket(apdkMessage);

            InputStream sin = socket.getInputStream();
            OutputStream sout = socket.getOutputStream();

            DataInputStream in = new DataInputStream(sin);
            DataOutputStream out = new DataOutputStream(sout);

            byte[] data = apdkMessage.getData();

            out.write(data);
            out.flush();

            byte[] responseMessageData = IOUtils.toByteArray(in);
            log.info("The server sent me this : " + ArrayUtils.toString(responseMessageData));

            RequestMessage responseMessage = new RequestMessage(responseMessageData);

            result = apdkMessage.getFormatter().toMessageString(responseMessage);

            log.info(result);
        } catch (Exception x) {
            log.error(x.getMessage(), x);
            result = x.toString();
        }
        return result;
    }

  private Socket getSocket(ApdkMessage message) throws IOException {
    InetAddress ipAddress = InetAddress.getByName(message.getServerAddress());
    return new Socket(ipAddress, message.getServerPort());
  }

}

package ru.peak.ml.apdk.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@Service
@Slf4j
public class ApdkService {

    int PORT = 7000;
    String ADDRESS = "127.0.0.1";

    public void sendMessage(){
        try {
            InetAddress ipAddress = InetAddress.getByName(ADDRESS); // создаем объект который отображает вышеописанный IP-адрес.
            Socket socket = new Socket(ipAddress, PORT); // создаем сокет используя IP-адрес и порт сервера.

            // Берем входной и выходной потоки сокета, теперь можем получать и отсылать данные клиентом.
            InputStream sin = socket.getInputStream();
            OutputStream sout = socket.getOutputStream();

            // Конвертируем потоки в другой тип, чтоб легче обрабатывать текстовые сообщения.
            DataInputStream in = new DataInputStream(sin);
            DataOutputStream out = new DataOutputStream(sout);

//            byte[] data = new byte[]{2, 59, 0, 0, 1, 0, 7, 1, 8, 0, 49, 48, 48, 48, 48, 54, 57, 56, 2, 3, 0, 50, 48, 53, 6, 4, 0, 49, 48, 49, 48, 17, 6, 0, 49, 49, 54, 48, 48, 49, 18, 3, 0, 16, 0, 1, 19, 3, 0, 16, 0, 1, 25, 1, 0, 48, 100, 3, 0, 48, 48, 48, 93, -118};
            byte[] data = new byte[]{2, -117, 0, 0, 1, 0, 7, 1, 8, 0, 57, 57, 55, 55, 53, 53, 51, 51, 2, 4, 0, 50, 50, 52, 52, 3, 27, 0, 4, 69, -54, -126, -107, -13, -118, 42, -108, -4, 4, -76, -96, 110, -42, -104, 25, 106, -53, 112, -31, 51, 0, 92, 57, 60, -44, 4, 3, 0, 54, 52, 51, 5, 14, 0, 50, 48, 49, 53, 48, 52, 50, 49, 49, 55, 49, 49, 50, 50, 6, 6, 0, 49, 49, 54, 48, 49, 52, 7, 10, 0, 49, 48, 48, 48, 48, 48, 48, 48, 48, 49, 16, 1, 0, 49, 17, 6, 0, 49, 49, 54, 48, 48, 49, 18, 3, 0, 16, 0, 1, 19, 3, 0, 16, 0, 1, 23, 4, 0, 49, 50, 48, 48, 25, 1, 0, 49, 100, 3, 0, 48, 48, 48, -48, -27};


            System.out.println("Sending this line to the server...");
            out.write(data); // отсылаем введенную строку текста серверу.
            out.flush(); // заставляем поток закончить передачу данных.
            List<Byte> bbytes = new ArrayList<>();
            byte cbbb = in.readByte(); // ждем пока сервер отошлет строку текста.
            System.out.println("The server was very polite. It sent me this : " + cbbb);
            System.out.println("Looks like the server is pleased with us. Go ahead and enter more lines.");
            System.out.println();
        } catch (Exception x) {
            log.error(x.getMessage(), x);
        }
    }

}

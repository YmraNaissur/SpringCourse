package learning.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * naissur
 * 18.08.2017
 */
public class SocketExample {
    public static void main(String[] args) {
        try {
            // Создаем сокет, получаем входной и выходной потоки
            Socket socket = new Socket("whois.tcinet.ru", 43);
            InputStream input = socket.getInputStream();
            OutputStream output = socket.getOutputStream();

            // Пишем запрос в сокет через выходной поток
            byte[] query = "yandex.ru".getBytes();
            output.write(query);

            // Получаем и выводим данные через входной поток
            int ch;
            while ((ch = input.read()) != -1) {
                System.out.print((char) ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

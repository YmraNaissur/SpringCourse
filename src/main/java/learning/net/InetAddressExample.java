package learning.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * naissur
 * 18.08.2017
 */
public class InetAddressExample {
    public static void main(String[] args) {
        try {
            // получим адрес локального хоста
            InetAddress address = InetAddress.getLocalHost();
            System.out.println(address);

            // получим адрес по имени хоста
            address = InetAddress.getByName("www.yandex.ru");
            System.out.println(address);

            // получим все адреса по имени хоста
            System.out.println("\nAll www.yandex.ru addresses:");
            InetAddress[] addresses = InetAddress.getAllByName("www.yandex.ru");
            for (InetAddress a : addresses) {
                System.out.println(a);
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}

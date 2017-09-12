package learning.nio.readingFileWithChannels;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * naissur
 * 12.09.2017
 * Пример чтения файла через канал с использованием java.nio.
 * Файл находится в том же пакете, что и данный класс.
 */
public class ExplicitReading {
    public static void main(String[] args) {
        int count;
        Path filepath = null;

        // Получаем объект интерфейса Path, инкапсулирующий путь к файлу с тестовыми данными.
        try {
            filepath = Paths.get(Paths.get("").toAbsolutePath().toString() +
                    "\\src\\main\\java\\learning\\nio\\readingFileWithChannels\\test.txt");
        } catch (InvalidPathException e) {
            System.out.println("Invalid path.");
            System.exit(1);
        }

        // Открываем байтовый канал статическим методом класса Files.
        try (SeekableByteChannel channel = Files.newByteChannel(filepath)) {
            // Создаем байтовый буфер размером 128 байт.
            ByteBuffer fBuf = ByteBuffer.allocate(128);


            do {
                // Читаем из канала в буфер, получаем число фактически прочитанных байт.
                count = channel.read(fBuf);

                // Если число прочитанных байт равно -1, значит достигнут конец файла.
                if (count != -1) {
                    // Возвращаем указатель буфера в начало.
                    fBuf.rewind();
                    // Выводим на экран прочитанные байты, преобразуя их в символы.
                    for (int i = 0; i < count; i++) {
                        System.out.print((char) fBuf.get());
                    }
                }
            } while (count != -1);

            System.out.println();

        } catch (IOException e) {
            System.out.println("I/O Error");
            System.exit(1);
        }
    }
}

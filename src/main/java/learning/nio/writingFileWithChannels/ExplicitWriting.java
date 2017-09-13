package learning.nio.writingFileWithChannels;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.*;

/**
 * naissur
 * 13.09.2017
 * Программа побайтово записывает информацию в файл при помощи nio.
 */
public class ExplicitWriting {
    // Путь к файлу. Он будет создан в том же каталоге, в котором находится класс ExplicitWriting.
    private static final String TEST_FILE_PATH = Paths.get("").toAbsolutePath().toString() +
            "\\src\\main\\java\\learning\\nio\\writingFileWithChannels\\test.txt";
    // Данные, которые нужно записать в файл.
    private static final String TEXT_TO_BE_WRITTEN = "It is a text\r\nthat has to be written\r\ninto the file.";

    public static void main(String[] args) {
        Path filepath = null;

        // Получаем объект интерфейса Path, инкапсулирующий путь к файлу.
        try {
            filepath = Paths.get(TEST_FILE_PATH);
        } catch (InvalidPathException e) {
            System.out.println("Invalid path.");
            System.exit(1);
        }

        // Открываем байтовый канал вызовом метода Files.newByteChannel().
        // Файл открывается для чтения и записи, создается, если не существует.
        try (SeekableByteChannel channel = Files.newByteChannel(filepath, StandardOpenOption.CREATE,
                                                    StandardOpenOption.READ, StandardOpenOption.WRITE)) {
            // Определяем буфер размера, равного размеру данных.
            ByteBuffer buf = ByteBuffer.allocate(TEXT_TO_BE_WRITTEN.length());

            // Посимвольно пишем данные в буфер.
            for (int i = 0; i < TEXT_TO_BE_WRITTEN.length(); i++) {
                buf.put((byte) TEXT_TO_BE_WRITTEN.charAt(i));
            }

            // Обнуляем указатель буфера и записываем его в канал.
            buf.rewind();
            channel.write(buf);

        } catch (IOException e) {
            System.out.println("I/O Error.");
            System.exit(1);
        }
    }
}

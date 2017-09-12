package learning.nio.readingFileWithChannels;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * naissur
 * 12.09.2017
 * Пример чтения из файла с использованием java.nio. Применяется мэппинг в буфер MappedByteBuffer.
 * Файл находится в том же каталоге, что и текущий класс.
 */
public class MappedFileReading {
    public static void main(String[] args) {
        long size;  // Здесь будет храниться размер файла (channel.size()).
        Path filepath = null;   // Объект класса Path, инкапсулирующий путь к файлу.

        try {
            // Файл содержится в том же каталоге, что и текущий класс.
            filepath = Paths.get(Paths.get("").toAbsolutePath().toString() +
                    "\\src\\main\\java\\learning\\nio\\readingFileWithChannels\\test.txt");
        } catch (InvalidPathException e) {
            System.out.println("Invalid path.");
            System.exit(1);
        }

        // Объявляем канал, приведя результат вызова метода Files.newByteChannel() к типу FileChannel.
        try (FileChannel channel = (FileChannel) Files.newByteChannel(filepath)) {
            size = channel.size(); // Получаем размер файла.
            // Создаем буфер, куда для чтения вносим содержимое файла с позиции 0 до конца (size).
            MappedByteBuffer mBuf = channel.map(FileChannel.MapMode.READ_ONLY, 0, size);

            // Читаем содержимое буфера и выводим на экран, приводя к символьному типу.
            for (int i = 0; i < mBuf.capacity(); i++) {
                System.out.print((char) mBuf.get(i));
            }

            System.out.println();
        } catch (IOException e) {
            System.out.println("I/O Error.");
            System.exit(1);
        }

    }
}
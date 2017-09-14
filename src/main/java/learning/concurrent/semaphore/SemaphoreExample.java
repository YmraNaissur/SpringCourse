package learning.concurrent.semaphore;

import java.util.concurrent.Semaphore;

/**
 * naissur
 * 14.09.2017
 */
public class SemaphoreExample {
    public static void main(String[] args) {
        // Создается семафор, позволяющий одновременный доступ к ресурсу только одному потоку.
        Semaphore semaphore = new Semaphore(1);
        // Запускаются два потока, описанные ниже.
        new Thread(new IncThread(semaphore, "A")).start();
        new Thread(new DecThread(semaphore, "B")).start();
    }
}

// В этом классе хранится одна переменная, общая для всех потоков.
class Data {
    static int count;
}

// В этом потоке значение общей переменной будет УВЕЛИЧИВАТЬСЯ на 1 пять раз.
class IncThread implements Runnable {
    private Semaphore sem;  // Ссылка на семафор
    private String name;    // Имя потока

    IncThread(Semaphore sem, String name) {
        this.name = name;
        this.sem = sem;
    }

    @Override
    public void run() {
        try {
            // Запрашиваем доступ к семафору.
            System.out.println("Thread " + name + " is aquiring permission.");
            sem.acquire();
            System.out.println("Thread " + name + " permission granted.");

            // Когда доступ получен, все остальные потоки будут ждать, пока мы не освободим его.
            // Таким образом, несмотря на то, что увеличение общей переменной не является атомарной операцией,
            // оно будет выполнено 5 раз в одном потоке.
            for (int i = 0; i < 5; i++) {
                Data.count++;
                System.out.println("Thread " + name + " : " + Data.count);
                // Sleep - для демонстрации.
                // Обычно в таких местах происходит переключение на другой поток.
                // В данном случае этого не произойдет.
                Thread.sleep(10);
            }

            // Освобождаем семафор.
            sem.release();
            System.out.println("Thread " + name + " released the lock.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

// В этом потоке всё аналогично потоку IncThread, только общая переменная 5 раз УМЕНЬШАЕТСЯ на единицу.
class DecThread implements Runnable {
    private Semaphore sem;
    private String name;

    DecThread(Semaphore sem, String name) {
        this.name = name;
        this.sem = sem;
    }

    @Override
    public void run() {
        try {
            // Запрашиваем доступ к семафору.
            System.out.println("Thread " + name + " is aquiring permission.");
            sem.acquire();
            System.out.println("Thread " + name + " permission granted.");

            // Выполняем операции.
            for (int i = 0; i < 5; i++) {
                Data.count--;
                System.out.println("Thread " + name + " : " + Data.count);
                Thread.sleep(10);
            }

            // Освобождаем семафор.
            sem.release();
            System.out.println("Thread " + name + " released the lock.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
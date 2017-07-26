package springRobot.toshiba;

import springRobot.interfaces.Head;

/**
 * naissur
 * 26.07.2017
 * Классы и интерфейсы этого пакета будут использованы
 * для создания бинов при помощи Spring Framework
 */
public class ToshibaHead implements Head {
    public void calc() {
        System.out.println("Toshiba is calculating...");
    }
}

package springRobot.toshiba;

import springRobot.interfaces.Leg;

/**
 * naissur
 * 26.07.2017
 * Классы и интерфейсы этого пакета будут использованы
 * для создания бинов при помощи Spring Framework
 */
public class ToshibaLeg implements Leg {
    public void go() {
        System.out.println("Toshiba is going...");
    }
}

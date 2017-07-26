package springRobot.sony;

import springRobot.interfaces.Hand;

/**
 * naissur
 * 26.07.2017
 * Классы и интерфейсы этого пакета будут использованы
 * для создания бинов при помощи Spring Framework
 */
public class SonyHand implements Hand {
    public void catchSomething() {
        System.out.println("Sony is catching...");
    }
}

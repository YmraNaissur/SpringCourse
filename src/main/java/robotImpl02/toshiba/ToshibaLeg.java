package robotImpl02.toshiba;

import robotImpl02.interfaces.Leg;

/**
 * naissur
 * 26.07.2017
 * Классы и интерфейсы этого пакета показывают, как делать более правильно
 * из-за уменьшения связанности между классами за счет использования интерфейсов
 */
public class ToshibaLeg implements Leg {
    public void go() {
        System.out.println("Toshiba is going...");
    }
}

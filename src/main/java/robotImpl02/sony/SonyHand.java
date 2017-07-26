package robotImpl02.sony;

import robotImpl02.interfaces.Hand;

/**
 * naissur
 * 26.07.2017
 * Классы и интерфейсы этого пакета показывают, как делать более правильно
 * из-за уменьшения связанности между классами за счет использования интерфейсов
 */
public class SonyHand implements Hand {
    public void catchSomething() {
        System.out.println("Sony is catching...");
    }
}

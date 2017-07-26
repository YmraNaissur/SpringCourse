package robotImpl02.sony;

import robotImpl02.interfaces.Head;

/**
 * naissur
 * 26.07.2017
 * Классы и интерфейсы этого пакета показывают, как делать более правильно
 * из-за уменьшения связанности между классами за счет использования интерфейсов
 */
public class SonyHead implements Head {
    public void calc() {
        System.out.println("Sony is calculating...");
    }
}

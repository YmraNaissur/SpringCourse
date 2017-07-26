package robotImpl02.start;

import robotImpl02.toshiba.ToshibaHand;
import robotImpl02.toshiba.ToshibaHead;
import robotImpl02.toshiba.ToshibaLeg;

/**
 * naissur
 * 26.07.2017
 * Классы и интерфейсы этого пакета показывают, как делать более правильно
 * из-за уменьшения связанности между классами за счет использования интерфейсов
 */
public class RobotManager {
    public static void main(String[] args) {
        Robot robot = new Robot(new ToshibaHand(), new ToshibaHead(), new ToshibaLeg());
        robot.action();
    }
}
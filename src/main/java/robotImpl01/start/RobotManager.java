package robotImpl01.start;

/**
 * naissur
 * 26.07.2017
 * В классах этого пакета показано, как делать плохо
 * из-за сильной связанности объектов
 */
public class RobotManager {
    public static void main(String[] args) {
        Robot robot = new Robot();
        robot.action();
    }
}

package springRobot.start;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import springRobot.interfaces.Robot;
import springRobot.robot.ModelT1000;

/**
 * naissur
 * 26.07.2017
 * Классы и интерфейсы этого пакета будут использованы
 * для создания бинов при помощи Spring Framework
 */
public class Start {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

        Robot t1000 = getRobot(context, "t1000");
        Robot t1000Empty = getRobot(context, "t1000Empty");

        if (t1000 != null) {
            t1000.action();
            t1000.checkParameters();
        }

        if (t1000Empty != null) {
            t1000Empty.action();
            t1000Empty.checkParameters();
        }
    }

    /**
     * * Получаем робота из конфигурации Spring по id
     * @param context контекст приложения, в котором нужно найти робота
     * @param robotId id робота
     * @return объект типа Robot с соответствующим id
     */
    private static Robot getRobot(ApplicationContext context, String robotId) {
        Object obj = context.getBean(robotId);

        if (obj instanceof ModelT1000) {
            return (ModelT1000) obj;
        } else {
            return null;
        }
    }
}
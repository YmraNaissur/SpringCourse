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

        Object obj = context.getBean("t1000");

        if (obj instanceof ModelT1000) {
            Robot t1000 = (ModelT1000) obj;
            t1000.dance();
            t1000.action();
        }
    }
}
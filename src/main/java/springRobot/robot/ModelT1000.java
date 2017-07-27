package springRobot.robot;

import springRobot.interfaces.Head;
import springRobot.interfaces.Hand;
import springRobot.interfaces.Leg;
import springRobot.interfaces.Robot;

/**
 * naissur
 * 26.07.2017
 */
public class ModelT1000 implements Robot {
    private Hand hand;
    private Head head;
    private Leg leg;

    // Конструктор по умолчанию
    public ModelT1000() {    }

    public ModelT1000(Hand hand, Head head, Leg leg) {
        super();
        this.hand = hand;
        this.head = head;
        this.leg = leg;
    }

    public void action() {
        head.calc();
        hand.catchSomething();
        leg.go();
    }

    public void dance() {
        System.out.println("T1000 is dancing");
    }
}

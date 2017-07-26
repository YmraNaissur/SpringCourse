package robotImpl02.start;

import robotImpl02.interfaces.Hand;
import robotImpl02.interfaces.Head;
import robotImpl02.interfaces.Leg;

/**
 * naissur
 * 26.07.2017
 * Классы и интерфейсы этого пакета показывают, как делать более правильно
 * из-за уменьшения связанности между классами за счет использования интерфейсов
 */
class Robot {
    // Здесь составные части ссылаются на интерфейсы, а не на конкретные объекты
    private Hand hand;
    private Head head;
    private Leg leg;

    // В конструкторе можно оснастить робота любыми реализациями рук, ног и головы,
    // в том числе и разных компаний
    Robot(Hand hand, Head head, Leg leg) {
        super();
        this.hand = hand;
        this.head = head;
        this.leg = leg;
    }

    void action() {
        hand.catchSomething();
        head.calc();
        leg.go();
    }
}

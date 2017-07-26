package robotImpl01.start;

import robotImpl01.objects.SonyHand;
import robotImpl01.objects.SonyHead;
import robotImpl01.objects.SonyLeg;

/**
 * naissur
 * 26.07.2017
 * В классах этого пакета показано, как делать плохо
 * из-за сильной связанности объектов
 */
class Robot {
    // Робот жестко связан с объектами SonyHand, SonyHead и SonyLeg
    // Если нужно будет поменять их на запачасти другой компании,
    // нужно будет переписывать код класса
    private SonyHand hand = new SonyHand();
    private SonyHead head = new SonyHead();
    private SonyLeg leg = new SonyLeg();

    void action() {
        head.calc();
        hand.catchSomething();
        leg.go();
    }
}

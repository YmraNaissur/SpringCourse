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
    private Hand hand;  // руки
    private Head head;  // голова
    private Leg leg;    // ноги

    private String color;   // цвет робота
    private int year;       // год выпуска
    private boolean soundEnabled;   // наличие звука

    // Конструктор по умолчанию
    public ModelT1000() {    }

    // Конструктор с тремя параметрами для указания запчастей
    public ModelT1000(Hand hand, Head head, Leg leg) {
        super();
        this.hand = hand;
        this.head = head;
        this.leg = leg;
    }

    // Конструктор с тремя параметрами для указания свойств
    public ModelT1000(String color, int year, boolean soundEnabled) {
        this.color = color;
        this.year = year;
        this.soundEnabled = soundEnabled;
    }

    // Конструктор со всеми параметрами
    public ModelT1000(Hand hand, Head head, Leg leg, String color, int year, boolean soundEnabled) {
        super();
        this.hand = hand;
        this.head = head;
        this.leg = leg;
        this.color = color;
        this.year = year;
        this.soundEnabled = soundEnabled;
    }

    // Выполняем какие-то действия
    // Метод с внедрением зависимостей
    public void action() {
        head.calc();
        hand.catchSomething();
        leg.go();
    }

    // Танцуем
    // Метод без внедрения зависимостей
    public void dance() {
        System.out.println("T1000 is dancing");
    }

    // Выводим информацию о параметрах робота
    public void checkParameters() {
        System.out.printf("Color: %s%nYear: %d%nSound enabled: %b%n", color, year, soundEnabled);
    }

    // Геттеры и сеттеры
    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }

    public Leg getLeg() {
        return leg;
    }

    public void setLeg(Leg leg) {
        this.leg = leg;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isSoundEnabled() {
        return soundEnabled;
    }

    public void setSoundEnabled(boolean soundEnabled) {
        this.soundEnabled = soundEnabled;
    }
}

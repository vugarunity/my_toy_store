

public class Main {
    public static void main(String[] args) {
        ToyLottery lottery = new ToyLottery();
        lottery.addToy(new Toy("1", "Конструктор", 2));
        lottery.addToy(new Toy("2", "Робот", 2));
        lottery.addToy(new Toy("3", "Кукла", 6));

        lottery.runLottery(10);
    }
}

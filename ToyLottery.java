import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.Random;

public class ToyLottery {
    private PriorityQueue<Toy> toyQueue;

    public ToyLottery() {
        toyQueue = new PriorityQueue<>((t1, t2) -> Integer.compare(t2.getWeight(), t1.getWeight()));
    }

    public void addToy(Toy toy) {
        toyQueue.add(toy);
    }

    public String getRandomToy() {
        int totalWeight = toyQueue.stream().mapToInt(Toy::getWeight).sum();
        int randomValue = new Random().nextInt(totalWeight);
        int cumulativeWeight = 0;

        for (Toy toy : toyQueue) {
            cumulativeWeight += toy.getWeight();
            if (randomValue < cumulativeWeight) {
                return toy.getId();
            }
        }

        return null; 
    }

    public void runLottery(int times) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("results.txt"))) {
            for (int i = 0; i < times; i++) {
                writer.println(getRandomToy());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

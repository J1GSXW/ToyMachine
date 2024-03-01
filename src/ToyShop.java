import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class ToyShop {
    private List<Toy> toys = new ArrayList<>();

    public void addToy(int id, String name, int quantity, int weight) {
        toys.add(new Toy(id, name, quantity, weight));
    }

    public void updateWeight(int id, int newWeight) {
        for (Toy toy : toys) {
            if (toy.getId() == id) {
                toy.setWeight(newWeight);
                break;
            }
        }
    }

    public String drawToy() {
        List<Toy> availableToys = new ArrayList<>();
        for (Toy toy : toys) {
            for (int i = 0; i < toy.getWeight(); i++) {
                availableToys.add(toy);
            }
        }

        if (!availableToys.isEmpty()) {
            Random random = new Random();
            Toy chosenToy = availableToys.get(random.nextInt(availableToys.size()));
            int index = toys.indexOf(chosenToy);
            toys.get(index).setQuantity(toys.get(index).getQuantity() - 1);
            if (toys.get(index).getQuantity() == 0) {
                toys.remove(index);
            }

            try (FileWriter writer = new FileWriter("prize_toys.txt", true)) {
                writer.write(chosenToy.getId() + ": " + chosenToy.getName() + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }

            return chosenToy.getName();
        } else {
            return "Нет доступных игрушек для розыгрыша.";
        }
    }

    public List<Toy> getToys() {
        return toys;
    }
}

public class Main {
    public static void main(String[] args) {
        ToyShop toyShop = new ToyShop();

        // Добавляем игрушки
        toyShop.addToy(1, "Кукла", 10, 30);
        toyShop.addToy(2, "Машинка", 15, 50);
        toyShop.addToy(3, "Мишка", 8, 20);
        toyShop.addToy(4, "Пистолет", 5, 25);
        toyShop.addToy(5, "Набор посуды", 20, 10);

        toyShop.updateWeight(1, 20);

        String prize = toyShop.drawToy();
        System.out.println("Выйгранная игрушка: " + prize);

        System.out.println("Оставшиеся игрушки:");
        for (Toy toy : toyShop.getToys()) {
            System.out.println(toy.getName() + " " + toy.getQuantity());
        }
    }
}

//zad 1 i 2
class Vehicle {
    public void start() {
        System.out.println("Pojazd zostaje uruchomiony.");
    }
    public void stop() {
        System.out.println("Pojazd zostaje zatrzymany.");
    }
}

class Car extends Vehicle {
    private int numberOfSeats;

    public Car(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    @Override
    public void start() {
        System.out.println("Samochód zostaje uruchomiony.");
    }

    @Override
    public void stop() {
        System.out.println("Samochód zostaje zatrzymany.");
    }
}

// zad 3 i 4
class Animal {
    public void makeNoise() {
        System.out.println("Zwierze wydaje dzwiek.");
    }

    public void roam() {
        System.out.println("Zwierze sie przemieszcza.");
    }
}

class Felidae extends Animal {
    @Override
    public void roam() {
        System.out.println("Zwierze z rodziny kotowatych. ");
    }
}

class Canidae extends Animal {
    @Override
    public void roam() {
        System.out.println("Zwierze z rodziny psich.");
    }
}

class Cat extends Felidae {
    @Override
    public void makeNoise() {
        System.out.println("Kot: Miau!");
    }
}

class Tiger extends Felidae {
    @Override
    public void makeNoise() {
        System.out.println("Tygrys: Roooar!");
    }
}

class Dog extends Canidae {
    @Override
    public void makeNoise() {
        System.out.println("Pies: Hau hau!");
    }
}

class Wolf extends Canidae {
    @Override
    public void makeNoise() {
        System.out.println("Wilk: Auuuuu!");
    }
}
public class Main {
    public static void main(String[] args) {
        Car mojSamochod = new Car(5);
        System.out.println("Liczba miejsc: " + mojSamochod.getNumberOfSeats());
        mojSamochod.start();
        mojSamochod.stop();

        System.out.println("\n--- Zwierzeta ---");
        Animal[] zwierzeta = {
                new Cat(), new Tiger(), new Dog(), new Wolf()
        };

        for (Animal z : zwierzeta) {
            z.makeNoise();
            z.roam();
            System.out.println();
        }
    }
}

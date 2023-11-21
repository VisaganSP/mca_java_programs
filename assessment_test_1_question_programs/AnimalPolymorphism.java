// java program 8.b i)

class AnimalPolymorphism {
    public static void main(String[] args) {
        Animal herbivore = new Herbivores();
        Animal carnivore = new Carnivores();
        Animal omnivore = new Omnivores();

        // Calling eat() using the parent class's reference variable
        herbivore.eat();
        carnivore.eat();
        omnivore.eat();
    }
}

class Animal {
    public void eat() {
        System.out.println("This animal eats something.");
    }
}

class Herbivores extends Animal {
    @Override
    public void eat() {
        System.out.println("This herbivore eats plants.");
    }
}

class Carnivores extends Animal {
    @Override
    public void eat() {
        System.out.println("This carnivore eats meat.");
    }
}

class Omnivores extends Animal {
    @Override
    public void eat() {
        System.out.println("This omnivore eats both plants and meat.");
    }
}
import java.util.*;
/**
 * PSA: I apologize if there are typos here; I did not run this to check,
 * but it looks intuitively fine, in the actual interview, you don't run code on the
 * whiteboard just make sure it makes sense. love :)
 */
abstract class Animal {
    private int order;
    protected String name;
    public Animal (String name) {
        this.name = name;
    }
    // The order in which the animal was received
    public void setOrder(int order) {
        this.order = order;
    }
    public int gerOrder() {
        return order;
    }
    // Compare which animal is older than which
    public boolean isOlderThan (Animal a) {
        // Means this came in earlier than a so it has a lesser order
        return this.order < a.getOrder;
    }
}

class AnimalQueue {
    Queue<Cat> cats = new ArrayDeque<>();
    Queue<Dog> dogs = new ArrayDeque<>();
    public int order; // Maintains the timestamp, you can also choose to peek from
    // either dog or cat and increment +1 for the order but that is a whole other step
    // It is easier this way

    // Instantiate the two queues
    public AnimalQueue () {

    }
    public void enqueue (Animal a) {
        a.setOrder(order);
        order++;

        if (a.instanceof Dog) {
            // Add to dog queue
            dogs.push(a);
        } else {
            // There is only one option left
            cats.push(a);
        }
    }

    public Animal dequeueAny() {
        // Looks at the top of both cats and dogs and return the oldest
        if (dogs.size() == 0) {
            // If there are no dogs we can only afford to give out cats, mean cats
            return dequeueCats();
        }
        if (cats.size() == 0) {
            // If we have no cats, yaaay! Who let the dogs out???
            return dequeueDogs();
        }
        // If we have both dogs and cats, let us pick the oldest
        Dog dog = dogs.peek();
        Cat cat = cats.peek();
        if (dog.isOlderThan(cat)) {
            return dequeueDogs();
        } else {
            return dequeueCats();
        }
    }
    public Cat dequeueCats () {
        // Remove the oldest in cat
        return cats.poll();
    }
    public Dog dequeueDogs () {
        // Remove the oldest in dogs
        return dogs.poll();
    }
}

public class Dog extends Animal {
    public Dog (String name) {
        super(name);
    }
}

public class Cat extends Animal {
    public Cat (String name) {
        super(name);
    }
}
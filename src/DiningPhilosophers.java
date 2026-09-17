import java.util.concurrent.Semaphore;

public class DiningPhilosophers {

    static final int N = 5;

    static Semaphore[] chopstick = new Semaphore[N];

    // Only 4 philosophers can try to pick chopsticks
    static Semaphore room = new Semaphore(4);

    public static void main(String[] args) throws InterruptedException {

        // Initialize chopsticks
        for (int i = 0; i < N; i++) {
            chopstick[i] = new Semaphore(1);
        }

        // Create and start philosophers
        Philosopher[] philosophers = new Philosopher[N];

        for (int i = 0; i < N; i++) {
            philosophers[i] = new Philosopher(i);
            philosophers[i].start();
        }

        // Wait for all philosophers to finish
        for (int i = 0; i < N; i++) {
            philosophers[i].join();
        }

        System.out.println("Dinner completed.");
    }
}

class Philosopher extends Thread {

    int id;
    int left;
    int right;

    Philosopher(int id) {
        this.id = id;

        left = id;
        right = (id + 1) % DiningPhilosophers.N;
    }

    @Override
    public void run() {

        try {

            System.out.println(
                    "Philosopher " + id + " is thinking..."
            );

            Thread.sleep(1000);

            // Enter room
            DiningPhilosophers.room.acquire();

            // Pick up left chopstick
            DiningPhilosophers.chopstick[left].acquire();

            System.out.println(
                    "Philosopher " + id +
                            " picked left chopstick"
            );

            // Pick up right chopstick
            DiningPhilosophers.chopstick[right].acquire();

            System.out.println(
                    "Philosopher " + id +
                            " picked right chopstick"
            );

            // Eat
            System.out.println(
                    "Philosopher " + id +
                            " is eating..."
            );

            Thread.sleep(2000);

            // Put down chopsticks
            DiningPhilosophers.chopstick[left].release();
            DiningPhilosophers.chopstick[right].release();

            System.out.println(
                    "Philosopher " + id +
                            " finished eating and put down chopsticks."
            );

            // Leave room
            DiningPhilosophers.room.release();

        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();
        }
    }
}
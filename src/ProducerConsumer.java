import java.util.concurrent.Semaphore;


public class ProducerConsumer {
    static final int BUFFER_SIZE = 5;
    static int[] buffer = new int[BUFFER_SIZE];
    static int in = 0, out = 0;

    static Semaphore empty = new Semaphore(BUFFER_SIZE);
    static Semaphore full = new Semaphore(0);
    static Semaphore mutex = new Semaphore(1);

    public static void main(String[] args) throws InterruptedException {
        Producer p = new Producer();
        Consumer c = new Consumer();
        p.start();
        c.start();
        p.join();
        c.join();
        System.out.println("Production and consumption completed.");
    }

}

class Producer extends Thread {
    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                ProducerConsumer.empty.acquire();
                ProducerConsumer.mutex.acquire();
                ProducerConsumer.buffer[ProducerConsumer.in] = i;
                System.out.println("produced " + i);
                ProducerConsumer.in = (ProducerConsumer.in + 1) % ProducerConsumer.BUFFER_SIZE;
                ProducerConsumer.mutex.release();
                ProducerConsumer.full.release();
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class Consumer extends Thread {
    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                ProducerConsumer.full.acquire();
                ProducerConsumer.mutex.acquire();
                int item = ProducerConsumer.buffer[ProducerConsumer.out];
                System.out.println("consumed " + item);
                ProducerConsumer.out = (ProducerConsumer.out + 1) % ProducerConsumer.BUFFER_SIZE;
                ProducerConsumer.mutex.release();
                ProducerConsumer.empty.release();
                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}


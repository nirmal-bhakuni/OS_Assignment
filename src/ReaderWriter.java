import java.util.concurrent.Semaphore;

public class ReaderWriter {

    static int data = 0;
    static int readCount = 0;
    static Semaphore mutex = new Semaphore(1);
    static Semaphore rw = new Semaphore(1);

    public static void main(String[] args) throws InterruptedException {
        Reader r1 = new Reader();
        Reader r2 = new Reader();
        Reader r3 = new Reader();
        Writer w1 = new Writer();
        Writer w2 = new Writer();
        w1.start();
        r1.start();
        r2.start();
        r3.start();
        w2.start();
        r1.join();
        r2.join();
        r3.join();
        w1.join();
        w2.join();
        System.out.println("Reading and writing completed.");
    }
}

class Reader extends Thread {
    @Override
    public void run() {
        try {
            ReaderWriter.mutex.acquire();
            ReaderWriter.readCount++;
            if (ReaderWriter.readCount == 1) {
                ReaderWriter.rw.acquire();
            }
            ReaderWriter.mutex.release();
            System.out.println("Reader " + Thread.currentThread().getName() + " START reading " + ReaderWriter.data);
            Thread.sleep(3000);
            System.out.println("Reader " + Thread.currentThread().getName() + " END reading");
            ReaderWriter.mutex.acquire();
            ReaderWriter.readCount--;
            if (ReaderWriter.readCount == 0) {
                ReaderWriter.rw.release();
            }
            ReaderWriter.mutex.release();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class Writer extends Thread {
    @Override
    public void run() {
        try {
            ReaderWriter.rw.acquire();
            System.out.println("Writer " + Thread.currentThread().getName() + " START writing");
            ReaderWriter.data++;
            Thread.sleep(5000);
            System.out.println("Writer " + Thread.currentThread().getName() + " END writing " + ReaderWriter.data);
            ReaderWriter.rw.release();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
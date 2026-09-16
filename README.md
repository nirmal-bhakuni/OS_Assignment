# Operating System Synchronization Problems — Java

This repository contains **Java implementations of classic Operating System synchronization and concurrency problems**.

The programs demonstrate concepts such as **threads, synchronization, mutexes, semaphores, inter-thread communication, and resource sharing**.

## 📚 Problems Covered

### 1. Producer–Consumer Problem

Demonstrates synchronization between producer and consumer threads sharing a common buffer.

**Concepts:**

* Threads
* Shared buffer
* Synchronization
* `wait()` / `notify()`
* Semaphores

### 2. Reader–Writer Problem

Demonstrates multiple readers accessing shared data while writers require exclusive access.

**Concepts:**

* Reader–writer synchronization
* Mutual exclusion
* Semaphores
* Thread synchronization

### 3. Dining Philosophers Problem

Demonstrates synchronization when multiple processes compete for limited shared resources.

**Concepts:**

* Deadlock
* Resource sharing
* Mutex / Semaphores
* Thread synchronization

## 🛠️ Technologies Used

* **Language:** Java
* **Concepts:** Operating Systems, Multithreading, Synchronization
* **JDK:** Java 8+

## 📁 Repository Structure

```text
OS-Synchronization-Java/
│
├── ProducerConsumer.java
├── ReaderWriter.java
├── DiningPhilosophers.java
│
└── README.md
```

> The repository structure may change as more implementations and variations are added.

## ▶️ How to Run

### 1. Clone the repository

```bash
git clone <repository-url>
```

### 2. Navigate to the project

```bash
cd OS-Synchronization-Java
```

### 3. Compile a program

```bash
javac ProducerConsumer.java
```

### 4. Run it

```bash
java ProducerConsumer
```

Similarly:

```bash
javac ReaderWriter.java
java ReaderWriter
```

```bash
javac DiningPhilosophers.java
java DiningPhilosophers
```

## 🎯 Purpose

The purpose of this repository is to understand how Operating System synchronization problems can be implemented using **Java multithreading and synchronization mechanisms**.

It is also intended as a collection of programs for **OS lab work, practice, and revision**.

## 📖 Topics

* Process Synchronization
* Threads
* Critical Section
* Race Conditions
* Mutual Exclusion
* Semaphores
* Monitors
* Deadlock
* Starvation
* Inter-thread Communication
* Resource Allocation

## 🚧 Work in Progress

More synchronization problems, implementations, and variations will be added over time.

---

**Made with Java ☕ | Operating Systems & Concurrency**

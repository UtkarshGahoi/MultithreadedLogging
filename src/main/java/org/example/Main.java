package org.example;

import Service.QueueService;
import Service.QueueServiceImpl;
import Worker.Consumer;
import Worker.Producer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        QueueService queueService = new QueueServiceImpl(100);
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.execute(new Producer(queueService));
        executorService.execute(new Producer(queueService));
        executorService.execute(new Consumer(queueService));
        executorService.shutdown();
        }
    }
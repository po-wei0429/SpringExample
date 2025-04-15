package com.example.demo;

// AsyncExample =========================================================================================================================
// CompletableFuture.runAsync() 會在背景執行 非同步任務，但主程式不會等待它完成就繼續執行。
// future.join(); 讓程式等待該任務完成，才結束主程式。

// import java.util.concurrent.CompletableFuture;

// public class AsyncExample {
//     public static void main(String[] args) {
//         System.out.println("開始執行");

//         CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
//             try {
//                 Thread.sleep(2000); // 模擬長時間運算
//                 System.out.println("長時間運算完成於執行緒：" + Thread.currentThread().getName());
//             } catch (InterruptedException e) {
//                 e.printStackTrace();
//             }
//         });

//         System.out.println("這行程式不會被阻塞，會立即執行");

//         future.join(); // 等待非同步任務完成
//         System.out.println("所有任務完成");
//     }
// }

// SynchronousExample =========================================================================================================================
// task(1) → task(2) → task(3) 依序執行，不會有同時執行的情況。
// 這是最基本的同步程式設計方式。

// public class SynchronousExample {
//     public static void main(String[] args) {
//         System.out.println("開始執行");
//         task(1);
//         task(2);
//         task(3);
//         System.out.println("所有任務執行完成");
//     }

//     public static void task(int id) {
//         System.out.println("執行任務 " + id);
//         try {
//             Thread.sleep(1000); // 模擬任務執行時間
//         } catch (InterruptedException e) {
//             e.printStackTrace();
//         }
//     }
// }

// ParallelExample =========================================================================================================================
// parallelStream() 讓 Java 自動分配多個 CPU 核心來 真正同時執行（平行運算）。
// 適合大規模數據處理，讓每個數字的運算分配到不同核心。

// import java.util.List;
// import java.util.stream.IntStream;

// public class ParallelExample {
//     public static void main(String[] args) {
//         List<Integer> numbers = IntStream.rangeClosed(1, 10).boxed().toList();

//         numbers.parallelStream().forEach(num -> {
//             System.out.println("處理數字 " + num + " 於執行緒：" + Thread.currentThread().getName());
//         });
//     }
// }

// ConcurrencyExample =========================================================================================================================
// 使用 ExecutorService 來管理執行緒池（ThreadPool），允許多個任務「輪流執行」。
// 這裡只開兩條執行緒，任務會在這兩條執行緒之間 切換（並發），但不一定真的同時執行。

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrencyExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2); // 兩條執行緒輪流執行
        for (int i = 1; i <= 5; i++) {
            final int task = i;
            executor.submit(() -> {
                System.out.println("執行任務 " + task + " 於執行緒：" + Thread.currentThread().getName());
            });
        }
        executor.shutdown();
    }
}

//=========================================================================================================================
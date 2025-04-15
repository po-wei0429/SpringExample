package com.example.demo;
// ===================================================================================================================================================
// 用java打一個猜數字遊戲

// import java.util.Random;
// import java.util.Scanner;

// public class GuessNumberGame {
//     public static void main(String[] args) {
//         Random random = new Random();
//         Scanner scanner = new Scanner(System.in);
        
//         int targetNumber = random.nextInt(100) + 1; // 隨機生成 1 到 100 之間的數字
//         int guess;
//         int attempts = 0;
        
//         System.out.println("歡迎來到猜數字遊戲！請猜 1 到 100 之間的數字。");
        
//         while (true) {
//             System.out.print("請輸入你的猜測: ");
//             guess = scanner.nextInt();
//             attempts++;
            
//             if (guess < targetNumber) {
//                 System.out.println("太低了！再試一次。");
//             } else if (guess > targetNumber) {
//                 System.out.println("太高了！再試一次。");
//             } else {
//                 System.out.println("恭喜！你猜對了，答案是 " + targetNumber + "。");
//                 System.out.println("你總共猜了 " + attempts + " 次。");
//                 break;
//             }
//         }
        
//         scanner.close();
//     }
// }

// ===================================================================================================================================================
// 用java打一個猜數字遊戲，用game類別


// import java.util.Random;
// import java.util.Scanner;

// class Game {
//     private final int targetNumber;
//     private final Scanner scanner;
    
//     public Game(int maxNumber) {
//         Random random = new Random();
//         this.targetNumber = random.nextInt(100) + 1; // 產生 1 到 maxNumber 之間的數字
//         this.scanner = new Scanner(System.in);
//     }
    
//     public void play() {
//         System.out.println("猜數字遊戲開始！請輸入 1 到 100 之間的數字。");
//         int guess;
//         int attempts = 0;
        
//         while (true) {
//             System.out.print("請輸入你的猜測: ");
//             guess = scanner.nextInt();
//             attempts++;
            
//             if (guess < targetNumber) {
//                 System.out.println("太小了，請再試一次！");
//             } else if (guess > targetNumber) {
//                 System.out.println("太大了，請再試一次！");
//             } else {
//                 System.out.println("恭喜你猜對了！總共嘗試了 " + attempts + " 次。");
//                 break;
//             }
//         }
//     }
// }

// public class GuessNumberGame {
//     public static void main(String[] args) {
//         Game game = new Game(100); // 設定最大數字為 100
//         game.play();
//     }
// }

// ===================================================================================================================================================
// 用java打一個猜數字遊戲，用game類別，player類別，難易度模式切換，有多個player

// import java.util.Random;
// import java.util.Scanner;

// // 玩家類別，表示玩家要做的事
// class Player {
//     private String name;
//     public Player(String name) {
//         this.name = name;
//     }
//     public String getName() {
//         return name;
//     }
//     public int guessNumber(Scanner scanner) {
//         System.out.print(name + "，請輸入你的猜測數字：");
//         return scanner.nextInt();                           //.nextInt()：從輸入中讀取下一個整數值。
//     }
// }

// // 遊戲類別，負責遊戲流程
// class GameMode {
//     private int targetNumber;
//     private Player[] players;                               //副程式Player用陣列來紀錄name
//     private Random random;
//     private Scanner scanner;
//     private int bound = 100;
//     private int difficultylevel = 0;
//     private int[] remainguesstime ;
//     private int initialguesstime = 0;

//     public void GameMode(){
//         System.out.print("選擇難易度: 1 (Easy), 2 (Medium), or 3 (Hard)：");
//         scanner = new Scanner(System.in);
//         difficultylevel = scanner.nextInt();
//         // scanner.nextLine();
//         if (difficultylevel == 1) {
//             bound = 100;
//             System.out.println("你選擇了難度" + difficultylevel + "！ 玩家可以猜20次，請把握機會!");
//         } else if (difficultylevel == 2) {
//             bound = 200;
//             System.out.println("你選擇了難度" + difficultylevel + "！ 玩家可以猜15次，請把握機會!");
//         } else if(difficultylevel == 3){
//             bound = 300;
//             System.out.println("你選擇了難度" + difficultylevel + "！ 玩家可以猜10次，請把握機會!");
//         } else{
//             bound = 100;
//             System.out.println("輸入錯誤，更改為難度1");
//         }
//         System.out.println("請選擇 1~" + bound + " 的數字");
//     }
    

//     public void GamePlayerSet(String[] playerNames) {
//         random = new Random();
//         scanner = new Scanner(System.in);
//         targetNumber = random.nextInt(bound) + 1;       // 目標數字 
//         System.out.println("==================解答測試" + targetNumber);
//         players = new Player[playerNames.length];           // 建立玩家陣列, 長度為playerNames陣列的元素數量
//         remainguesstime = new int[playerNames.length];
//         for (int i = 0; i < playerNames.length; i++) {
//             players[i] = new Player(playerNames[i]);        //將playerNames存放到本class的players陣列
//             if (bound == 100) {
//                 remainguesstime[i] = 20;
//                 initialguesstime = 20;
//             } else if (bound == 200) {
//                 remainguesstime[i] = 15;
//                 initialguesstime = 15;
//             } else if (bound == 300) {
//                 remainguesstime[i] = 10;
//                 initialguesstime = 10;
//             }else {
//                 remainguesstime[i] = 20;
//                 initialguesstime = 20;
//             } 
//         }
//     }

//     public void start() {
//         boolean guessedCorrectly = false;
//         while (!guessedCorrectly) {
//             int playernumber = 0;
//             for (Player player : players) {                     //增強型 for 迴圈 (Enhanced for loop, for-each loop)，它的作用是 "遍歷" players 陣列
//                 int guess = player.guessNumber(scanner);
//                 if (guess == targetNumber) {
//                     remainguesstime[playernumber]-= 1;
//                     System.out.print("恭喜 " + player.getName() + " 猜對了！目標數字是 " + targetNumber + " ，猜了" + (initialguesstime-remainguesstime[playernumber]) + "次!");
//                     if(remainguesstime[playernumber] == 0 ){
//                         System.out.println("海底撈月 ");
//                         guessedCorrectly = true;
//                     }
//                     guessedCorrectly = true;
//                     break;
//                 } else if (guess < targetNumber) {
                    
//                     remainguesstime[playernumber] -= 1;
//                     System.out.println("" + player.getName() + " 猜太小了！還有" + remainguesstime[playernumber] + "次機會!");
//                     if(remainguesstime[playernumber] == 0 ){
//                         System.out.println("可惜~用完所有次數了 ");
//                         guessedCorrectly = true;
//                     }
//                 } else {
//                     System.out.println("" + player.getName() + " 猜太大了！還有" + remainguesstime[playernumber] + "次機會!");
//                     remainguesstime[playernumber] -= 1;
//                     if(remainguesstime[playernumber] == 0 ){
//                         System.out.println("可惜~用完所有次數了 ");
//                         guessedCorrectly = true;
//                     }
//                 }
//                 playernumber += 1;
//                 if(playernumber > 2) playernumber = 0;
//             }
//         }
//     }
// }

// // 主程式
// public class GuessNumberGame {
//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);
//         System.out.print("請輸入玩家數量：");           // 輸入3 => 3\n
//         int playerCount = scanner.nextInt();                // scanner.nextInt(); 讀取使用者輸入的一整行整數
//         scanner.nextLine(); // 在 Scanner 中 混合使用 nextInt()、nextDouble()、next() 和 nextLine()，建議在數值輸入後加上 scanner.nextLine(); 來清除緩衝區的換行符，以確保 nextLine() 能夠正常讀取完整的文字輸入！
        
//         String[] playerNames = new String[playerCount];     // 建立一個大小為 playerCount 的字串陣列
//         for (int i = 0; i < playerCount; i++) {
//             System.out.print("請輸入玩家 " + (i + 1) + " 的名稱：");
//             playerNames[i] = scanner.nextLine();            // scanner.nextLine(); 讀取使用者輸入的一整行文字
//         }
        
//         GameMode gamemode = new GameMode();
//         gamemode.GameMode();
//         gamemode.GamePlayerSet(playerNames);
//         gamemode.start();
//     }
// }

// ===================================================================================================================================================
// 用java打一個猜數字遊戲，用game類別，player類別，難易度模式切換，有多個player，加入排行榜

// import java.util.Random;
// import java.util.Scanner;
// import java.util.*;
// import java.io.*;

// // 排行榜
// class Leaderboard {
//     private Map<String, Integer> rankings = new HashMap<>();

//     public void addScore(String playerName, int guesses) {
//         rankings.put(playerName, guesses);
//     }

//     public void displayRankings() {
//         System.out.println("\n===== 排行榜 =====");
//         rankings.entrySet().stream()
//             .sorted(Map.Entry.comparingByValue()) // 按猜測次數排序
//             .forEach(entry -> System.out.println(entry.getKey() + " 猜測 " + entry.getValue() + " 次"));
//     }
// }
// // 玩家類別，表示玩家要做的事
// class Player {
//     private String name;
//     public Player(String name) {
//         this.name = name;
//     }
//     public String getName() {
//         return name;
//     }
//     // public int guessNumber(Scanner scanner) {
//     //     System.out.print(name + "，請輸入你的猜測數字：");
//     //     return scanner.nextInt();                           //.nextInt()：從輸入中讀取下一個整數值。
//     // }
//     public int guessNumber(Scanner scanner) {
//         int guess;
//         while (true) {                          // 無限迴圈，直到輸入正確為止
//             System.out.print(name + "，請輸入你的猜測數字：");
//             if (scanner.hasNextInt()) {         // 檢查是否為整數
//                 guess = scanner.nextInt();      //.nextInt()：從輸入中讀取下一個整數值。
//                 scanner.nextLine();             // 吃掉換行符，避免影響下一次輸入
//                 return guess;
//             } else {
//                 System.out.println("輸入錯誤的值！請輸入數字。");
//                 scanner.nextLine();             // 清除錯誤輸入，避免無窮迴圈
//             }
//         }
//     }
// }

// // 遊戲類別，負責遊戲模式及流程
// class GameMode {
//     private int targetNumber;
//     private Player[] players;                               //副程式Player用陣列來紀錄name
//     private Random random;
//     private Scanner scanner;
//     private int bound = 100;
//     private int[] remainguesstime ;
//     private int initialguesstime = 0;
//     private Leaderboard leaderboard = new Leaderboard(); // 加入排行榜

//     public void GameMode(){
//         System.out.print("選擇難易度: 1 (Easy), 2 (Medium), or 3 (Hard)：");
//         scanner = new Scanner(System.in);
//         int difficultylevel = scanner.nextInt();
//         // scanner.nextLine();
//         if (difficultylevel == 1) {
//             bound = 100;
//             System.out.println("你選擇了難度" + difficultylevel + "！ 玩家可以猜20次，請把握機會!");
//         } else if (difficultylevel == 2) {
//             bound = 200;
//             System.out.println("你選擇了難度" + difficultylevel + "！ 玩家可以猜15次，請把握機會!");
//         } else if(difficultylevel == 3){
//             bound = 300;
//             System.out.println("你選擇了難度" + difficultylevel + "！ 玩家可以猜10次，請把握機會!");
//         } else{
//             bound = 100;
//             System.out.println("輸入錯誤，更改為難度1");
//         }
//         System.out.println("請選擇 1~" + bound + " 的數字");
//     }
    

//     public void GamePlayerSet(String[] playerNames) {
//         random = new Random();
//         scanner = new Scanner(System.in);
//         targetNumber = random.nextInt(bound) + 1;       // 目標數字 
//         System.out.println("==================解答測試" + targetNumber);
//         players = new Player[playerNames.length];           // 建立玩家陣列, 長度為playerNames陣列的元素數量
//         remainguesstime = new int[playerNames.length];
//         for (int i = 0; i < playerNames.length; i++) {
//             players[i] = new Player(playerNames[i]);        //將playerNames存放到本class的players陣列
//             if (bound == 100) {
//                 remainguesstime[i] = 20;
//                 initialguesstime = 20;
//             } else if (bound == 200) {
//                 remainguesstime[i] = 15;
//                 initialguesstime = 15;
//             } else if (bound == 300) {
//                 remainguesstime[i] = 10;
//                 initialguesstime = 10;
//             }else {
//                 remainguesstime[i] = 20;
//                 initialguesstime = 20;
//             } 
//         }
//     }

//     public void start() {
//         boolean guessedCorrectly = false;
//         while (!guessedCorrectly) {
//             int playernumber = 0;
//             for (Player player : players) {                     //增強型 for 迴圈 (Enhanced for loop, for-each loop)，它的作用是 "遍歷" players 陣列
//                 int guess = player.guessNumber(scanner);
//                 if (guess == targetNumber) {
//                     remainguesstime[playernumber]-= 1;
//                     System.out.print("恭喜 " + player.getName() + " 猜對了！目標數字是 " + targetNumber + " ，猜了" + (initialguesstime-remainguesstime[playernumber]) + "次!");
                    
//                     leaderboard.addScore(player.getName(), (initialguesstime-remainguesstime[playernumber])); // 加入排行榜
                    
//                     if(remainguesstime[playernumber] == 0 ){
//                         System.out.println("海底撈月 ");
//                         guessedCorrectly = true;
//                     }
//                     guessedCorrectly = true;
//                     break;
//                 } else if (guess < targetNumber) {
                    
//                     remainguesstime[playernumber] -= 1;
//                     System.out.println("" + player.getName() + " 猜太小了！還有" + remainguesstime[playernumber] + "次機會!");
//                     if(remainguesstime[playernumber] == 0 ){
//                         System.out.println("可惜~用完所有次數了 ");
//                         guessedCorrectly = true;
//                     }
//                 } else if (guess > targetNumber){
//                     remainguesstime[playernumber] -= 1;
//                     System.out.println("" + player.getName() + " 猜太大了！還有" + remainguesstime[playernumber] + "次機會!");
                    
//                     if(remainguesstime[playernumber] == 0 ){
//                         System.out.println("可惜~用完所有次數了 ");
//                         guessedCorrectly = true;
//                     }
//                 } 
//                 playernumber ++;
//                 if(playernumber > 2) playernumber = 0;
//             }
//         }
//         leaderboard.displayRankings(); // 顯示排行榜
//     }
// }

// // 主程式
// public class GuessNumberGame {
//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);
//         System.out.print("請輸入玩家數量：");           // 輸入3 => 3\n
//         int playerCount = scanner.nextInt();                // scanner.nextInt(); 讀取使用者輸入的一整行整數
//         scanner.nextLine(); // 在 Scanner 中 混合使用 nextInt()、nextDouble()、next() 和 nextLine()，建議在數值輸入後加上 scanner.nextLine(); 來清除緩衝區的換行符，以確保 nextLine() 能夠正常讀取完整的文字輸入！
        
//         String[] playerNames = new String[playerCount];     // 建立一個大小為 playerCount 的字串陣列
//         for (int i = 0; i < playerCount; i++) {
//             System.out.print("請輸入玩家 " + (i + 1) + " 的名稱：");
//             playerNames[i] = scanner.nextLine();            // scanner.nextLine(); 讀取使用者輸入的一整行文字
//         }
        
//         GameMode gamemode = new GameMode();
//         gamemode.GameMode();
//         gamemode.GamePlayerSet(playerNames);
//         gamemode.start();
//     }
// }

// ===================================================================================================================================================
// 用java打一個猜數字遊戲，用game類別，player類別，難易度模式切換，有多個player，加入排行榜另外存檔

// import java.util.Random;
// import java.util.Scanner;
// import java.util.*;
// import java.io.*;



// // 玩家類別，表示玩家要做的事
// class Player {
//     private String name;
//     public Player(String name) {
//         this.name = name;
//     }
//     public String getName() {
//         return name;
//     }
//     // public int guessNumber(Scanner scanner) {
//     //     System.out.print(name + "，請輸入你的猜測數字：");
//     //     return scanner.nextInt();                           //.nextInt()：從輸入中讀取下一個整數值。
//     // }
//     public int guessNumber(Scanner scanner) {
//         int guess;
//         while (true) {                          // 無限迴圈，直到輸入正確為止
//             System.out.print(name + "，請輸入你的猜測數字：");
//             if (scanner.hasNextInt()) {         // 檢查是否為整數
//                 guess = scanner.nextInt();      //.nextInt()：從輸入中讀取下一個整數值。
//                 scanner.nextLine();             // 吃掉換行符，避免影響下一次輸入
//                 return guess;
//             } else {
//                 System.out.println("輸入錯誤的值！請輸入數字。");
//                 scanner.nextLine();             // 清除錯誤輸入，避免無窮迴圈
//             }
//         }
//     }
// }

// // 遊戲類別，負責遊戲模式及流程
// class GameMode {
//     private int targetNumber;
//     private Player[] players;                               //副程式Player用陣列來紀錄name
//     private Random random;
//     private Scanner scanner;
//     private int bound = 100;
//     private int[] remainguesstime ;
//     private int initialguesstime = 0;
//     private int usedguesstime = 0;
//     private int difficultylevel = 0;
//     private String leaderboardFile;  // 存放排行榜檔案名稱 

//     public void GameMode(){
//         System.out.print("選擇難易度: 1 (Easy), 2 (Medium), or 3 (Hard)：");
//         scanner = new Scanner(System.in);
//         difficultylevel = scanner.nextInt();
//         switch (difficultylevel) {
//             case 1:
//                 bound = 100;
//                 System.out.println("你選擇了難度" + difficultylevel + "！ 玩家可以猜20次，請把握機會!");
//                 leaderboardFile = "leaderboard_easy.txt";   // 🔹 設定排行榜檔案
//                 break;
//             case 2:
//                 bound = 200;
//                 System.out.println("你選擇了難度" + difficultylevel + "！ 玩家可以猜15次，請把握機會!");
//                 leaderboardFile = "leaderboard_medium.txt";
//                 break;
//             case 3:
//                 bound = 300;
//                 System.out.println("你選擇了難度" + difficultylevel + "！ 玩家可以猜10次，請把握機會!");
//                 leaderboardFile = "leaderboard_hard.txt";
//                 break;
//             default:
//                 bound = 100;
//                 System.out.println("輸入錯誤，更改為難度1");
//                 leaderboardFile = "leaderboard_easy.txt";   // 🔹 設定排行榜檔案
//         }
//         System.out.println("請選擇 1~" + bound + " 的數字");
//     }

    

//     public void GamePlayerSet(String[] playerNames) {
//         random = new Random();
//         scanner = new Scanner(System.in);
//         targetNumber = random.nextInt(bound) + 1;       // 目標數字 
//         System.out.println("==================解答測試" + targetNumber);
//         players = new Player[playerNames.length];           // 建立玩家陣列, 長度為playerNames陣列的元素數量
//         remainguesstime = new int[playerNames.length];
//         for (int i = 0; i < playerNames.length; i++) {
//             players[i] = new Player(playerNames[i]);        //將playerNames存放到本class的players陣列
//             if (bound == 100) {
//                 remainguesstime[i] = 20;
//                 initialguesstime = 20;
//             } else if (bound == 200) {
//                 remainguesstime[i] = 15;
//                 initialguesstime = 15;
//             } else if (bound == 300) {
//                 remainguesstime[i] = 10;
//                 initialguesstime = 10;
//             }else {
//                 remainguesstime[i] = 20;
//                 initialguesstime = 20;
//             } 
//         }
//     }

//     public void start() {
//         boolean guessedCorrectly = false;
//         while (!guessedCorrectly) {
//             int playernumber = 0;
//             for (Player player : players) {                     //增強型 for 迴圈 (Enhanced for loop, for-each loop)，它的作用是 "遍歷" players 陣列
//                 int guess = player.guessNumber(scanner);
//                 if (guess == targetNumber) {
//                     remainguesstime[playernumber]-= 1;
//                     usedguesstime = initialguesstime - remainguesstime[playernumber];
//                     System.out.print("恭喜 " + player.getName() + " 猜對了！目標數字是 " + targetNumber + " ，猜了" + usedguesstime + "次!");
                    
//                    updateLeaderboard(player.getName(), usedguesstime);       //更新對應難度的排行榜，後半為猜測次數

//                     if(remainguesstime[playernumber] == 0 ){
//                         System.out.println("海底撈月 ");
//                         guessedCorrectly = true;
//                     }
//                     guessedCorrectly = true;
//                     break;
//                 } else if (guess < targetNumber) {
                    
//                     remainguesstime[playernumber] -= 1;
//                     System.out.println("" + player.getName() + " 猜太小了！還有" + remainguesstime[playernumber] + "次機會!");
//                     if(remainguesstime[playernumber] == 0 ){
//                         System.out.println("可惜~用完所有次數了 ");
//                         guessedCorrectly = true;
//                     }
//                 } else if (guess > targetNumber){
//                     remainguesstime[playernumber] -= 1;
//                     System.out.println("" + player.getName() + " 猜太大了！還有" + remainguesstime[playernumber] + "次機會!");
                    
//                     if(remainguesstime[playernumber] == 0 ){
//                         System.out.println("可惜~用完所有次數了 ");
//                         guessedCorrectly = true;
//                     }
//                 } 
//                 playernumber ++;
//                 if(playernumber > 2) playernumber = 0;
//             }
//         }
//         displayLeaderboard();        //  顯示排行榜
//     }

//      /*  更新排行榜（寫入對應難度的檔案） */
//      private void updateLeaderboard(String playerName, int usedguesstime) {
//         try (FileWriter writer = new FileWriter(leaderboardFile, true)) {
//             writer.write(playerName + " " + usedguesstime + "\n");
//         } catch (IOException e) {
//             System.out.println(" 錯誤：無法更新排行榜！");
//         }
//     }

//     /*  顯示排行榜（讀取對應難度的檔案） */
//     private void displayLeaderboard() {
//         System.out.println("\n **" + getDifficultyName() + " 模式排行榜** ");
//         try (BufferedReader reader = new BufferedReader(new FileReader(leaderboardFile))) {
//             String line;
//             List<String> scores = new ArrayList<>();
//             while ((line = reader.readLine()) != null) {
//                 scores.add(line);
//             }

//             // 依猜測次數排序
//             scores.sort(Comparator.comparingInt(s -> Integer.parseInt(s.split(" ")[1])));

//             for (String entry : scores) {
//                 System.out.println(entry);
//             }
//         } catch (IOException e) {
//             System.out.println(" 無排行榜紀錄");
//         }
//     }

//     /* 根據難度回傳對應的文字 */
//     private String getDifficultyName() {
//         switch (difficultylevel) {
//             case 1: return "Easy";
//             case 2: return "Medium";
//             case 3: return "Hard";
//             default: return "Easy";
//         }
//     }
// }


// // 主程式
// public class GuessNumberGame {
//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);
//         System.out.print("請輸入玩家數量：");           // 輸入3 => 3\n
//         int playerCount = scanner.nextInt();                // scanner.nextInt(); 讀取使用者輸入的一整行整數
//         scanner.nextLine(); // 在 Scanner 中 混合使用 nextInt()、nextDouble()、next() 和 nextLine()，建議在數值輸入後加上 scanner.nextLine(); 來清除緩衝區的換行符，以確保 nextLine() 能夠正常讀取完整的文字輸入！
        
//         String[] playerNames = new String[playerCount];     // 建立一個大小為 playerCount 的字串陣列
//         for (int i = 0; i < playerCount; i++) {
//             System.out.print("請輸入玩家 " + (i + 1) + " 的名稱：");
//             playerNames[i] = scanner.nextLine();            // scanner.nextLine(); 讀取使用者輸入的一整行文字
//         }
        
//         GameMode gamemode = new GameMode();
//         gamemode.GameMode();
//         gamemode.GamePlayerSet(playerNames);
//         gamemode.start();
//     }
// }
package com.example.demo;
// package com.example.demo;
// 請設計三個 Java 類別：MeanCalculator、RangeMeanCalculator 和 WeightedMeanCalculator，以計算不同類型的平均值。
// 與之前的版本不同，本題要求使用 Composition (組合) 而非 繼承 (Inheritance)，並且適當地使用 final 來保護不可變的方法或屬性。

// MeanCalculator 負責計算從 1 到 upper 的平均值。
// RangeMeanCalculator 內部包含 MeanCalculator (使用 Composition)，計算 lower 到 upper 的平均值。
// WeightedMeanCalculator 內部包含 MeanCalculator (使用 Composition)，計算一組數值的 加權平均數。
// package com.example.demo;
// MeanCalculator 負責計算從 1 到 upper 的平均值。
class MeanCalculator {
    private final int upper;

    public MeanCalculator(final int upper) {
        if (upper <= 0) {
            throw new IllegalArgumentException("upper 必須大於 0");
        }
        this.upper = upper;
    }
    
    public final float calculateMean() {
        int sum = 0;
        sum = (1 + upper) * upper / 2; 
        // for (int i = 1; i <= upper; i++) {
        //     sum += i;
        // }
        return (float) sum / upper;
    }
}

// RangeMeanCalculator 內部包含 MeanCalculator (使用 Composition)，計算 lower 到 upper 的平均值。
class RangeMeanCalculator {
    private final MeanCalculator meanCalculator_upper;
    private final MeanCalculator meanCalculator_lower;
    private final int lower;
    private final int upper;
    
    public RangeMeanCalculator(final int lower, final int upper) {
        if (lower > upper || lower <= 0) {
            throw new IllegalArgumentException("lower 必須小於等於 upper，且大於 0");
        }
        this.lower = lower;
        this.upper = upper;
        this.meanCalculator_upper = new MeanCalculator(upper);
        this.meanCalculator_lower = new MeanCalculator(lower - 1);
    }
    
    public final float calculateMean() {
        // int sum = 0;
        // sum = (lower + upper) * (upper - lower + 1) / 2; 
        // for (int i = lower; i <= upper; i++) {
        //     sum += i;
        // }
        return (float) (meanCalculator_upper.calculateMean() * upper - meanCalculator_lower.calculateMean() * (lower-1)) / (upper - lower + 1);
    }
}

// WeightedMeanCalculator 內部包含 MeanCalculator (使用 Composition)，計算一組數值的 加權平均數。
class WeightedMeanCalculator {
    private final MeanCalculator meanCalculator;
    private final int lower;
    private final int upper;

    public WeightedMeanCalculator(final int lower, final int upper) {
        if (lower > upper || lower <= 0) {
            throw new IllegalArgumentException("lower 必須小於等於 upper，且大於 0");
        }
        this.meanCalculator = new MeanCalculator(1); // 這裡的 MeanCalculator 只是佔位，不實際使用
        this.lower = lower;
        this.upper = upper;
    }
    
    public final float calculateWeightedMean() {
        int weightedSum = 0;
        for (int i = lower; i <= upper; i++) {
            weightedSum += i * i;
        }
        return (float) weightedSum / (upper - lower + 1);
    }
}

// 測試程式
public class CompositionHomework{
    public static void main(String[] args){
        MeanCalculator mean = new MeanCalculator(10);
        System.out.println("Mean (1~10): " + mean.calculateMean());
        
        RangeMeanCalculator rangeMean = new RangeMeanCalculator(3, 10);
        System.out.println("Range Mean (3~10): " + rangeMean.calculateMean());
        
        WeightedMeanCalculator weightedMean = new WeightedMeanCalculator(1, 3);
        System.out.println("Weighted Mean: " + weightedMean.calculateWeightedMean());
    }
}

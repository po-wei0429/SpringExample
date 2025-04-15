package com.example.demo;

public class Fibonacci{
    static int func_fib(int n)
    {
        if(n<2) return n;
        else return func_fib(n-2) + func_fib(n-1);
    }
}
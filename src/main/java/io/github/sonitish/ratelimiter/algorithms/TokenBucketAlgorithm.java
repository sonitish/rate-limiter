package io.github.sonitish.ratelimiter.algorithms;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class TokenBucketAlgorithm {

    private TokenBucketAlgorithm(){};

    static Queue<Integer> tokenBucket = new ArrayBlockingQueue<>(1);

    public static int getToken() throws Exception{
        if(!tokenBucket.isEmpty()){
            return tokenBucket.poll();
        }
        else{
            throw new Exception("No tokens");
        }
    }

    public static void refillTokens(int tokens){
        boolean isTokenAdded =  tokenBucket.offer(tokens);
        if (!isTokenAdded){
            System.out.println("Queue is full");
        }
    }

    public static void refillBucket(){
        int tokens = 1;
        refillTokens(tokens);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("Exception occured while exception thread sleep:- ");
            throw new RuntimeException(e);
        }
    }
}
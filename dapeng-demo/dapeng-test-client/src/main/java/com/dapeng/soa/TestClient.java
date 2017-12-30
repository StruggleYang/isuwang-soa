package com.dapeng.soa;

import com.isuwang.dapeng.core.SoaException;
import com.isuwang.soa.CalculateServiceClient;
import com.isuwang.soa.PrintServiceClient;

import java.util.concurrent.CompletableFuture;


/**
 * Created by admin on 2017/8/16.
 */
public class TestClient {

    public static void main(String[] args) throws InterruptedException, SoaException {

        System.setProperty("soa.zookeeper.host", "192.168.99.100:2181");
        PrintServiceClient client = new PrintServiceClient();
        String result = client.printInfo2("test");
        System.out.println("result:"+result);
 //       CalculateServiceClient client = new CalculateServiceClient();
//        int count =client.calcualteWordCount("f://test.txt","to");
//        System.out.println(count);

//        CompletableFuture<Integer> future =  client.calcualteWordCount("f://test.txt","to",2000);
//        future.whenComplete((result, ex) -> {
//            if (result!=null) {
//                System.out.println(result);
//            }else {
//                future.completeExceptionally(ex);
//            }
//        });


    }
}
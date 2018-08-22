package com.study.future;

/**
 * 首先客户端向服务器请求RealSubject，但是这个资源的创建是非常耗时的，怎么办呢？这种情况下，首先返回Client一个FutureSubject,
 * 以满足客户端的需求，于此同时呢，Future会通过另外一个Thread 去构造一个真正的资源，资源准备完毕之后，在给future一个通知。
 * 如果客户端急于获取这个真正的资源，那么就会阻塞客户端的其他所有线程，等待资源准备完毕。
 */
public class Test {
    public static void main(String[] args) {
        Client client = new Client();
        Data data = client.request("name");
        System.out.println("请求完毕!!");
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            // TODO: handle exception
        }
        System.out.println("获取的数据:" +data.getContent());
    }
}

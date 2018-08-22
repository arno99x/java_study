package com.study.future;

public class Client {
    public Data request(final String request){
        final FutureData future = new FutureData();
        new Thread(){
            @Override
            public void run() {

                RealData reaData = new RealData(request);
                future.setRealData(reaData);
            };
        }.start();
        return future;
    }
}

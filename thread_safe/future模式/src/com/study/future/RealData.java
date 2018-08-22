package com.study.future;

public class RealData implements Data {
    protected String result;

    public RealData(String para) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            sb.append(para);
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                // TODO: handle exception
            }
            result = sb.toString();
        }
    }

    @Override
    public String getContent() {
        return result;
    }
}

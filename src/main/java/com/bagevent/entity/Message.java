package com.bagevent.entity;

import java.util.HashMap;
import java.util.Map;

public class Message {
    //鐘舵�佺爜 100-鎴愬姛 200-澶辫触
    private int code;
    //鎻愮ず淇℃伅
    private String message;
    //鐢ㄦ埛瑕佽繑鍥炵粰娴忚鍣ㄧ殑鏁版嵁
    private Map<String,Object> extend=new HashMap<String,Object>();

    public static Message success(){
        Message result = new Message();
        result.setCode(100);
        result.setMessage("success!");
//        System.out.println(result.code+"\t"+result.message);
        return result;
    }

    public static Message fail(){
        Message result = new Message();
        result.setCode(200);
        result.setMessage("fail!");
//        System.out.println(result.code+"\t"+result.message);
        return result;
    }

    public Message add(String key,Object value){
        this.getExtend().put(key,value);
        return this;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getExtend() {
        return extend;
    }

    public void setExtend(Map<String, Object> extend) {
        this.extend = extend;
    }
}

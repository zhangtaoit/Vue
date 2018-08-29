package com.yatop.util;


public class ResponseMessage {

    private String status;
    private String message;
    private Object result;

    public static ResponseMessage success() {
        ResponseMessage responseBean = new ResponseMessage();
        responseBean.setStatus("success");
        return responseBean;
    }

    public static ResponseMessage success(Object object) {
        ResponseMessage responseBean = new ResponseMessage();
        responseBean.setStatus("success");
        responseBean.setResult(object);
        return responseBean;
    }

    public static ResponseMessage error(String message) {
        ResponseMessage responseBean = new ResponseMessage();
        responseBean.setStatus("error");
        responseBean.setMessage(message);
        return responseBean;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}

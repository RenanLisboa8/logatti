package br.com.company;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Message implements Serializable {
    private static final long serialVersionUID = -2723363051271966964L;

    private String user;
    private String message;

    public Message(String user, String message){
        this.user=user;
        this.message=message;
    }

    private static List<Message> lstMessage = new ArrayList<Message>();

    public static List<Message> getLstMessage() {
        return lstMessage;
    }

    public static void setLstMessage(Message msg) {
        lstMessage.add(msg);
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

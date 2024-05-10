package com.QA.Test;

import org.eclipse.jetty.websocket.client.WebSocketClient;

public class EventItem {
        private String event;
        private Object data;
        WebSocketClient al = new WebSocketClient();
       // private Acknowledgment ack;  // Assuming Acknowledgment is a class, adjust as needed

        // Constructor
//        public EventItem(String event, Object data, Acknowledgment ack) {
//            this.event = event;
//            this.data = data;
//            this.ack = ack;
//        }

        // Getter methods
        public String getEvent() {
            return event;
        }

        public Object getData() {
            return data;
        }

//        public Acknowledgment getAck() {
//            return ack;
//        }
}



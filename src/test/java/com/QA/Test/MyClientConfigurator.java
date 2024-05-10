package com.QA.Test;


import javax.websocket.ClientEndpointConfig;
import java.util.Collections;
import java.util.List;
import java.util.Map;
    public class MyClientConfigurator extends ClientEndpointConfig.Configurator {
        @Override
        public void beforeRequest(Map<String, List<String>> headers) {
            // Add custom headers to the WebSocket handshake request
            headers.put("authorization", Collections.singletonList("6336")); // TODO: add header for 2 apps
            headers.put("app-version", Collections.singletonList("474"));
          //  headers.put("app-version", BuildConfig.VERSION_CODE.toString());
         //   headers.put("deviceid", deviceRepository.getDeviceId());
         //   headers.put("deviceinfo", deviceRepository.getDeviceInfo());
            // Add more headers as needed
        }

//        private void emitExistingEvents() {
//            while (!eventQueue.isEmpty() && ioSocket.isConnected()) {
//                try {
//                    EventItem eventItem = eventQueue.poll();
//                    if (eventItem != null) {
//                        if (eventItem.getAck() == null) {
//                            ioSocket.sendEvent(eventItem.getEvent(), eventItem.getData());
//                        } else {
//                            ioSocket.sendEvent(eventItem.getEvent(), eventItem.getData(), eventItem.getAck());
//                        }
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }

    }

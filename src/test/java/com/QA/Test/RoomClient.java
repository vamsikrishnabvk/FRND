package com.QA.Test;


import javax.websocket.*;
import java.net.URI;

public class RoomClient extends Endpoint {

        @OnMessage
        public void onMessage(String message) {
            System.out.println("Received message: " + message);
        }

    @Override
    public void onOpen(Session session, EndpointConfig endpointConfig) {

    }

    @OnClose
        public void onClose(Session session, CloseReason closeReason) {
            System.out.println("Connection closed: " + closeReason.getReasonPhrase());
        }

        @OnError
        public void onError(Session session, Throwable throwable) {
            throwable.printStackTrace();
        }


        public static void main(String[] args) {
            String roomName = "Kii";
           // String endpointURL = "ws://127.0.0.1:8088/game/charades";
            String authorizationToken = "6336";
            String appVersion = "474";
            String deviceId = "ZD2227CVBC";
            String deviceInfo = "yourDeviceInfo";

            // Include headers in the WebSocket URI
            String endpointURL = "ws://dev.frndapp.in:8087/game/charades";

            try {
                WebSocketContainer container = ContainerProvider.getWebSocketContainer();
                ClientEndpointConfig.Configurator configurator = new MyClientConfigurator();
                ClientEndpointConfig clientConfig = ClientEndpointConfig.Builder.create()
                        .configurator(configurator)
                        .build();
                Session session = container.connectToServer(RoomClient.class, clientConfig, URI.create(endpointURL));

                // Configure headers manually
//                Map<String, Object> headers = new HashMap<>();
//                headers.put("Authorization", "6336");
//                headers.put("app-version", "2.149");
//                headers.put("deviceid", "ZD2227CVBC");
                //headers.put("deviceinfo", deviceDetails.getDeviceInfo());

                // Set headers for the WebSocket session

                // Perform any necessary actions after connection, if needed

                // Simulate sending a message to the server
                session.getBasicRemote().sendText("{\"type\": \"$event\",\"data\": 12345}");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


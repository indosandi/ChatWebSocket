/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kmbmicro.chatwebsocket;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author sandiwibowo
 */
@ServerEndpoint(value="/chatendpoint", encoders = {ChatEncoder.class}, decoders = {ChatDecoder.class})
public class ChatRecBc {
    private static Set<Session> peers = Collections.synchronizedSet(new HashSet<Session>());
    @OnMessage
    public void broadcastFigure(ChatData chatData, Session session) throws IOException, EncodeException {
        System.out.println("broadcast Data: " + chatData);
        DbString.createItems(chatData);
        for (Session peer : peers) {
//            if (!peer.equals(session)) {
                peer.getBasicRemote().sendObject(chatData);
//            }
        }
    }

    @OnOpen
    public void onOpen(Session peer) {
        peers.add(peer);
        System.out.println("on Open");
        DbString.init();
    }

    @OnError
    public void onError(Throwable t) {
    }

    @OnClose
    public void onClose(Session peer) {
        peers.remove(peer);
    }
    
}

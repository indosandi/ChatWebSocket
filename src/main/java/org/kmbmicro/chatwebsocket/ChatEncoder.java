/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kmbmicro.chatwebsocket;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

/**
 *
 * @author sandiwibowo
 */
public class ChatEncoder implements Encoder.Text<ChatData> {

    @Override
    public String encode(ChatData arg0) throws EncodeException {
        System.out.println("lklklklk");
        return arg0.getJson().toString(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void init(EndpointConfig config) {
        System.out.println("init"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void destroy() {
        System.out.println("destroy"); //To change body of generated methods, choose Tools | Templates.
    }
    
}

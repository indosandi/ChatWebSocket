/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kmbmicro.chatwebsocket;

import java.io.StringReader;
import javax.json.Json;
import javax.json.JsonException;
import javax.json.JsonObject;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

/**
 *
 * @author sandiwibowo
 */
public class ChatDecoder implements Decoder.Text<ChatData> {

    @Override
    public ChatData decode(String arg0) throws DecodeException {
        JsonObject jsonObject = Json.createReader(new StringReader(arg0)).readObject();
        return  new ChatData(jsonObject);
    }

    @Override
    public boolean willDecode(String arg0) {
       try {
            Json.createReader(new StringReader(arg0)).readObject();
            return true;
        } catch (JsonException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public void init(EndpointConfig config) {
        System.out.println("init");//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void destroy() {
        System.out.println("destroy"); //To change body of generated methods, choose Tools | Templates.
    }
    
}

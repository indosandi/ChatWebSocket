/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kmbmicro.chatwebsocket;

import java.io.StringWriter;
import javax.json.Json;
import javax.json.JsonObject;

/**
 *
 * @author sandiwibowo
 */
public class ChatData {
    private JsonObject json;
    public JsonObject getJson() {
        return json;
    }

    public void setJson(JsonObject json) {
        this.json = json;
    }

    public ChatData(JsonObject json) {
        this.json = json;
    }
    public String getUser(){
        return this.json.getString("name");
    }
    public String getChat(){
        return this.json.getString("chat");
    }
    
    @Override
    public String toString() {
        StringWriter writer = new StringWriter();
        Json.createWriter(writer).write(json);
        return writer.toString();
    }
}

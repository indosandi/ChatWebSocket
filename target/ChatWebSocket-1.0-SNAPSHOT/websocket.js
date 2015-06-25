/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var wsUri = "ws://" + document.location.host + document.location.pathname + "chatendpoint";
var websocket = new WebSocket(wsUri);

websocket.onerror = function(evt) { onError(evt) };

function onError(evt) {
    writeToScreen('<span style="color: red;">ERROR:</span> ' + evt.data);
}
// For testing purposes
var output = document.getElementById("output");
var here=document.getElementById("here");
var mytext=document.getElementById("mytext");
console.log(mytext.type);


websocket.onopen = function(evt) { onOpen(evt) };

function writeToScreen(message) {
    output.innerHTML += message + "<br>";
}

function onOpen() {
    writeToScreen("Connected to " + wsUri);
}
// End test functions
websocket.onmessage = function(evt) { onMessage(evt) };

function sendText(json) {
    var json = JSON.stringify({
        "text": mytext.value       
    });
    console.log("sending text: " + json);
    
    websocket.send(json);
}
                
function onMessage(evt) {
    console.log("received: " + evt.data);
//    drawImageText(evt.data);
    var msg=JSON.parse(evt.data)
//    receiver(msg); 
 //   here.innerHTML=msg.text;
}
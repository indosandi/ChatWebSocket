# ChatWebSocket
Chat Application using websocket technology

1. Server
Websocket endpoint run in glassfish server. Server receive JSON (string) data from client. The data is converted into class ChatData
by class ChatDecoder. Afterthat, server send to database (dynamoDB) and send it back to client.

2. WebClient
Written in javascript to handle all chat event. Connect into websocket server then start to transfer all data to server and receive 
data from websocket server.



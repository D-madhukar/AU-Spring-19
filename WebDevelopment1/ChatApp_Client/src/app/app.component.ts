import { Component } from '@angular/core';
import Stomp from 'stompjs';
import SockJS from 'sockjs-client';
import $ from 'jquery';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
  private url = 'http://localhost:8080/server';
  private title = 'WebSockets chat';
  private stompClient;

  constructor(){
    this.initializeWebSocketConnection();
  }

  initializeWebSocketConnection(){
    let server = new SockJS(this.url);
    this.stompClient = Stomp.over(server);
    const let that = this;
    this.stompClient.connect({}, function(frame) {
      that.stompClient.subscribe("/chat", (msg) => {
        if(msg.body) {
          $(".chat").append("<div class='message'>"+msg.body+"</div>")
          console.log(msg.body);
        }
      });
    });
  }

  sendMsg(msg) {
    this.stompClient.send('/app/send/message' , {}, msg);
    $('#input').val('');
  }

}

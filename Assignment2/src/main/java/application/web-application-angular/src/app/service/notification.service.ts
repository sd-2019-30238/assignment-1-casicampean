import {Injectable} from "@angular/core";
import SockJS from "sockjs-client"
import Stomp from "stompjs"

@Injectable()
export class NotificationService {

  // Open connection with the back-end socket
  public connect() {
    let socket = new SockJS(`http://localhost:8080/socket`);

    let stompClient = Stomp.over(socket);

    return stompClient;
  }
}

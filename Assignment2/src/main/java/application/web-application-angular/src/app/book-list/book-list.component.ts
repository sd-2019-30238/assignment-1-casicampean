import { Component, OnInit } from '@angular/core';
import {Book} from "../../models/book";
import {BookService} from "../service/book.service";
import {AccountServiceService} from "../service/account-service.service";
import {AuthenticationService} from "../service/authentication.service";
import {BorrowedService} from "../service/borrowed.service";
import {Borrowed} from "../../models/borrowed";
import {Account} from "../../models/account";
import {NotificationService} from "../service/notification.service";

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css']
})
export class BookListComponent implements OnInit {

  books: Book[];
  borrowed = new Borrowed();
  account = new Account()
  bookId:number;
  public notification = '';


  constructor(private notificationService: NotificationService, private bookService: BookService , private service: AuthenticationService, private borrowedService: BorrowedService) {
    let stompClient = this.notificationService.connect();
    stompClient.connect({}, frame => {

      // Subscribe to notification topic
      stompClient.subscribe('/topic/notification/', notifications => {

        // Update notifications attribute with the recent messsage sent from the server
        this.notification = notifications.body;
      })
    });
  }

  ngOnInit() {
    this.bookService.findAll().subscribe(data =>{
      this.books = data;
    })
    this.getAccount();
  }

  getAccount(){
    this.service.getLoggedAccount().subscribe(account => this.account = account);
  }

  borrow() {
    this.borrowed.bookID = this.bookId;
    this.borrowed.userID = this.account.id;
    this.borrowed.username = this.account.username;

    this.borrowedService.borrowBook(this.borrowed).subscribe();
  }

  delete() {

  }
}

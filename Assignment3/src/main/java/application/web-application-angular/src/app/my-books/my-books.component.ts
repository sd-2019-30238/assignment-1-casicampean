import { Component, OnInit } from '@angular/core';
import {Borrowed} from "../../models/borrowed";
import {BorrowedService} from "../service/borrowed.service";
import {Account} from "../../models/account";
import {AuthenticationService} from "../service/authentication.service";
import {LoginComponent} from "../login/login.component";
import {Book} from "../../models/book";

@Component({
  selector: 'app-my-books',
  templateUrl: './my-books.component.html',
  styleUrls: ['./my-books.component.css']
})
export class MyBooksComponent implements OnInit {

  myBooks: Borrowed[];
  bookId:number;
  account = new Account();
  returnedBook = new Borrowed();

  constructor(private Bservice: BorrowedService, private  service: AuthenticationService) { }

  getMyBooks(){
    this.Bservice.getMyBooks(this.service.account).subscribe(books => this.myBooks = books);
  }

  getAccount(){
    this.service.getLoggedAccount().subscribe(account => this.account = account);
  }

  ngOnInit() {
    this.getAccount();
    this.getMyBooks();
  }

  //returneza cartea---> setez book.counter + 1
  //sterg din Borrowed Books imprumutul
  return() {
    this.returnedBook.bookID = this.bookId;
    this.Bservice.returnBook(this.returnedBook).subscribe();



  }
}

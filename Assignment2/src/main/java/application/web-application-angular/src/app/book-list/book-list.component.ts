import { Component, OnInit } from '@angular/core';
import {Book} from "../../models/book";
import {BookService} from "../service/book.service";
import {AccountServiceService} from "../service/account-service.service";
import {AuthenticationService} from "../service/authentication.service";

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css']
})
export class BookListComponent implements OnInit {

  books: Book[];

  constructor(private bookService: BookService , private service: AuthenticationService) { }

  ngOnInit() {
    this.bookService.findAll().subscribe(data =>{
      this.books = data;
    })
  }

}

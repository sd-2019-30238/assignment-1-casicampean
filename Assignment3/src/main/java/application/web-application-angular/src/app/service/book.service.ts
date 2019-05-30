import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Book} from "../../models/book";

@Injectable({
  providedIn: 'root'
})
export class BookService {

  private bookUrl: string;

  constructor(private http: HttpClient) {
    this.bookUrl = 'http://localhost:8080/books';
  }

  public findAll(): Observable<Book[]>{
    return this.http.get<Book[]>(this.bookUrl);
  }

  public save(book: Book){
    return this.http.post<Book>(this.bookUrl, book);
  }
}

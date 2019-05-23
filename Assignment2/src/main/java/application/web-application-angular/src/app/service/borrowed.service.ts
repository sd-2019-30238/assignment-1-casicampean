import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {Borrowed} from "../../models/borrowed";
import {Account} from "../../models/account";

@Injectable({
  providedIn: 'root'
})
export class BorrowedService {

  private borrowedUrl: string;



  constructor(private http: HttpClient) {
    this.borrowedUrl = 'http://localhost:8080/borrowedBooks';
  }

  public findAll() : Observable<Borrowed[]>{
    return  this.http.get<Borrowed[]>(this.borrowedUrl);
  }

  public getMyBooks(account: Account): Observable<Borrowed[]>{
    const httpOptions = {
      headers: new HttpHeaders({ 'Content-Type': 'application/json' })
    };
    return this.http.post<Borrowed[]>('http://localhost:8080/getBorrowedBooks', account, httpOptions);
  }


  public borrowBook(borrowed: Borrowed): Observable<Borrowed>{
    const httpOptions = {
      headers: new HttpHeaders({ 'Content-Type': 'application/json' })
    };

    return this.http.post<Borrowed>(this.borrowedUrl, borrowed, httpOptions);
  }

  public returnBook(borrowed: Borrowed): Observable<Borrowed>{
    const httpOptions = {
      headers: new HttpHeaders({ 'Content-Type': 'application/json' })
    };

    return this.http.post<Borrowed>('http://localhost:8080/returnBorrowedBook', borrowed, httpOptions);
  }


}

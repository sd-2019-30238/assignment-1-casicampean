import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Borrowed} from "../../models/borrowed";

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

  public save(borrowed: Borrowed){
    return this.http.post<Borrowed>(this.borrowedUrl, borrowed);
  }
}

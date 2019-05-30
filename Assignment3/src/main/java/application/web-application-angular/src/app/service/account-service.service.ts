import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Observable} from "rxjs";
import {Account} from "../../models/account";

@Injectable({
  providedIn: 'root'
})
export class AccountServiceService {

  private accountsUrl: string;


  constructor(private http: HttpClient) {
    this.accountsUrl = 'http://localhost:8080/accounts';
  }

  public findAll() : Observable<Account[]>{
    return  this.http.get<Account[]>(this.accountsUrl);
  }

  public save(account: Account){
    return this.http.post<Account>(this.accountsUrl, account);
  }
}

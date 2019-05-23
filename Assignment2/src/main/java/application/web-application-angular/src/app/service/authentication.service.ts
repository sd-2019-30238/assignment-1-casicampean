import { Injectable } from '@angular/core';
import {CanActivate} from "@angular/router";
import {Account} from "../../models/account";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService{

  private loginURL = 'http://localhost:8080/login';
  account = new Account();
  staff = false;




  constructor(private http:HttpClient) { }

  validCredentials(username: string, password: string) {

    this.account.username = username;
    this.account.password = password;

    const jsonHeaders = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    };
    return this.http.post(this.loginURL, this.account, jsonHeaders);
  }

  authenticate(valid: number, username: string) {
    if (valid === 1) {//daca account este de tip staff
      sessionStorage.setItem('username', username)
      this.staff = true;

      return true;
    } else if (valid === 2){//daca account este de tip user
      sessionStorage.setItem('username', username)
      this.staff = false;

      return true;
    } else {
      return false;
    }
  }

  isStaff(){
    return this.staff;
  }

  getLoggedUser (): Observable<Account> {
    const httpOptions = {
      headers: new HttpHeaders({ 'Content-Type': 'application/json' })
    };

    return this.http.post<Account>('http://localhost:8080/getAccount', this.account, httpOptions);
  }

  isUserLoggedIn(){
    let user = sessionStorage.getItem('username')
    console.log(!(user === null))
    return !(user === null)
  }

  logOut(){
    sessionStorage.removeItem('username')
  }
}

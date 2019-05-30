import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {AuthenticationService} from "../service/authentication.service";
import {Account} from "../../models/account";
import {BorrowedService} from "../service/borrowed.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username = ''
  password = ''
  invalidLogin = false
  account = new Account();

  constructor(private router: Router, private loginService: AuthenticationService, private  borrowedService: BorrowedService) { }

  ngOnInit(){
  }

  getLoggedAccount(): void {
    this.loginService.getLoggedAccount()
      .subscribe(account => {
        this.account = account;
      });
  }

  checkLogin() {

    this.account.username = this.username;
    this.account.password = this.password;

    this.loginService.validCredentials(this.username, this.password).subscribe(res => {
      this.router.navigate([''])
      this.loginService.authenticate(res as number, this.username);

    });
  }
  register(){
    this.router.navigate(['addAccount']);
  }


}

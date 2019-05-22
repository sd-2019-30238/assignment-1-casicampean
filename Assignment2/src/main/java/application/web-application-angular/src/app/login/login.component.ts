import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {AuthenticationService} from "../authentication.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username = 'casi'
  password = 'casi'
  invalidLogin = false

  constructor(private router: Router, private loginService: AuthenticationService) { }

  ngOnInit(){
  }

  login(x){
    console.log("Login from value", x);
    //this.router.navigate(['/users']);
  }

  checkLogin(){
    if(this.loginService.authenticate(this.username, this.password)){
      this.router.navigate(['menu'])
      this.invalidLogin = false
    }else{
      this.invalidLogin = true
    }
  }

}

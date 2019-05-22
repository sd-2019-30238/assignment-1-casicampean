import { Component, OnInit } from '@angular/core';
import {Account} from "../../account/account";
import {ActivatedRoute, Router} from "@angular/router";
import {AccountServiceService} from "../../account/account-service.service";

@Component({
  selector: 'app-account-form',
  templateUrl: './account-form.component.html',
  styleUrls: ['./account-form.component.css']
})
export class AccountFormComponent   {

  account: Account;

  constructor(private route: ActivatedRoute, private router: Router, private accountService: AccountServiceService) {
    this.account = new Account();
  }

  onSubmit(){
    this.accountService.save(this.account).subscribe(result => this.goToAccountList());
  }

  goToAccountList(){
    this.router.navigate(['/accounts']);
  }


}

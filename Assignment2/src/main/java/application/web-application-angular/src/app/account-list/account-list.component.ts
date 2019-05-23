import { Component, OnInit } from '@angular/core';
import {AccountServiceService} from "../service/account-service.service";
import {Account} from "../../models/account";
import {AuthenticationService} from "../service/authentication.service";

@Component({
  selector: 'app-account-list',
  templateUrl: './account-list.component.html',
  styleUrls: ['./account-list.component.css']
})
export class AccountListComponent implements OnInit {

  accounts: Account[];

  constructor(private accountService: AccountServiceService) { }

  ngOnInit() {
    this.accountService.findAll().subscribe(data => {
      this.accounts = data;
    })
  }

}

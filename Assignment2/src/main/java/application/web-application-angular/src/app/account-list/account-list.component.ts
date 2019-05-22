import { Component, OnInit } from '@angular/core';
import {AccountServiceService} from "../../account/account-service.service";
import {Account} from "../../account/account";

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

import { Component, OnInit } from '@angular/core';
import {Borrowed} from "../../borrowed/borrowed";
import {BorrowedService} from "../../borrowed/borrowed.service";

@Component({
  selector: 'app-borrowed-list',
  templateUrl: './borrowed-list.component.html',
  styleUrls: ['./borrowed-list.component.css']
})
export class BorrowedListComponent implements OnInit {

  borrowed_books: Borrowed[];

  constructor(private borrowedService: BorrowedService) { }

  ngOnInit() {
    this.borrowedService.findAll().subscribe(data =>{
      this.borrowed_books = data;
    })
  }

}

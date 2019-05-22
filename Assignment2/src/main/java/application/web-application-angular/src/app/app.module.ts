import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AccountListComponent } from './account-list/account-list.component';
import { AccountFormComponent } from './account-form/account-form.component';
import {FormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import {AccountServiceService} from "../account/account-service.service";
import { BookListComponent } from './book-list/book-list.component';
import { BorrowedListComponent } from './borrowed-list/borrowed-list.component';
import { BookFormComponent } from './book-form/book-form.component';
import {BookService} from "../book/book.service";
import {BorrowedService} from "../borrowed/borrowed.service";

@NgModule({
  declarations: [
    AppComponent,
    AccountListComponent,
    AccountFormComponent,
    BookListComponent,
    BorrowedListComponent,
    BookFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [AccountServiceService, BookService, BorrowedService],
  bootstrap: [AppComponent]
})
export class AppModule { }

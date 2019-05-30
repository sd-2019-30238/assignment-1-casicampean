import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AccountListComponent } from './account-list/account-list.component';
import { AccountFormComponent } from './account-form/account-form.component';
import {FormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import {AccountServiceService} from "./service/account-service.service";
import { BookListComponent } from './book-list/book-list.component';
import { BorrowedListComponent } from './borrowed-list/borrowed-list.component';
import { BookFormComponent } from './book-form/book-form.component';
import {BookService} from "./service/book.service";
import {BorrowedService} from "./service/borrowed.service";
import { LoginComponent } from './login/login.component';
import { MenuComponent } from './menu/menu.component';
import {AuthenticationService} from "./service/authentication.service";
import { LogoutComponent } from './logout/logout.component';
import { MyBooksComponent } from './my-books/my-books.component';

@NgModule({
  declarations: [
    AppComponent,
    AccountListComponent,
    AccountFormComponent,
    BookListComponent,
    BorrowedListComponent,
    BookFormComponent,
    LoginComponent,
    MenuComponent,
    LogoutComponent,
    MyBooksComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [AccountServiceService, BookService, BorrowedService, AuthenticationService],
  bootstrap: [AppComponent]
})
export class AppModule { }

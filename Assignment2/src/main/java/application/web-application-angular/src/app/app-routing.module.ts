import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {AccountListComponent} from "./account-list/account-list.component";
import {AccountFormComponent} from "./account-form/account-form.component";
import {BookListComponent} from "./book-list/book-list.component";
import {BookFormComponent} from "./book-form/book-form.component";
import {BorrowedListComponent} from "./borrowed-list/borrowed-list.component";
import {LoginComponent} from "./login/login.component";
import {MenuComponent} from "./menu/menu.component";
import {LogoutComponent} from "./logout/logout.component";
import {AuthGuardService} from "./service/auth-guard.service";

const routes: Routes = [
  {
    path:'', redirectTo: '/login', pathMatch:'full'},
  {path: 'login', component: LoginComponent},
  {path: 'logout', component: LogoutComponent, canActivate:[AuthGuardService]},
  {path: 'menu', component: MenuComponent, canActivate:[AuthGuardService]},
  {path: 'accounts', component: AccountListComponent, canActivate:[AuthGuardService]},
  {path: 'addAccount', component: AccountFormComponent, canActivate:[AuthGuardService]},
  {path: 'books', component: BookListComponent, canActivate:[AuthGuardService]},
  {path: 'addBook', component: BookFormComponent, canActivate:[AuthGuardService]},
  {path: 'borrowedBooks', component: BorrowedListComponent, canActivate:[AuthGuardService]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UsersService } from '../users.service';
import { OrdersService } from '../orders.service';
import { Orders } from './../orders';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css'],
})
export class UserComponent implements OnInit {
  constructor(
    private usersService: UsersService,
    private router: Router,
    private ordersService: OrdersService
  ) {}
  msg: String = '';
  id: any;
  key: string = 'Name';
  myItem: any = '';

  key2: string = 'Email';
  myItem2: any = '';

  ngOnInit(): void {}
  public login(email: string, password: String): void {
    localStorage.setItem(this.key2, email);
    this.myItem2 = localStorage.getItem(this.key2);
    this.usersService.login(email, password).subscribe(
      (data) => {
        this.storeName(data);
        console.log(data);
        this.msg = data;
        if (this.msg == 'Incorrect credentials..') {
          alert(this.msg);
        } else {
          if (this.myItem != 1) {
            this.router.navigate(['/search']);
          } else {
            this.router.navigate(['/movies']);
          }
        }
      },
      (error) => {
        console.log(error);
      }
    );
  }
  storeName(data: string) {
    localStorage.setItem(this.key, data);
    this.myItem = localStorage.getItem(this.key);
  }

  public signup(email: String, password: String, full_name: String): void {
    this.usersService.signup(email, password, full_name).subscribe(
      (data) => {
        alert('registered ' + full_name);
      },
      (error) => {
        console.log(error);
        console.log('failed');
      }
    );
  }
}

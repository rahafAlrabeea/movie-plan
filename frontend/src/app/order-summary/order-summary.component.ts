import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { OrdersService } from '../orders.service';

@Component({
  selector: 'app-order-summary',
  templateUrl: './order-summary.component.html',
  styleUrls: ['./order-summary.component.css'],
})
export class OrderSummaryComponent implements OnInit {
  email: any;
  key: string = 'Email';
  msg: String = '';
  public summary: any = [];
  constructor(private ordersService: OrdersService, private router: Router) {
    this.view();
  }

  ngOnInit(): void {}
  view() {
    this.email = localStorage.getItem(this.key);

    this.ordersService.viewSummary(this.email).subscribe(
      (data) => {
        this.summary.push(data);
        if (this.summary !== null) {
          this.summary = data;
        } else {
          alert('Sorry something went wrong!!');
        }
      },
      (error) => {
        console.log(error);
      }
    );
  }
  backToMainPage() {
    this.router.navigate(['/search']);
  }
}

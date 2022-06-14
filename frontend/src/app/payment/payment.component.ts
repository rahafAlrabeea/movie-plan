import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { OrdersService } from '../orders.service';
import { OrderSummary } from './../order-summary';
import { OrderSummaryComponent } from './../order-summary/order-summary.component';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css'],
})
export class PaymentComponent implements OnInit {
  msg: String = '';
  constructor(
    private ordersService: OrdersService,
    private router: Router,
    private OrderSummary: OrderSummaryComponent
  ) {}

  ngOnInit(): void {}

  pay(cNumber: String, edate: String, pin: String): void {
    this.ordersService.pay(cNumber, edate, pin).subscribe(
      (data) => {
        this.msg = data;
        if (this.msg == 'paid successfully..') {
          this.router.navigate(['/order-summary']);
        } else {
          alert(this.msg);
        }
      },
      (error) => {
        console.log('hooo');
        console.log(error);
      }
    );
  }
}

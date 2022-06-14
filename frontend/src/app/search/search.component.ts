import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NEVER } from 'rxjs';
import { Movies } from '../movies';
import { MoviesService } from './../movies.service';
import { Orders } from './../orders';
import { OrdersService } from './../orders.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css'],
})
export class SearchComponent implements OnInit {
  public movie: any = [];
  msg: String = '';
  id: any;
  key: string = 'Name';
  constructor(
    private moviesService: MoviesService,
    private ordersService: OrdersService,
    private router: Router
  ) {}

  ngOnInit(): void {}
  public searchProducts(product_name: String, filter: String): void {
    console.log(product_name);

    if (filter != '') {
      this.sortOutput(filter);
    } else {
      this.moviesService.searchProduct(product_name).subscribe(
        (data) => {
          this.movie = data;
          //this.movie.push(data);
          console.log(this.movie);
        },
        (error) => {
          console.log(error);
        }
      );
    }
  }
  public sortOutput(filter: String) {
    this.moviesService.filterSearch(filter).subscribe(
      (data) => {
        (this.movie = data),
          //this.movie.push(data);
          console.log(this.movie);
      },
      (error) => {
        console.log(error);
      }
    );
  }
  public addOrder(date: String, movie_id: number, quantity: number) {
    this.id = localStorage.getItem(this.key);
    this.ordersService.addOrder(this.id, date, movie_id, quantity).subscribe(
      (data) => {
        this.msg = data;
        if (this.msg == 'Order has been created') {
          this.router.navigate(['/payment']);
        } else {
          alert(this.msg);
        }
      },
      (error) => {
        console.log(error);
      }
    );
  }
}

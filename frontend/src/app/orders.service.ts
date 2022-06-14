import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { text } from 'express';
import { Observable } from 'rxjs';
import { Users } from './users';
import { OrderSummary } from './order-summary';

@Injectable({
  providedIn: 'root',
})
export class OrdersService {
  private baseUrl = 'http://localhost:8080/orders';

  constructor(private http: HttpClient) {}
  addOrder(
    user_id: number,
    date: String,
    movie_id: number,
    quantity: number
  ): Observable<any> {
    console.log(user_id, date, movie_id, quantity);
    return this.http.post(
      `${this.baseUrl}/add`,
      {
        date: date,
        user_id: user_id,
        movie_id: movie_id,
        quantity: quantity,
      },
      { responseType: 'text' }
    );
  }
  pay(
    card_number: String,
    expiration_date: String,
    pin: String
  ): Observable<any> {
    console.log(card_number, expiration_date, pin);
    return this.http.get(
      `${this.baseUrl}/pay?card_number=${card_number}&expiration_date=${expiration_date}&pin=${pin}`,
      { responseType: 'text' }
    );
  }
  viewSummary(email: String): Observable<OrderSummary> {
    return this.http.get<OrderSummary>(`${this.baseUrl}/view/${email}`);
  }
}

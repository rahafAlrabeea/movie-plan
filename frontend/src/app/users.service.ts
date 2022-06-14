import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Users } from './users';

@Injectable({
  providedIn: 'root',
})
export class UsersService {
  private baseUrl = 'http://localhost:8080/users';
  constructor(private http: HttpClient) {}
  login(email: String, password: String): Observable<any> {
    return this.http.post(
      `${this.baseUrl}/signin`,
      {
        email: email,
        password: password,
      },
      { responseType: 'text' }
    );
  }
  signup(email: String, password: String, full_name: String): Observable<any> {
    console.log(`${this.baseUrl}/signin`, {
      email: email,
      password: password,
      full_name: full_name,
    });
    return this.http.post<any>(`${this.baseUrl}/signup`, {
      email: email,
      password: password,
      full_name: full_name,
    });
  }
}

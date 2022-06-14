import { HttpClient } from '@angular/common/http';
import { identifierName } from '@angular/compiler';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Movies } from './movies';

@Injectable({
  providedIn: 'root',
})
export class MoviesService {
  private baseUrl = 'http://localhost:8080/movies';
  constructor(private http: HttpClient) {}
  searchProduct(name: String): Observable<Movies> {
    return this.http.get<Movies>(`${this.baseUrl}/search/?keyword=${name}`);
  }
  filterSearch(filter: String): Observable<Movies> {
    if (filter == 'genre') {
      console.log('genre');
      return this.http.get<Movies>(`${this.baseUrl}/sort/genre`);
    } else if (filter == 'ratings') {
      console.log('ratings');
      return this.http.get<Movies>(`${this.baseUrl}/sort/ratings`);
    } else {
      console.log('price');
      return this.http.get<Movies>(`${this.baseUrl}/sort/price`);
    }
  }
  addGenre(genre_id: number, genre: String): Observable<any> {
    return this.http.post(
      `${this.baseUrl}/add`,
      {
        genre_id: genre_id,
        genre: genre,
      },
      { responseType: 'text' }
    );
  }
  deleteGenre(genre_id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/delete/${genre_id}`, {
      responseType: 'text',
    });
  }
  editMovie(
    movie_id: number,
    name: String,
    description: String,
    language: String,
    timings: String,
    ratings: number,
    genre: number,
    ticket_price: String
  ): Observable<any> {
    console.log({
      movie_id: movie_id,
      name: name,
      ticket_price: ticket_price,
      language: language,
      description: description,
      genre: genre,
      ratings: ratings,
      timings: timings,
    });
    return this.http.patch(
      `${this.baseUrl}/update/movie/${movie_id}`,
      {
        movie_id: movie_id,
        name: name,
        ticket_price: ticket_price,
        language: language,
        description: description,
        genre: genre,
        ratings: ratings,
        timings: timings,
      },
      {
        responseType: 'text',
      }
    );
  }

  getMoviesList(): Observable<Movies[]> {
    return this.http.get<Movies[]>(`${this.baseUrl}/view`);
  }
  getMovieById(id: number): Observable<Movies> {
    console.log(`${this.baseUrl}/${id}`);
    return this.http.get<Movies>(`${this.baseUrl}/${id}`);
  }
}

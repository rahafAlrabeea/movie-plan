import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Movies } from '../movies';
import { MoviesService } from './../movies.service';
import { Router } from '@angular/router';
import { EditMovieComponent } from './../edit-movie/edit-movie.component';

@Component({
  selector: 'app-movie',
  templateUrl: './movie.component.html',
  styleUrls: ['./movie.component.css'],
})
export class MovieComponent implements OnInit {
  public movies: Movies[] = [];
  public movie: any = [];
  public movi: any = [];
  msg: String = '';
  key3: string = 'movieId';
  myItem3: any = '';
  constructor(private movieService: MoviesService, private router: Router) {}

  ngOnInit(): void {
    this.getMovies();
  }
  public editMovie(
    movie_id: number,
    name: String,
    description: String,
    language: String,
    timings: String,
    ratings: number,
    genre: number,
    ticket_price: String
  ): void {
    this.movieService
      .editMovie(
        movie_id,
        name,
        description,
        language,
        timings,
        ratings,
        genre,
        ticket_price
      )
      .subscribe(
        (data) => {
          this.msg = data;
          if (this.msg == 'Movie has been changed..') {
            alert(this.msg);
          } else {
            alert(this.msg);
          }
        },
        (error) => {
          console.log(error);
        }
      );
  }
  public getMovies(): void {
    this.movieService.getMoviesList().subscribe(
      (response: Movies[]) => {
        this.movies = response;
        console.log(this.movies);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
  public sendToEditPage(movie_id: number): void {
    localStorage.setItem(this.key3, movie_id.toString());
    this.myItem3 = localStorage.getItem(this.key3);
    this.movieService.getMovieById(movie_id).subscribe(
      (data) => {
        this.movi = data;
        this.router.navigate(['/edit-movie']);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
  redirectToAddGenrePage() {
    this.router.navigate(['/addGenre']);
  }
}

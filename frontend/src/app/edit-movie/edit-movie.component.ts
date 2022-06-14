import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MoviesService } from '../movies.service';

@Component({
  selector: 'app-edit-movie',
  templateUrl: './edit-movie.component.html',
  styleUrls: ['./edit-movie.component.css'],
})
export class EditMovieComponent implements OnInit {
  public mov: any = [];
  msg: String = '';

  constructor(private movieService: MoviesService, private router: Router) {}

  ngOnInit(): void {}
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
          this.mov = data;
          console.log(this.mov);
          if (this.msg == 'Movie has been changed..') {
            this.router.navigate(['/movies']);
            alert(this.msg);
          } else {
            alert('Sorry something went wrong');
          }
        },
        (error) => {
          console.log(error);
        }
      );
  }
}

import { Component, OnInit } from '@angular/core';
import { MoviesService } from '../movies.service';

@Component({
  selector: 'app-genres',
  templateUrl: './genres.component.html',
  styleUrls: ['./genres.component.css'],
})
export class GenresComponent implements OnInit {
  constructor(private movieServices: MoviesService) {}
  msg: String = '';
  ngOnInit(): void {}
  public addGenre(id: number, genre: String): void {
    this.movieServices.addGenre(id, genre).subscribe(
      (data) => {
        console.log(data);
        this.msg = data;
        if (this.msg == 'Genre has been created') {
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
  public deleteGenre(id: number): void {
    this.movieServices.deleteGenre(id).subscribe(
      (data) => {
        console.log(data);
        this.msg = data;
        if (this.msg == 'Genre has been deleted..') {
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
}

import { NgModule, DoBootstrap } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { SearchComponent } from './search/search.component';
import { UserComponent } from './user/user.component';
import { GenresComponent } from './genres/genres.component';
import { PaymentComponent } from './payment/payment.component';
import { MovieComponent } from './movie/movie.component';
import { EditMovieComponent } from './edit-movie/edit-movie.component';
import { OrderSummaryComponent } from './order-summary/order-summary.component';

@NgModule({
  declarations: [
    AppComponent,
    SearchComponent,
    UserComponent,
    GenresComponent,
    PaymentComponent,
    MovieComponent,
    EditMovieComponent,
    OrderSummaryComponent,
  ],
  imports: [BrowserModule, AppRoutingModule, HttpClientModule, FormsModule],
  providers: [UserComponent, OrderSummaryComponent],
  bootstrap: [AppComponent],
})
export class AppModule {}

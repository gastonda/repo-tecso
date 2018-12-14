import { BrowserModule } from '@angular/platform-browser';
import { NgModule , NO_ERRORS_SCHEMA  } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MDBBootstrapModule } from 'angular-bootstrap-md';
import {HttpClientModule, HttpParams} from '@angular/common/http';


//RUTAS
import { APP_ROUTING } from "./app.routes";


//SERVICIOS
import { CurrentAccountService } from './services/currentAccount.service';
import { MovementsService } from './services/movements.service';

//COMPONENTES
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { MovementsComponent } from './components/movements/movements.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    MovementsComponent
  ],
  imports: [
    BrowserModule,
    MDBBootstrapModule.forRoot(),
    APP_ROUTING,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [
    CurrentAccountService,
    MovementsService
  ],
  bootstrap: [AppComponent],
  schemas : [NO_ERRORS_SCHEMA] 
})
export class AppModule { }

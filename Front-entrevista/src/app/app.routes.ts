import { RouterModule, Routes } from "@angular/router" ;
import { HomeComponent } from "./components/home/home.component";
import { MovementsComponent } from "./components/movements/movements.component";

const APP_ROUTES : Routes = [
  {path : 'home' , component: HomeComponent },
  {path : 'movements' , component: MovementsComponent },
  {path : '**' , pathMatch: 'full' , redirectTo: 'home' }
];

export const APP_ROUTING = RouterModule.forRoot(APP_ROUTES);

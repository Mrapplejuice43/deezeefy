import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { Musique } from './model';
import { HomeComponent } from './home/home.component';
import { MusiqueComponent } from './musique/musique.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { RechercheComponent } from './recherche/recherche.component';

const routes: Routes = [
  {path: "home", component: HomeComponent},
  {path: "musique", component: MusiqueComponent},
  {path: "recherche", component: RechercheComponent},
  {path: "", redirectTo: "home", pathMatch: 'full'},
  {path: "**", component: PageNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

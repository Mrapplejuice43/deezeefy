import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { RechercheComponent } from './recherche/recherche.component';

const routes: Routes = [
  {path: "home", component: HomeComponent},
  {path: "", redirectTo: "home", pathMatch: 'full'},
  {path: "**", component: PageNotFoundComponent},
  {path: "recherche", component: RechercheComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { ArtistComponent } from './artist/artist.component';
import { AdminComponent } from './admin/admin.component';
import { UtilisateurComponent } from './utilisateur/utilisateur.component';
import { MusiqueComponent } from './musique/musique.component';
import { PodcastComponent } from './podcast/podcast.component';
import { PlaylistComponent } from './playlist/playlist.component';
import { SeConnecterComponent } from './se-connecter/se-connecter.component';


const routes: Routes = [
  {path: "home", component: HomeComponent},
  {path:"artiste",component:ArtistComponent},
  {path:"admin",component:AdminComponent},
  {path:"utilisateur",component:UtilisateurComponent},
  {path:"musique",component:MusiqueComponent},
  {path:"podcast",component:PodcastComponent},
  {path:"playlist",component:PlaylistComponent},
  {path:"connection",component:SeConnecterComponent},
  

  // Toujours en dernier 
  {path: "", redirectTo: "home", pathMatch: 'full'},
  {path: "**", component: PageNotFoundComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { Musique } from './model';
import { HomeComponent } from './home/home.component';
import { LectureMusiqueComponent } from './lecture-musique/lecture-musique.component';
import { MusiqueComponent } from './musique/musique.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { ArtistComponent } from './artist/artist.component';
import { AdminComponent } from './admin/admin.component';
import { UtilisateurComponent } from './utilisateur/utilisateur.component';
import { PodcastComponent } from './podcast/podcast.component';
import { PlaylistComponent } from './playlist/playlist.component';
import { SeConnecterComponent } from './se-connecter/se-connecter.component';
import { RechercheComponent } from './recherche/recherche.component';
import { CompteComponent } from './compte/compte.component';
import { EnregistrementMusiqueComponent } from './enregistrement-musique/enregistrement-musique.component';
import { CreationCompteComponent } from './creation-compte/creation-compte.component';


const routes: Routes = [
  {path: "home", component: HomeComponent},
  {path:"artiste",component:ArtistComponent},
  {path:"admin",component:AdminComponent},
  {path:"utilisateur",component:UtilisateurComponent},
  {path:"musique",component:MusiqueComponent},
  {path:"podcast",component:PodcastComponent},
  {path:"playlist",component:PlaylistComponent},
  {path:"connexion",component:SeConnecterComponent},
  {path:"compte",component:CompteComponent},
  {path:"creationCompte",component:CreationCompteComponent},


  // Toujours en dernier
  {path: "recherche", component: RechercheComponent},
  {path: "enregistrement-musique", component: EnregistrementMusiqueComponent},
  {path: "", redirectTo: "home", pathMatch: 'full'},
  {path: "**", component: PageNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

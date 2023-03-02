import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http'
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { HomeComponent } from './home/home.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { LectureMusiqueComponent } from './lecture-musique/lecture-musique.component';
import { ArtistComponent } from './artist/artist.component';
import { AdminComponent } from './admin/admin.component';
import { UtilisateurComponent } from './utilisateur/utilisateur.component';
import { PodcastComponent } from './podcast/podcast.component';
import { PlaylistComponent } from './playlist/playlist.component';
import { SeConnecterComponent } from './se-connecter/se-connecter.component';
import { RechercheComponent } from './recherche/recherche.component';
import { MusiqueComponent } from './musique/musique.component';
import { EnregistrementMusiqueComponent } from './enregistrement-musique/enregistrement-musique.component';
import { CompteComponent } from './compte/compte.component';
import { CreationCompteComponent } from './creation-compte/creation-compte.component';
import { InfosAdminComponent } from './compte/infos-admin/infos-admin.component';
import { InfosUtilisateurComponent } from './compte/infos-utilisateur/infos-utilisateur.component';
import { InfosArtisteComponent } from './compte/infos-artiste/infos-artiste.component';
import { HistoriqueCompteComponent } from './compte/historique-compte/historique-compte.component';
import { CarouselComponent } from './home/carousel/carousel.component';
import { CardsComponent } from './home/cards/cards.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    HomeComponent,
    PageNotFoundComponent,
    ArtistComponent,
    AdminComponent,
    UtilisateurComponent,
    MusiqueComponent,
    PodcastComponent,
    PlaylistComponent,
    SeConnecterComponent,
    RechercheComponent,
    LectureMusiqueComponent,
    CompteComponent,
    EnregistrementMusiqueComponent,
    CreationCompteComponent,
    InfosAdminComponent,
    InfosUtilisateurComponent,
    InfosArtisteComponent,
    HistoriqueCompteComponent,
    CarouselComponent,
    CardsComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

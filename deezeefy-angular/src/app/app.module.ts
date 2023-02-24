import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http'
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { HomeComponent } from './home/home.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { ArtistComponent } from './artist/artist.component';
import { AdminComponent } from './admin/admin.component';
import { UtilisateurComponent } from './utilisateur/utilisateur.component';
import { MusiqueComponent } from './musique/musique.component';
import { PodcastComponent } from './podcast/podcast.component';
import { PlaylistComponent } from './playlist/playlist.component';
import { SeConnecterComponent } from './se-connecter/se-connecter.component';

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
    SeConnecterComponent
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

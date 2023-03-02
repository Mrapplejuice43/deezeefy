import { Injectable } from '@angular/core';
import { ArtistHttpService } from '../artist/artist-http.service';
import { Artiste, Utilisateur } from '../model';
import { UtilisateurHttpService } from '../utilisateur/utilisateur-http.service';

@Injectable({
  providedIn: 'root'
})
export class CreationCompteHttpService {
  constructor(
    private artistHttpService: ArtistHttpService,
    private utilisateurHttpService: UtilisateurHttpService,
    ) { }

  creationUser(formUser: Utilisateur) {
    this.utilisateurHttpService.insert(formUser)
  }
  creationArtiste(formArtiste: Artiste) {
    this.artistHttpService.insert(formArtiste)
  }
}

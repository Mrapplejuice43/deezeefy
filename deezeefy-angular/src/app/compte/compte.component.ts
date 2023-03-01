import { Component } from '@angular/core';
import { ArtistHttpService } from '../artist/artist-http.service';
import { Artiste, Compte, Utilisateur } from '../model';

@Component({
  selector: 'app-compte,[app-artist],[app-utilisateur]',
  templateUrl: './compte.component.html',
  styleUrls: ['./compte.component.scss']
})
export class CompteComponent {

  type: string;
  
formArtiste: Artiste = null;
formUser: Utilisateur = null;


  constructor(private artistHttpService:ArtistHttpService){
  
  }

 
add() {
  this.artistHttpService.insert(this.formArtiste);
  }
}

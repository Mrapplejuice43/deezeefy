import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ArtistHttpService } from '../artist/artist-http.service';
import { Artiste, Compte, Utilisateur } from '../model';
import { UtilisateurHttpService } from '../utilisateur/utilisateur-http.service';


@Component({
  selector: 'app-creation-compte',
  templateUrl: './creation-compte.component.html',
  styleUrls: ['./creation-compte.component.scss']
})
export class CreationCompteComponent {
  type: string;
  
formArtiste: Artiste = new Artiste();
formUser: Utilisateur= new Utilisateur();

constructor(private artistHttpService:ArtistHttpService, private utilisateurHttpService: UtilisateurHttpService, private router:Router){
  
}


addArtiste() {
this.artistHttpService.insert(this.formArtiste);
this.router.navigate(["/connection"]);
}

cancelArtiste () {
this.formArtiste=undefined;
this.type=null;
}

addUser() {
  this.utilisateurHttpService.insert(this.formUser);
  this.router.navigate(["/connection"]);
  }

cancelUser () {
    this.formUser=undefined;
    this.type=null;
  }
}

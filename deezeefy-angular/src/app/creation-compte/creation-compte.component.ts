import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Artiste, Utilisateur } from '../model';
import { CreationCompteHttpService } from './creation-compte-http.service';


@Component({
  selector: 'app-creation-compte',
  templateUrl: './creation-compte.component.html',
  styleUrls: ['./creation-compte.component.scss']
})
export class CreationCompteComponent {
  type: string = "";

  formArtiste: Artiste = new Artiste();
  formUser: Utilisateur= new Utilisateur();

constructor(
  private creationCompteService: CreationCompteHttpService,
  private router:Router
  ) {}

onSelectChange() {
  if(this.type == "artiste") {
    this.formArtiste = new Artiste();
  } else if (this.type == "user") {
    this.formUser = new Utilisateur()
    this.formUser.abonnement = "";
  } else {
    this.formArtiste = undefined
    this.formUser = undefined
  }
}

addArtiste() {
  this.formArtiste.type = this.type
  this.creationCompteService.creationArtiste(this.formArtiste);
  this.router.navigate(["/connexion"]);
}

cancelArtiste () {
  this.formArtiste=undefined;
  this.type="";
}

addUser() {
  this.formUser.type = this.type
  this.creationCompteService.creationUser(this.formUser);
  this.router.navigate(["/connexion"]);
}

cancelUser () {
    this.formUser=undefined;
    this.type="";
  }
}

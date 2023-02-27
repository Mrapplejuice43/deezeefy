import { Component } from '@angular/core';
import { Artiste, Compte, Utilisateur } from '../model';

@Component({
  selector: 'app-compte,[app-artist],[app-utilisateur]',
  templateUrl: './compte.component.html',
  styleUrls: ['./compte.component.scss']
})
export class CompteComponent {

  type: string;
  
formArtist: Artiste = null;
formUser: Utilisateur = null;


  constructor(){
  
  }

  categorise(){
    if(this.type == "artiste"){
      this.formArtist = new Artiste();

    }else if(this.type == "user"){
      this.formUser = new Utilisateur();
    }

    
  }

}

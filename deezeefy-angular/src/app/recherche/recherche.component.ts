import { Component } from '@angular/core';

@Component({
  selector: 'app-recherche',
  templateUrl: './recherche.component.html',
  styleUrls: ['./recherche.component.scss']
})
export class RechercheComponent {

  recherche: string;

  constructor(){}

  /*search(): Array<Musique> {
    if(this.recherche) {
      return this.musiqueService.findAllByTitre(this.recherche);
    } 

    return this.musiqueService.findAll();
  }*/

}
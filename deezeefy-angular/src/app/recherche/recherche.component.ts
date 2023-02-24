import { Component } from '@angular/core';
import { Musique } from '../model';
import { RechercheService } from './recherche.service';

@Component({
  selector: 'app-recherche',
  templateUrl: './recherche.component.html',
  styleUrls: ['./recherche.component.scss']
})
export class RechercheComponent {

  titre: string="";

  constructor(private rServ: RechercheService){}

  search() :Array<Musique> {
    if(this.titre){
      return this.rServ.findAllByTitre(this.titre);}
    return null;
  }

}

import { Component, Inject } from '@angular/core';
import { Musique } from '../model';
import { RechercheService } from './recherche.service';

@Component({
  selector: 'app-recherche',
  templateUrl: './recherche.component.html',
  styleUrls: ['./recherche.component.scss']
})
export class RechercheComponent {

  titre: string="";
  auteur: string="";
  genre: string="";

  selection: Array<Musique> = new Array<Musique>();

  constructor(private rServ : RechercheService){}


validerT(){
  this.rServ.findAllByTitre(this.titre).subscribe(resp => { this.selection = resp;})
}

validerA(){
  this.rServ.findAllByAuteur(this.auteur).subscribe(resp => { this.selection = resp;})
}

validerG(){
  this.rServ.findAllByGenre(this.genre).subscribe(resp => { this.selection = resp;})
}
}

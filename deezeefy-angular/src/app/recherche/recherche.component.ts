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

  

  selection: Array<Musique> = new Array<Musique>();

  constructor(private rServ : RechercheService){}


valider(){
  this.rServ.findAllByTitre(this.titre).subscribe(resp => { this.selection = resp;})
}
}

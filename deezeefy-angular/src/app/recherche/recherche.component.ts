import { Component, Inject } from '@angular/core';
import { ContenuPlaylist, Musique, Playlist } from '../model';
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

//Partie ajoutter à une playliste

playlist: Array<Musique> = new Array<Musique>();


select(id: number){
  this.rServ.findById(id).subscribe(resp =>{
    let m: Musique = resp;
    this.playlist.push(m);
    console.log(this.playlist)
  })
}

add(){
  for (let m of this.playlist) {
    let cp : ContenuPlaylist = new ContenuPlaylist();
    cp.contenuAssocie = m;
    console.log("test1")
    this.rServ.createCP(cp);
    console.log(cp)
}
}
}

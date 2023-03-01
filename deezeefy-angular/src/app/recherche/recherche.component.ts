import { Component, EventEmitter, Inject, Input, Output } from '@angular/core';
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
@Input("playlist")
playlist: Playlist;


listMus: Array<Musique> = new Array<Musique>();

@Output() newItemEvent = new EventEmitter<Array<Musique>>();

select(id: number){
  this.rServ.findById(id).subscribe(resp =>{
    let m: Musique = resp;
    this.listMus.push(m);
    console.log(this.listMus)
  })
}

add(){
  for (let m of this.listMus) {
    let cp : ContenuPlaylist = new ContenuPlaylist();
    cp.contenuAssocie = m;
    cp.playlistAssociee= this.playlist ;
    this.rServ.createCP(cp);
}
this.newItemEvent.emit(this.listMus);
this.listMus= new Array<Musique>();
}
}

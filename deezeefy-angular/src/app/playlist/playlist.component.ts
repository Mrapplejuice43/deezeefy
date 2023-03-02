import { DatePipe } from '@angular/common';
import { Component } from '@angular/core';
import { Observable } from 'rxjs';
import { Contenu, ContenuPlaylist, Musique } from '../model';
import { Playlist } from '../model';
import { PlaylistService } from './playlist.service';

@Component({
  selector: 'app-playlist',
  templateUrl: './playlist.component.html',
  styleUrls: ['./playlist.component.scss']
})
export class PlaylistComponent {

  formPlaylist: Playlist;

  currentDate: Date;

  nbContenu: number=0;

  playlistMod : Playlist;

  contenuP : Array<ContenuPlaylist>;

  musiqueP: Array<Contenu> = new Array<Contenu>();

  constructor(
    private playlistService: PlaylistService,
  ) {}

  getAuthUserType() {
    return this.playlistService.getAuthUserType()
  }

  public findAll() {
    return this.playlistService.findAll();
  }

  addPlaylist() {
    if(this.formPlaylist) {
      if(this.formPlaylist.id) {
        this.playlistService.update(this.formPlaylist)
      } else {
        this.playlistService.insert(this.formPlaylist)
      }

      this.formPlaylist = undefined
    } else {
      this.formPlaylist = new Playlist()
    }
  }

  cancel() {
    this.formPlaylist = undefined;
    this.playlistMod = undefined
  }

  edit(id: number) {
    this.playlistService.findById(id).subscribe((resp) => { this.formPlaylist = resp })
  }

  remove(id: number) {
    this.playlistService.remove(id)
  }


  //b. récupérer la playliste par son id
  //c. récupérer la liste de contenuPlaylist avec l'id de la playlist
  //d. récupérer la liste de musiques correspondant à la liste de contenuPlaylist
  completer(id: number){
    this.playlistService.findById(id).subscribe((resp)=> {
      this.playlistMod= resp;
      this.playlistService.findAllCPByIdP(this.playlistMod.id).subscribe((resp)=>{
        this.contenuP=resp;
        for (let cp of this.contenuP) {
            this.musiqueP.push(cp.contenuAssocie);
        };
      });
    })
  }

  removeContenu(id: number){

  }
}

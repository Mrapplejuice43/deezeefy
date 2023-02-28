import { DatePipe } from '@angular/common';
import { Component } from '@angular/core';
import { ContenuPlaylist, Musique } from '../model';
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

  musiqueP: Array<Musique>;

  constructor(
    private playlistService: PlaylistService
  ) {}

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

  completer(id: number){
    this.playlistService.findById(id).subscribe((resp)=> {
      this.playlistMod= resp
      this.recCP(this.playlistMod.id)
      this.rempM(this.contenuP)
    })
    
  }

  rempM(lcp: Array<ContenuPlaylist>){
    for (let cp of lcp) {
      this.musiqueP.push(cp.contenuAssocie);
    }
  }

  recCP(id: number){
    this.playlistService.findAllCPByIdP(id).subscribe((resp)=>{this.contenuP=resp})
  }
}

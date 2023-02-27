import { HttpClient } from '@angular/common/http';
import { Component, ElementRef, Input, ViewChild } from '@angular/core';
import { AudioService } from '../audio.service';

@Component({
  selector: 'app-lecture-musique',
  templateUrl: './lecture-musique.component.html',
  styleUrls: ['./lecture-musique.component.scss']
})
export class LectureMusiqueComponent {

  @Input()
  musicId: number;

  constructor(
    private http: HttpClient,
    private audioService: AudioService,
  ) {}

  play () {
    this.http.get<Musique>("http://localhost:8080/musique/" + this.musicId).subscribe((resp) => {
      let m: Musique = resp
      let view = new Int8Array(m.piste);
      this.audioService.sendToBufferAndPlay(view)
    })
  }

  stop() {
    this.audioService.stop();
  }
}

class Musique {
  id: number
  version: number
  titre: string
  duree: number
  piste: Array<number>
  artiste: any
  auditeurs: Array<any>
  listePlaylistAssociees: Array<any>
  genre: string

  constructor(id?: number,
    version?: number,
    titre?: string,
    duree?: number,
    piste?: Array<number>,
    artiste?: any,
    auditeurs?: Array<any>,
    listePlaylistAssociees?: Array<any>,
    genre?: string) {
      this.id = id
      this.version = version
      this.titre = titre
      this.duree = duree
      this.piste = piste
      this.artiste = artiste
      this.auditeurs = auditeurs
      this.listePlaylistAssociees = listePlaylistAssociees
      this.genre = genre
    }
}

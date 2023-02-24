import { HttpClient } from '@angular/common/http';
import { Component, ElementRef, ViewChild } from '@angular/core';

@Component({
  selector: 'app-lecture-musique',
  templateUrl: './lecture-musique.component.html',
  styleUrls: ['./lecture-musique.component.scss']
})
export class LectureMusiqueComponent {
  audioCtx: AudioContext = new AudioContext()
  constructor(
    private http: HttpClient
  ) {}

  play (id: number) {
    let bufferSource = this.audioCtx.createBufferSource();
    let gainNode: GainNode = this.audioCtx.createGain()
    gainNode.gain.value = 1;
    let destination = this.audioCtx.destination;

    this.http.get<Musique>("http://localhost:8080/musique/" + id).subscribe((resp) => {
      let m: Musique = resp
      let view = new Int8Array(m.piste);

      this.audioCtx.decodeAudioData(view.buffer, function (soundBuffer) {
        bufferSource.buffer = soundBuffer
        bufferSource.connect(gainNode)
        gainNode.connect(destination)
        bufferSource.start(0)
      })
    })
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

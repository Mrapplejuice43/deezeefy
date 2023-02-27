import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AudioService } from '../audio.service';

@Component({
  selector: 'app-enregistrement-musique',
  templateUrl: './enregistrement-musique.component.html',
  styleUrls: ['./enregistrement-musique.component.scss']
})
export class EnregistrementMusiqueComponent {
  fileName: string
  constructor(
    private http: HttpClient,
    private router: Router
  ) {

  }

  save(event: any) {
    let f: File = event.target.files[0]
    console.log(f)
    this.fileName = f.name
    var fr = new FileReader();

    fr.onloadend = () => {
      let res: Int8Array;
      if(typeof(fr.result) == 'string') {
        let buffer: string = fr.result
        let encoder = new TextEncoder()
        let encodedString: Uint8Array = encoder.encode(buffer)
        res = new Int8Array(encodedString.buffer.slice(encodedString.byteOffset), 0, encodedString.length)

      } else {
        let buffer: ArrayBuffer = fr.result
        res = new Int8Array(buffer)
      }

      let music: Musique = new Musique();
      music.titre = f.name.split(".")[0]
      music.piste = Array.from(res);
      music.duree = Math.round(f.size / 24000) // Les mp3 se lisent a 192kbits/s donc 24000 octets par seconde
      this.http.post<Musique>("http://localhost:9999/musique", music).subscribe(() => {
        this.router.navigate(['/musique'])
      })
    };

    fr.readAsArrayBuffer(f)

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

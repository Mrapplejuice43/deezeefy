import { formatDate } from '@angular/common';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AudioService } from '../audio.service';
import { AuthService } from '../auth.service';
import { CompteHistory, Musique } from '../model';


@Injectable({
  providedIn: 'root'
})
export class LectureMusiqueService {

  constructor(
    private http: HttpClient,
    private audioService: AudioService,
    private authService: AuthService) { }

  play(id: number) {
    this.http.get<Musique>("http://localhost:9999/musique/" + id + "/piste").subscribe((resp) => {
      let m: Musique = resp
      let view = new Int8Array(m.piste);
      this.audioService.sendToBufferAndPlay(view)

      let acc = this.authService.getCompte();
      let accId = acc ? acc.id : -1

      this.http
        .get<CompteHistory>("http://localhost:9999/compteHistory/" + accId + "/" + m.id)
        .subscribe(resp => {
          let hist = resp;
          let now: Date = new Date()
          now.setTime(Date.now())
          let day = now.getDay() < 10 ? "0" + now.getDay() : now.getDay()
          let month = now.getMonth() < 10 ? "0" + now.getMonth() : now.getMonth()
          hist.dateDerniereEcoute = now.getFullYear() + '-' + month + '-' + day
          console.log(hist.dateDerniereEcoute)
          hist.nombreEcoutes = hist.nombreEcoutes ? hist.nombreEcoutes+=1 : 1

          this.http.put<CompteHistory>("http://localhost:9999/compteHistory/" + hist.id, hist).subscribe()
        })
    })
  }

  stop() {
    this.audioService.stop()
  }
}

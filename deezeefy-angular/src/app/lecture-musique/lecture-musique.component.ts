import { HttpClient } from '@angular/common/http';
import { Component, ElementRef, Input, ViewChild } from '@angular/core';
import { AudioService } from '../audio.service';
import { Musique } from '../model';

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
    this.http.get<Musique>("http://localhost:9999/musique/" + this.musicId + "/piste").subscribe((resp) => {
      let m: Musique = resp
      let view = new Int8Array(m.piste);
      this.audioService.sendToBufferAndPlay(view)
    })
  }

  stop() {
    this.audioService.stop();
  }
}


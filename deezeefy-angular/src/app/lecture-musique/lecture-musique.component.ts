import { Component, Input } from '@angular/core';
import { LectureMusiqueService } from './lecture-musique.service';

@Component({
  selector: 'app-lecture-musique',
  templateUrl: './lecture-musique.component.html',
  styleUrls: ['./lecture-musique.component.scss']
})
export class LectureMusiqueComponent {

  @Input()
  musicId: number;

  constructor(
    private lectureMusiqueService: LectureMusiqueService
  ) {}

  play () {
    this.lectureMusiqueService.play(this.musicId);
  }

  stop() {
    this.lectureMusiqueService.stop();
  }
}


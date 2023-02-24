import { Component } from '@angular/core';
import { MusiqueHttpService } from './musique-http.service';

@Component({
  selector: 'app-musique',
  templateUrl: './musique.component.html',
  styleUrls: ['./musique.component.scss']
})
export class MusiqueComponent {
  constructor(
    private musiqueService: MusiqueHttpService
  ) {}

  public findAll() {
    return this.musiqueService.findAll();
  }


}

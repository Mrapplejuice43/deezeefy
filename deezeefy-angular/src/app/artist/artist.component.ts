import { Component } from '@angular/core';

import { Artiste } from '../model';
import { ArtistHttpService } from './artist-http.service';

@Component({
  selector: 'app-artist',
  templateUrl: './artist.component.html',
  styleUrls: ['./artist.component.scss']
})
export class ArtistComponent {

  formArtiste: Artiste = new Artiste();


  constructor(
    private artistHttpService: ArtistHttpService) {

  }

  
  add() {
    this.artistHttpService.insert(this.formArtiste);
  }

  cancel() {
    this.formArtiste = undefined
  }

}

import { Component } from '@angular/core';
import { Router } from '@angular/router';

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
    private artistHttpService: ArtistHttpService, private router : Router) {

  }

  
  add() {
    this.artistHttpService.insert(this.formArtiste);
    this.router.navigate(['/']);
  }

  cancel() {
    this.formArtiste = undefined
  }

}

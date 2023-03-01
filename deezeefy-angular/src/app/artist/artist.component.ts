import { Component } from '@angular/core';
import { Router } from '@angular/router';

import { Artiste } from '../model';
import { ArtistHttpService } from './artist-http.service';

@Component({
  selector: 'app-artist',
  templateUrl: './artist.component.html',
  styleUrls: ['./artist.component.scss'],
})
export class ArtistComponent {
  formArtiste: Artiste;

  constructor(
    private artistHttpService: ArtistHttpService,
    private router: Router
  ) {}

  add() {
    if (this.formArtiste) {
      if (this.formArtiste.id) {
        this.artistHttpService.update(this.formArtiste);
      } else {
        this.artistHttpService.insert(this.formArtiste);
      }

      this.formArtiste = undefined;
    } else {
      this.formArtiste = new Artiste();
    }
  }

  cancel() {
    this.formArtiste = undefined;
  }

  public findAll() {
    return this.artistHttpService.findAll();
  }

  edit(id: number) {
    this.artistHttpService.findById(id).subscribe((resp) => {
      this.formArtiste = resp;
    });
  }

  remove(id: number) {
    this.artistHttpService.remove(id);
  }
}

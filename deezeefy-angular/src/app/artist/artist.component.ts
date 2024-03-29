import { Component } from '@angular/core';

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
  ) {}

  add() {
    if (this.formArtiste) {
      this.formArtiste.type = "artiste"
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

  typeCompte(): string {
    return this.artistHttpService.getTypeCompte();
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

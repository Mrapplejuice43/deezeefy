import { CurrencyPipe } from '@angular/common';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';

import { Admin, Artiste } from '../model';
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
    private router: Router,
    private authservice : AuthService
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

  typeCompte():string{
  return this.authservice.getTypeCompte() ;
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

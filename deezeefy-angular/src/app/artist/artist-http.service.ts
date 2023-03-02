import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Artiste } from '../model';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';
import { MusiqueHttpService } from '../musique/musique-http.service';

@Injectable({
  providedIn: 'root',
})
export class ArtistHttpService {
  artistes: Array<Artiste> = new Array<Artiste>();

  constructor(
    private http: HttpClient,
    private authService: AuthService,
    private musiqueService: MusiqueHttpService
    ) {
    this.load();
  }

  getTypeCompte(): string {
    return this.authService.getTypeCompte()
  }

  findById(id: number): Observable<Artiste> {
    return this.http.get<Artiste>('http://localhost:9999/artiste/' + id);
  }

  insert(artist: Artiste): void {
    this.http
      .post<Artiste>('http://localhost:9999/artiste/', artist)
      .subscribe((resp) => {
        this.load();
      });
  }

  load(): void {
    this.http
      .get<Array<Artiste>>('http://localhost:9999/artiste')
      .subscribe((resp) => {
        this.artistes = resp;
      });
  }

  findAll(): Array<Artiste> {
    return this.artistes;
  }

  remove(id: number): void {
    this.http.delete('http://localhost:9999/compteHistory/compte/' + id).subscribe(() => {
      this.http.delete("http://localhost:9999/contenuPlaylist/artiste/" + id).subscribe(() => {
        this.http.delete("http://localhost:9999/compteHistory/artiste/" + id).subscribe(() => {
          this.http.delete("http://localhost:9999/contenu/artiste/" + id).subscribe(() => {
            this.http.delete<void>('http://localhost:9999/artiste/' + id).subscribe((resp) => {
              this.load();
              this.musiqueService.load()
            });
          })
        })
      })
    })
  }

  update(artist: Artiste): void {
    this.http
      .put<Artiste>('http://localhost:9999/artiste/' + artist.id, artist)
      .subscribe((resp) => {
        this.load();
      });
  }
}

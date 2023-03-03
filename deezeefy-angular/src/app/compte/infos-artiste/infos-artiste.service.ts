import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { AuthService } from 'src/app/auth.service';
import { Artiste, Compte } from 'src/app/model';
import { MusiqueHttpService } from 'src/app/musique/musique-http.service';
import { CompteService } from '../compte.service';

@Injectable({
  providedIn: 'root'
})
export class InfosArtisteService {

  constructor(
    private compteService: CompteService,
    private http: HttpClient,
    private musiqueService: MusiqueHttpService,
    private auth: AuthService
  ) { }

  getConnectedUser(): Compte {
    return this.compteService.getConnectedUser()
  }

  updateUser(user: Artiste): Observable<Artiste> {
    return this.http.put<Artiste>("http://localhost:9999/artiste/" + user.id, user)
  }

  deleteUser(id: number): void {
    this.http.delete('http://localhost:9999/compteHistory/compte/' + id).subscribe(() => {
      this.http.delete("http://localhost:9999/contenuPlaylist/artiste/" + id).subscribe(() => {
        this.http.delete("http://localhost:9999/compteHistory/artiste/" + id).subscribe(() => {
          this.http.delete("http://localhost:9999/contenu/artiste/" + id).subscribe(() => {
            this.http.delete<void>('http://localhost:9999/artiste/' + id).subscribe((resp) => {
              this.musiqueService.load()
              this.auth.disconnectCompte()
            });
          })
        })
      })
    })
  }
}

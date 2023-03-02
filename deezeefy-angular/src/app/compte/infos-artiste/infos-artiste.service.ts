import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Artiste, Compte } from 'src/app/model';
import { CompteService } from '../compte.service';

@Injectable({
  providedIn: 'root'
})
export class InfosArtisteService {

  constructor(
    private compteService: CompteService,
    private http: HttpClient,
    private router: Router
  ) { }

  getConnectedUser(): Compte {
    return this.compteService.getConnectedUser()
  }

  updateUser(user: Artiste): Observable<Artiste> {
    return this.http.put<Artiste>("http://localhost:9999/artiste/" + user.id, user)
  }

  deleteUser(user: Artiste) {
    this.http.delete<Artiste>("http://localhost:9999/artiste/" + user.id).subscribe(() => {
      this.router.navigate(['/home'])
      this.compteService.logoutUser()
    })
  }
}

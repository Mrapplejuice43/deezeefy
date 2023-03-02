import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Compte, Utilisateur } from 'src/app/model';
import { CompteService } from '../compte.service';

@Injectable({
  providedIn: 'root'
})
export class InfosUtilisateurService {

  constructor(
    private compteService: CompteService,
    private http: HttpClient,
    private router: Router
  ) { }

  getConnectedUser(): Compte {
    return this.compteService.getConnectedUser()
  }

  updateUser(user: Utilisateur): Observable<Utilisateur> {
    return this.http.put<Utilisateur>("http://localhost:9999/utilisateur/" + user.id, user)
  }

  deleteUser(user: Utilisateur) {
    this.http.delete<Utilisateur>("http://localhost:9999/utilisateur/" + user.id).subscribe(() => {
      this.router.navigate(['/home'])
      this.compteService.logoutUser()
    })
  }
}

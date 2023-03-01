import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Utilisateur } from 'src/app/model';

@Injectable({
  providedIn: 'root'
})
export class InfosUtilisateurService {

  constructor(
    private http: HttpClient
  ) { }

  getUser(id: number): Observable<Utilisateur> {
    return this.http.get<Utilisateur>("http://localhost:9999/utilisateur/" + id)
  }
}

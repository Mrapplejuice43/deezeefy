import { Injectable } from '@angular/core';
import { Utilisateur } from '../model';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UtilisateurHttpService {

  utilisateurs: Array<Utilisateur> = new Array<Utilisateur>();
  // abonnements: Map<string, number> = new Map<string, number >();

  constructor(private http: HttpClient) {
    this.load();
  }

  insert(utilisateur: Utilisateur): void {
    this.http.post<Utilisateur>("http://localhost:9999/utilisateur", utilisateur).subscribe(response => {
      this.load();
      alert("Votre compte a bien été crée ! ");
    })
  }

  load(): void {
    this.http.get<Array<Utilisateur>>("http://localhost:9999/utilisateur").subscribe(resp => {
      this.utilisateurs = resp;
    });
  }

  delete(id: number): void {
    this.http.delete<Utilisateur>("http://localhost:9999/utilisateur/" + id).subscribe(resp => {
      this.load()
    });
  }

}


import { Injectable } from '@angular/core';
import { Utilisateur } from '../model';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UtilisateurHttpService {

  utilisateurs: Array<Utilisateur> = new Array<Utilisateur>();
  // abonnements: Map<string, number> = new Map<string, number >();

  constructor(private http: HttpClient) {
    this.load();
  }

  findAll(): Array<Utilisateur> {
    return this.utilisateurs;
  }

  findById(id: number): Observable<Utilisateur> {
    return this.http.get<Utilisateur>("http://localhost:9999/utilisateur/" + id);
  }

insert(utilisateur:Utilisateur):void{
  this.http.post<Utilisateur>("http://localhost:9999/utilisateur", utilisateur).subscribe(response =>{
    this.load();
  })
}

update(utilisateur: Utilisateur): void {
  this.http.put<Utilisateur>("http://localhost:9999/utilisateur/" + utilisateur.id, utilisateur).subscribe(resp => {
    this.load();
  });
}

remove(id: number): void {
  this.http.delete<void>("http://localhost:9999/utilisateur/" + id).subscribe(resp => {
    this.load();
  });
}

private load(): void {
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


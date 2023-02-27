import { Injectable } from '@angular/core';
import { Utilisateur } from '../model';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UtilisateurHttpService {


  utilisateurs : Array<Utilisateur>=new Array<Utilisateur>();
 


  constructor(private http: HttpClient) {
    this.load();
  }


insert(utilisateur:Utilisateur):void{
  this.http.get<Utilisateur>("http://localhost:9999/utilisateur", utilisateur).subscribe(response =>{
    this.load();
  })

  
}

  private load(): void {
    this.http.get<Array<Utilisateur>>("http://localhost:9999/utilisateur").subscribe(resp => {
      this.utilisateurs = resp;
    });
  }

}


import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Musique } from '../model';

@Injectable({
  providedIn: 'root'
})
export class RechercheService {

  selection: Array<Musique> = new Array<Musique>();

  constructor(private http: HttpClient) { }


  findAllByTitre(titre: string): Array<Musique>{
    this.http.get<Array<Musique>>("http://localhost:8080/musique/recherche/"+ titre).subscribe(resp => {
      this.selection = resp;
    });
    return this.selection;
  }
}

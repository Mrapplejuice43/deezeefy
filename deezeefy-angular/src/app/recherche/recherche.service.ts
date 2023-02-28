import { HttpClient } from '@angular/common/http';
import { Injectable, Optional } from '@angular/core';
import { Observable } from 'rxjs';
import { Musique } from '../model';

@Injectable({
  providedIn: 'root'
})
export class RechercheService {


  constructor(private http: HttpClient) { }


  findAllByTitre(titre: string): Observable<Array<Musique>>{
    return this.http.get<Array<Musique>>("http://localhost:9999/musique/rechercheTitre/"+ titre);
    
  }

  findAllByAuteur(auteur: string): Observable<Array<Musique>>{
    return this.http.get<Array<Musique>>("http://localhost:9999/musique/rechercheAuteur/"+ auteur);
    
  }

  findAllByGenre(genre: string): Observable<Array<Musique>>{
    return this.http.get<Array<Musique>>("http://localhost:9999/musique/rechercheGenre/"+ genre);
    
  }
}

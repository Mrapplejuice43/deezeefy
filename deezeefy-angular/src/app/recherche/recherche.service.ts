import { HttpClient } from '@angular/common/http';
import { Injectable, Optional } from '@angular/core';
import { Observable } from 'rxjs';
import { ContenuPlaylist, Musique } from '../model';

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
  

  findById(id: number): Observable<Musique>{
    return this.http.get<Musique>("http://localhost:9999/musique/"+ id);
    
  }

  createCP(cp: ContenuPlaylist){
    return this.http.post<ContenuPlaylist>("http://localhost:9999/contenuPlaylist/", cp).subscribe();
  }

 
}

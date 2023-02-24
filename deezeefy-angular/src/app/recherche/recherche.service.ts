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
    return this.http.get<Array<Musique>>("http://localhost:8080/musique/recherche/"+ titre);
    
  }
}

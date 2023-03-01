import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Artiste } from 'src/app/model';

@Injectable({
  providedIn: 'root'
})
export class InfosArtisteService {

  constructor(
    private http: HttpClient
  ) { }

  getArtiste(id: number): Observable<Artiste> {
    return this.http.get<Artiste>("http://localhost:9999/artiste/" + id)
  }
}

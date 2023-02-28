import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Artiste } from '../model';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class ArtistHttpService {

  artistes: Array<Artiste> = new Array<Artiste>();

  constructor(private http: HttpClient, private router :Router){
    this.load();

  }

  findById(id: number): Observable<Artiste> {
    return this.http.get<Artiste>("http://localhost:9999/artiste/" + id);
  }

  insert(artist: Artiste): void {
    this.http.post<Artiste>("http://localhost:9999/artiste/",artist).subscribe(resp => { 
      this.load();
      alert("Votre compte Artiste a bien été crée ! ");
    });

}

 load(): void {
    this.http.get<Array<Artiste>>("http://localhost:9999/artiste").subscribe(resp => {
      this.artistes = resp;
    });
  }

}

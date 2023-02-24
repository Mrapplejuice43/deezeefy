import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Contenu } from '../model';

@Injectable({
  providedIn: 'root'
})
export class MusiqueHttpService {
  contenus: Array<Contenu> = new Array<Contenu>();
  genres: Map<string, string> = new Map<string,string>();
  
  
  constructor(private http: HttpClient) {
    this.load();
  }

  findAllGenre(): Map<string, string> {
    return this.genres;
  }

  findAll(): Array<Contenu> {
    return this.contenus;
  }
  
  load() {}


}

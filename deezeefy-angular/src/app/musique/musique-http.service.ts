import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Musique } from '../model';

@Injectable({
  providedIn: 'root'
})
export class MusiqueHttpService {
  musiques: Array<Musique> = new Array<Musique>();
  
  
  constructor(private http: HttpClient) {
    this.load();
  }



  findAll(): Array<Musique> {
    return this.musiques;
  }
  

  private load(): void {
    this.http.get<Array<Musique>>("http://localhost:8080/musique").subscribe(resp => {
      this.musiques = resp;
    });
  }

}

import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
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
  
  findById(id: number): Observable<Musique> {
    return this.http.get<Musique>("http://localhost:9999/musique/" + id);
  }

  insert(musique: Musique): void {
    if (!musique.piste) {
      musique.piste=[]
    }
    console.log(musique)
    this.http.post<Musique>("http://localhost:9999/musique", musique).subscribe(resp => {
      this.load();
    });
  }

  update(musique: Musique): void {
    this.http.put<Musique>("http://localhost:9999/musique/" + musique.id, musique).subscribe(resp => {
      this.load();
    });
  }

  remove(id: number): void {
    this.http.delete<void>("http://localhost:9999/musique/" + id).subscribe(resp => {
      this.load();
    });
  }

  private load(): void {
    this.http.get<Array<Musique>>("http://localhost:9999/musique").subscribe(resp => {
      this.musiques = resp;
    });
  }

}

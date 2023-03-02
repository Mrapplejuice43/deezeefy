import { DatePipe } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AuthService } from '../auth.service';
import { Compte, ContenuPlaylist, Playlist } from '../model';

@Injectable({
  providedIn: 'root'
})
export class PlaylistService {

  playlists : Array<Playlist>;

  constructor(
    private http: HttpClient,
    private authServ: AuthService
  ) {
    this.load();
  }

  getAuthUserType(): string {
    return this.authServ.getTypeCompte();
  }

  findAll(): Array<Playlist> {
    return this.playlists;
  }

  findById(id: number): Observable<Playlist> {
    return this.http.get<Playlist>("http://localhost:9999/playlist/" + id);
  }

  createDate(){
    let now: Date = new Date();
    now.setTime(Date.now())
    let day = now.getDay() < 10 ? "0" + now.getDay() : now.getDay()
    let month = now.getMonth() < 10 ? "0" + now.getMonth() : now.getMonth()
    return now.getFullYear() + '-' + month + '-' + day
  }

  insert(playlist: Playlist): void {
    playlist.nbContenu = 0;
    playlist.dateCreation  = this.createDate();
    //playlist.createur = this.authServ.getCompte();
    playlist.duree=0;
    this.http.post<Playlist>("http://localhost:9999/playlist", playlist ).subscribe(resp => {
      this.load();
    });
  }

  update(playlist: Playlist): void {
    this.http.put<Playlist>("http://localhost:9999/playlist/" + playlist.id, playlist).subscribe(resp => {
      this.load();
    });
  }

  remove(id: number): void {
    this.http.delete<void>("http://localhost:9999/playlist/" + id).subscribe(resp => {
      this.load();
    });
  }

  private load(): void {
    this.http.get<Array<Playlist>>("http://localhost:9999/playlist").subscribe(resp => {
      this.playlists = resp;
    });
  }

  findAllCPByIdP(id: number){
    return this.http.get<Array<ContenuPlaylist>>("http://localhost:9999/contenuPlaylist/playlistId/"+id)
  }

}

import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ContenuPlaylist, Playlist } from '../model';

@Injectable({
  providedIn: 'root'
})
export class PlaylistService {

  playlists : Array<Playlist>;
  
  constructor(private http: HttpClient) {
    this.load();
  }


  findAll(): Array<Playlist> {
    return this.playlists;
  }

  findById(id: number): Observable<Playlist> {
    return this.http.get<Playlist>("http://localhost:9999/playlist/" + id);
  }

  insert(playlist: Playlist): void {
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
    return this.http.get<Array<ContenuPlaylist>>("http://localhost:9999/contenuPlaylist/playlistId"+id)
  }

}

import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { CompteHistory } from 'src/app/model';

@Injectable({
  providedIn: 'root'
})
export class HistoriqueCompteService {

  compteHistory: Array<CompteHistory> = new Array<CompteHistory>()

  constructor(
    private http: HttpClient,
  ) { }

  findAll() {
    return this.compteHistory
  }

  load(id: number) {
    this.http.get<Array<CompteHistory>>("http://localhost:9999/compteHistory/compte/" + id).subscribe(resp => {
      this.compteHistory = resp
    })
  }
}

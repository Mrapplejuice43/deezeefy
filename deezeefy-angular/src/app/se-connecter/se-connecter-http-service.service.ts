import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Admin } from '../model';

@Injectable({
  providedIn: 'root'
})
export class SeConnecterHttpServiceService {

  admin: Array<Admin> = new Array<Admin>();
  
  constructor(private http: HttpClient) { 
      this.load();
    }
  findById(id: number): Observable<Admin> {
      return this.http.get<Admin>("http://localhost:9999/admin/" + id);    
    }


findInDb(){


}

  load() {
    this.http.get<Array<Admin>>("http://localhost:9999/admin").subscribe(resp => {
      this.admin = resp;
    });
  }
}

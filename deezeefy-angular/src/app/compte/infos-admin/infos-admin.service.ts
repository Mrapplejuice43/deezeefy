import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Admin } from 'src/app/model';

@Injectable({
  providedIn: 'root'
})
export class InfosAdminService {

  constructor(
    private http: HttpClient
  ) { }

  getAdmin(id: number): Observable<Admin> {
    return this.http.get<Admin>("http://localhost:9999/admin/" + id)
  }
}

import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Admin, Compte } from 'src/app/model';
import { CompteService } from '../compte.service';

@Injectable({
  providedIn: 'root'
})
export class InfosAdminService {

  constructor(
    private compteService: CompteService,
    private http: HttpClient,
    private router: Router
  ) { }

  getConnectedUser(): Compte {
    return this.compteService.getConnectedUser()
  }

  updateUser(user: Admin): Observable<Admin> {
    return this.http.put<Admin>("http://localhost:9999/admin/" + user.id, user)
  }

  deleteUser(user: Admin) {
    this.http.delete("http://localhost:9999/compteHistory/compte/" + user.id).subscribe(() => {
      this.http.delete<Admin>("http://localhost:9999/admin/" + user.id).subscribe(() => {
      this.router.navigate(['/home'])
        this.compteService.logoutUser()
      })
    })
  }
}

import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { AuthService } from '../auth.service';
import { Admin } from '../model';

@Injectable({
  providedIn: 'root'
})
export class AdminHttpService {
  admins: Array<Admin> = new Array<Admin>();

  constructor(
    private http: HttpClient,
    private authService : AuthService,
    private router: Router
    ) {
    this.load();
  }

  getCurrentUserType(): string {
    if(this.authService.getTypeCompte() != "admin") {
      this.router.navigate(["/home"])
    }
    return this.authService.getTypeCompte()
  }

  findAll(): Array<Admin> {
    return this.admins;
  }

  findById(id: number): Observable<Admin> {
    return this.http.get<Admin>("http://localhost:9999/admin/" + id);
  }

  insert(admin: Admin): void {
    this.http.post<Admin>("http://localhost:9999/admin", admin).subscribe(resp => {
      this.load();
    });
  }

  update(admin: Admin): void {
    this.http.put<Admin>("http://localhost:9999/admin/" + admin.id, admin).subscribe(resp => {
      this.load();
    });
  }

  remove(id: number): void {
    this.http.delete("http://localhost:9999/compteHistory/compte/" + id).subscribe(() => {
      this.http.delete<void>("http://localhost:9999/admin/" + id).subscribe(resp => {
        this.load();
      });
    })
  }

  private load(): void {
    this.http.get<Array<Admin>>("http://localhost:9999/admin").subscribe(resp => {
      this.admins = resp;
    });
  }
}

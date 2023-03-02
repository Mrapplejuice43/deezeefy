import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, throwError } from 'rxjs';
import { AuthService } from '../auth.service';
import {
  AuthDTO,
  Compte,
} from '../model';

@Injectable({
  providedIn: 'root',
})
export class SeConnecterHttpServiceService {
  compteNotFoundError: boolean = false

  constructor(
    private http: HttpClient,
    private authService: AuthService
  ) {}

  getCompteNotFoundError(): boolean {
    return this.compteNotFoundError;
  }

  loginCompte(dto: AuthDTO) {
    this.http
      .post<Compte>('http://localhost:9999/compte/auth', dto)
      .pipe(
        catchError((err) => {
          if(err.status === 404) {
            this.compteNotFoundError = true
            return throwError(() => console.error("Le compte n'existe pas"))
          }
          return throwError(() => console.error(err.status))
        })
      )
      .subscribe((resp) => {
        this.authService.loginCompte(resp);
      });
  }
}


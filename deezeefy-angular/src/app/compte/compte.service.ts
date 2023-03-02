import { Injectable } from '@angular/core';
import { AuthService } from '../auth.service';
import { Compte } from '../model';

@Injectable({
  providedIn: 'root'
})
export class CompteService {

  constructor(
    private authService: AuthService
  ) { }

  getConnectedUser(): Compte {
    return this.authService.getCompte()
  }

  getConnectedUserType(): string {
    return this.authService.getTypeCompte()
  }

  logoutUser() {
    this.authService.disconnectCompte()
  }
}

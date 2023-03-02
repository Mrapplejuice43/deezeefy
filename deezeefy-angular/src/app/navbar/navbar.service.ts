import { Injectable } from '@angular/core';
import { AuthService } from '../auth.service';
import { Compte } from '../model';

@Injectable({
  providedIn: 'root'
})
export class NavbarService {

  constructor(
    private authService: AuthService
  ) {}

  getCompteType(): string {
    return this.authService.getTypeCompte();
  }

  getAuthCompte(): Compte {
    return this.authService.getCompte();
  }

  logout() {
    this.authService.disconnectCompte();
  }
}

import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Compte } from './model';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  private compteConnecte: Compte = undefined;

  constructor(private router: Router) {}

  loginCompte(compteToConnect: Compte) {
    if (compteToConnect) {
      if (compteToConnect.type) {
        this.compteConnecte = compteToConnect;
        this.router.navigate(['/home']);
      }
    }
  }

  getCompte(): Compte {
    return this.compteConnecte;
  }

  getTypeCompte(): string {
    if (this.compteConnecte) {
      return this.compteConnecte.type;
    }
    return undefined;
  }

  disconnectCompte() {
    this.compteConnecte = undefined;
    this.router.navigate(['/home']);
  }
}

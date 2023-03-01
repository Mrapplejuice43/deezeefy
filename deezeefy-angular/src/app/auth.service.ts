import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import {
  Compte,
  COMPTE_ADMIN,
  COMPTE_ARTISTE,
  COMPTE_UTILISATEUR,
} from './model';

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
        if (compteToConnect.type == COMPTE_UTILISATEUR) {
          this.router.navigate(['/utilisateur']);
        } else if (compteToConnect.type == COMPTE_ADMIN) {
          this.router.navigate(['/admin']);
        } else if (compteToConnect.type == COMPTE_ARTISTE) {
          this.router.navigate(['/artiste']);
        }
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

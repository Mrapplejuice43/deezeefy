import { Component } from '@angular/core';
import {
  Admin,
  AuthDTO,
  COMPTE_ADMIN,
  COMPTE_ARTISTE,
  COMPTE_UTILISATEUR,
} from '../model';
import { SeConnecterHttpServiceService } from './se-connecter-http-service.service';

@Component({
  selector: 'app-se-connecter',
  templateUrl: './se-connecter.component.html',
  styleUrls: ['./se-connecter.component.scss'],
})
export class SeConnecterComponent {
  adminType: string = COMPTE_ADMIN
  userType: string = COMPTE_UTILISATEUR
  artisteType: string = COMPTE_ARTISTE
  typeCompte: string = this.userType;
  authentification: AuthDTO = new AuthDTO();
  erreur: boolean = false;

  constructor(
    private connectionService: SeConnecterHttpServiceService
  ) {}

  getCompteNotFoundError(): boolean {
    return this.connectionService.getCompteNotFoundError()
  }

  login(event: any) {
    if(event instanceof PointerEvent || (event instanceof KeyboardEvent && event.key == "Enter")) {
      if (this.typeCompte && this.authentification.isValide()) {
        this.connectionService.loginCompte(this.authentification);
      } else {
        this.erreur = true;
      }
    }
  }
}

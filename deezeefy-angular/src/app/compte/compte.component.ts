import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';
import { Compte, COMPTE_ADMIN, COMPTE_ARTISTE, COMPTE_UTILISATEUR } from '../model';

@Component({
  selector: 'app-compte,[app-artist],[app-utilisateur]',
  templateUrl: './compte.component.html',
  styleUrls: ['./compte.component.scss']
})
export class CompteComponent {
  adminType: string = COMPTE_ADMIN
  userType: string = COMPTE_UTILISATEUR
  artisteType: string = COMPTE_ARTISTE
  user: Compte = this.getCompte()

  constructor(
    private authService: AuthService,
    private router: Router
  ){}

  getCompte(): Compte {
    if(this.authService.getCompte()) {
      return this.authService.getCompte()
    }
    this.router.navigate(['/home']);
    return null;
  }

}

import { Component } from '@angular/core';
import { AuthService } from '../auth.service';
import { Compte } from '../model';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss'],
})
export class NavbarComponent {
  constructor(private authService: AuthService) {}

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

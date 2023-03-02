import { Component } from '@angular/core';
import { AuthService } from '../auth.service';
import { Compte } from '../model';
import { NavbarService } from './navbar.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss'],
})
export class NavbarComponent {
  constructor(
    private navbarService: NavbarService
  ) {}

  getCompteType(): string {
    return this.navbarService.getCompteType();
  }

  getAuthCompte(): Compte {
    return this.navbarService.getAuthCompte();
  }

  logout() {
    this.navbarService.logout();
  }
}

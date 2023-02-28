import { Component } from '@angular/core';
import { AuthService } from '../auth.service';
import { Compte } from '../model';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent {

constructor(private service : AuthService){

}

getCompteType():string{
  
  if(this.service.getCompte())
  {
  return this.service.getCompte().type;
  }
  return undefined;
}

getAuthCompte(): Compte {
  return this.service.getCompte();
}

logout() {
  this.service.disconnectCompte();
}

}

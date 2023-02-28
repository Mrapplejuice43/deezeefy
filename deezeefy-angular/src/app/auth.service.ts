import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Compte, Utilisateur } from './model';



@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private compteConnecte : Compte = undefined;

  constructor( private router: Router) { 
 

  }

loginCompte(compteToConnect : Compte){

  if(compteToConnect){

    if(compteToConnect.type){

      this.compteConnecte = compteToConnect;
      if(compteToConnect.type == "utilisateur"){
        this.router.navigate(["/utilisateur"]);
      }else
      if(compteToConnect.type == "admin"){
        this.router.navigate(["/admin"])
      }else
      if(compteToConnect.type == "artiste"){
        this.router.navigate(["/artiste"]);
      }
     
    }
  } 
}

getCompte():Compte{
  return this.compteConnecte;
}

disconnectCompte(){

  this.compteConnecte = undefined;
  this.router.navigate(["/home"]);
}

}

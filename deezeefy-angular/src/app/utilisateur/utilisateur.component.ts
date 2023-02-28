import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Utilisateur } from '../model';
import { UtilisateurHttpService } from './utilisateur-http.service';

@Component({
  selector: 'app-utilisateur',
  templateUrl: './utilisateur.component.html',
  styleUrls: ['./utilisateur.component.scss']
})
export class UtilisateurComponent {

  formUser : Utilisateur= new Utilisateur();
  constructor( private utilisateurHttpServ : UtilisateurHttpService, private router: Router){
  }

  save(){
    this.utilisateurHttpServ.insert(this.formUser);
    this.router.navigate(['/']);
  }

  remove(id: number): void {
    this.utilisateurHttpServ.delete(id);
  }

  cancel():void{
   
    if(confirm("Etes-vous sur de ne pas vouloir créer un compte ?")){
      this.formUser = undefined;
    };
    // redirect home 
  }

}

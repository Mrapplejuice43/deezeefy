import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';
import { Admin, Utilisateur } from '../model';
import { UtilisateurHttpService } from './utilisateur-http.service';

@Component({
  selector: 'app-utilisateur',
  templateUrl: './utilisateur.component.html',
  styleUrls: ['./utilisateur.component.scss']
})
export class UtilisateurComponent {

  formUtilisateur: Utilisateur;
  formAdmin:Admin;


  constructor(
    private utilisateurService: UtilisateurHttpService, private router: Router
  ) {}

  save(){
    this.utilisateurService.insert(this.formUtilisateur);
    this.router.navigate(['/']);
  }

  public findAll() {
    return this.utilisateurService.findAll();
  }

  addUtilisateur() {
    if(this.formUtilisateur) {
      this.formUtilisateur.type = "user"
      if(this.formUtilisateur.id) {

        this.utilisateurService.update(this.formUtilisateur)
      } else {

        this.utilisateurService.insert(this.formUtilisateur)
      }

      this.formUtilisateur = undefined
    } else {
      this.formUtilisateur = new Utilisateur()

    }
  }


  cancel():void{

    if(confirm("Etes-vous sur de ne pas vouloir créer un compte ?")){
      this.formUtilisateur = undefined;
    };
    // redirect home
  }

  edit(id: number) {
    this.utilisateurService.findById(id).subscribe((resp) => { this.formUtilisateur = resp })
  }

  remove(id: number) {
    this.utilisateurService.remove(id)
  }

}

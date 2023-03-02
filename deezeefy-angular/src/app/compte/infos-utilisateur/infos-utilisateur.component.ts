import { Component, Input, OnInit } from '@angular/core';
import { Utilisateur } from 'src/app/model';
import { InfosUtilisateurService } from './infos-utilisateur.service';

@Component({
  selector: 'app-infos-utilisateur',
  templateUrl: './infos-utilisateur.component.html',
  styleUrls: ['./infos-utilisateur.component.scss']
})
export class InfosUtilisateurComponent implements OnInit {
  user: Utilisateur
  editMode: boolean = false

  constructor(
    private infosUtilisateurService: InfosUtilisateurService
  ) {}

  ngOnInit(): void {
    this.user = (this.infosUtilisateurService.getConnectedUser() as Utilisateur)
  }

  edit() {
    this.editMode = true
  }

  editUser() {
    this.infosUtilisateurService.updateUser(this.user).subscribe(resp => {
      this.user = resp
      this.editMode = false
    })
  }

  cancel() {
    this.editMode = false
  }

  deleteUser() {
    this.infosUtilisateurService.deleteUser(this.user)
  }
}

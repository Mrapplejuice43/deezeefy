import { Component, Input, OnInit } from '@angular/core';
import { Utilisateur } from 'src/app/model';
import { InfosUtilisateurService } from './infos-utilisateur.service';

@Component({
  selector: 'app-infos-utilisateur',
  templateUrl: './infos-utilisateur.component.html',
  styleUrls: ['./infos-utilisateur.component.scss']
})
export class InfosUtilisateurComponent implements OnInit {
  @Input("id")
  id: number

  user: Utilisateur

  constructor(
    private infosUtilisateurService: InfosUtilisateurService
  ) {}


  ngOnInit(): void {
    this.getUser()
  }

  getUser(): void {
    this.infosUtilisateurService.getUser(this.id).subscribe(resp => {
      this.user = resp
    })
  }
}

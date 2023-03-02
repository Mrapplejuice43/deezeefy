import { Component, Input, OnInit } from '@angular/core';
import { Artiste } from 'src/app/model';
import { InfosArtisteService } from './infos-artiste.service';

@Component({
  selector: 'app-infos-artiste',
  templateUrl: './infos-artiste.component.html',
  styleUrls: ['./infos-artiste.component.scss']
})
export class InfosArtisteComponent implements OnInit {
  artiste: Artiste
  editMode: boolean = false

  constructor(
    private infosArtisteService: InfosArtisteService
  ) {}

  ngOnInit(): void {
    this.artiste = (this.infosArtisteService.getConnectedUser() as Artiste)
  }

  edit() {
    this.editMode = true
  }

  editUser() {
    this.infosArtisteService.updateUser(this.artiste).subscribe(resp => {
      this.artiste = resp
      this.editMode = false
    })
  }

  cancel() {
    this.editMode = false
  }

  deleteUser() {
    this.infosArtisteService.deleteUser(this.artiste)
  }
}

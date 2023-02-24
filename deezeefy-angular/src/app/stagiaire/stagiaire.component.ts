import { Component } from '@angular/core';
import { Stagiaire } from '../model';
import { StagiaireHttpService } from './stagiaire-http.service';

@Component({
  selector: 'app-stagiaire',
  templateUrl: './stagiaire.component.html',
  styleUrls: ['./stagiaire.component.scss']
})
export class StagiaireComponent {

  formStagiaire: Stagiaire

  constructor(
    private stagiaireService: StagiaireHttpService
  ) {}

  public findAll() {
    return this.stagiaireService.findAll();
  }

  findAllCivilite(): Map<string, string> {
    return this.stagiaireService.findAllCivilite();
  }

  addStagiaire() {
    if(this.formStagiaire) {
      if(this.formStagiaire.id) {
        this.stagiaireService.update(this.formStagiaire)
      } else {
        this.stagiaireService.insert(this.formStagiaire)
      }

      this.formStagiaire = undefined
    } else {
      this.formStagiaire = new Stagiaire()
    }
  }

  cancel() {
    this.formStagiaire = undefined
  }

  edit(id: number) {
    this.stagiaireService.findById(id).subscribe((resp) => { this.formStagiaire = resp })
  }

  remove(id: number) {
    this.stagiaireService.remove(id)
  }
}

import { Component } from '@angular/core';
import { AuthService } from '../auth.service';
import { Admin, Musique } from '../model';
import { MusiqueHttpService } from './musique-http.service';

@Component({
  selector: 'app-musique',
  templateUrl: './musique.component.html',
  styleUrls: ['./musique.component.scss']
})
export class MusiqueComponent {
  formMusique: Musique;
  formAdmin : Admin;

  constructor(
    private musiqueService: MusiqueHttpService,
    private authService : AuthService
  ) {}

  public findAll() {
    return this.musiqueService.findAll();
  }

  addMusique() {
    if(this.formMusique) {
      if(this.formMusique.id) {
        
        this.musiqueService.update(this.formMusique)
      } else {
        
        this.musiqueService.insert(this.formMusique)
      }
      
      this.formMusique = undefined
    } else {
      this.formMusique = new Musique()
      
    }
  }
  typeCompte():string{
  return this.authService.getTypeCompte();
  }
  
  cancel() {
    this.formMusique = undefined
  }
  
  edit(id: number) {
    this.musiqueService.findById(id).subscribe((resp) => { this.formMusique = resp })
  }

  remove(id: number) {
    this.musiqueService.remove(id)
  }
}

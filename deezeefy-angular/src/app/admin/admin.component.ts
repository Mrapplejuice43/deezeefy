import { Component } from '@angular/core';
import { Admin } from '../model';
import { AdminHttpService } from './admin-http.service';
import { MusiqueComponent } from '../musique/musique.component';
import { MusiqueHttpService } from '../musique/musique-http.service';
import { Musique } from '../model';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.scss']
})
export class AdminComponent {
  formAdmin: Admin

  constructor(
    private adminService: AdminHttpService
  ) {}

  public findAll() {
    return this.adminService.findAll();
  }

  addAdmin() {
    if(this.formAdmin) {
      if(this.formAdmin.id) {
        
        this.adminService.update(this.formAdmin)
      } else {
        
        this.adminService.insert(this.formAdmin)
      }
      
      this.formAdmin = undefined
    } else {
      this.formAdmin = new Admin()
      
    }
  }
  
  cancel() {
    this.formAdmin = undefined
  }
  
  edit(id: number) {
    this.adminService.findById(id).subscribe((resp) => { this.formAdmin = resp })
  }

  remove(id: number) {
    this.adminService.remove(id)
  }
}

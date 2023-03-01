import { Component } from '@angular/core';
import { AuthService } from '../auth.service';
import { Admin } from '../model';
import { AdminHttpService } from './admin-http.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.scss'],
})
export class AdminComponent {
  formAdmin: Admin;
  admin : boolean = true;

  constructor(private adminService: AdminHttpService,private authService : AuthService) {}

  public findAll() {
    return this.adminService.findAll();
  }

  addAdmin() {
    if (this.formAdmin) {
      if (this.formAdmin.id) {
        this.adminService.update(this.formAdmin);
      } else {
        this.adminService.insert(this.formAdmin);
      }

      this.formAdmin = undefined;
    } else {
      this.formAdmin = new Admin();
    }
  }
  
  typeCompte():string{
    return this.authService.getTypeCompte() ;
  
  }
  cancel() {
    this.formAdmin = undefined;
  }

  edit(id: number) {
    this.adminService.findById(id).subscribe((resp) => {
      this.formAdmin = resp;
    });
  }

  remove(id: number) {
    this.adminService.remove(id);
  }
}

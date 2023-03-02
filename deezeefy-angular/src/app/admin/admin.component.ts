import { Component } from '@angular/core';
import { Admin } from '../model';
import { AdminHttpService } from './admin-http.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.scss'],
})
export class AdminComponent {
  formAdmin: Admin;

  constructor(
    private adminService: AdminHttpService,
    ) {}

  public findAll() {
    return this.adminService.findAll();
  }

  addAdmin() {
    if (this.formAdmin) {
      this.formAdmin.type = "admin"
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

  typeCompte(): string {
    return this.adminService.getCurrentUserType();
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

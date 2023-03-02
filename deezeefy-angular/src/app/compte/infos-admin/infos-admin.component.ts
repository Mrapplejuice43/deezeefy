import { Component, Input, OnInit } from '@angular/core';
import { Admin } from 'src/app/model';
import { InfosAdminService } from './infos-admin.service';

@Component({
  selector: 'app-infos-admin',
  templateUrl: './infos-admin.component.html',
  styleUrls: ['./infos-admin.component.scss']
})
export class InfosAdminComponent implements OnInit {
  admin: Admin
  editMode: boolean = false

  constructor(
    private infosAdminService: InfosAdminService
  ) {}

  ngOnInit(): void {
    this.admin = this.infosAdminService.getConnectedUser()
  }

  edit() {
    this.editMode = true
  }

  editUser() {
    this.infosAdminService.updateUser(this.admin).subscribe(resp => {
      this.admin = resp
      this.editMode = false
    })
  }

  cancel() {
    this.editMode = false
  }

  deleteUser() {
    this.infosAdminService.deleteUser(this.admin)
  }
}

import { Component, Input, OnInit } from '@angular/core';
import { Admin } from 'src/app/model';
import { InfosAdminService } from './infos-admin.service';

@Component({
  selector: 'app-infos-admin',
  templateUrl: './infos-admin.component.html',
  styleUrls: ['./infos-admin.component.scss']
})
export class InfosAdminComponent implements OnInit {
  @Input("id")
  id: number

  admin: Admin

  constructor(
    private infosAdminService: InfosAdminService
  ) {}

  ngOnInit(): void {
    this.getAdmin()
  }

  getAdmin(): void {
    this.infosAdminService.getAdmin(this.id).subscribe(resp => {
      this.admin = resp
    })
  }

}

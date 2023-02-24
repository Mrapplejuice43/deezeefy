import { Component } from '@angular/core';
import { Admin } from '../model';
import { SeConnecterHttpServiceService } from './se-connecter-http-service.service';


@Component({
  selector: 'app-se-connecter',
  templateUrl: './se-connecter.component.html',
  styleUrls: ['./se-connecter.component.scss']
})
export class SeConnecterComponent {
  formAdmin: Admin;



  constructor(private adminService: SeConnecterHttpServiceService){

  }

  


}

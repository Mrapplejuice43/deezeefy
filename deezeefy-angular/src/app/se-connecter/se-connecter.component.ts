import { Component } from '@angular/core';
import { Admin, AuthDTO } from '../model';
import { SeConnecterHttpServiceService } from './se-connecter-http-service.service';


@Component({
  selector: 'app-se-connecter',
  templateUrl: './se-connecter.component.html',
  styleUrls: ['./se-connecter.component.scss']
})
export class SeConnecterComponent {

  typeCompte : string;
  authentification : AuthDTO = new AuthDTO();
  erreur : boolean = false;

  constructor(private  connectionService: SeConnecterHttpServiceService){

  }

login( ){
  if(this.typeCompte && this.authentification.isValide()){

    if(this.typeCompte == "utilisateur"){

      this.connectionService.loginUser(this.authentification);

    }else if(this.typeCompte == "admin"){


      this.connectionService.loginAdmin(this.authentification);

    }else if(this.typeCompte == "artiste"){


      this.connectionService.loginArtist(this.authentification);

    }
  }else{
   this.erreur = true;
    
  }

}


}

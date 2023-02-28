import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AuthService } from '../auth.service';
import { Admin, Artiste, AuthDTO, Utilisateur } from '../model';

@Injectable({
  providedIn: 'root'
})
export class SeConnecterHttpServiceService {

  
  constructor(private http: HttpClient,private authService : AuthService) { 
    
    }
 
loginUser(dto : AuthDTO){

  this.http.post<Utilisateur>("http://localhost:9999/utilisateur/auth",dto).subscribe(resp => { 
    resp.type = "utilisateur";
    this.authService.loginCompte(resp)
   
  });

}

loginAdmin(dto : AuthDTO){

  this.http.post<Admin>("http://localhost:9999/admin/auth",dto).subscribe(resp => { 
    resp.type = "admin";
    this.authService.loginCompte(resp)
  });

}

loginArtist(dto : AuthDTO){

  this.http.post<Artiste>("http://localhost:9999/artiste/auth",dto).subscribe(resp => { 
    resp.type = "artiste";
    this.authService.loginCompte(resp)
  });

}

}

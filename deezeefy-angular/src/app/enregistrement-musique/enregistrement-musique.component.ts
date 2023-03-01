import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AudioService } from '../audio.service';
import { EnregistrementMusiqueService } from './enregistrement-musique.service';

@Component({
  selector: 'app-enregistrement-musique',
  templateUrl: './enregistrement-musique.component.html',
  styleUrls: ['./enregistrement-musique.component.scss']
})
export class EnregistrementMusiqueComponent {
  fileName: string

  constructor(private enregistrementService: EnregistrementMusiqueService  ) {

  }

  getUploadProgress() {
    return this.enregistrementService.uploadProgress
  }

  save(event: any) {
    let f: File = event.target.files[0]
    if(f) {
      this.fileName = f.name
      this.enregistrementService.save(f)
    }
  }
}

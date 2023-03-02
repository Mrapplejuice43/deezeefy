import { Component } from '@angular/core';
import { Artiste, Musique } from '../model';
import { EnregistrementMusiqueService } from './enregistrement-musique.service';

@Component({
  selector: 'app-enregistrement-musique',
  templateUrl: './enregistrement-musique.component.html',
  styleUrls: ['./enregistrement-musique.component.scss']
})
export class EnregistrementMusiqueComponent {
  file: File
  fileName: string
  formMusique: Musique
  uploadFromAdmin: boolean = false

  artistes: Array<Artiste> = new Array<Artiste>()

  constructor(
    private enregistrementService: EnregistrementMusiqueService
    ) { this.findAllArtistes() }

  getUploadProgress() {
    return this.enregistrementService.uploadProgress
  }

  findAllArtistes() {
    return this.enregistrementService.findAllArtistes().subscribe(resp => {
      this.artistes = resp
    })
  }

  save(event: any) {
    this.file = event.target.files[0]
    if(this.file) {
      this.fileName = this.file?.name
      this.formMusique = new Musique()
      this.formMusique.titre = this.fileName.split(".")[0]
      this.formMusique.duree = Math.round(this.file.size / 24000) // Les mp3 se lisent a 192kbits/s donc 24000 octets par seconde
      this.formMusique.type = "musique"
      this.formMusique.genre = ""
      if(this.enregistrementService.getAuthUserType() == "admin") {
        this.uploadFromAdmin = true
        this.formMusique.auteur = new Artiste()
      } else {
        this.formMusique.auteur = this.enregistrementService.getAuthUser()
      }
    }
  }

  cancel() {
    this.file = undefined
    this.fileName = undefined
    this.formMusique = undefined
    this.uploadFromAdmin = false
  }

  upload() {
    if(this.file) {
      this.enregistrementService.save(this.file, this.formMusique)
      this.cancel()
    }
  }
}

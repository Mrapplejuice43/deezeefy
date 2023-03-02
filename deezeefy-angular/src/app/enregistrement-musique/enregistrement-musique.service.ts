import { HttpClient, HttpEventType } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { finalize, Observable, Subscription } from 'rxjs';
import { AuthService } from '../auth.service';
import { Artiste, Musique } from '../model';
import { MusiqueHttpService } from '../musique/musique-http.service';

@Injectable({
  providedIn: 'root'
})
export class EnregistrementMusiqueService {

  uploadProgress: number
  uploadSubscribedMethod: Subscription

  constructor(
    private http: HttpClient,
    private router: Router,
    private authService: AuthService,
    private musiqueService: MusiqueHttpService
  ) { }

  getAuthUser() {
    return this.authService.getCompte();
  }

  getAuthUserType() {
    return this.authService.getTypeCompte();
  }

  findAllArtistes(): Observable<Array<Artiste>> {
    return this.http.get<Array<Artiste>>("http://localhost:9999/artiste")
  }

  save (file: File, musique: Musique) {
    var fr = new FileReader();

    fr.onloadend = () => {
      let res: Int8Array;
      if(typeof(fr.result) == 'string') {
        let buffer: string = fr.result
        let encoder = new TextEncoder()
        let encodedString: Uint8Array = encoder.encode(buffer)
        res = new Int8Array(encodedString.buffer.slice(encodedString.byteOffset), 0, encodedString.length)

      } else {
        let buffer: ArrayBuffer = fr.result
        res = new Int8Array(buffer)
      }

      musique.piste = Array.from(res);
      const upload = this.http.post<Musique>("http://localhost:9999/musique", musique, {
        reportProgress: true,
        observe: 'events'
      }).pipe(finalize(() => {
        this.reset()
        this.musiqueService.load()
        this.router.navigate(['/compte'])
      }))

      this.uploadSubscribedMethod = upload.subscribe((event) => {
        if(event.type == HttpEventType.UploadProgress) {
          this.uploadProgress = Math.round(100 * (event.loaded / event.total))
        }
      })
    };

    fr.readAsArrayBuffer(file)
  }

  reset () {
    this.uploadSubscribedMethod = null
    this.uploadProgress = null
  }
}

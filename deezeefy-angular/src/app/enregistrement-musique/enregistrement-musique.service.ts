import { HttpClient, HttpEventType } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { finalize, Subscription } from 'rxjs';
import { Musique } from '../model';

@Injectable({
  providedIn: 'root'
})
export class EnregistrementMusiqueService {

  uploadProgress: number
  uploadSubscribedMethod: Subscription

  constructor(
    private http: HttpClient,
    private router: Router
  ) { }

  save (file: File) {
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

      let music: Musique = new Musique();
      music.titre = file.name.split(".")[0]
      music.piste = Array.from(res);
      music.duree = Math.round(file.size / 24000) // Les mp3 se lisent a 192kbits/s donc 24000 octets par seconde
      const upload = this.http.post<Musique>("http://localhost:9999/musique", music, {
        reportProgress: true,
        observe: 'events'
      }).pipe(finalize(() => {
        this.reset()
        this.router.navigate(['/musique'])
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

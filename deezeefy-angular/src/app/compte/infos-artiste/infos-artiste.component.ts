import { Component, Input, OnInit } from '@angular/core';
import { Artiste } from 'src/app/model';
import { InfosArtisteService } from './infos-artiste.service';

@Component({
  selector: 'app-infos-artiste',
  templateUrl: './infos-artiste.component.html',
  styleUrls: ['./infos-artiste.component.scss']
})
export class InfosArtisteComponent implements OnInit {
  @Input("id")
  id: number

  artiste: Artiste

  constructor(
    private infosArtisteService: InfosArtisteService
  ) {}

  ngOnInit(): void {
    this.getArtiste()
  }

  getArtiste(): void {
    this.infosArtisteService.getArtiste(this.id).subscribe(resp => {
      this.artiste = resp
    })
  }
}

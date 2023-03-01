import { HttpClient } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { CompteHistory } from 'src/app/model';
import { CompteService } from '../compte.service';
import { HistoriqueCompteService } from './historique-compte.service';

@Component({
  selector: 'app-historique-compte',
  templateUrl: './historique-compte.component.html',
  styleUrls: ['./historique-compte.component.scss']
})
export class HistoriqueCompteComponent implements OnInit{
  @Input("id")
  compteId: number

  constructor(
    private historiqueService: HistoriqueCompteService
  ) { }

  ngOnInit(): void {
    this.load()
  }

  findAll(): Array<CompteHistory> {
    return this.historiqueService.findAll();
  }

  load() {
    this.historiqueService.load(this.compteId)
  }
}

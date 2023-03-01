import { TestBed } from '@angular/core/testing';

import { HistoriqueCompteService } from './historique-compte.service';

describe('HistoriqueCompteService', () => {
  let service: HistoriqueCompteService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(HistoriqueCompteService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

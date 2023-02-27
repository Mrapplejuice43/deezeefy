import { TestBed } from '@angular/core/testing';

import { EnregistrementMusiqueService } from './enregistrement-musique.service';

describe('EnregistrementMusiqueService', () => {
  let service: EnregistrementMusiqueService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EnregistrementMusiqueService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

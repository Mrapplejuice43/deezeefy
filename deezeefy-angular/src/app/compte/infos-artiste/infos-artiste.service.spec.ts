import { TestBed } from '@angular/core/testing';

import { InfosArtisteService } from './infos-artiste.service';

describe('InfosArtisteService', () => {
  let service: InfosArtisteService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(InfosArtisteService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

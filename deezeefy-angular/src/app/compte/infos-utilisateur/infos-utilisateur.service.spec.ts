import { TestBed } from '@angular/core/testing';

import { InfosUtilisateurService } from './infos-utilisateur.service';

describe('InfosUtilisateurService', () => {
  let service: InfosUtilisateurService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(InfosUtilisateurService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

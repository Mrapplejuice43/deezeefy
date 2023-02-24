import { TestBed } from '@angular/core/testing';

import { SeConnecterHttpServiceService } from './se-connecter/se-connecter-http-service.service';

describe('SeConnecterHttpServiceService', () => {
  let service: SeConnecterHttpServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SeConnecterHttpServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

import { TestBed } from '@angular/core/testing';

import { LectureMusiqueService } from './lecture-musique.service';

describe('LectureMusiqueService', () => {
  let service: LectureMusiqueService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LectureMusiqueService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

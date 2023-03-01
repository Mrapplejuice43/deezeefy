import { TestBed } from '@angular/core/testing';

import { InfosAdminService } from './infos-admin.service';

describe('InfosAdminService', () => {
  let service: InfosAdminService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(InfosAdminService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

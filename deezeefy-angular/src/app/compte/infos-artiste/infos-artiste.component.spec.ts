import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InfosArtisteComponent } from './infos-artiste.component';

describe('InfosArtisteComponent', () => {
  let component: InfosArtisteComponent;
  let fixture: ComponentFixture<InfosArtisteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InfosArtisteComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InfosArtisteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

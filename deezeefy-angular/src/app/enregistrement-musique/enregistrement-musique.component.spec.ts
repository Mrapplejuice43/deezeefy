import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EnregistrementMusiqueComponent } from './enregistrement-musique.component';

describe('EnregistrementMusiqueComponent', () => {
  let component: EnregistrementMusiqueComponent;
  let fixture: ComponentFixture<EnregistrementMusiqueComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EnregistrementMusiqueComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EnregistrementMusiqueComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

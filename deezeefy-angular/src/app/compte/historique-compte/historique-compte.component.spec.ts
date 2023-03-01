import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HistoriqueCompteComponent } from './historique-compte.component';

describe('HistoriqueCompteComponent', () => {
  let component: HistoriqueCompteComponent;
  let fixture: ComponentFixture<HistoriqueCompteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HistoriqueCompteComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HistoriqueCompteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

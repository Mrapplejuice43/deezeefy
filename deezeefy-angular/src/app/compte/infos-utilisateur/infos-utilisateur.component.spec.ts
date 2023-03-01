import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InfosUtilisateurComponent } from './infos-utilisateur.component';

describe('InfosUtilisateurComponent', () => {
  let component: InfosUtilisateurComponent;
  let fixture: ComponentFixture<InfosUtilisateurComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InfosUtilisateurComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InfosUtilisateurComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

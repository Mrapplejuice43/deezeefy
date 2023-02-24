import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LectureMusiqueComponent } from './lecture-musique.component';

describe('LectureMusiqueComponent', () => {
  let component: LectureMusiqueComponent;
  let fixture: ComponentFixture<LectureMusiqueComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LectureMusiqueComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LectureMusiqueComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

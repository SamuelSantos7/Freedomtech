import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AtualizarComponent } from './atualizar.component';

describe('AtualizarComponent', () => {
  let component: AtualizarComponent;
  let fixture: ComponentFixture<AtualizarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AtualizarComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AtualizarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

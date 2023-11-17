import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PainelCurriculosComponent } from './painel-curriculos.component';

describe('PainelCurriculosComponent', () => {
  let component: PainelCurriculosComponent;
  let fixture: ComponentFixture<PainelCurriculosComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PainelCurriculosComponent]
    });
    fixture = TestBed.createComponent(PainelCurriculosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

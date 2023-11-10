import { TestBed } from '@angular/core/testing';

import { curriculoService } from './curriculos.service';

describe('CurriculosService', () => {
  let service: curriculoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(curriculoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

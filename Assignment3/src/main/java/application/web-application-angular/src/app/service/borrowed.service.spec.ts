import { TestBed } from '@angular/core/testing';

import { BorrowedService } from './borrowed.service';

describe('BorrowedService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: BorrowedService = TestBed.get(BorrowedService);
    expect(service).toBeTruthy();
  });
});

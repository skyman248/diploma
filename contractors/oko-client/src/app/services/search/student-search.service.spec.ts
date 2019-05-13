import { TestBed } from '@angular/core/testing';

import { StudentSearchService } from './student-search.service';

describe('StudentSearchService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: StudentSearchService = TestBed.get(StudentSearchService);
    expect(service).toBeTruthy();
  });
});

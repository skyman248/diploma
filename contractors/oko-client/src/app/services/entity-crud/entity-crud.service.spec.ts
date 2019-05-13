import { TestBed } from '@angular/core/testing';

import { EntityCrudService } from './entity-crud.service';

describe('EntityCrudService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: EntityCrudService = TestBed.get(EntityCrudService);
    expect(service).toBeTruthy();
  });
});

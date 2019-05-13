import { Injectable } from '@angular/core';
import { HttpService } from '../http/http.service';
import { Observable } from 'rxjs';
import { FacultyInterface } from 'src/app/interfaces/models/faculty.interface';

@Injectable({
  providedIn: 'root'
})
export class FacultyService {

  constructor(private http: HttpService) { }

  public getAllFaculties(): Observable<FacultyInterface[]> {
    return this.http.get<FacultyInterface[]>('entity/faculties', {});
  }
}

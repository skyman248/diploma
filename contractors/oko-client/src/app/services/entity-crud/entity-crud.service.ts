import { Injectable } from '@angular/core';
import { HttpService } from '../http/http.service';
import { Observable } from 'rxjs';
import { EducationLevelInterface } from 'src/app/interfaces/models/education-level.interface';
import { EducationProgramInterface } from 'src/app/interfaces/models/education-program.interface';
import { DirectionInterface } from 'src/app/interfaces/models/direction.interface';
import { FacultyInterface } from 'src/app/interfaces/models/faculty.interface';
import { CountryInterface } from 'src/app/interfaces/models/country.interface';
import { EducationLanguageInterface } from 'src/app/interfaces/models/education-language.interface';
import { EducationFormInterface } from 'src/app/interfaces/models/education-form.interface';
import { ArrivalLineInterface } from 'src/app/interfaces/models/arrival-line.interface';

@Injectable({
  providedIn: 'root'
})
export class EntityCrudService {

  constructor(private http: HttpService) { }

  public getAllEducationLevels(): Observable<EducationLevelInterface[]> {
    return this.http.get('entity/education_levels', {});
  }

  public getAllEducationPrograms(): Observable<EducationProgramInterface[]> {
    return this.http.get('entity/education_programs', {});
  }

  public getDirectionByFaculty(faculty: FacultyInterface): Observable<DirectionInterface[]> {
    return this.http.get(`entity/directions?faculty_id=${faculty.id}`, {});
  }

  public getAllCountries(): Observable<CountryInterface[]> {
    return this.http.get('entity/countries', {});
  }

  public getAllEducationLanguages(): Observable<EducationLanguageInterface[]> {
    return this.http.get('entity/education_languages', {});
  }

  public getAllEducationForms(): Observable<EducationFormInterface[]> {
    return this.http.get('entity/education_forms', {});
  }

  public getAllArrivalLines(): Observable<ArrivalLineInterface[]> {
    return this.http.get('entity/arrival_lines', {});
  }
}

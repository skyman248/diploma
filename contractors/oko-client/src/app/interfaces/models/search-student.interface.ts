import { CountryInterface } from './country.interface';
import { FacultyInterface } from './faculty.interface';
import { DirectionInterface } from './direction.interface';
import { EducationProgramInterface } from './education-program.interface';
import { EducationLevelInterface } from './education-level.interface';
import { EducationFormInterface } from './education-form.interface';
import { ArrivalLineInterface } from './arrival-line.interface';
import { EducationLanguageInterface } from './education-language.interface';

export interface SearchStudentInterface {
    surname?: string;
    name?: string;
    dataOfBirth?: Date;
    nationality?: string;
    country?: CountryInterface;
    contractNumber?: string;
    course?: number;
    faculty?: FacultyInterface;
    direction?: DirectionInterface;
    educationProgram?: EducationProgramInterface;
    educationLevel?: EducationLevelInterface;
    educationForm?: EducationFormInterface;
    arrivalLine?: ArrivalLineInterface;
    educationLanguage?: EducationLanguageInterface;
}

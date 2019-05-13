import { StudentInterface } from './student.interface';
import { ContractInterface } from './contract.interface';
import { CountryInterface } from './country.interface';
import { EducationFormInterface } from './education-form.interface';
import { FacultyInterface } from './faculty.interface';
import { DirectionInterface } from './direction.interface';
import { EducationLevelInterface } from './education-level.interface';

export interface SearchStudentResultInterface {
    student: StudentInterface;
    contract: ContractInterface;
    country: CountryInterface;
    course: number;
    educationForm: EducationFormInterface;
    faculty: FacultyInterface;
    direction: DirectionInterface;
    educationLevel: EducationLevelInterface;
}

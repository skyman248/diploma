import { FacultyInterface } from './faculty.interface';

export interface DirectionInterface {
    id: string;
    directionName: string;
    faculty: FacultyInterface;
}

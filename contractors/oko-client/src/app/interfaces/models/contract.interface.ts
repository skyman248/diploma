import { StudentInterface } from './student.interface';
import { ContractTypeInterface } from './contract-type.interface';
import { OrderInterface } from './order.interface';
import { EducationProgramInterface } from './education-program.interface';
import { EducationLevelInterface } from './education-level.interface';
import { EducationFormInterface } from './education-form.interface';
import { ArrivalLineInterface } from './arrival-line.interface';
import { EducationLanguageInterface } from './education-language.interface';
import { StudentStatusInterface } from './student-status.interface';
import { PaymentFormInterface } from './payment-form.interface';
import { DirectionInterface } from './direction.interface';

export interface ContractInterface {
    id: string;
    student: StudentInterface;
    contractType: ContractTypeInterface;
    contractDate: Date;
    contractValue: number;
    contractNumber: string;
    orders: OrderInterface[];
    deactOrder: OrderInterface;
    educationProgram: EducationProgramInterface;
    educationLevel: EducationLevelInterface;
    educationForm: EducationFormInterface;
    arrivalLine: ArrivalLineInterface;
    payer: string;
    dateIn: Date;
    planDateOut: Date;
    course: number;
    educationLanguage: EducationLanguageInterface;
    studentStatus: StudentStatusInterface;
    yearsOfEduc: number;
    comment: string;
    usualPaymentForm: PaymentFormInterface;
    direction: DirectionInterface;
    isBudget: boolean;
    isActive: boolean;
}

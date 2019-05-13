import { OrderTypeInterface } from './order-type.interface';

export interface OrderInterface {
    id: string;
    orderNumber: string;
    orderDate: Date;
    relatedDate: Date;
    note: string;
    orderType: OrderTypeInterface;
}

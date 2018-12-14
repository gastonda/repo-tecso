import {CurrentAccount} from './currentAccount';
import { Movement } from './movement';

export class MovementsAccount {
    account: CurrentAccount;
    movements: Movement[];


    constructor(movement: any = {}){
		this.account = movement.account ;
		this.movements = movement.movements ;
	}
} 
export class Movement{
    id : number = 0;
    date: Date ;
	movementType: string = "";
	account_id: number= 0;
	description: string = "";
    amount: number= 0;
    
    constructor(movement: any = {}){
		this.id = movement.id;
		this.date = movement.date || new Date;
		this.movementType = movement.movementType || '';
		this.account_id = movement.account_id || 0;
		this.description = movement.description || '';
		this.amount = movement.amount || 0;
	}

}

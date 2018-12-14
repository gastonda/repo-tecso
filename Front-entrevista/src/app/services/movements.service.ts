import { Injectable } from '@angular/core';
import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http';




@Injectable()
export class MovementsService{

    private idAccountSelected;


    public setAccountSelected(id){
        this.idAccountSelected=id;
    }

    public getAccountSelected(){
        return this.idAccountSelected;
    }

    constructor(private http: HttpClient){
    }

    getMovements(accountId){
        const params = new HttpParams().set('accountId', accountId);
       return  this.http.get('/api/getMovements', { params : params , responseType: 'json'});
    }

    saveMovement(movement){
        return  this.http.post('/api/addMovement', movement, {responseType: 'text'});
    }
}
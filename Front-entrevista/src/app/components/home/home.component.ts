import { Component, OnInit } from '@angular/core';
import { CurrentAccount} from '../../models/currentAccount';
import { CurrentAccountService } from '../../services/currentAccount.service';
import { MovementsService } from '../../services/movements.service';
import { Router } from '@angular/router';
import { FormControl, FormGroup, FormBuilder, Validators } from '@angular/forms';
import { map } from 'rxjs/operators';
import * as $ from 'jquery';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.sass']
})
export class HomeComponent implements OnInit {

  selectedCurrency: string;
  accountForm: FormGroup;
  
  private currentAccount ={
    balance: 0,
    currency: "",
    creationTimestamp: Date,
    modificationTimestamp: Date
  }

  private currentAccounts:  CurrentAccount [] = [];

  
  currencies = [
    { name: "PESOS", value: 1 },
    { name: "DOLARES", value: 2 },
    { name: "EUROS", value: 3 }
  ]

  constructor(private currentAccountService: CurrentAccountService, private router: Router,
              private movementsService: MovementsService) { 
    this.accountForm = this.createFormGroup();
    this.updateTable();
  }

  ngOnInit() {
     
  }


  createFormGroup() {
    return new FormGroup({
        currency: new FormControl(),
        balance: new FormControl()
    });
  }

  deleteAccount(id){
    this.currentAccountService.deleteAccount(id).subscribe(
      result =>{
        $("#accountDeleted").fadeIn();
        this.updateTable();
        setTimeout(() => {
          $("#accountDeleted").fadeOut();
        }, 1500);
      },error => {
        this.updateTable();
        $("#accountWithMovements").fadeIn();
        setTimeout(() => {
          $("#accountWithMovements").fadeOut();
        }, 2500);
      }
    )
  }

  createAccount(){
      if(!this.accountForm.valid){
        $("#fieldsRequired").fadeIn();
        setTimeout(() => {
          $("#fieldsRequired").fadeOut();
        }, 1500);
        return;
      }
      const now= new Date();
      this.currentAccount= Object.assign({}, this.accountForm.value);
      this.currentAccountService.createAccount(this.currentAccount).subscribe(
        result => {
            $("#newAccountOk").fadeIn();
            this.updateTable();
            this.accountForm.reset();
            setTimeout(() => {
              $("#newAccountOk").fadeOut();
            }, 1500);
        },
        error => {
            $("#newAccountFail").fadeIn();
            setTimeout(() => {
              $("#newAccountFail").fadeOut();
            }, 1500);
        }
      );
      
      
  }

  updateTable(){
      this.currentAccountService.getAllAccounts().pipe(map(res => res as CurrentAccount[])).subscribe(
        result => {
            this.currentAccounts= result;
        }
      );
  }

  getMovements(accountId){
      this.movementsService.setAccountSelected(accountId);
      this.router.navigate(['/movements']);
  
  }

}

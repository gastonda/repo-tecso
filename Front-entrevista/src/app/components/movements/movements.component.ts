import { Component, OnInit } from '@angular/core';
import { Movement} from '../../models/movement';
import { MovementsAccount} from '../../models/movementsAccount';
import { FormControl, FormGroup, FormBuilder, Validators } from '@angular/forms';
import { CurrentAccountService } from '../../services/currentAccount.service';
import { MovementsService } from '../../services/movements.service';
import { Router } from '@angular/router';
import { map } from 'rxjs/operators';
import * as $ from 'jquery';
import { IfStmt } from '@angular/compiler';


@Component({
  selector: 'app-movements',
  templateUrl: './movements.component.html',
  styleUrls: ['./movements.component.scss']
})
export class MovementsComponent implements OnInit {

  //private movementsAccounts:  MovementsAccount [] = [];
  private movementsAccounts= new  MovementsAccount() ;
  validForm = true;
  movementForm: FormGroup;
  newMovement:{
    id : number ;
    date: Date ;
	  movementType: string ;
	  account_id: number;
	  description: string;
    amount: number;
  } ; 
  constructor(private movementsService: MovementsService , private formBuilder: FormBuilder, private router : Router ) { 
    this.getMovements();
    this.newMovement= new Movement();  
    this.movementForm = this.createFormGroup();
  }

  ngOnInit() {
    

  }

  getMovements(){
    this.movementsService.getMovements(this.movementsService.getAccountSelected())
    .pipe(map(res => res as MovementsAccount)).subscribe(
      result => {
          this.movementsAccounts= result;
      });
  }

  createFormGroup() {
    return new FormGroup({
        movementType: new FormControl(),
        amount: new FormControl(),
        description: new FormControl()
    });
  }

  home(){
    this.router.navigate(['/home']);
  }

  saveMovement(){
      if(!this.movementForm.valid){
        $("#fieldsRequired").fadeIn();
        setTimeout(() =>{
          $("#fieldsRequired").fadeOut();
        }, 1500);
        return;
      }
      this.newMovement= Object.assign({}, this.movementForm.value);
      this.newMovement.account_id= this.movementsService.getAccountSelected();
      this.movementsService.saveMovement(this.newMovement).subscribe(
        result =>{
          this.newMovement= new Movement();
          this.movementForm.reset();
          $("#closeModal").click();
          this.getMovements();
         $("#newMovementOk").fadeIn();
         setTimeout(() =>{
            $("#newMovementOk").fadeOut();
          }, 1800);
        },
        error => {
          this.newMovement= new Movement();
          this.movementForm.reset();
          $("#closeModal").click();
          if(error.error === 'REJECTED'){
            $("#newMovementFail").fadeIn();
          }else{
            $("#newMovementException").fadeIn();
            console.log(error);
          }
          setTimeout(() => {
            $("#newMovementFail").fadeOut();
            $("newMovementException").fadeOut();
          }, 2000);
        }

      );
      
  }



}

import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http'
import { Observable } from 'rxjs';
import { Productos } from '../producto/productos';

@Injectable({
  providedIn: 'root'
})
export class ServicesService {

  url="http://localhost:8080/api/prodcuto"

  constructor(private http:HttpClient) { }


 


}

import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http'

@Injectable({
  providedIn: 'root'
})
export class ServicesService {

  url="http://localhost:8080/api"

  constructor(private http:HttpClient) { }


}

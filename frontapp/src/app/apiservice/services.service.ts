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

  //metodo para agregar productos
  public agregarProductos(productos:Productos):Observable<Object>{
    return this.http.post(this.url+"/guardar", productos);
  }
 
  //metodo para listar productos
  public listarProductos():Observable<Productos[]>{
    return this.http.get<Productos[]>(this.url+"/listar");
  }


}

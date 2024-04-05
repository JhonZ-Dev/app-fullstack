import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http'
import { Observable } from 'rxjs';
import { Productos } from '../producto/productos';

@Injectable({
  providedIn: 'root'
})
export class ServicesService {

  url="http://localhost:8081/api/producto"

  constructor(private http:HttpClient) { }

  //metodo para agregar productos
  public agregarProductos(productos:Productos):Observable<Object>{
    return this.http.post(this.url+"/guardar", productos);
  }
 
  //metodo para listar productos
  public listarProductos():Observable<Productos[]>{
    return this.http.get<Productos[]>(this.url+"/listar");
  }

  //metodo para ediar los productos
  public editarProductos(id_producto:number, productos:Productos):Observable<Productos>{
    //return this.http.put(this.url+"/editar/"+id_producto, productos);
    return this.http.put<Productos>(`${this.url}/editar/${id_producto}`, productos);
  }

  //eliminar
  public eliminarproducto(id_producto:number):Observable<void>{
    return this.http.delete<void>(this.url+"/eliminar/"+id_producto);
  }

  //obetenerporid
  public obtenerPorId(id_producto:number):Observable<Productos>{
    return this.http.get<Productos>(`${this.url}/obtener/${id_producto}`);
  }


}

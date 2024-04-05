import { Component } from '@angular/core';
import { Productos } from '../../productos';
import { ServicesService } from 'src/app/apiservice/services.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-guardar-producto',
  templateUrl: './guardar-producto.component.html',
  styleUrls: ['./guardar-producto.component.css']
})
export class GuardarProductoComponent {
  producto:Productos = new Productos();
  constructor(private serviceAPI:ServicesService, private enrutador:Router){}

  //guardarproducto
  public guardarProducto(){
    this.serviceAPI.agregarProductos(this.producto).subscribe({next:(datos)=>{console.log("guardado")},});
  }


}

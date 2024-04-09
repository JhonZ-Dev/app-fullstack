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
  imagenPreview: string | ArrayBuffer;

  constructor(private serviceAPI:ServicesService, private enrutador:Router){}

  //guardarproducto
  public guardarProducto(){
    this.serviceAPI.agregarProductos(this.producto).subscribe({next:(datos)=>{console.log("guardado")
    this.irListaUsuarios();
    },});
  }

  irListaUsuarios() {
    this.enrutador.navigate(["/productos-lista"])
  }

  onFileSelected(event: Event): void {
    const inputElement = event.target as HTMLInputElement;
    if (inputElement && inputElement.files && inputElement.files.length > 0) {
      const file = inputElement.files[0];
      if (file) {
        const reader = new FileReader();
        reader.onload = () => {
          if (reader.result !== null) {
            this.imagenPreview = reader.result;
          }
        };
        reader.readAsDataURL(file);
      }
    }
  }



}

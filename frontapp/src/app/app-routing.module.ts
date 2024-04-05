import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListarComponent } from './producto/listar/listar/listar.component';
import { GuardarProductoComponent } from './producto/guardar/guardar-producto/guardar-producto.component';
import { EditarProductoComponent } from './producto/editar/editar-producto/editar-producto.component';

const routes: Routes = [
  {path:'productos-lista', component:ListarComponent},
  {path:'productos-agregar', component:GuardarProductoComponent},
  {path:'productos-editar/:id_producto', component:EditarProductoComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

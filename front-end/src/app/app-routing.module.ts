//import { SobreComponent } from './sobre/sobre.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CadastrarComponent } from './cadastrar/cadastrar.component';
import { ProjetoComponent } from './projeto/projeto.component';

const routes: Routes = [
  {path:'cadastro',
component:CadastrarComponent
},
{path:'',redirectTo: 'inicio', pathMatch:'full'},

{path:"inicio",component: ProjetoComponent},

//{path:"sobre",component:SobreComponent},


];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

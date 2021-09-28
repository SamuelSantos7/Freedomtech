import { SobreComponent } from './sobre/sobre.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CadastrarComponent } from './cadastrar/cadastrar.component';
import { ProjetoComponent } from './projeto/projeto.component';
import { LoginComponent } from './login/login.component';

import { CategoriaComponent } from './categoria/categoria.component';
import { TimelineComponent } from './timeline/timeline.component';
import { AtualizarComponent } from './atualizar/atualizar.component';
import { ContatosComponent } from './contatos/contatos.component';
import { CategoriaEditComponent } from './edit/categoria-edit/categoria-edit.component';
import { CategoriaDeleteComponent } from './delete/categoria-delete/categoria-delete.component';
import { PostagemEditComponent } from './edit/postagem-edit/postagem-edit.component';
import { PostagemDeleteComponent } from './delete/postagem-delete/postagem-delete.component';
import { SobreNosComponent } from './sobre-nos/sobre-nos.component';

const routes: Routes = [
  {path:'cadastro',
component:CadastrarComponent},

{path:'',redirectTo: 'inicio', pathMatch:'full'},


{path:"inicio",component: ProjetoComponent},

{path:"contatos", component: ContatosComponent},

{path:"cancelar",component: ProjetoComponent},

{path:"atualizar",component: AtualizarComponent},

{path:"login", component: LoginComponent},

{path:"timeline", component: TimelineComponent},

{path: "cadastrar", component: TimelineComponent},

{path: "sobre", component: SobreComponent},

{path: "categoria", component: CategoriaComponent},

{path: "sobre-nos", component: SobreNosComponent},



{path: 'categoria-edit/:id', component: CategoriaEditComponent},
  {path: 'categoria-delete/:id', component: CategoriaDeleteComponent},
  {path: 'postagem-edit/:id', component: PostagemEditComponent},
  {path: 'postagem-delete/:id', component: PostagemDeleteComponent},


];




@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

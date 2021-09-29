import { HttpClientModule } from '@angular/common/http'
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';


import { AppComponent } from './app.component';
import { ProjetoComponent } from './projeto/projeto.component';
import { SobreNosComponent } from './sobre-nos/sobre-nos.component';
import { FooterComponent } from './footer/footer.component';
import { LoginComponent } from './login/login.component';
import { CategoriaComponent } from './categoria/categoria.component';
import { CarrosselComponent } from './carrossel/carrossel.component';
import { CadastrarComponent } from './cadastrar/cadastrar.component';
import { TimelineComponent } from './timeline/timeline.component';
import { CategoriaEditComponent } from './edit/categoria-edit/categoria-edit.component';
import { CategoriaDeleteComponent } from './delete/categoria-delete/categoria-delete.component';
import { PostagemEditComponent } from './edit/postagem-edit/postagem-edit.component';
import { PostagemDeleteComponent } from './delete/postagem-delete/postagem-delete.component';
import { AtualizarComponent } from './atualizar/atualizar.component';
import { ContatosComponent } from './contatos/contatos.component';
import { NavbarComponent } from './navbar/navbar.component';

@NgModule({
  declarations: [
    AppComponent,
    ProjetoComponent,
    SobreNosComponent,
    FooterComponent,
    CarrosselComponent,
    LoginComponent,
    SobreNosComponent,
    CategoriaComponent,
    CadastrarComponent,
    TimelineComponent,
    CategoriaEditComponent,
    CategoriaDeleteComponent,
    PostagemEditComponent,
    PostagemDeleteComponent,
    AtualizarComponent,
    ContatosComponent,
    NavbarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

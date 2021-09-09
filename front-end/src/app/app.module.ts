import { HttpClientModule } from '@angular/common/http'
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProjetoComponent } from './projeto/projeto.component';
import { SobreNosComponent } from './sobre-nos/sobre-nos.component';
import { FooterComponent } from './footer/footer.component';
import { CarrosselComponent } from './carrossel/carrossel.component';
//import { CadastrarComponent } from './cadastrar/cadastrar.component';
import { NavbarComponent } from './navbar/navbar.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

@NgModule({
  declarations: [
    AppComponent,
    ProjetoComponent,
    SobreNosComponent,
    FooterComponent,
    CarrosselComponent,
    //CadastrarComponent,
    NavbarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

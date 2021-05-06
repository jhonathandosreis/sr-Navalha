import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './view/login/login.component';
import { RecuperarSenhaComponent } from './view/recuperar-senha/recuperar-senha.component';
import { HomeComponent } from './view/home/home.component';
import { FooterComponent } from './view/footer/footer.component';
import { HeaderComponent } from './view/header/header.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RecuperarSenhaComponent,
    HomeComponent,
    FooterComponent,
    HeaderComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
